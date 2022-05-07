package com.zilio.labs.wikipediareader.service;

import com.zilio.labs.wikipediareader.dto.WikipediaReaderRequestDto;
import com.zilio.labs.wikipediareader.dto.WikipediaReaderResponse;
import com.zilio.labs.wikipediareader.dto.WikipediaResponse;
import com.zilio.labs.wikipediareader.dto.WikipediaSearch;
import com.zilio.labs.wikipediareader.facade.WikipediaFacade;
import com.zilio.labs.wikipediareader.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WikipediaReaderService {

    private final WikipediaFacade wikipediaFacade;

    public WikipediaReaderService(WikipediaFacade wikipediaFacade) {
        this.wikipediaFacade = wikipediaFacade;
    }

    public WikipediaReaderResponse search(WikipediaReaderRequestDto request) {

        String sanitizeInputUser = StringUtil.sanitizeInputUser(request.getSearch());

        request.setSearch(sanitizeInputUser);

        WikipediaResponse wikipediaResponse = wikipediaFacade.search(request);

        Optional<WikipediaSearch> optionalWikipediaSearch =
                wikipediaResponse.getQuery().getSearch()
                        .stream()
                        .findFirst();

        if (optionalWikipediaSearch.isEmpty())
            return WikipediaReaderResponse
                    .builder()
                    .resultSearch("Nenhum conteúdo encontrado.")
                    .build();

        WikipediaSearch wikipediaSearch = optionalWikipediaSearch.get();

        String snippetSanitized = StringUtil.sanitizeResponseSnippetWikipedia(wikipediaSearch.getSnippet());

        String resultSearch = wikipediaSearch.getTitle() + " " + snippetSanitized;

        return WikipediaReaderResponse
                .builder()
                .resultSearch(resultSearch)
                .build();
    }
}
