package com.example.credit.service;

import com.example.credit.model.Credit;
import com.example.credit.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditService {

    private final CreditRepository creditRepository;

    @Autowired
    public CreditService(CreditRepository creditRepository){
        this.creditRepository=creditRepository;
    }

    public Credit create(Credit credit){
        Credit credit1 = creditRepository.save(credit);
        return credit1;
    }
}
