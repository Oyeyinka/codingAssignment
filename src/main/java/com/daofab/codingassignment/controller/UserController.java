package com.daofab.codingassignment.controller;

import com.daofab.codingassignment.entity.ChildDto;
import com.daofab.codingassignment.entity.PageableResponseDto;
import com.daofab.codingassignment.service.IUserService;
import com.daofab.codingassignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    public UserController(IUserService getDataService) {
        this.userService = getDataService;
    }

    @GetMapping
    public ResponseEntity<PageableResponseDto> getParent(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "2") int size)
    {
        var list = userService.getParent(page, size);
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getChild")
    public ResponseEntity<Optional<List<ChildDto>>> getChild()
    {
        var list = userService.getChild();
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }


}
