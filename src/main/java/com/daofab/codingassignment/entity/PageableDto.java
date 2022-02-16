package com.daofab.codingassignment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Using lombok to generate getters and setters
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageableDto {

    private Integer page;
    private Integer size;
}
