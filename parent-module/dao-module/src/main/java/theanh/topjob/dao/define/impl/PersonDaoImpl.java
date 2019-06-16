package theanh.topjob.dao.define.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import theanh.topjob.dao.define.IPersonDao;
import theanh.topjob.dao.entity.Person;
import theanh.topjob.dao.repository.PersonRepository;

@Repository
public class PersonDaoImpl implements IPersonDao{

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public void insert(Person person) {
		personRepository.saveAndFlush(person);
	}

	
}
