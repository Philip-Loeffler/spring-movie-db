package com.bmdb.db;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.Actor;
public interface ActorRepo extends JpaRepository<Actor, Integer> {

	List<Actor> findByGender(String gender);
	List<Actor> findByLastNameLike(String lastName);
	List<Actor> findByBirthDateBetween(LocalDate d1, LocalDate d2);

//	List<Actor> findByDate(LocalDate birthDate);

}





