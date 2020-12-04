package com.example.springbootswagger2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "All details about the Student. ")
public class Student {
	@ApiModelProperty(notes = "Name of the Student",name="name",required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "Class of the Student",name="class",required=true,value="test class")
	private String standard;
	@ApiModelProperty(notes = "Country of the Student",name="country",required=true,value="test country")
	private String country;
	@ApiModelProperty(notes = "Student Id",name="sId",required=true,value="123")
	private int sId;

	public int getsId() {
		return sId;
	}

	public Student(String name, String standard, String country, int sId) {
		super();
		this.name = name;
		this.standard = standard;
		this.country = country;
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public String getStandard() {
		return standard;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", standard=" + standard + ", country=" + country + ", sId=" + sId +"]";
	}

}
