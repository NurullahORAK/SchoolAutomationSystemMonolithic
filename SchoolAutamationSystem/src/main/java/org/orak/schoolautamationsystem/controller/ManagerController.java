package org.orak.schoolautamationsystem.controller;

import org.orak.schoolautamationsystem.dto.ManagerDto;
import org.orak.schoolautamationsystem.request.ManagerRequest;
import org.orak.schoolautamationsystem.response.ManagerResponse;
import org.orak.schoolautamationsystem.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @PostMapping
    public ManagerResponse create(@RequestBody ManagerRequest managerRequest){
        return toResponse(managerService.create(toEntity(managerRequest)));
    }
    @GetMapping
    public ManagerResponse get(@RequestParam(value = "managerId")String id){
        return toResponse(managerService.get(id));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id")String id){
        managerService.delete(id);
    }
    @PutMapping("/{id}")
    private ManagerResponse update(@PathVariable(name = "id")String id,@RequestBody ManagerRequest managerRequest){
        return toResponse(managerService.update(id,toEntity(managerRequest)));
    }
    private ManagerResponse toResponse(ManagerDto managerDto) {
        ManagerResponse managerResponse=new ManagerResponse();
        managerResponse.setId(managerDto.getId());
        managerResponse.setName(managerDto.getName());
        return managerResponse;
    }

    private ManagerDto toEntity(ManagerRequest managerRequest) {
        ManagerDto managerDto=new ManagerDto();
        managerDto.setId(managerRequest.id);
        managerDto.setName(managerRequest.name);
        return managerDto;
    }
}
