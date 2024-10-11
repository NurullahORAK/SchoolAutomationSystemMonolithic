package org.orak.schoolautamationsystem.service.impl;

import org.orak.schoolautamationsystem.dto.StudentDto;
import org.orak.schoolautamationsystem.entity.Student;
import org.orak.schoolautamationsystem.repository.StudentRepository;
import org.orak.schoolautamationsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private LessonServiceImpl service;

    @Override
    public StudentDto create(StudentDto entity) {
        return toDto(repository.save(toEntity(entity)));
    }

    @Override
    public StudentDto get(String id) {
        return toDto(repository.findById(Integer.parseInt(id)).get());
    }

    @Override
    public void delete(String id) {
        repository.deleteById(Integer.parseInt(id));
    }

    @Override
    public StudentDto update(String id, StudentDto entity) {
        StudentDto studentDto = toDto(repository.findById(Integer.parseInt(id)).get());
        studentDto.setId(entity.getId());
        studentDto.setName(entity.getName());
        return toDto(repository.save(toEntity(studentDto)));
    }

    private Student toEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setStudentName(studentDto.getName());
        student.setLesson(service.findLessonById(studentDto.getLessonId()));
        return student;
    }

    public StudentDto toDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getStudentName());
        studentDto.setLessonId(student.getLesson().getId());
        return studentDto;
    }
}
