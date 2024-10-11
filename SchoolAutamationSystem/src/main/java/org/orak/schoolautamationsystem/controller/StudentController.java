package org.orak.schoolautamationsystem.controller;

import org.orak.schoolautamationsystem.dto.StudentDto;
import org.orak.schoolautamationsystem.request.StudentRequest;
import org.orak.schoolautamationsystem.response.StudentResponse;
import org.orak.schoolautamationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public StudentResponse create(@RequestBody StudentRequest studentRequest) {
        return toResponse(studentService.create(toEntity(studentRequest)));
    }

    @GetMapping
    public StudentResponse get(@RequestParam(value = "studentId") String id) {
        return toResponse(studentService.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        studentService.delete(id);
    }

    @PutMapping("/{id}")
    public StudentResponse update(@PathVariable(name = "id") String id, @RequestBody StudentRequest studentRequest) {
        return toResponse(studentService.update(id, toEntity(studentRequest)));
    }

    private StudentResponse toResponse(StudentDto dto) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(dto.getId());
        studentResponse.setName(dto.getName());
        studentResponse.setLessonId(dto.getId());
        return studentResponse;
    }


    private StudentDto toEntity(StudentRequest studentRequest) {
        StudentDto studentDto = new StudentDto();
        studentDto.setName(studentRequest.name);
        studentDto.setId(studentRequest.lessonId);
        return studentDto;
    }
}
