package org.orak.schoolautamationsystem.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomRequest {
    public String name;
    public int schoolId;
}
