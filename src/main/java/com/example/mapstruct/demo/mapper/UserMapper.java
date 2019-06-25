package com.example.mapstruct.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.example.mapstruct.demo.model.Book;
import com.example.mapstruct.demo.model.User;
import com.example.mapstruct.demo.response.UserDTO;

@Mapper(uses = BookMapper.class)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mappings({
			@Mapping(source = "name", target = "userName"),
			@Mapping(source = "age", target = "userAge"),
			// where we flatten the address properties
			@Mapping(source = "address.streetName", target = "userStreet"),
			@Mapping(source = "address.apartmentNo", target = "userApartmentNumber",defaultValue = "no app"),
			// expression
			@Mapping(target = "allBooksAsString", expression = "java(UserMapper.getBooksAsString(user.getBooksList()))")

	})
	UserDTO userDtoFromUser(User user);

	List<UserDTO> userDtoListFromUserList(List<User> users);

	static String getBooksAsString(List<Book> books) {
		return books.stream().map(Book::getBookName).collect(Collectors.joining(","));
	}

}
