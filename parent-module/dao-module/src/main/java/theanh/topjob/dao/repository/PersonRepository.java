package theanh.topjob.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import theanh.topjob.dao.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String>{

}
