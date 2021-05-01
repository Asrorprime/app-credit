package com.example.passportdata.model;

import com.example.passportdata.model.template.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "passport_entity")
public class Passport extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String givenByWhom;
    @Column(length = 9, unique = true)
    private String passportNumber;
    private String dateOfBirth;
    private String dateOfIssue;
    private String dateOfExpire;
    @Column(length = 14, unique = true)
    private Long pinfl;
    private String placeOfPlace;

    public Passport() {
    }

    public Passport(Long id, String givenByWhom, String passportNumber, String dateOfBirth, String dateOfIssue, String dateOfExpire, Long pinfl, String placeOfPlace) {
        this.id = id;
        this.givenByWhom = givenByWhom;
        this.passportNumber = passportNumber;
        this.dateOfBirth = dateOfBirth;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpire = dateOfExpire;
        this.pinfl = pinfl;
        this.placeOfPlace = placeOfPlace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGivenByWhom() {
        return givenByWhom;
    }

    public void setGivenByWhom(String givenByWhom) {
        this.givenByWhom = givenByWhom;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfExpire() {
        return dateOfExpire;
    }

    public void setDateOfExpire(String dateOfExpire) {
        this.dateOfExpire = dateOfExpire;
    }

    public Long getPinfl() {
        return pinfl;
    }

    public void setPinfl(Long pinfl) {
        this.pinfl = pinfl;
    }

    public String getPlaceOfPlace() {
        return placeOfPlace;
    }

    public void setPlaceOfPlace(String placeOfPlace) {
        this.placeOfPlace = placeOfPlace;
    }
}
