package com.facenet.tutorial.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * This class was created at 11/28/2022 16:57:27
 *
 * @author Minh.LN
 */

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Jame Bonds"),
            new Student(2, "Victoria Alice"),
            new Student(3, "Vladimir Kata")
    );

    @GetMapping
    public List<Student> getAllStudent(){
        return STUDENTS;
    }

    @PostMapping
    public void createStudent(@RequestBody Student student){
        System.out.println("Create student : " + student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println("deleted " + studentId);
    }

    @PutMapping(path = "{studentId}")
    public void editStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
        System.out.println(String.format("%s %s", studentId, student));
    }

}
