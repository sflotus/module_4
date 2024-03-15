package org.arthur.ss1.repo.imple;

import org.arthur.ss1.model.Student;
import org.arthur.ss1.repo.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    static List<Student> list;
    static {
        list = new ArrayList<>();
        list.add(new Student(1,"a","a@gmail.com"));
        list.add(new Student(2,"b","b@gmail.com"));
        list.add(new Student(3,"c","c@gmail.com"));
        list.add(new Student(4,"d","d@gmail.com"));
    }
    @Override
    public List<Student> getList() {
        return list;
    }

    @Override
    public void add(Student student) {
    list.add(student);
    }
}
