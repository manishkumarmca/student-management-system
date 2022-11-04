package com.manish.java.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.manish.java.entity.Student;
import com.manish.java.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
//handler method to handle list controller for student
	@GetMapping("/students")
	public String listStudents(Model model){
		model.addAttribute("students", studentService.getAllStudents());
		return"students";
		
		
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
		
		
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, 
			@ModelAttribute("student") Student student, Model model)
	{
		//get student from database by id
		
		Student exitingStudent=studentService.getStudentById(id);
		exitingStudent.setId(id);
		exitingStudent.setFirstName(student.getFirstName());
		exitingStudent.setLastName(student.getLastName());
		exitingStudent.setEmail(student.getEmail());
		
		//save updated student details
		
		studentService.updateStudent(exitingStudent);
		return "redirect:/students"; 
		
		 
		
	}
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	}
	
	

