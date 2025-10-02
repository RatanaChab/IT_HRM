package com.example.IT_HRM.Controller;

import com.example.IT_HRM.Entity.ProgramMenu;
import com.example.IT_HRM.Service.ProgramMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("api/hrm/menu")
public class ProgramController {

    @Autowired
    private ProgramMenuService programMenuService;

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody ProgramMenu menu){
        programMenuService.create(menu);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getProgram(){
        List<String> allProgram = programMenuService.getAllProgram().stream().map(p -> p.getMenuUrl()).toList();
        return ResponseEntity.ok(programMenuService.getAllProgram());
    }
}
