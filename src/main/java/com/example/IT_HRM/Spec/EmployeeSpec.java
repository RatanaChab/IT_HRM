package com.example.IT_HRM.Spec;

import com.example.IT_HRM.Entity.Employee;
import com.example.IT_HRM.Entity.EmployeeDetail;
import jakarta.persistence.criteria.*;
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

        CriteriaQuery<EmployeeDetail>  criteriaQuery = cb.createQuery(EmployeeDetail.class);
        Root<EmployeeDetail> fromEmpDetail = query.from(EmployeeDetail.class);
        //CriteriaQuery<EmployeeDetail> empCode2 = criteriaQuery.select(fromEmpDetail.get("emp_code"));


        if( Objects.nonNull(employeeFilter.getEmpCode()) ) {
            String empCode = employeeFilter.getEmpCode();
            Predicate empCode1 = cb.equal(fromEmpDetail.get("emp_code"), employeeFilter.getEmpCode());
            predicates.add(empCode1);
        }

        //Predicate pred = cb.and(predicates.toArray(Predicate[]::new)).in(join);
        Predicate pred = cb.and(predicates.toArray(Predicate[]::new));
        return pred;
    }
}
