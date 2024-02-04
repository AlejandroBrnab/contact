package com.example.contact.PresentationLayer;

import lombok.Data;
import lombok.NoArgsConstructor;

//las cosas que se mandan para el request
@Data
@NoArgsConstructor
public class ContactResponseDTO {

    private String contactid; //public
    private String firstname;
    private String lastName;
    private String phoneNumber;
    private String address;
}
