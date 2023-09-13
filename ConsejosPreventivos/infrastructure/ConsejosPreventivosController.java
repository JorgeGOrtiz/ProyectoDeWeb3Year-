package cu.edu.unah.Proyectov1.ConsejosPreventivos.infrastructure;

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

import cu.edu.unah.Proyectov1.ConsejosPreventivos.domain.ConsejosPreventivos;
import cu.edu.unah.Proyectov1.ConsejosPreventivos.application.ConsejosPreventivosService;

@RequestMapping("/consejosPreventivos")
@RestController
public class ConsejosPreventivosController {
	
	@Autowired
	private ConsejosPreventivosService  ConsejosPreventivosService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ConsejosPreventivos>> findAll() {
		try {
			return new ResponseEntity<List<ConsejosPreventivos>>(ConsejosPreventivosService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejosPreventivos> findById(
			
						@PathVariable int id) {
		try {
			return new ResponseEntity<ConsejosPreventivos>(ConsejosPreventivosService.findId(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejosPreventivos> create(
			
			@RequestBody ConsejosPreventivos univ) throws URISyntaxException {
		ConsejosPreventivos result = ConsejosPreventivosService.save(univ);

		return ResponseEntity.created(new URI("/ConsejosPreventivos/create/" + result.getIdConsejosPreventivos())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejosPreventivos> updateGrupoanimal(
			
			
			@RequestBody ConsejosPreventivos univ) throws URISyntaxException {
		if (univ.getIdConsejosPreventivos() == 0) {
			return new ResponseEntity<ConsejosPreventivos>(HttpStatus.NOT_FOUND);
		}

		try {
			ConsejosPreventivos result = ConsejosPreventivosService.update(univ);

			return ResponseEntity.created(new URI("/ConsejosPreventivos/updated/" + result.getIdConsejosPreventivos())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@PathVariable int id) {
		ConsejosPreventivosService.delete(id);

		return ResponseEntity.ok().build();
	}

}
