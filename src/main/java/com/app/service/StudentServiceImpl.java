package com.app.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.model.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	@Autowired
	private JdbcTemplate jdbcconfig;
	 @Autowired
	    public StudentServiceImpl(JdbcTemplate jdbcconfig) {
	        this.jdbcconfig = jdbcconfig;
	    }

	Student student;


	@SuppressWarnings("deprecation")
	@Override
	public Student getStudent(int id) {
		String query = "SELECT * FROM Students WHERE id = ?";
		return jdbcconfig.queryForObject(query, new Object[]{id}, (rs, rowNum) ->
        new Student(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),rs.getInt("grade")));
	}

	@Override
	public int saveStudent(Student st) {
		if (st == null) {
            throw new IllegalArgumentException("Student object is null.");
        }
		 String query = "INSERT INTO Students (id, first_name, last_name, grade) VALUES (?, ?, ?, ?)";

	        return jdbcconfig.update(query, st.getId(), st.getFirstName(), st.getLastName(), st.getGrade());
	}

	@Override
	public List<Student> listAllStudents() {
		List<Student> studentList = new ArrayList<>();

		try {
			String query = "SELECT * FROM Students";
			List<Map<String, Object>> rows = jdbcconfig.queryForList(query);

			for (Map<String, Object> row : rows) {
				System.out.println("row  ::::"+row);
				Student student=new Student();
				if (row.get("id") != null) {
				student.setId((Integer) row.get("id"));}
				student.setFirstName((String) row.get("first_name"));
				student.setLastName((String) row.get("last_name"));
				student.setGrade((Integer) row.get("grade"));
				studentList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentList;
	}

	@Override
	public void update(int id, Student st) {
		 if (st == null) {
	            throw new IllegalArgumentException("Student object is null.");
	        }
		 String query = "UPDATE Students SET first_name = ?, last_name = ?, grade = ? WHERE id = ?";

	        jdbcconfig.update(query, st.getFirstName(), st.getLastName(), st.getGrade(), id);
	}

	@Override
	public void delete(int id) {
		 String query = "DELETE FROM Students WHERE id = ?";
		 jdbcconfig.update(query, id);
	}

	@Override
	public boolean isStudentUnique(int sid) {
		Student student =getStudent(sid);
		return (student == null || (sid != 0));
	}

	public List<Student> search(int sid) {
		List<Student> studentList = new ArrayList<>();

		try {
			String query = "SELECT * FROM Students WHERE id = ?";
			List<Map<String, Object>> rows = jdbcconfig.queryForList(query, sid);

			for (Map<String, Object> row : rows) {
				Student student = new Student();
				student.setId((int) row.get("id"));
				student.setFirstName((String) row.get("first_name"));
				student.setLastName((String) row.get("last_name"));
				student.setGrade((int) row.get("grade"));
				studentList.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentList;
	}

}
