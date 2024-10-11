package org.orak.schoolautamationsystem.repository;

import org.orak.schoolautamationsystem.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {
}
