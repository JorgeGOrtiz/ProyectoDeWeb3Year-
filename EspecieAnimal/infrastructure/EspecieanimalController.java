package cu.edu.unah.Proyectov1.EspecieAnimal.infrastructure;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import cu.edu.unah.Proyectov1.Animal.domain.Animal;
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

import cu.edu.unah.Proyectov1.EspecieAnimal.domian.Especieanimal;
import cu.edu.unah.Proyectov1.EspecieAnimal.domian.EspecieanimalPK;
import cu.edu.unah.Proyectov1.EspecieAnimal.application.EspecieanimalService;

@RequestMapping("/especieanimal")
@RestController
public class EspecieanimalController {
	
	@Autowired
	private EspecieanimalService especieAnimalService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Especieanimal>> findAll() {
		try {
			return new ResponseEntity<List<Especieanimal>>(especieAnimalService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Especieanimal> findById(
			
						@RequestBody EspecieanimalPK id) {
		try {
			return new ResponseEntity<Especieanimal>(especieAnimalService.findId(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Especieanimal> create(
			
			@RequestBody Especieanimal especieanimal) throws URISyntaxException {
		Especieanimal result = especieAnimalService.save(especieanimal);

		return new ResponseEntity<Especieanimal>(result, HttpStatus.CREATED);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Especieanimal> updateEspecieanimal(
			
			
			@RequestBody Especieanimal especieanimal) throws URISyntaxException {
		if (especieanimal.getEspecieanimalPK() == null) {
			return new ResponseEntity<Especieanimal>(HttpStatus.NOT_FOUND);
		}

		try {
			Especieanimal result = especieAnimalService.update(especieanimal);

			return new ResponseEntity<Especieanimal>(result,HttpStatus.CREATED);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody EspecieanimalPK id) {
		especieAnimalService.delete(id);

		return ResponseEntity.ok().build();
	}
	@PostMapping(path = { "/delete/{us}/{rol}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol) {
		EspecieanimalPK id = new EspecieanimalPK(us,rol);
		System.out.println("voy a borrar"+id);
		especieAnimalService.delete(id);
		return ResponseEntity.ok().build();
	}

}
