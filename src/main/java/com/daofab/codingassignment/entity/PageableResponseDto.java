package com.daofab.codingassignment.entity;

import lombok.*;

import java.util.List;

//Using lombok to generate getters and setters
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageableResponseDto <T> {
    private List<T> content;
    private Integer size;
    private Integer totalElements;
    private Integer totalPages;
    private Integer number;
}