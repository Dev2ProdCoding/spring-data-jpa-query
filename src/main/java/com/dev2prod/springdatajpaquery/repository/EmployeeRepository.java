package com.dev2prod.springdatajpaquery.repository;

import com.dev2prod.springdatajpaquery.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e")
    List<Employee> findAllEmployeesQuery();

    @Query("select e from Employee e where e.active=:activeState and e.designation in :designationList")
    List<Employee> findEmployeeByDesignationAndActiveQuery(@Param("activeState") Boolean activeState,
                                                           @Param("designationList") List<String> designationList,
                                                           Sort sort);
    @Modifying
    @Query("update Employee e set e.active= ?1 where e.empId in ?2")
    int updateEmployeeStateByEmployeeId(Boolean activeState,List<Long> empIdList);
}
