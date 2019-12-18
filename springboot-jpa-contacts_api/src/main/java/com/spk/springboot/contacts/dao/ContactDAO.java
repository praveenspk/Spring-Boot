/**
 * 
 */
package com.spk.springboot.contacts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spk.springboot.contacts.model.Contact;

/**
 * @author Praveen
 *
 */

@Repository
public interface ContactDAO extends JpaRepository<Contact, Integer> {

}
