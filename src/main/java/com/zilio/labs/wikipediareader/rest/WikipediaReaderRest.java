package com.zilio.labs.wikipediareader.rest;

import com.zilio.labs.wikipediareader.dto.WikipediaReaderRequestDto;
import com.zilio.labs.wikipediareader.service.WikipediaReaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wikipedia-reader")
public class WikipediaReaderRest {

    private final WikipediaReaderService wikipediaReaderService;

    public WikipediaReaderRest(WikipediaReaderService wikipediaReaderService) {
        this.wikipediaReaderService = wikipediaReaderService;
    }

    @GetMapping
    public ResponseEntity<?> search(@RequestBody WikipediaReaderRequestDto request) {
        return ResponseEntity.ok(wikipediaReaderService.search(request));
    }
}
