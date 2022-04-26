package com.example.agw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.agw.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query(value = "select p from Person p where p.id = 1001")
	Person find1Mains();

	@Query(value = "select p from Person p where p.id in (:id1 , :id2)")
	List<Person> find2Mains(@Param("id1") long id1, @Param("id2") long i2);
}
