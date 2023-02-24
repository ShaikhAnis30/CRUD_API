package com.example.CRUD_API.Services;

import com.example.CRUD_API.Entities.Student;
import com.example.CRUD_API.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //1 - create Student
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    //2 - Get Student by id
    public Student getStudent(int id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    //3 - Update age of given student
    public void updateAge(int id, int age) {
        Student student = studentRepository.findById(id).get();//(.get) throws no such element Exception
        student.setAge(age);
        studentRepository.save(student);
    }

    //4 - delete Student by id
    public void deleteStudent(int id) {
        Student student = studentRepository.findById(id).get();

        studentRepository.delete(student);
    }

    //Get student name
    public String getStudentName(int id) {
        Student student = studentRepository.findById(id).get();

        return student.getName();
    }
}
