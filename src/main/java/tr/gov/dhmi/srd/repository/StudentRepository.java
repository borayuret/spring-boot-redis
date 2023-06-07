package tr.gov.dhmi.srd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.gov.dhmi.srd.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
