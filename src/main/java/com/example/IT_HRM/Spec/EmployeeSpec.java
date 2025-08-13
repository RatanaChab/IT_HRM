package com.example.IT_HRM.Spec;

import com.example.IT_HRM.Entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class EmployeeSpec implements Specification<Employee> {

    private final EmployeeFilter employeeFilter;

    List<Predicate> predicates = new ArrayList<>();

    @Override
    public Predicate toPredicate(Root<Employee> emp, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if( Objects.nonNull(employeeFilter.getId()) ){
            Predicate id = emp.get("id").in(employeeFilter.getId());
            predicates.add(id);
        }

        if( Objects.nonNull(employeeFilter.getBranch()) ){
            Predicate branch = emp.get("branch").in(employeeFilter.getBranch());
            predicates.add(branch);
        }
        Predicate pred = cb.and(predicates.toArray(Predicate[]::new));
        return pred;
    }
}
