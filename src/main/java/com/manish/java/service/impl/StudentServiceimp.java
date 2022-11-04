package com.manish.java.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manish.java.entity.Student;
import com.manish.java.repository.StudentRepository;
import com.manish.java.service.StudentService;
 

@Service
public class StudentServiceimp implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceimp(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		 
		return  studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		 
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		 
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		 studentRepository.deleteById(id);
		
	}

}

