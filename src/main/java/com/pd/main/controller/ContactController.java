package com.pd.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pd.main.entity.Contact;
import com.pd.main.service.ContactService;

@RestController
@RequestMapping("/pb")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping("/save")
	public ResponseEntity<String> saveContacts(@RequestBody Contact Contact) {
		String body = contactService.saveContact(Contact);

		return ResponseEntity.ok(body);

	}

	@GetMapping("/all")
	public ResponseEntity<List<Contact>> getAllContacts() {
		List<Contact> allContacts = contactService.getAllContacts();
		return ResponseEntity.ok(allContacts);

	}

	@GetMapping("/edit/{id}")
	public ResponseEntity<Contact> editContactById(@PathVariable("id") Integer id) {
		Contact contactById = contactService.getContactById(id);
		return ResponseEntity.ok(contactById);

	}

	@PutMapping("/update")
	public ResponseEntity<String> upadteContactsById(@RequestBody Contact Contact) {
		String saveContact = contactService.updateContact(Contact);
		return ResponseEntity.ok(saveContact);

	}

	@DeleteMapping("/delete/{contactId}")
	public ResponseEntity<String> deleteContactsById(@PathVariable("contactId") Integer contactId) {
		String deleteContactById = contactService.deleteContactById(contactId);
		return ResponseEntity.ok(deleteContactById);

	}

}
