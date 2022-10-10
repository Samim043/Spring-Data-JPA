package com.sam.spring.jpa.repository;

import com.sam.spring.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{

     List<Student> findByFirstName(String firstName);

     List<Student> findByFirstNameContaining(String name);

     List<Student> findByLastNameNotNull ();

     List<Student> findByGuardianName(String guardianName);

     Student findByFirstNameAndLastName(String firstName, String lastName);

     //JPQL
     @Query("select s from Student s where s.emailId = ?1")
     Student getStudentByEmailAddress(String emailId);

     @Query("select s.firstName from Student s where s.emailId = ?1")
     String getStudentFirstNameByEmailAddress(String emailId);

}
