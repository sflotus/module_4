package org.arthur.ss6_jpa.service.imple;

import org.arthur.ss6_jpa.model.Student;
import org.arthur.ss6_jpa.repository.IStudentRepository;
import org.arthur.ss6_jpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepository studentRepository;

    @Override
    public Page<Student> getList(Pageable pageable) {
        return studentRepository.findAllByActive(pageable);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean add(Student student) {
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean edit(Student student) {
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Student student) {
        student.setActive(false);
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Page<Student> findStudentByNameContainingAndActive( String name,Pageable pageable) {
        return studentRepository.findStudentByNameContainingAndActive(name, true,pageable);
    }

    @Override
    public List<Student> findStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }
}
