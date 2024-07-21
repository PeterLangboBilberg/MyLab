package org.bilberg.langbo.peter.SpectacledPenguin_server.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
      return  studentService.getstudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id){
        return  studentService.getstudent(id);
    }

    @GetMapping(path = "/count")
    public int getCount(){
        return studentService.getCount();
    }

    @PostMapping
    public Student registreStudent(@RequestBody Student student){
        studentService.add(student);
        return new Student();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable("id") long id){
        System.out.println("Delete "+id);
    }


}
