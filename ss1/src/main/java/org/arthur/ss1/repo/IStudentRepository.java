package org.arthur.ss1.repo;

import org.arthur.ss1.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getList();
    void add(Student student);
}
