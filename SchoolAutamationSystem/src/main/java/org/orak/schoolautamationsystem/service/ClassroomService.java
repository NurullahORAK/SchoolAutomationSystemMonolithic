package org.orak.schoolautamationsystem.service;

import org.orak.schoolautamationsystem.dto.ClassroomDto;

public interface ClassroomService {

    ClassroomDto get(String s);

    ClassroomDto create(ClassroomDto entity);

    void delete(String id);

    ClassroomDto update(String id, ClassroomDto entity);
}
