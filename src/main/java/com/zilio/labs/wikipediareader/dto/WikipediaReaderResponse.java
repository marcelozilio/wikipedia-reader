package com.zilio.labs.wikipediareader.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WikipediaReaderResponse {

    private String resultSearch;
}
