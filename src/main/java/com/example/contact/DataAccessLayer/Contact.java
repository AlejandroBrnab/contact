package com.example.contact.DataAccessLayer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="contacts")
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //interna or private (Integer a la  otra)

    @Column(name = "contactid")
    private String contactid; //public
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
}
