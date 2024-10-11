package org.orak.schoolautamationsystem.dto;

import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomDto {
    private int id;
    private String name;
    private int schoolId;
    private List<LessonDto> lessons;
    }
