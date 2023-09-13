package cu.edu.unah.Proyectov1.Diagnostico.infrastructure;

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

import cu.edu.unah.Proyectov1.Diagnostico.domain.Diagnostico;
import cu.edu.unah.Proyectov1.Diagnostico.domain.DiagnosticoPK;
import cu.edu.unah.Proyectov1.Diagnostico.application.DiagnosticoService;

@RequestMapping("/Diagnostico")
@RestController
public class DiagnosticoController {
	
	@Autowired
	private DiagnosticoService DiagnosticoService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Diagnostico>> findAll() {
		try {
			return new ResponseEntity<List<Diagnostico>>(DiagnosticoService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Diagnostico> findById(
			
			@PathVariable DiagnosticoPK id) {
		try {
			return new ResponseEntity<Diagnostico>(DiagnosticoService.findId (id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Diagnostico> create(
			
			@RequestBody Diagnostico univ) throws URISyntaxException {
		Diagnostico result = DiagnosticoService.save(univ);

		return ResponseEntity.created(new URI("/Diagnostico/create/" + result.getDiagnosticoPK())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Diagnostico> updateDiagnostico(
			
			
			@RequestBody Diagnostico univ) throws URISyntaxException {
		if (univ.getDiagnosticoPK() == null) {
			return new ResponseEntity<Diagnostico>(HttpStatus.NOT_FOUND);
		}

		try {
			Diagnostico result = DiagnosticoService.update(univ);

			return ResponseEntity.created(new URI("/Diagnostico/updated/" + result.getDiagnosticoPK())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody DiagnosticoPK id) {
		DiagnosticoService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{us}/{rol}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol) {
DiagnosticoPK id = new DiagnosticoPK(us,rol);
System.out.println("voy a borrar"+id);
DiagnosticoService.delete(id);
return ResponseEntity.ok().build();
}}

