package com.sam.spring.jpa.repository;

import com.sam.spring.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

}
