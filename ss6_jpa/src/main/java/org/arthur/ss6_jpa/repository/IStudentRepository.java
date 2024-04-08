package org.arthur.ss6_jpa.repository;

import org.arthur.ss6_jpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    @Query(nativeQuery = true, value = "select * from student where active = true")
    Page<Student> findAllByActive(Pageable pageable);
    Page<Student> findStudentByNameContainingAndActive(String name,boolean active,Pageable pageable);
    List<Student> findStudentByEmail(String email);
}
