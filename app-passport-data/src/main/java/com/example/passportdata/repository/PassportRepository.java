package com.example.passportdata.repository;

import com.example.passportdata.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {
    Passport findByPinfl(Long pinfl);

    Passport findByPassportNumber(String passportNumber);
}
