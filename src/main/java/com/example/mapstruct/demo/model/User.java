package com.example.mapstruct.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

	private String name;

	private String age;

	private Address address;

	private List<Book> booksList;
}
