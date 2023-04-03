package com.example.demo;

import com.example.demo.DataAccessObject.StudentDataAccessObject;
import com.example.demo.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDataAccessObject studentDataAccessObject){
		return runner -> {
			createStudent(studentDataAccessObject);
//			queryForStudents(studentDataAccessObject);
//			readStudent(studentDataAccessObject);
//			updateStudent(studentDataAccessObject);
//			queryStudentLastName(studentDataAccessObject);
//			deleteStudent(studentDataAccessObject);
//			deleteAllStudent(studentDataAccessObject);
		};
	}

	private void deleteAllStudent(StudentDataAccessObject studentDataAccessObject) {
		int numberOfRows = studentDataAccessObject.deleteAll();
		System.out.println("Number of Rows Deleted: " + numberOfRows);
	}

	private void updateStudent(StudentDataAccessObject studentDataAccessObject) {
		int theID = 1;
		Student tempStudent = studentDataAccessObject.findById(theID);
		tempStudent.setFirstName("Asim");
		tempStudent.setLastName("Abdelgadir");
		tempStudent.setEmail("aa@gmail.com");
		studentDataAccessObject.update(tempStudent);
	}

	private void queryStudentLastName(StudentDataAccessObject studentDataAccessObject) {
		List<Student> theStudent = studentDataAccessObject.findByLastName("Abdelgadir");
		for (Student tempStudent: theStudent){
			System.out.println("Query Student Last Name: " + tempStudent);
		}
	}

	private void queryForStudents(StudentDataAccessObject studentDataAccessObject) {
		List<Student> theStudents = studentDataAccessObject.findAll();
		for (Student student: theStudents){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDataAccessObject studentDataAccessObject) {
		int theID = 1;
		System.out.println(studentDataAccessObject.findById(theID));
	}

	private void createStudent(StudentDataAccessObject studentDataAccessObject){
		Student tempStudent = new Student("Esam", "Mohamed", "asimsharf@gmail.com");
		studentDataAccessObject.save(tempStudent);
	}

	private void deleteStudent(StudentDataAccessObject studentDataAccessObject){
		int theID = 1;
		studentDataAccessObject.delete(theID);
	}

}
