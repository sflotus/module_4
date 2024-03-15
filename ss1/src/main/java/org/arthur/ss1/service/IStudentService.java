package org.arthur.ss1.service;

import org.arthur.ss1.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getList();
    void add(Student student);
}
