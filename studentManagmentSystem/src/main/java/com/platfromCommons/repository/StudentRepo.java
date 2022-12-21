package com.platfromCommons.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platfromCommons.entity.Student;
//import com.platfromCommons.entity.StudentDTO;

public interface StudentRepo extends JpaRepository<Student, Integer> {

//	@Query("select new com.masai.entity.StudentDTO(s.name,s.usc) from Student s where s.usc=?1")
//	public StudentDTO fun1(Integer usc);

}
