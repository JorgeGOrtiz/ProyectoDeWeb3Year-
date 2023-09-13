package cu.edu.unah.Proyectov1.Alimentacion.infrastructure;

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

import cu.edu.unah.Proyectov1.Alimentacion.domain.Alimentacion;
import cu.edu.unah.Proyectov1.Alimentacion.domain.AlimentacionPK;
import cu.edu.unah.Proyectov1.Alimentacion.application.AlimentacionService;

@RequestMapping("/alimentacion")
@RestController
public class AlimentacionController {
	
	@Autowired
	private AlimentacionService alimentacionService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Alimentacion>> findAll() {
		try {
			return new ResponseEntity<List<Alimentacion>>(alimentacionService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Alimentacion> findById(
			
			@RequestBody AlimentacionPK id) {
		try {
			return new ResponseEntity<Alimentacion>(alimentacionService.findId (id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Alimentacion> create(
			
			@RequestBody Alimentacion alimentacion) throws URISyntaxException {
		Alimentacion result = alimentacionService.save(alimentacion);


		return new ResponseEntity<Alimentacion>(result,HttpStatus.CREATED);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Alimentacion> updateAlimentacion(
			
			
			@RequestBody Alimentacion alimentacion) throws URISyntaxException {
		if (alimentacion.getAlimentacionPK() == null) {
			return new ResponseEntity<Alimentacion>(HttpStatus.NOT_FOUND);
		}

		try {
			Alimentacion result = alimentacionService.update(alimentacion);

			return new ResponseEntity<Alimentacion>(result,HttpStatus.CREATED);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody AlimentacionPK id) {
		alimentacionService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{us}/{rol}/{uf}/{paf}/{sof}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol,@PathVariable int uf,@PathVariable int paf,@PathVariable int sof) {
AlimentacionPK id = new AlimentacionPK(us,rol,uf,paf,sof);
System.out.println("voy a borrar"+id);
alimentacionService.delete(id);
return ResponseEntity.ok().build();
}}

