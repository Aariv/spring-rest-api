package com.ariv.rest.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ariv.rest.model.Person;

@Repository
public class PersonRepository {

	private List<Person> persons = new ArrayList<>();
	
	public PersonRepository() {
		persons.add(new Person((long) (persons.size() + 1), "Selva"));
		persons.add(new Person((long) (persons.size() + 1), "Tom"));
		persons.add(new Person((long) (persons.size() + 1), "Jerry"));
	}

	public Person add(Person person) {
		person.setId((long) (persons.size() + 1));
		persons.add(person);
		return person;
	}

	public Person update(Person person) {
		persons.set(person.getId().intValue() - 1, person);
		return person;
	}

	public Person update(Long id, Person person) {
		persons.set(id.intValue() - 1, person);
		return person;
	}

	public Person findById(Long id) {
		Optional<Person> person = persons.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (person.isPresent())
			return person.get();
		else
			return null;
	}
	
	public List<Person> findAll() {
		return persons;
	}

	public void delete(Long id) {
		persons.remove(id.intValue());
	}

}