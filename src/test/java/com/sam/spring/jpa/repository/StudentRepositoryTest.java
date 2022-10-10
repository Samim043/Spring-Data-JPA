package com.sam.spring.jpa.repository;

import com.sam.spring.jpa.entity.Guardian;
import com.sam.spring.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

   @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder()
                .email("nahid@gmail.com")
                .name("nahid")
                .mobile("99999999999")
                .build();

        Student student = Student.builder()
                .emailId("srsamim043@gmail.com")
                .firstName("Snigdho")
                .lastName("Rahman")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("nahid@gmail.com")
                .name("nahid")
                .mobile("99999999999")
                .build();

        Student student = Student.builder()
                .firstName("Jibon")
                .lastName("Hasan")
                .emailId("jibon@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("Student List: "+studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Snigdho");
        System.out.println("Students = " +students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("ni");
        System.out.println("Students = " +students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("nahid");
        System.out.println("Students = " +students);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("jibon@gmail.com");
        System.out.println("Student = "+student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
       String firstName = studentRepository.getStudentFirstNameByEmailAddress("jibon@gmail.com");
        System.out.println("First Name = "+firstName);
    }

}