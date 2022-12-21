package com.platfromCommons.service;

import java.util.List;


import com.platfromCommons.entity.Student;
//import com.platfromCommons.entity.StudentDTO;
import com.platfromCommons.exceptionsHandler.StudentException;

public interface StudentService {
	
	
public Student saveStudent(Student student);
	
	public Student getStudentByUsc(Integer usc)throws StudentException;
	
	public List<Student> getAllStudentDetails()throws StudentException;
	
	public Student deleteStudentByUsc(Integer usc)throws StudentException;
	
	public Student updateStudent(Integer usc, String updateName)throws StudentException;
	
	
	//public StudentDTO getStudentNameAndUsc(Integer usc) throws StudentException;

}
