package cu.edu.unah.Proyectov1.Enfermedades.infrastructure;

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

import cu.edu.unah.Proyectov1.Enfermedades.domain.Enfermedades;
import cu.edu.unah.Proyectov1.Enfermedades.application.EnfermedadesService;

@RequestMapping("/Enfermedades")
@RestController
public class EnfermedadesController {
	
	@Autowired
	private EnfermedadesService EnfermedadesService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Enfermedades>> findAll() {
		try {
			return new ResponseEntity<List<Enfermedades>>(EnfermedadesService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Enfermedades> findById(
			
						@PathVariable int id) {
		try {
			return new ResponseEntity<Enfermedades>(EnfermedadesService.findId(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Enfermedades> create(
			
			@RequestBody Enfermedades univ) throws URISyntaxException {
		Enfermedades result = EnfermedadesService.save(univ);

		return ResponseEntity.created(new URI("/Enfermedades/create/" + result.getIdEnfermedades())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Enfermedades> updateEnfermedades(
			
			
			@RequestBody Enfermedades univ) throws URISyntaxException {
		if (univ.getIdEnfermedades() == 0) {
			return new ResponseEntity<Enfermedades>(HttpStatus.NOT_FOUND);
		}

		try {
			Enfermedades result = EnfermedadesService.update(univ);

			return ResponseEntity.created(new URI("/Enfermedades/updated/" + result.getIdEnfermedades())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@PathVariable int id) {
		EnfermedadesService.delete(id);

		return ResponseEntity.ok().build();
	}

}
