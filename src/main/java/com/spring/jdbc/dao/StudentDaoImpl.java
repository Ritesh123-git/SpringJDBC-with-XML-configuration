package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	public int insert(Student student) {
		
		String query="insert into student values(?,?,?)";
		int update = this.jdbcTemplate.update(query, student.getId(), student.getName(),student.getCity());
		return update;
		
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int change(Student student) {
		// updating data
		String query="update student set name=?, city=? where id=?";
		int update = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return update;
	}
	public int delete(int studentId) {
		// delete operation
		String query="delete from student where id=?";
		int update = this.jdbcTemplate.update(query,studentId);
		return update;
	}
	public Student getStudent(int studentId) {
		// select single student data
		
		RowMapper<Student> rowMapper= new RowMapperImpl(); 
		String query="select *from student where id=?";
		Student queryForObject = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return queryForObject;
	}
	public List<Student> getAllStudents() {
		//selecting multiple student
		String query="select * from student";
		List<Student> query2 = this.jdbcTemplate.query(query,new RowMapperImpl());
		return query2;
	}
	
	

}
