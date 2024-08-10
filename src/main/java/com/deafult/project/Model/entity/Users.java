package com.deafult.project.Model.entity;

import com.deafult.project.Enums.Role;
import com.deafult.project.Enums.Gender;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;



@Table(name = "Users")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name" , nullable = false)
    private String name;     //     @Column(name = "name_user") change name in database

    @Column(name = "email" , unique = true , nullable = false)
    private String email;

    @Column(name = "password" , nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role" , nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender" , nullable = false)
    private Gender gender;

    @Column(name = "birthday" , nullable = false)
    private Date birthday;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
