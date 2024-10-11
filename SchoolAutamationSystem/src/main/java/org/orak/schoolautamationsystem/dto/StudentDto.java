package org.orak.schoolautamationsystem.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private int id;
    private String name;
    private int lessonId;

}
