package org.arthur.ss6_jpa.controller;

import org.arthur.ss6_jpa.model.StudentClass;
import org.arthur.ss6_jpa.service.IStudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class")
@CrossOrigin
public class ClassAPI {
    @Autowired
    IStudentClassService studentClassService;
    @GetMapping("")
    public ResponseEntity<List<StudentClass>> getListClass(){
        List<StudentClass> list = studentClassService.getList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentClass> findClassBIyId(@PathVariable("id") Long id){
        StudentClass studentClass = studentClassService.findById(id);
        if(studentClass == null){
            return new ResponseEntity<>(studentClass,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentClass,HttpStatus.OK);
    }
}
