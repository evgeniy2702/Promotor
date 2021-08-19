package com.promotor.java_angular.repositories;


import com.promotor.java_angular.model.Month;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthRepository extends JpaRepository<Month, Long> {

    Month getMonthByName(String name);

    Month findMonthById(Long id);

}
