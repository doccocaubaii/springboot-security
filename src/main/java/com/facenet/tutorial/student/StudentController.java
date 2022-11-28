package com.facenet.tutorial.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * This class was created at 11/28/2022 14:57:31
 *
 * @author Minh.LN
 */

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
      new Student(1, "Jame Bonds"),
      new Student(2, "Victoria Alice"),
      new Student(3, "Vladimir Kata")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(s-> s.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Student " + studentId + " doesnot exits!!"));
    }
}
