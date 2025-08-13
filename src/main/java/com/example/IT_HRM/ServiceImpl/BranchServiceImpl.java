package com.example.IT_HRM.ServiceImpl;

import com.example.IT_HRM.Entity.Branch;
import com.example.IT_HRM.GlobalException.DataIntegrityException;
import com.example.IT_HRM.Repository.BranchRepos;
import com.example.IT_HRM.Service.BranchService;
import com.example.IT_HRM.Utils.CommonUse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepos branchRep;

    @Override
    public Branch create(Branch branch) {
        checkDuplicates();
        Branch branch1 = new Branch();
        branch.setEntryBy("HO_IT");
        branch.setEntryDate(LocalDateTime.now());
        try {
            branch1 =  branchRep.save(branch);
        }catch (Exception e){
            throw new DataIntegrityException("Fields", e.getMessage());
        }
        return branch1;
    }

    public void checkDuplicates(){
        List<Branch> branchAll = branchRep.findAll();
        Map<String, List<Branch>> grouped = branchAll.stream().collect(Collectors.groupingBy(Branch::getBranchCode));
        grouped.forEach((key, group) -> {
            if(group.size() == 1){
                System.out.println("Duplicate found for: " + key);
                throw new DataIntegrityException("Duplicate",key);
            }
        });

    }

}
