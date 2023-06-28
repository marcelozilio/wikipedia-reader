package com.zilio.labs.wikipediareader.util;

import org.springframework.util.StringUtils;

import java.text.Normalizer;

public class StringUtil {

    public static String sanitizeResponseSnippetWikipedia(String snippet) {
        snippet = snippet.replace("<span class=\"searchmatch\">", " ");

        return snippet.replace("</span>", " ");
    }

    public static String sanitizeInputUser(String inputSearch) {
        String inputSearchSanitize = inputSearch.replaceAll(" ", "-");

        inputSearchSanitize = stripAccents(inputSearchSanitize);

        return inputSearchSanitize;
    }


    public static String stripAccents(String text) {
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        return text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }
}
