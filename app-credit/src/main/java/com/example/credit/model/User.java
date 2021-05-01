package com.example.credit.model;

import com.example.credit.model.enums.Gender;
import com.example.credit.model.templates.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_entity")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String userLastName;
    @Size(min = 6, max = 12)
    private String password;
    private String email;
    @Column(unique = true)
    @NotBlank
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Gender gender;


}
