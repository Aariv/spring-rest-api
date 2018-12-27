/**
 * 
 */
package com.ariv.rest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ariv.rest.model.Person;
import com.ariv.rest.repository.PersonRepository;

/**
 * @author kloudone
 *
 */
@RestController
@RequestMapping("/api")
public class PersonResource {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/persons")
	public List<Person> persons() {
		return personRepository.findAll();
	}
}
