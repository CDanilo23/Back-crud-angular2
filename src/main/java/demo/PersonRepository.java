package demo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	Collection<Person> findByName(String name);
	
	Person findById(Integer id);
	
	@SuppressWarnings("unchecked")
	Person save(Person person);
}
