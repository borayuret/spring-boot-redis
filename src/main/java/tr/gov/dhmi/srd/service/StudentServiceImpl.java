package tr.gov.dhmi.srd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import tr.gov.dhmi.srd.entity.Student;
import tr.gov.dhmi.srd.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl
        implements StudentService{

    @Autowired
    private StudentRepository studentRepository;


    @Override
    @Cacheable(value = "studentList")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Cacheable(value = "student", key = "#id")
    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    @Override


    @Caching(evict = {@CacheEvict(cacheNames = "studentList", allEntries = true)},
             put ={@CachePut(value = "student", key = "#student.id")}
    )
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }


    @Caching(evict = {
            @CacheEvict(cacheNames = "student", key="#id"),
            @CacheEvict(cacheNames = "studentList", allEntries = true)
    })
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
}


