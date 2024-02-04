package com.example.contact.PresentationLayer;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactRequestDTO {

        private String firstname;
        private String lastName;
        private String phoneNumber;
        private String address;
}
