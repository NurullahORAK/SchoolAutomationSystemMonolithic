package org.orak.schoolautamationsystem.service;

import org.orak.schoolautamationsystem.dto.TeacherDto;

public interface TeacherService {
    TeacherDto update(String id, TeacherDto entity);

    TeacherDto create(TeacherDto teacherDto);

    TeacherDto get(String id);

    void delete(String id);
}
