package com.platfromCommons.service;

import java.util.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.platfromCommons.entity.Student;
//import com.platfromCommons.entity.StudentDTO;
import com.platfromCommons.exceptionsHandler.StudentException;
import com.platfromCommons.repository.StudentRepo;

public class StudentServiceImpl implements StudentService {

	@Autowired(required = false)
	private StudentRepo sRepo;

	@Override
	public Student saveStudent(Student student) {

		Student saved = sRepo.save(student);

		return saved;
	}

	@Override
	public Student getStudentByUsc(Integer usc) throws StudentException {

		Optional<Student> opt = sRepo.findById(usc);
		return opt.orElseThrow(() -> new StudentException("Student does not exist with unique student code +" + usc));
	}

	@Override
	public List<Student> getAllStudentDetails() throws StudentException {
		List<Student> students = sRepo.findAll();

		if (students.size() > 0)
			return students;
		else
			throw new StudentException("No Student Found..");
	}

	@Override
	public Student deleteStudentByUsc(Integer usc) throws StudentException {
		Student existingStudent = sRepo.findById(usc)
				.orElseThrow(() -> new StudentException("Student does not exist with unique student code " + usc));

		sRepo.delete(existingStudent);

		return existingStudent;
	}

	@Override
	public Student updateStudent(Integer usc, String updateName) throws StudentException {
		Optional<Student> opt = sRepo.findById(usc);

		if (opt.isPresent()) {

			Student existingStudent = opt.get();

			existingStudent.setName(updateName);

			return sRepo.save(existingStudent);

		} else
			throw new StudentException("Student does not exist with unique student code :" + usc);
	}

//	@Override
//	public StudentDTO getStudentNameAndUsc(Integer usc) throws StudentException {
//		
//		StudentDTO result = sRepo.fun1(usc);
//
//		if (result != null)
//			return result;
//		else
//			throw new StudentException("Student does not exist with unique student code :" + usc);
//	}

}
