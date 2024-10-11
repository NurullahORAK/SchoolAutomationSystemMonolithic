package org.orak.schoolautamationsystem.service;

import org.orak.schoolautamationsystem.dto.LessonDto;

public interface LessonService {
    LessonDto crate(LessonDto entity);

    LessonDto get(String id);

    void delete(String id);

    LessonDto update(String id, LessonDto entity);
}
