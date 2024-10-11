package org.orak.schoolautamationsystem.repository;

import org.orak.schoolautamationsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
