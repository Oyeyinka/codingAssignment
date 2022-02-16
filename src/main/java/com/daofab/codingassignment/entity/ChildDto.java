package com.daofab.codingassignment.entity;

import lombok.*;

import java.io.Serializable;

//Using lombok to generate getters and setters
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChildDto implements Serializable {
    public Integer id;
    public Integer parentId;
    public Long paidAmount;

}
