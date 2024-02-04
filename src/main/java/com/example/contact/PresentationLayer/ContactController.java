package com.example.contact.PresentationLayer;

import com.example.contact.BusinessLayer.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {
    private ContactService contactService; //inject el contact service

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    //ResponseEntity<List<ContactResponseDTO> getAllContacts(){
    //return repsonseentity.ok().body(contactService.getAllContacts()); }
    //es la misma que de abajo, pero ella lo hizo asi
    @GetMapping()//no agregar nada porque los queremos todos
    public List<ContactResponseDTO> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{contactid}")
    public ResponseEntity<ContactResponseDTO> getContact(@PathVariable String contactid) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.getContactByid(contactid));
    }

    @PostMapping()
    public ResponseEntity<ContactResponseDTO> addContact(@RequestBody ContactRequestDTO contactRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.addContact(contactRequestDTO));
    }

    @PutMapping("/{contactid}")
    public ResponseEntity<ContactResponseDTO> updateContact(@PathVariable String contactid, @RequestBody ContactRequestDTO contactRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.updateContact(contactid, contactRequestDTO));
    }

    @DeleteMapping("/{contactid}")
    public ResponseEntity<Void> deleteContact(@PathVariable String contactid){
        contactService.deleteContact(contactid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
