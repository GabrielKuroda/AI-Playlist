package com.ai.playlist.creator.controller;

import com.ai.playlist.creator.integration.gemini.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController {

    @Autowired
    private GeminiService service;

    @GetMapping("/ask")
    public ResponseEntity<String> askGemini(final String text) {
        final String s = service.GenerateTextFromTextInput(text);
        return ResponseEntity.ok(s);
    }

}
