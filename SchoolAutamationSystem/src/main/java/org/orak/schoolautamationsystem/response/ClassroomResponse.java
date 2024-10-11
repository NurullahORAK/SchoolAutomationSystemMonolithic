package org.orak.schoolautamationsystem.response;

import lombok.*;
import org.orak.schoolautamationsystem.dto.LessonDto;

import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomResponse {
    private int id;
    private String name;
    private int schoolId;
    private List<LessonDto> lessons;

}
