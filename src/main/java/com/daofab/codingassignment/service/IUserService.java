package com.daofab.codingassignment.service;

import com.daofab.codingassignment.entity.ChildDto;
import com.daofab.codingassignment.entity.PageableResponseDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    PageableResponseDto getParent(int page, int size);
    Optional<List<ChildDto>> getChild();
}
