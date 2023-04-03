package com.example.demo;

import com.example.demo.dao.StudentDAO;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
//			queryForStudents(studentDAO);
//			readStudent(studentDAO);
//			updateStudent(studentDAO);
//			queryStudentLastName(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int numberOfRows = studentDAO.deleteAll();
		System.out.println("Number of Rows Deleted: " + numberOfRows);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int theID = 6;
		Student tempStudent = studentDAO.findById(theID);
		System.out.println("Student Before Update: " + tempStudent);
		tempStudent.setFirstName("Asim");
		tempStudent.setLastName("Abdelgadir");
		tempStudent.setEmail("aa@gmail.com");
		System.out.println("Student After Update: " + tempStudent);
		studentDAO.update(tempStudent);
		System.out.println("Student After Update: " + studentDAO.findById(theID));
	}

	private void queryStudentLastName(StudentDAO studentDAO) {
		System.out.println("Query Student Last Name: ");
		List<Student> theStudent = studentDAO.findByLastName("Abdelgadir");
		System.out.println("Query Student Last Name: " + theStudent);
		for (Student tempStudent: theStudent){
			System.out.println("Query Student Last Name: " + tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		System.out.println("Query For Students: ");
		List<Student> theStudents = studentDAO.findAll();

		System.out.println("Query For Students: " + theStudents);
		for (Student student: theStudents){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Read Student: ");
		int theID = 6;
		System.out.println("Read Student: " + studentDAO.findById(theID));
		System.out.println(studentDAO.findById(theID));
	}

	private void createStudent(StudentDAO studentDAO){
		System.out.println("Create Student: ");
		Student tempStudent = new Student("Esam", "Mohamed", "asimsharf@gmail.com");
		System.out.println("Create Student: " + tempStudent);
		studentDAO.save(tempStudent);
	}

	private void deleteStudent(StudentDAO studentDAO){
		System.out.println("Delete Student: ");
		int theID = 3;
		System.out.println("Delete Student: " + studentDAO.findById(theID));
		studentDAO.delete(theID);
	}

}
