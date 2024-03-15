package org.arthur.ss1.service.imple;

import org.arthur.ss1.model.Student;
import org.arthur.ss1.repo.IStudentRepository;
import org.arthur.ss1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepository studentRepository;
    @Override
    public List<Student> getList() {
        return studentRepository.getList();
    }

    @Override
    public void add(Student student) {
        studentRepository.add(student);
    }
}
