package com.example.transonicweb.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="user_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  {
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Column(length=30, nullable=false)
    private String name;

    @Column(length=20, nullable=false)
    private String password;

    @Column(length=200, nullable=false)
    private String email;

    @Column
    private boolean enabled;
}
