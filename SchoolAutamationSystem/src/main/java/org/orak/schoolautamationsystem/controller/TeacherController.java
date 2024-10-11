package org.orak.schoolautamationsystem.controller;

import org.orak.schoolautamationsystem.dto.TeacherDto;
import org.orak.schoolautamationsystem.request.TeacherRequest;
import org.orak.schoolautamationsystem.response.TeacherResponse;
import org.orak.schoolautamationsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public TeacherResponse create(@RequestBody TeacherRequest teacherRequest) {
        return toResponse(teacherService.create(toEntity(teacherRequest)));
    }

    @GetMapping
    public TeacherResponse get(@RequestParam(value = "teacherId") String id) {
        return toResponse(teacherService.get(id));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id")String id){
        teacherService.delete(id);
    }
    @PutMapping("/{id}")
    public TeacherResponse update(@PathVariable(name = "id")String id,@RequestBody TeacherRequest teacherRequest){
        return toResponse(teacherService.update(id,toEntity(teacherRequest)));
    }

    private TeacherResponse toResponse(TeacherDto dto) {
        TeacherResponse response=new TeacherResponse();
        response.setId(dto.getId());
        response.setTeacherName(dto.getTeacherName());
        return response;
    }

    private TeacherDto toEntity(TeacherRequest teacherRequest) {
        TeacherDto teacherDto=new TeacherDto();
        teacherDto.setTeacherName(teacherRequest.teacherName);
        return teacherDto;
    }
}