package com.example.mapstruct.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapstruct.demo.mapper.UserMapper;
import com.example.mapstruct.demo.model.Address;
import com.example.mapstruct.demo.model.Book;
import com.example.mapstruct.demo.model.User;
import com.example.mapstruct.demo.response.UserDTO;

@RestController
public class UserController {

	@RequestMapping("/user")
	public UserDTO getOneUser() {

		User user = getUserSample();

		UserDTO userDTO = UserMapper.INSTANCE.userDtoFromUser(user);

		return userDTO;

	}

	@RequestMapping("/userList")
	public List<UserDTO> getListOfUsers() {

		List<User> userListSample = getUserListSample();

		List<UserDTO> userDTOS = UserMapper.INSTANCE.userDtoListFromUserList(userListSample);

		return userDTOS;
	}


	private List<User> getUserListSample() {
		List<User> userList = new ArrayList<>();
		userList.add(getUserSample());
		userList.add(getUserSample());
		return userList;
	}

	private User getUserSample() {
		Address add = Address.builder().streetName("14 wexstr").apartmentNo("155").postal("10715").build();

		List<Book> bookList = new ArrayList<>();

		Book book1 = Book.builder().bookName("BookName1 !! ").bookDesc("!! description1 !!").bookNo("123454321").build();
		Book book2 = Book.builder().bookName("BookName2 !! ").bookDesc("!! description2 !!").bookNo("123454321").build();

		bookList.add(book1);
		bookList.add(book2);

		return User.builder().name("Ayman").address(add).age("27").booksList(bookList).build();
	}
}
