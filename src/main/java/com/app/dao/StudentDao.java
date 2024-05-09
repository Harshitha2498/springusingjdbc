package com.app.dao;

import java.util.List;

import com.app.model.Student;

/**
 * Student Dao Interface for Simple Spring MVC CRUD App
 * 
 * @author Mandar Pandit
 */
public interface StudentDao {

//	Student getStudent(int id);
//
//	int saveStudent(Student st);

//	List<Student> listAllStudents();

//	void updateStudent(Student st);
//
//	void deleteStudent(Student st);
	List<Student> findByNameContainingIgnoreCase(int sid);

}
