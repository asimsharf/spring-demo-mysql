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
//			queryForStudents(studentDAO);
//			readStudent(studentDAO);
//			updateStudent(studentDAO);
//			queryStudentLastName(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDataAccessObject studentDataAccessObject) {
		int numberOfRows = studentDataAccessObject.deleteAll();
		System.out.println("Number of Rows Deleted: " + numberOfRows);
	}

	private void updateStudent(StudentDataAccessObject studentDataAccessObject) {
		int theID = 6;
		Student tempStudent = studentDataAccessObject.findById(theID);
		System.out.println("Student Before Update: " + tempStudent);
		tempStudent.setFirstName("Asim");
		tempStudent.setLastName("Abdelgadir");
		tempStudent.setEmail("aa@gmail.com");
		System.out.println("Student After Update: " + tempStudent);
		studentDataAccessObject.update(tempStudent);
		System.out.println("Student After Update: " + studentDataAccessObject.findById(theID));
	}

	private void queryStudentLastName(StudentDataAccessObject studentDataAccessObject) {
		System.out.println("Query Student Last Name: ");
		List<Student> theStudent = studentDataAccessObject.findByLastName("Abdelgadir");
		System.out.println("Query Student Last Name: " + theStudent);
		for (Student tempStudent: theStudent){
			System.out.println("Query Student Last Name: " + tempStudent);
		}
	}

	private void queryForStudents(StudentDataAccessObject studentDataAccessObject) {
		System.out.println("Query For Students: ");
		List<Student> theStudents = studentDataAccessObject.findAll();

		System.out.println("Query For Students: " + theStudents);
		for (Student student: theStudents){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDataAccessObject studentDataAccessObject) {
		System.out.println("Read Student: ");
		int theID = 6;
		System.out.println("Read Student: " + studentDataAccessObject.findById(theID));
		System.out.println(studentDataAccessObject.findById(theID));
	}

	private void createStudent(StudentDataAccessObject studentDataAccessObject){
		System.out.println("Create Student: ");
		Student tempStudent = new Student("Esam", "Mohamed", "asimsharf@gmail.com");
		System.out.println("Create Student: " + tempStudent);
		studentDataAccessObject.save(tempStudent);
	}

	private void deleteStudent(StudentDataAccessObject studentDataAccessObject){
		System.out.println("Delete Student: ");
		int theID = 3;
		System.out.println("Delete Student: " + studentDataAccessObject.findById(theID));
		studentDataAccessObject.delete(theID);
	}

}
