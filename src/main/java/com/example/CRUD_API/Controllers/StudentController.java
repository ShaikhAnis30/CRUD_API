package com.example.CRUD_API.Controllers;

import com.example.CRUD_API.Entities.Student;
import com.example.CRUD_API.Services.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create-student")
    public ResponseEntity createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return new ResponseEntity<>("Student Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-student")
    public ResponseEntity getStudent(@RequestParam("id") int id) {
        try {
            Student response = studentService.getStudent(id);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Please Enter Valid Id", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update-age")
    public ResponseEntity updateAge(@RequestParam("id") int id, @RequestParam("age") int age) {
        try {
            studentService.updateAge(id, age);
            return new ResponseEntity<>("Age Updated Successfully", HttpStatus.ACCEPTED);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Please Enter Valid Id", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        try {
            studentService.deleteStudent(id);
            return new ResponseEntity<>("Student Deleted Successfully", HttpStatus.GONE);
        }catch (NoSuchElementException e) {
            return  new ResponseEntity<>("Please Enter Valid Id", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-name/{id}")
    public ResponseEntity getStudentName(@PathVariable int id) {
        try {
            String response = studentService.getStudentName(id);
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Please Enter Valid Id", HttpStatus.BAD_REQUEST);
        }
    }
}
