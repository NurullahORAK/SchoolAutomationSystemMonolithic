package org.orak.schoolautamationsystem.repository;

import org.orak.schoolautamationsystem.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School,Integer> {
}
