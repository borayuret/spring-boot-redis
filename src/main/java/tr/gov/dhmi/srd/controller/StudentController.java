package tr.gov.dhmi.srd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;
import tr.gov.dhmi.srd.entity.Student;
import tr.gov.dhmi.srd.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable long id)
    {
        return studentService.getStudentById(id);
    }


    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable long id)
    {
        studentService.deleteStudent(id);
    }

}
