package cu.edu.unah.Proyectov1.ConsejoDeAlimentacion.infrastructure;

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

import cu.edu.unah.Proyectov1.ConsejoDeAlimentacion.domain.ConsejoAlimentacion;
import cu.edu.unah.Proyectov1.ConsejoDeAlimentacion.domain.ConsejoAlimentacionPK;
import cu.edu.unah.Proyectov1.ConsejoDeAlimentacion.application.ConsejoAlimentacionService;

@RequestMapping("/ConsejoAlimentacion")
@RestController
public class ConsejoAlimentacionController {
	
	@Autowired
	private ConsejoAlimentacionService ConsejoAlimentacionService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ConsejoAlimentacion>> findAll() {
		try {
			return new ResponseEntity<List<ConsejoAlimentacion>>(ConsejoAlimentacionService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejoAlimentacion> findById(
			
			@RequestBody ConsejoAlimentacionPK id) {
		try {
			return new ResponseEntity<ConsejoAlimentacion>(ConsejoAlimentacionService.findId (id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejoAlimentacion> create(
			
			@RequestBody ConsejoAlimentacion ConsejoAlimentacion) throws URISyntaxException {
		ConsejoAlimentacion result = ConsejoAlimentacionService.save(ConsejoAlimentacion);


		return new ResponseEntity<ConsejoAlimentacion>(result,HttpStatus.CREATED);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ConsejoAlimentacion> updateConsejoAlimentacion(
			
			
			@RequestBody ConsejoAlimentacion ConsejoAlimentacion) throws URISyntaxException {
		if (ConsejoAlimentacion.getConsejoAlimentacionPK() == null) {
			return new ResponseEntity<ConsejoAlimentacion>(HttpStatus.NOT_FOUND);
		}

		try {
			ConsejoAlimentacion result = ConsejoAlimentacionService.update(ConsejoAlimentacion);

			return new ResponseEntity<ConsejoAlimentacion>(result,HttpStatus.CREATED);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody ConsejoAlimentacionPK id) {
		ConsejoAlimentacionService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{a}/{b}/{c}/{d}/{e}/{f}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int a,@PathVariable int b,@PathVariable int c,@PathVariable int d,@PathVariable int e,@PathVariable int f) {
ConsejoAlimentacionPK id = new ConsejoAlimentacionPK(a,b,c,d,e,f);
System.out.println("voy a borrar"+id);
ConsejoAlimentacionService.delete(id);
return ResponseEntity.ok().build();
}}

