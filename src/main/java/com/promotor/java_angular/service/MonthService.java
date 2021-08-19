package com.promotor.java_angular.service;

import com.promotor.java_angular.repositories.MonthRepository;
import com.promotor.java_angular.model.Month;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonthService {

    private MonthRepository monthRepository;

    @Autowired
    public void setMonthRepository(MonthRepository monthRepository) {
        this.monthRepository = monthRepository;
    }

    public List<Month> findAllMonth(){
        return monthRepository.findAll();
    }

    public List<Month> findMonthByString(String string) {

        List<Month> months = monthRepository.findAll().stream()
                            .filter(month -> month.getName().toLowerCase().contains(string.toLowerCase()))
                            .collect(Collectors.toList());

        return months;
    }

    public Month saveMonth(Month month){
        monthRepository.save(month);
        return monthRepository.getMonthByName(month.getName());
    }

    public List<Month> updateMonth(Month month){
        Month monthDB = monthRepository.findMonthById(month.getId());
        if(monthDB != null){
            monthDB.setName(month.getName());
            monthRepository.save(monthDB);
            return Arrays.asList(monthDB);
        } else {
            throw new EntityNotFoundException("No matches with id :" + month.getId());
        }
    }

    public List<Month> deleteMonth(Long id) {
        Month monthDB = monthRepository.findMonthById(id);
        if(monthDB != null){
            monthRepository.delete(monthDB);
            return monthRepository.findAll();
        } else {
            return monthRepository.findAll();
        }
    }
}

