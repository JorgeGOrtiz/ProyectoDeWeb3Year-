package cu.edu.unah.Proyectov1.ChatConsejoCrianza.infrastructure;

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

import cu.edu.unah.Proyectov1.ChatConsejoCrianza.domain.ChatConsejoCrianza;
import cu.edu.unah.Proyectov1.ChatConsejoCrianza.domain.ChatConsejoCrianzaPK;
import cu.edu.unah.Proyectov1.ChatConsejoCrianza.application.ChatConsejoCrianzaService;

@RequestMapping("/ChatConsejoCrianza")
@RestController
public class ChatConsejoCrianzaController {
	
	@Autowired
	private ChatConsejoCrianzaService ChatConsejoCrianzaService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ChatConsejoCrianza>> findAll() {
		try {
			return new ResponseEntity<List<ChatConsejoCrianza>>(ChatConsejoCrianzaService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejoCrianza> findById(
			
			@PathVariable ChatConsejoCrianzaPK id) {
		try {
			return new ResponseEntity<ChatConsejoCrianza>(ChatConsejoCrianzaService.findId (id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejoCrianza> create(
			
			@RequestBody ChatConsejoCrianza univ) throws URISyntaxException {
		ChatConsejoCrianza result = ChatConsejoCrianzaService.save(univ);

		return ResponseEntity.created(new URI("/ChatConsejoCrianza/create/" + result.getChatConsejoCrianzaPK())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejoCrianza> updateChatConsejoCrianza(
			
			
			@RequestBody ChatConsejoCrianza univ) throws URISyntaxException {
		if (univ.getChatConsejoCrianzaPK() == null) {
			return new ResponseEntity<ChatConsejoCrianza>(HttpStatus.NOT_FOUND);
		}

		try {
			ChatConsejoCrianza result = ChatConsejoCrianzaService.update(univ);

			return ResponseEntity.created(new URI("/ChatConsejoCrianza/updated/" + result.getChatConsejoCrianzaPK())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody ChatConsejoCrianzaPK id) {
		ChatConsejoCrianzaService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{a}/{b}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int a,@PathVariable int b) {
ChatConsejoCrianzaPK id = new ChatConsejoCrianzaPK(a,b);
System.out.println("voy a borrar"+id);
ChatConsejoCrianzaService.delete(id);
return ResponseEntity.ok().build();
}}

