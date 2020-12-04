package com.example.springbootswagger2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootswagger2.model.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Swagger2DemoRestController")
@RestController
public class Swagger2DemoRestController {

	List<Student> students = new ArrayList<Student>();
	{
		students.add(new Student("Ashish", "IV", "India", 1));
		students.add(new Student("Mandar", "V", "India", 2));
		students.add(new Student("Akshay", "III", "USA", 3));
		students.add(new Student("Rutu", "VI", "USA", 4));
	}

	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })

	@ApiOperation(value = "Get list of Students", response = Iterable.class, tags = "getStudents")
	@RequestMapping(value = "/getStudents", method = RequestMethod.GET)
	public List<Student> getStudents() {
		System.out.println(students);
		return students;
	}

	@ApiOperation(value = "Get specific Student By Name", response = Student.class, tags = "getStudentByName")
	@RequestMapping(value = "/getStudentByName/{name}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable(value = "name") String name) {
		return students.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
	}

	@ApiOperation(value = "Get specific Student By Country", response = Student.class, tags = "getStudentByCountry")
	@RequestMapping(value = "/getStudentByCountry/{country}")
	public List<Student> getStudentByCountry(@PathVariable(value = "country") String country) {
		System.out.println("Searching Student in country : " + country);
		List<Student> studentsByCountry = students.stream().filter(x -> x.getCountry().equalsIgnoreCase(country))
				.collect(Collectors.toList());
		System.out.println(studentsByCountry);
		return studentsByCountry;
	}

	@ApiOperation(value = "Get specific Student By Standard",response = Student.class,tags="getStudentByStandard")
	@RequestMapping(value = "/getStudentByStandard/{standard}")
	public List<Student> getStudentByStandard(@PathVariable(value = "standard") String standard) {
		return students.stream().filter(x -> x.getStandard().equalsIgnoreCase(standard)).collect(Collectors.toList());
	}

}
