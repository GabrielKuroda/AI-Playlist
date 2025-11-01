package com.ai.playlist.creator.integration.gemini.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeminiService {

    @Value("${gemini.model}")
    private String geminiModel;

    private String apiKey;

    public GeminiService() {
        final Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("GEMINI_API_KEY");
    }

    public String GenerateTextFromTextInput (final String promptText){
        Client client = Client.builder().apiKey(apiKey).build();

        GenerateContentResponse response =
                client.models.generateContent(
                        geminiModel,
                        promptText,
                        null);

        return response.text();
    }
}
