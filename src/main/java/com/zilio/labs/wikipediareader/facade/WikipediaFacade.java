package com.zilio.labs.wikipediareader.facade;

import com.zilio.labs.wikipediareader.dto.WikipediaReaderRequestDto;
import com.zilio.labs.wikipediareader.dto.WikipediaResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WikipediaFacade {

    private String urlWikipedia = "https://{lang}.wikipedia.org/w/api.php/action=query&format=json&list=search&srsearch={search}";

    private final RestTemplate restTemplate;

    public WikipediaFacade() {
        this.restTemplate =
                new RestTemplateBuilder()
                        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                        .build();
    }

    public WikipediaResponse search(WikipediaReaderRequestDto request) {

        ResponseEntity<WikipediaResponse> response =
                restTemplate.exchange(
                        urlWikipedia,
                        HttpMethod.GET,
                        new HttpEntity<>(request),
                        WikipediaResponse.class,
                        request.getLanguage(),
                        request.getSearch()
                );

        return response.getBody();
    }
}
