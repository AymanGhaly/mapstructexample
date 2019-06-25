package com.example.mapstruct.demo.response;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {

	// different name
	private String userName;

	private String userAge;

	// flatten property from the address relation
	private String userStreet;

	private String userApartmentNumber;

	// same name as the model
	private String age;

	private String allBooksAsString;

	private List<BookDTO> booksList;


}
