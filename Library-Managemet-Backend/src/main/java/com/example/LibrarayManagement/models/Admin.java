package com.example.LibrarayManagement.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @CreationTimestamp
    private Date createdOn;

    // n transactions here
    // What type of relationship it is

    @OneToMany(mappedBy = "admin")
    List<Transaction> transactionList;

    @OneToOne
    @JoinColumn
    private User user;

}
