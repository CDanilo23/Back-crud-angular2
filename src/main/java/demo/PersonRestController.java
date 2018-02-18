package demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonRestController {
		
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping(produces="application/json",value="/persons",method=RequestMethod.GET)
	Collection<Person> findAll(){
		return this.personRepository.findAll();
	}
	
	@RequestMapping(produces="application/json",value="/persons/{id}",method=RequestMethod.GET)
	public Person getPersonById(@PathVariable("id") int id) {
		return this.personRepository.findById(id);
	}
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@RequestMapping(consumes= {"application/json"} , value="/persons", method=RequestMethod.PUT)
//	public Person editPerson(String person) {
//		System.out.println(person);
//		
//		return null;
//	}
	
	@RequestMapping(value="/persons/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Person> updateUser(@PathVariable("id") int id, @RequestBody Person person ){
		System.out.println(id+person.toString());
		Person currentPerson = personRepository.findById(id);
		if(currentPerson==null) {
			System.out.println(" Person with id => "+id+" doesn't found");
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		
		return  new ResponseEntity<Person>(HttpStatus.OK);
	}
}
