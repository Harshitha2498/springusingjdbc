package com.app.service;

import java.util.List;

import com.app.model.Student;

/**
 * Student Service Interface for Simple Spring MVC CRUD App
 * 
 * @author Mandar Pandit
 */
public interface StudentService {

	Student getStudent(int id);

	int saveStudent(Student st);

	List<Student> listAllStudents();

	void update(int id, Student st);

	void delete(int id);

	boolean isStudentUnique(int id);

	List<Student> search(int sid);
}
