package com.example.IT_HRM.Repository;

import com.example.IT_HRM.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepos extends JpaRepository<Branch,Long> {
}
