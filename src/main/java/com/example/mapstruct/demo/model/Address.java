package com.example.mapstruct.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

	private String streetName;
	private String postal;
	private String apartmentNo;
}
