package com.example.IT_HRM.Service;

import com.example.IT_HRM.DTO.LeaveDTO;
import com.example.IT_HRM.Entity.Leave;

import java.util.List;

public interface LeaveService {

    LeaveDTO Create(LeaveDTO leaveDTO);

    List<LeaveDTO> ListLeave();

    Leave getById( Long Id);

    Leave getByEmployee( Long emp ) ;

}
