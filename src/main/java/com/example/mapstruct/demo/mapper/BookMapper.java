package com.example.mapstruct.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.example.mapstruct.demo.model.Book;
import com.example.mapstruct.demo.response.BookDTO;

@Mapper
public interface BookMapper {

	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

	@Mappings({
			@Mapping(source = "bookNo", target = "bookNumber"),
			@Mapping(source = "bookDesc", target = "bookDescription")}
	)
	BookDTO bookDtoFromBook(Book book);
}
