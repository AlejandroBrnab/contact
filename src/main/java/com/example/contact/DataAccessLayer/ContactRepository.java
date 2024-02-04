package com.example.contact.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findContactByContactid(String contactid);

}
