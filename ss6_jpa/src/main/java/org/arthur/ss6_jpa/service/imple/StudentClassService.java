package org.arthur.ss6_jpa.service.imple;

import org.arthur.ss6_jpa.model.StudentClass;
import org.arthur.ss6_jpa.repository.IStudentClassRepository;
import org.arthur.ss6_jpa.service.IStudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentClassService implements IStudentClassService {
    @Autowired
    IStudentClassRepository studentClassRepository;
    @Override
    public List<StudentClass> getList() {
        return studentClassRepository.findAll();
    }

    @Override
    public boolean addNew(StudentClass studentClass) {
       try{
           studentClassRepository.save(studentClass);
       }catch (Exception e){
           return  false;
       }
        return true;
    }
}
