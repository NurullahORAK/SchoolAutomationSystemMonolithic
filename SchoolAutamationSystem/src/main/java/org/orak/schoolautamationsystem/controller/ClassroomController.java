package org.orak.schoolautamationsystem.controller;

import org.orak.schoolautamationsystem.dto.ClassroomDto;
import org.orak.schoolautamationsystem.request.ClassroomRequest;
import org.orak.schoolautamationsystem.response.ClassroomResponse;
import org.orak.schoolautamationsystem.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @PostMapping
    public ClassroomResponse create(@RequestBody ClassroomRequest classroomRequest) {
        return toResponse(classroomService.create(toEntity(classroomRequest)));
    }

    @GetMapping
    public ClassroomResponse get(@RequestParam(value = "classroomId") String classroomId) {
        return toResponse(classroomService.get(classroomId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        classroomService.delete(id);
    }

    @PutMapping("/{id}")
    public ClassroomResponse update(@PathVariable(value = "id") String id, @RequestBody ClassroomRequest classroomRequest) {
        return toResponse(classroomService.update(id, toEntity(classroomRequest)));
    }

    private ClassroomResponse toResponse(ClassroomDto classroomDto) {
        return ClassroomResponse.builder()
                .id(classroomDto.getId())
                .lessons(classroomDto.getLessons())
                .schoolId(classroomDto.getSchoolId())
                .name(classroomDto.getName())
                .build();
    }

    private ClassroomDto toEntity(ClassroomRequest classroomRequest) {
        return ClassroomDto.builder()
                .schoolId(classroomRequest.getSchoolId())
                .name(classroomRequest.getName())
                .build();
    }

}
