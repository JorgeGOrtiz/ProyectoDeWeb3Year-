package cu.edu.unah.Proyectov1.ConsejoPracticaCrianza.infrastructure;

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

import cu.edu.unah.Proyectov1.ConsejoPracticaCrianza.domain.ConsejosPracticasCrianza;
import cu.edu.unah.Proyectov1.ConsejoPracticaCrianza.application.ConsejosPracticasCrianzaService;

@RequestMapping("/ConsejoPracticasCrianza")
@RestController
public class ConsejoPracticasCrianzaController {
	
	@Autowired
	private ConsejosPracticasCrianzaService ConsejosPracticasCrianzaService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ConsejosPracticasCrianza>> findAll() {
		try {
			return new ResponseEntity<List<ConsejosPracticasCrianza>>(ConsejosPracticasCrianzaService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejosPracticasCrianza> findById(
			
						@PathVariable int id) {
		try {
			return new ResponseEntity<ConsejosPracticasCrianza>(ConsejosPracticasCrianzaService.findId(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejosPracticasCrianza> create(
			
			@RequestBody ConsejosPracticasCrianza univ) throws URISyntaxException {
		ConsejosPracticasCrianza result = ConsejosPracticasCrianzaService.save(univ);

		return ResponseEntity.created(new URI("/ConsejosPracticasCrianza/create/" + result.getIdConsejoPracticaCrianza())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejosPracticasCrianza> updateGrupoanimal(
			
			
			@RequestBody ConsejosPracticasCrianza univ) throws URISyntaxException {
		if (univ.getIdConsejoPracticaCrianza() == 0) {
			return new ResponseEntity<ConsejosPracticasCrianza>(HttpStatus.NOT_FOUND);
		}

		try {
			ConsejosPracticasCrianza result = ConsejosPracticasCrianzaService.update(univ);

			return ResponseEntity.created(new URI("/ConsejoPracticasCrianza/updated/" + result.getIdConsejoPracticaCrianza())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@PathVariable int id) {
		ConsejosPracticasCrianzaService.delete(id);

		return ResponseEntity.ok().build();
	}

}
