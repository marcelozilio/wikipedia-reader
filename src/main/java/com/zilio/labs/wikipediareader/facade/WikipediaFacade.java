package com.zilio.labs.wikipediareader.facade;

import com.zilio.labs.wikipediareader.dto.WikipediaReaderRequestDto;
import com.zilio.labs.wikipediareader.dto.WikipediaResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Component
public class WikipediaFacade {

    private final RestTemplate restTemplate;

    public WikipediaFacade() {
        this.restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
    }

    public WikipediaResponse search(WikipediaReaderRequestDto request) {

        var url = UriComponentsBuilder
                .fromHttpUrl("https://pt.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=" + request.getSearch())
                .toUriString();

        ResponseEntity<WikipediaResponse> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        new HttpEntity<>(request),
                        WikipediaResponse.class
                );

        return response.getBody();
    }
}
