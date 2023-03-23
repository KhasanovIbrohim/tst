package com.example.tst.controller;

import com.example.tst.dto.GroupDTO;
import com.example.tst.dto.UpdateGroupDTO;
import com.example.tst.payload.ResultMessage;
import com.example.tst.payload.ResultMessageObject;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/group")
public interface GroupController {
    @PostMapping("/create-group")
    ResultMessageObject add(@RequestBody GroupDTO groupDTO);
    @PutMapping("/update-group/{id}")
    ResultMessageObject update(@PathVariable UUID id, @RequestBody UpdateGroupDTO updateGroupDTO);
    @DeleteMapping
    ResultMessage delete(@PathVariable UUID groupId);
}
