package com.example.contact.BusinessLayer;

import com.example.contact.DataAccessLayer.Contact;
import com.example.contact.DataAccessLayer.ContactRepository;
import com.example.contact.PresentationLayer.ContactRequestDTO;
import com.example.contact.PresentationLayer.ContactResponseDTO;
import com.example.contact.utils.InUseException.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//aqui se hace el IoC?
@Service
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactResponseDTO> getAllContacts() {
        List<ContactResponseDTO> contactsList = new ArrayList<>();

        contactRepository.findAll().forEach(contact -> {
            ContactResponseDTO contactResponseDTO = new ContactResponseDTO();
            BeanUtils.copyProperties(contact, contactResponseDTO); //copia to lo que tenga un variable field?
            contactsList.add(contactResponseDTO);
        });
        return contactsList;
    }

    @Override
    public ContactResponseDTO getContactByid(String contactid) {
        Contact foundContact = contactRepository.findContactByContactid(contactid);
        ContactResponseDTO contactResponseDTO = new ContactResponseDTO();
        if (foundContact == null){
            throw new NotFoundException("Unknown contactid: " + contactid);
        }
        BeanUtils.copyProperties(foundContact, contactResponseDTO);
        return contactResponseDTO;
    }

    @Override
    public ContactResponseDTO addContact(ContactRequestDTO contactRequestDTO) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDTO, contact);
        contact.setContactid(UUID.randomUUID().toString());
        Contact savedContact = contactRepository.save(contact);
        ContactResponseDTO contactResponseDTO = new ContactResponseDTO();
        BeanUtils.copyProperties(savedContact, contactResponseDTO);
        return contactResponseDTO;
    }

    @Override
    public ContactResponseDTO updateContact(String contactid, ContactRequestDTO contactRequestDTO) {
        Contact foundContact = contactRepository.findContactByContactid(contactid);
        if(foundContact == null){
            throw new NotFoundException("Unknown contactid: " + contactid);
        }
        BeanUtils.copyProperties(contactRequestDTO, foundContact);
        contactRepository.save(foundContact);
        ContactResponseDTO contactResponseDTO = new ContactResponseDTO();
        BeanUtils.copyProperties(foundContact, contactResponseDTO);
        return contactResponseDTO;
    }

    @Override
    public void deleteContact(String contactid) {
        Contact foundContact = contactRepository.findContactByContactid(contactid);
        if(foundContact == null){
            throw new NotFoundException("Unknown contactid: " + contactid);
        }
        contactRepository.delete(foundContact);
    }
}
