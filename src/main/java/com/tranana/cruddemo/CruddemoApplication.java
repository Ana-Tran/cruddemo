package com.tranana.cruddemo;

import com.tranana.cruddemo.dao.StudentDAO;
import com.tranana.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
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
