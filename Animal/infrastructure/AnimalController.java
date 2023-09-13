package cu.edu.unah.Proyectov1.Animal.infrastructure;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.unah.Proyectov1.Animal.domain.Animal;
import cu.edu.unah.Proyectov1.Animal.domain.AnimalPK;
import cu.edu.unah.Proyectov1.Animal.application.AnimalService;

@RequestMapping("/animal")
@RestController
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Animal>> findAll() {
		try {
			return new ResponseEntity<List<Animal>>(animalService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Animal> findById(
			
			@RequestBody AnimalPK id) {
		try {
			return new ResponseEntity<Animal>(animalService.findId (id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Animal> create(
			
			@RequestBody Animal animal) throws URISyntaxException {
		Animal result = animalService.save(animal);


		return new ResponseEntity<Animal>(result,HttpStatus.CREATED);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Animal> updateAnimal(
			
			
			@RequestBody Animal animal) throws URISyntaxException {
		if (animal.getAnimalPK() == null) {
			return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
		}

		try {
			Animal result = animalService.update(animal);

			return new ResponseEntity<Animal>(result,HttpStatus.CREATED);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody AnimalPK id) {
		animalService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{us}/{rol}/{uf}/{paf}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol,@PathVariable int uf,@PathVariable int paf) {
AnimalPK id = new AnimalPK(us,rol,uf,paf);
System.out.println("voy a borrar"+id);
animalService.delete(id);
return ResponseEntity.ok().build();
}}

