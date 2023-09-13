package cu.edu.unah.Proyectov1.ChatConsejoPrevencion.infrastructure;

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

import cu.edu.unah.Proyectov1.ChatConsejoPrevencion.domain.ChatConsejoPrevencion;
import cu.edu.unah.Proyectov1.ChatConsejoPrevencion.domain.ChatConsejoPrevencionPK;
import cu.edu.unah.Proyectov1.ChatConsejoPrevencion.application.ChatConsejoPrevencionService;

@RequestMapping("chatConsejoPrevencion")
@RestController
public class ChatConsejoPrevencionController {
	
	@Autowired
	private ChatConsejoPrevencionService ChatConsejoPrevencionService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ChatConsejoPrevencion>> findAll() {
		try {
			return new ResponseEntity<List<ChatConsejoPrevencion>>(ChatConsejoPrevencionService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejoPrevencion> findById(
			
			@RequestBody ChatConsejoPrevencionPK id) {
		try {
			return new ResponseEntity<ChatConsejoPrevencion>(ChatConsejoPrevencionService.findId (id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejoPrevencion> create(
			
			@RequestBody ChatConsejoPrevencion univ) throws URISyntaxException {
		ChatConsejoPrevencion result = ChatConsejoPrevencionService.save(univ);

		return ResponseEntity.created(new URI("/chatConsejoPrevencion/create/" + result.getChatConsejoPrevencionPK())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejoPrevencion> updateChatConsejoPrevencion(
			
			
			@RequestBody ChatConsejoPrevencion univ) throws URISyntaxException {
		if (univ.getChatConsejoPrevencionPK() == null) {
			return new ResponseEntity<ChatConsejoPrevencion>(HttpStatus.NOT_FOUND);
		}

		try {
			ChatConsejoPrevencion result = ChatConsejoPrevencionService.update(univ);

			return ResponseEntity.created(new URI("/chatConsejoPrevencion/updated/" + result.getChatConsejoPrevencionPK())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody ChatConsejoPrevencionPK id) {
		ChatConsejoPrevencionService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{us}/{rol}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol) {
ChatConsejoPrevencionPK id = new ChatConsejoPrevencionPK(us,rol);
System.out.println("voy a borrar"+id);
ChatConsejoPrevencionService.delete(id);
return ResponseEntity.ok().build();
}}

