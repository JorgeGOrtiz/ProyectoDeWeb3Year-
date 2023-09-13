package cu.edu.unah.Proyectov1.ChatConsejosTratamiento.infrastructure;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import cu.edu.unah.Proyectov1.Animal.domain.Animal;
import cu.edu.unah.Proyectov1.Raza.domian.Raza;
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

import cu.edu.unah.Proyectov1.ChatConsejosTratamiento.domain.ChatConsejosTratamiento;
import cu.edu.unah.Proyectov1.ChatConsejosTratamiento.domain.ChatConsejosTratamientoPK;
import cu.edu.unah.Proyectov1.ChatConsejosTratamiento.application.ChatConsejoTratamientoService;

@RequestMapping("/ChatConsejosTratamiento")
@RestController
public class ChatConsejosTratamientoController {
	
	@Autowired
	private ChatConsejoTratamientoService ChatConsejoTratamientoService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ChatConsejosTratamiento>> findAll() {
		try {
			return new ResponseEntity<List<ChatConsejosTratamiento>>(ChatConsejoTratamientoService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejosTratamiento> findById(
			
			@RequestBody ChatConsejosTratamientoPK id) {
		try {
			return new ResponseEntity<ChatConsejosTratamiento>(ChatConsejoTratamientoService.findId(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejosTratamiento> create(

			@RequestBody ChatConsejosTratamiento ChatConsejosTratamiento) throws URISyntaxException {
		ChatConsejosTratamiento result = ChatConsejoTratamientoService.save(ChatConsejosTratamiento);

		return new ResponseEntity<ChatConsejosTratamiento>(result,HttpStatus.CREATED);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejosTratamiento> updateAnimal(
			
			
			@RequestBody ChatConsejosTratamiento ChatConsejosTratamiento) throws URISyntaxException {
		if (ChatConsejosTratamiento.getChatConsejosTratamientoPK() == null) {
			return new ResponseEntity<ChatConsejosTratamiento>(HttpStatus.NOT_FOUND);
		}

		try {
			ChatConsejosTratamiento result = ChatConsejoTratamientoService.update(ChatConsejosTratamiento);

			return new ResponseEntity<ChatConsejosTratamiento>(result,HttpStatus.CREATED);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody ChatConsejosTratamientoPK id) {
		ChatConsejoTratamientoService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{us}/{rol}/{uf}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol,@PathVariable int uf) {
ChatConsejosTratamientoPK id = new ChatConsejosTratamientoPK(us,rol,uf);
System.out.println("voy a borrar"+id);
ChatConsejoTratamientoService.delete(id);
return ResponseEntity.ok().build();
}
}

