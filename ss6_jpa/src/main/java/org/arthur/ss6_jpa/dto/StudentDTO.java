package org.arthur.ss6_jpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.arthur.ss6_jpa.model.StudentClass;
import org.arthur.ss6_jpa.service.IStudentService;
import org.arthur.ss6_jpa.service.imple.StudentService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentDTO implements Validator {
    private long id;

    @NotBlank(message = "Please input Name")
    @Size(max =25,message = "Max length is 25 char, please try again." )
    @Pattern(regexp = "^[A-Za-z ]*",message = "Name must not contain number")
    private String name;
    @NotBlank(message = "Please input Email")
    @Size(max =60,message = "Max length is 60 char, please try again." )
    @Pattern(regexp ="^[^@]+@[^@]+\\.[^@]+$" ,message = "Please input right format Email")
    private String email;
    @NotBlank(message = "Please input address")
    private String address;
    private boolean active = true;
    @NotNull(message = "Please choose class")
    private StudentClass studentClass;

    public StudentDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        IStudentService studentService = new StudentService();
        StudentDTO student = (StudentDTO) target;
        if(!studentService.findStudentByEmail(student.getEmail()).isEmpty()){
            errors.rejectValue("email","","Email has been exist");
        }
    }
}
