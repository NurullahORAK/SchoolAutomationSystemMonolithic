package org.orak.schoolautamationsystem.response;

import lombok.*;
import org.orak.schoolautamationsystem.dto.ClassroomDto;
import org.orak.schoolautamationsystem.dto.ManagerDto;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SchoolResponse {
    private int id;

    private String name;


    private ManagerDto manager;


    private List<ClassroomDto> classrooms;


}

