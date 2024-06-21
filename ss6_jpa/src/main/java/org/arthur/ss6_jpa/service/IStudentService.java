package org.arthur.ss6_jpa.service;

import org.arthur.ss6_jpa.dto.StudentDTO;
import org.arthur.ss6_jpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> getList(Pageable pageable);
    Student findById(Long id);
    boolean add(Student student);
    boolean edit(Student student);
    boolean delete(Student student);
    Page<Student> findStudentByNameContainingAndActive(String name,Pageable pageable);
    boolean isExitEmail(StudentDTO studentDTO);

}
