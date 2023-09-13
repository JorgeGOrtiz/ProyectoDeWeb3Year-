package cu.edu.unah.Proyectov1.ConsejoTratamiento.infrastructure;

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

import cu.edu.unah.Proyectov1.ConsejoTratamiento.domain.ConsejoTratamiento;
import cu.edu.unah.Proyectov1.ConsejoTratamiento.domain.ConsejoTratamientoPK;
import cu.edu.unah.Proyectov1.ConsejoTratamiento.application.ConsejoTratamientoService;

@RequestMapping("/ConsejoTratamiento")
@RestController
public class ConsejoTratamientoController {
	
	@Autowired
	private ConsejoTratamientoService ConsejoTratamientoService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ConsejoTratamiento>> findAll() {
		try {
			return new ResponseEntity<List<ConsejoTratamiento>>(ConsejoTratamientoService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejoTratamiento> findById(
			
			@PathVariable ConsejoTratamientoPK id) {
		try {
			return new ResponseEntity<ConsejoTratamiento>(ConsejoTratamientoService.findId (id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejoTratamiento> create(
			
			@RequestBody ConsejoTratamiento univ) throws URISyntaxException {
		ConsejoTratamiento result = ConsejoTratamientoService.save(univ);

		return ResponseEntity.created(new URI("/ConsejoTratamiento/create/" + result.getConsejoTratamientoPK())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejoTratamiento> updateConsejoTratamiento(
			
			
			@RequestBody ConsejoTratamiento univ) throws URISyntaxException {
		if (univ.getConsejoTratamientoPK() == null) {
			return new ResponseEntity<ConsejoTratamiento>(HttpStatus.NOT_FOUND);
		}

		try {
			ConsejoTratamiento result = ConsejoTratamientoService.update(univ);

			return ResponseEntity.created(new URI("/ConsejoTratamiento/updated/" + result.getConsejoTratamientoPK())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody ConsejoTratamientoPK id) {
		ConsejoTratamientoService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{us}/{rol}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol) {
ConsejoTratamientoPK id = new ConsejoTratamientoPK(us,rol);
System.out.println("voy a borrar"+id);
ConsejoTratamientoService.delete(id);
return ResponseEntity.ok().build();
}}

