package tr.gov.dhmi.srd.service;

import tr.gov.dhmi.srd.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(long id);

    Student updateStudent(Student student);

    void deleteStudent(long id);
}
