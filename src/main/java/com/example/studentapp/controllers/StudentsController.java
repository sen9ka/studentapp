package com.example.studentapp.controllers;

import com.example.studentapp.models.Student;
import com.example.studentapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.studentapp.util.ErrorsUtil.returnErrorsToClient;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentsController {

    private final StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> registerNewStudent(@RequestBody @Valid Student student,
                                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);
        studentService.addNewStudent(student);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

}
