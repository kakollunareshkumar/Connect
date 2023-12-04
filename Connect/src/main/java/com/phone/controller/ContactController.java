package com.phone.controller;

import com.phone.entities.Contact;
import com.phone.service.IContactService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private IContactService iContactService;



   @PostMapping("/add")
   public  ResponseEntity<Contact> addContact(@RequestBody @Valid Contact contact){

       Contact addedContact = iContactService.addContact(contact);

       return  new ResponseEntity<>(addedContact, HttpStatus.ACCEPTED);
   }

    @PutMapping("/update/{id}")
    public  ResponseEntity<Contact> updateContact(@PathVariable("id") Long id,@RequestBody @Valid Contact contact){

        Contact updatedContact = iContactService.updateContact(id,contact);

        return  new ResponseEntity<>(updatedContact, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteContact(@PathVariable("id") Long contactId){

             iContactService.deleteContact(contactId);

        return  new ResponseEntity<>("contact deleted successfully", HttpStatus.OK);
    }
    @GetMapping("/all")
    public  ResponseEntity<List<Contact>> getAllContacts(){

       List<Contact> allContacts =  iContactService.getAllContacts();

        return  new ResponseEntity<>(allContacts, HttpStatus.OK);
    }

    @GetMapping("/all/{name}")
    public  ResponseEntity<List<Contact>> getAllContactsByName(@PathVariable ("name") String name){

        List<Contact> allContactsByName =  iContactService.getContactsByName(name);

        System.out.println(" Added contacts to see merge process");
        System.out.println("Added another sout statement");
        int rand  = (int) Math.random();
        System.out.println("multiplication of 2  numbers "+rand*4);

        return  new ResponseEntity<>(allContactsByName, HttpStatus.OK);
    }

    @GetMapping("/all/add")
    public ResponseEntity<Integer> getMultiplication(int a, int b){

        int add  = a+b;
        return  new ResponseEntity<Integer>(add, HttpStatus.OK);
    }


    @GetMapping("/all/multiply")
    public ResponseEntity<Integer> getaddition(int a, int b){

        int mult  = a*b;
        System.out.println(" Added a*b in main branch");
         System.out.println(" Added another sout statement to see fetch and pull difference");
        System.out.println(" Added another sout statement  to see arrow button");
        
        return  new ResponseEntity<Integer>(mult, HttpStatus.OK);
    }


    
    @GetMapping("/all/divide")
    public ResponseEntity<Integer> getdivide(int a, int b){

        int mult  = a/b;
        System.out.println(" Added a/b in main branch");
         System.out.println(" Added another sout statement to see merge from main to delete_swagger1");
        System.out.println(" Added another sout statement  to see merge conflicts");
        
        return  new ResponseEntity<Integer>(mult, HttpStatus.OK);
    }
   
    @GetMapping("/all/mod")
    public ResponseEntity<Integer> getdivide(int a, int b){

        int mult  = a%b;
        System.out.println(" Added a%b in main branch");
         System.out.println(" Added another sout statement to see difference between local and remote branches in IDE");
        System.out.println(" Added another sout statement  to new changes by creating a new branch with remote repository branch ");
        
        return  new ResponseEntity<Integer>(mult, HttpStatus.OK);
    }
}
