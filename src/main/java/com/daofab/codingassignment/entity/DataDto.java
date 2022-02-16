package com.daofab.codingassignment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

//Using lombok to generate getters and setters
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataDto <T> implements Serializable {

    private List<T> data;
}