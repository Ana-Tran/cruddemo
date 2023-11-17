package com.tranana.cruddemo;

import com.tranana.cruddemo.dao.StudentDAO;
import com.tranana.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			queryForSTudents(studentDAO);
		};
	}

	private void queryForSTudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> studentList = studentDAO.finalAll();

		// display list of students
		for(Student tempStudent : studentList){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object .....");
		Student tempStudent = new Student("Kuromi", "Sanrio", "kuromisanrio@gmail.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student objects .....");
		Student secondStudent = new Student("Cinnamon","Roll","cinnamonroll@gmail.com");
		Student thirdStudent = new Student("Hello","Kitty","hellokitty@gmail.com");
		Student fourthStudent = new Student("Choco","Cat","chococat@gmail.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(secondStudent);
		studentDAO.save(thirdStudent);
		studentDAO.save(fourthStudent);

	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object .....");
		Student firstStudent = new Student("Pom Pom","Purin","pompompurin@gmail.com");

		// save the student object
		System.out.println("Saving the student ....");
		studentDAO.save(firstStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + firstStudent.getId());
	}

}
