package com.example.LibrarayManagement.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchBookResponse {

    List<BookResponse> bookResponses;

}
