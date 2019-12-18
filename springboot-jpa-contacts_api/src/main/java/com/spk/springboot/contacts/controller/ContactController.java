/**
 * 
 */
package com.spk.springboot.contacts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spk.springboot.contacts.dao.ContactDAO;
import com.spk.springboot.contacts.model.Contact;

/**
 * @author Praveen
 *
 */

@RestController
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	private ContactDAO dao;

	@PostMapping("/save")
	public Contact saveContact(@RequestBody Contact contact) {
		dao.save(contact);
		return contact;

	}

	@GetMapping("/list")
	public List<Contact> getContacts() {
		return dao.findAll();
	}

	@GetMapping("/contact/{id}")
	public Optional<Contact> getContactById(@PathVariable int id) {
		Optional<Contact> contact = dao.findById(id);
		return contact;

	}

	@PutMapping("/update")
	public Contact updateContact(@RequestBody Contact contact) {
		dao.save(contact);
		return contact;
	}

	@DeleteMapping("/delete/{id}")
	public String deleteContact(@PathVariable int id) {
		dao.deleteById(id);
		return "Contact has been deleted with id :" + id;

	}

	@DeleteMapping("delete")
	public String deleteAllContacts() {
		dao.deleteAll();
		return "All contacts has been deleted";
	}

}
