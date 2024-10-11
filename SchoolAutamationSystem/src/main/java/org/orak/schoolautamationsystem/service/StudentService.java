package org.orak.schoolautamationsystem.service;

import org.orak.schoolautamationsystem.dto.StudentDto;

public interface StudentService {
    StudentDto create(StudentDto entity);

    StudentDto get(String id);

    void delete(String id);

    StudentDto update(String id, StudentDto entity);
}
