package com.sam.spring.jpa.repository;

import com.sam.spring.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

     //Native Query
     @Query(
             value = "select * from tbl_student s where s.email_address = ?1",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNative(String emailId);

     //Native Query Named Param
     @Query(
             value = "select * from tbl_student s where s.email_address = :emailId",
             nativeQuery = true
     )
     Student getStudentByEmailAddressNativeNamedParam(@Param("emailId")String emailId);

     @Modifying
     @Transactional
     @Query(
             value = "update tbl_student set first_name = :firstName where email_address = :emailId",
             nativeQuery = true
     )
     int updateFirstNameByEmailAddress(@Param("firstName") String firstName,@Param("emailId") String emailId);

}
