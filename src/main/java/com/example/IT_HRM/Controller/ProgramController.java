package com.example.IT_HRM.Controller;

import com.example.IT_HRM.Entity.ProgramMenu;
import com.example.IT_HRM.Entity.UserGroupMenuId;
import com.example.IT_HRM.Service.ProgramMenuService;
import com.example.IT_HRM.Service.UserGroupMenuService;
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
    @Autowired
    private UserGroupMenuService userGroupMenuService;

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody ProgramMenu menu){
        programMenuService.create(menu);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/Programs/{menu}")
    public ResponseEntity<?> getProgramFilter(@RequestParam String menu){
        List<ProgramMenu> Menu = programMenuService.getBymenuIDN(menu);
        return ResponseEntity.ok(Menu);
    }

    @GetMapping
    public ResponseEntity<?> getProgram(){
        List<UserGroupMenuId> all = userGroupMenuService.getAll();
        return ResponseEntity.ok(all);
    }
}
