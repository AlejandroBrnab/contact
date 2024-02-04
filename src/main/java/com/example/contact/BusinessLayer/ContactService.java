package com.example.contact.BusinessLayer;

import com.example.contact.PresentationLayer.ContactRequestDTO;
import com.example.contact.PresentationLayer.ContactResponseDTO;

import java.util.List;

//to lo que tiene que estar en el server
public interface ContactService {

    public List<ContactResponseDTO> getAllContacts();

    public ContactResponseDTO getContactByid(String contactid);

    public ContactResponseDTO addContact(ContactRequestDTO contactRequestDTO);

    public ContactResponseDTO updateContact(String contactid, ContactRequestDTO contactRequestDTO);

    public void deleteContact(String contactid);
}
