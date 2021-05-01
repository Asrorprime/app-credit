package com.example.passportdata.controller;

import com.example.passportdata.model.Passport;
import com.example.passportdata.repository.PassportRepository;
import com.example.passportdata.service.PassportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passport")
public class PassportController {

    private final PassportRepository passportRepository;
    private final PassportService passprtService;

    public PassportController(PassportService passportService, PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
        this.passprtService = passportService;
    }

    @PostMapping("/create-passport")
    public ResponseEntity create(@RequestBody Passport passport) {
        Passport pinfl = passportRepository.findByPinfl(passport.getPinfl());
        Passport passportNumber = passportRepository.findByPassportNumber(passport.getPassportNumber());
        if (pinfl != null) {
            return ResponseEntity.ok("Bunday PINFL tizimda mavjud!");
        } else if (passportNumber != null) {
            return ResponseEntity.ok("Bunday seriyali  passport tizimda  mavjud!");
        } else passprtService.create(passport);
        return ResponseEntity.ok("Passport malumotlari saqlandi!");
    }

    @GetMapping("/get-passport")
    public ResponseEntity getPassport() {
        List<Passport> passport = passportRepository.findAll();
        return ResponseEntity.ok(passport);
    }

    @PostMapping("/get-pinfl/{pinfl}")
    public ResponseEntity getPassportWithPinfl(@PathVariable("pinfl") Long pinfl) {
        Passport passport = passportRepository.findByPinfl(pinfl);
        if (passport == null) {
            return ResponseEntity.ok("Bunday PNFL mavjud emas!");
        } else
            return ResponseEntity.ok(passport);
    }
}

