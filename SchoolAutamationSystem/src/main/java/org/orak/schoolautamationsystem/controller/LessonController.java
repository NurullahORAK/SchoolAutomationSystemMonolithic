package org.orak.schoolautamationsystem.controller;

import org.orak.schoolautamationsystem.dto.LessonDto;
import org.orak.schoolautamationsystem.request.LessonRequest;
import org.orak.schoolautamationsystem.response.LessonResponse;
import org.orak.schoolautamationsystem.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @PostMapping
    public LessonResponse create(@RequestBody LessonRequest lessonRequest) {
        return toResponse(lessonService.crate(toEntity(lessonRequest)));
    }

    @GetMapping
    public LessonResponse get(@RequestParam(value = "lessonId") String id) {
        return toResponse(lessonService.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        lessonService.delete(id);
    }

    @PutMapping("/{id}")
    public LessonResponse update(@PathVariable(name = "id") String id, @RequestBody LessonRequest lessonRequest) {
        return toResponse(lessonService.update(id, toEntity(lessonRequest)));
    }

    private LessonResponse toResponse(LessonDto dto) {
        return LessonResponse.builder()
                .id(dto.getId())
                .studentList(dto.getStudentList())
                .teacher(dto.getTeacher())
                .name(dto.getName())
                .classroomId(dto.getClassroomId())
                .build();
    }

    private LessonDto toEntity(LessonRequest lessonRequest) {
        return LessonDto.builder()
                .name(lessonRequest.getName())
                .classroomId(lessonRequest.getClassroomId())
                .build();
    }

}
