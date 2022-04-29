package com.zilio.labs.wikipediareader.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WikipediaSearch {

    private String title;
    private String snippet;
}
