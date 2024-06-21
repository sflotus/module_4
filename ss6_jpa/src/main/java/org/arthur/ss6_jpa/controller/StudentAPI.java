package org.arthur.ss6_jpa.controller;

import jakarta.validation.Valid;
import org.arthur.ss6_jpa.dto.StudentDTO;
import org.arthur.ss6_jpa.model.Student;
import org.arthur.ss6_jpa.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentAPI {
    @Autowired
    IStudentService studentService;
    @GetMapping("")
    public ResponseEntity<Page<Student>> getListStudent(@RequestParam(defaultValue = "",required = false) String valueSearch,
                                                        @RequestParam(defaultValue = "0",required = false) int page){
        Sort sort = Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(page,20,sort);
        Page<Student> listStudent = studentService.findStudentByNameContainingAndActive(valueSearch,pageable);
        return new  ResponseEntity<>(listStudent,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> addNewStudent(@Valid @RequestBody StudentDTO studentDTO,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            Map<String, String> map = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                map.put(error.getField(),error.getDefaultMessage());
            });
           return  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO,student);
        String msg;
        if (studentService.add(student)) {
            msg = "Add new student successful";
            return new ResponseEntity<>(msg,HttpStatus.OK);
        } else {
            msg = "Add new Student failed";
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        Student student = studentService.findById(id);
        String msg;
        if (studentService.delete(student)) {
            msg = "Delete successful";
        } else msg = "Delete failed";
        return  new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
