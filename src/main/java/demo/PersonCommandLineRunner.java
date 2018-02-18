package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonCommandLineRunner implements CommandLineRunner{

	@Override
	public void run(String... arg0) throws Exception {
		for(Person person : personRepository.findAll()) {
			System.out.println(person.getName());
		}
	}
	
	@Autowired
	PersonRepository personRepository;
	
	
}
