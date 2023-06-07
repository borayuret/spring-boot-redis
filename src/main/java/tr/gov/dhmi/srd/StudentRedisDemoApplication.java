package tr.gov.dhmi.srd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tr.gov.dhmi.srd.entity.Student;
import tr.gov.dhmi.srd.repository.StudentRepository;

@SpringBootApplication
@EnableCaching
public class StudentRedisDemoApplication implements ApplicationRunner {

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentRedisDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Student student1 = new Student();
        student1.setFirstName("Reha");
        student1.setLastName("Muhtar");
        student1.setAge(60);

        Student student2 = new Student();
        student2.setFirstName("Ali");
        student2.setLastName("Kırca");
        student2.setAge(55);

        studentRepository.save(student1);
        studentRepository.save(student2);



    }
}
