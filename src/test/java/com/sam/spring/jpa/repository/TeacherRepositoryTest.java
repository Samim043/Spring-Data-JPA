package com.sam.spring.jpa.repository;

import com.sam.spring.jpa.entity.Course;
import com.sam.spring.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDM = Course.builder()
                .title("Discrete Math")
                .credit(3)
                .build();

        Course courseSC =Course.builder()
                .title("Semiconductor")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Jafor")
                .lastname("Ikbal")
                .courses(List.of(courseDM,courseSC))
                .build();
        
        teacherRepository.save(teacher);
    }

}