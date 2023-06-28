package com.zilio.labs.wikipediareader.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WikipediaReaderRequestDto {

    private String language;
    private String search;
}
