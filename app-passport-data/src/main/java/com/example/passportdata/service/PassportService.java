package com.example.passportdata.service;

import com.example.passportdata.model.Passport;
import com.example.passportdata.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassportService {


    private final PassportRepository passportRepository;

    @Autowired
    public PassportService(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    public Passport create(Passport passport) {
        passportRepository.save(passport);
        return passport;
    }
    public Optional<Passport> getPassport(Long id){
        Optional<Passport> passport = passportRepository.findById(id);
        return passport;
    }
}
