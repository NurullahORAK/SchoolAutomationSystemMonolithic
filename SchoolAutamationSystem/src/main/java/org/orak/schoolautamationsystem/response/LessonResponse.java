package org.orak.schoolautamationsystem.response;

import lombok.*;
import org.orak.schoolautamationsystem.dto.StudentDto;
import org.orak.schoolautamationsystem.dto.TeacherDto;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonResponse {
    private int id;
    private String name;
    private int classroomId;
    private List<StudentDto> studentList;
    private TeacherDto teacher;
}
