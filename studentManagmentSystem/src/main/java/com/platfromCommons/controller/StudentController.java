package com.platfromCommons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platfromCommons.entity.Student;
//import com.platfromCommons.entity.StudentDTO;
import com.platfromCommons.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired(required = false)
	private StudentService sService;

	// save student to database
	@PostMapping("/")  // http://localhost:8080/students/
	public ResponseEntity<Student> saveStudentHandler(@RequestBody Student student) {

		Student savedStudent = sService.saveStudent(student);

		return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);

	}

	// get student by unique student code
	@GetMapping("/{usc}") // http://localhost:8080/students/usc
	public Student getStudenthandler(@PathVariable("usc") Integer usc) {

		return sService.getStudentByUsc(usc);

	}

	// get list of students
	@GetMapping("/") //http://localhost:8080/students/
	public ResponseEntity<List<Student>> getAllStudentHandler() {

		List<Student> students = sService.getAllStudentDetails();

		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}

	// delete student by unique student code
	@DeleteMapping("/{usc}")  //http://localhost:8080/students/usc
	public Student deleteStudentById(@PathVariable("usc") Integer usc) {

		return sService.deleteStudentByUsc(usc);
	}

	// update student name by unique student code
	@PutMapping("/{usc}")  //http://localhost:8080/students/usc
	public ResponseEntity<Student> updateStudentNameHandler(@PathVariable("usc") Integer usc,
			@RequestParam("name") String name) {

		Student updatedStudent = sService.updateStudent(usc, name);

		return new ResponseEntity<Student>(updatedStudent, HttpStatus.ACCEPTED);
	}

	// student details by DTO
//	@GetMapping("/dto/{usc}")
//	public StudentDTO getStudentNameAndUscHandler(@PathVariable("usc") Integer usc) {
//
//		return sService.getStudentNameAndUsc(usc);
//
//	}

}
