package org.arthur.ss6_jpa.service;

import org.arthur.ss6_jpa.model.StudentClass;

import java.util.List;

public interface IStudentClassService {
List<StudentClass> getList();
boolean addNew(StudentClass studentClass);
StudentClass findById(Long id);
}
