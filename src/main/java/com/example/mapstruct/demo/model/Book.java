package com.example.mapstruct.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

	private String bookName;

	private String bookNo;

	private String bookDesc;
}
