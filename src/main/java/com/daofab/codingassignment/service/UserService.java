package com.daofab.codingassignment.service;

import com.daofab.codingassignment.entity.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    ObjectMapper mapper = new ObjectMapper();

    public PageableResponseDto getParent(int page, int size) {

        PageableResponseDto pageableResponseDto = new PageableResponseDto();

        TypeReference<DataDto> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Parent.json");
        DataDto users = null;
        List<ParentDto> allUsers = null;

        try {
            users = mapper.readValue(inputStream,typeReference);

            var listOfParents = users.getData().subList(0, users.getData().size());

            int totalParents = listOfParents.size();

            allUsers = doPagination(new PageableDto(page, size), listOfParents);
            pageableResponseDto.setContent(allUsers);
            pageableResponseDto.setSize(allUsers.size());
            pageableResponseDto.setTotalElements(totalParents);
            pageableResponseDto.setNumber(page + 1);
            pageableResponseDto.setTotalPages((int) Math.ceil(totalParents / size) + 1);


        } catch (IOException e){
            System.out.println("Unable to retrieve data: " + e.getMessage());
        }

        return pageableResponseDto;
    }

    public Optional<List<ChildDto>> getChild() {

        ArrayList childList = new ArrayList();
        TypeReference<DataDto> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Child.json");
        DataDto users = null;

        try {
            users = mapper.readValue(inputStream,typeReference);

            childList.add(users);

            //Comparator to sort
            Comparator<ChildDto> comparator
                    = Comparator.comparingInt(ChildDto::getId);

            childList.sort(comparator);

        } catch (IOException e){
            System.out.println("Unable to save users: " + e.getMessage());
        }
        //Using Optional in case of null
        return Optional.ofNullable(childList);
    }

    //  Implemented a custom pagination method
    private List<ParentDto> doPagination(PageableDto pageable, List<ParentDto> requests) {

        List<ParentDto> paginatedList;

        Integer page = pageable.getPage();
        Integer size = pageable.getSize();

        int offset = page * size;
        if(requests.size()>offset){
            if(requests.size()>(offset+size)){
                paginatedList = requests.subList(offset, offset+size);
            }else{
                paginatedList = requests.subList(offset, requests.size());
            }
        }else{
            paginatedList = new ArrayList<>();
        }
        return paginatedList;
    }

}
