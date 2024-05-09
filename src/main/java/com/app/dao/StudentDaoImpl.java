package com.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Student;
/**
 * Student Dao Implementation for Simple Spring MVC CRUD App
 * 
 * @author Mandar Pandit
 */
@Repository("studentDao")
@Transactional
public class StudentDaoImpl implements StudentDao {
	JdbcTemplate jc=new JdbcTemplate();

	
//	public Student getStudent(Long id) {
//		
//		return getByKey(id);
//	}
//
//	
//
//	public int saveStudent(Student st) {
//		persist(st);
//		return st.getId();
//	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public List<Student> listAllStudents() {
//		List<Student> studentList = new ArrayList<>();
//
//        try {
//            String query = "SELECT * FROM Students";
//            List<Map<String, Object>> rows = jc.queryForList(query);
//
//            for (Map<String, Object> row : rows) {
//                Student student = new Student();
//                student.setId((int) row.get("id"));
//                student.setFirstName((String) row.get("first_name"));
//                student.setLastName((String) row.get("last_name"));
//                student.setGrade((int) row.get("grade"));
//                studentList.add(student);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return studentList;
//	}

//	public void updateStudent(Student st) {
//		update(st);
//	}
//
//	public void deleteStudent(Student st) {
//		delete(st);
//	}

	public List<Student> findByNameContainingIgnoreCase(int sid) {
		return null;
	}


}
