package org.orak.schoolautamationsystem.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonRequest {
    public String name;
    public int classroomId;
}
