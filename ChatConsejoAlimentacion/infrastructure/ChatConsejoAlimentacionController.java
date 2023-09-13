package cu.edu.unah.Proyectov1.ChatConsejoAlimentacion.infrastructure;

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

import cu.edu.unah.Proyectov1.ChatConsejoAlimentacion.domain.ChatConsejoAlimentacion;
import cu.edu.unah.Proyectov1.ChatConsejoAlimentacion.domain.ChatConsejoAlimentacionPK;
import cu.edu.unah.Proyectov1.ChatConsejoAlimentacion.application.ChatConsejoAlimentacionService;

@RequestMapping("/ChatConsejoAlimentacion")
@RestController
public class ChatConsejoAlimentacionController {
	
	@Autowired
	private ChatConsejoAlimentacionService ChatConsejoAlimentacionService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ChatConsejoAlimentacion>> findAll() {
		try {
			return new ResponseEntity<List<ChatConsejoAlimentacion>>(ChatConsejoAlimentacionService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejoAlimentacion> findById(
			
			@PathVariable ChatConsejoAlimentacionPK id) {
		try {
			return new ResponseEntity<ChatConsejoAlimentacion>(ChatConsejoAlimentacionService.findId (id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejoAlimentacion> create(
			
			@RequestBody ChatConsejoAlimentacion univ) throws URISyntaxException {
		ChatConsejoAlimentacion result = ChatConsejoAlimentacionService.save(univ);

		return ResponseEntity.created(new URI("/ChatConsejoAlimentacion/create/" + result.getChatConsejoAlimentacionPK())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ChatConsejoAlimentacion> updateChatConsejoAlimentacion(
			
			
			@RequestBody ChatConsejoAlimentacion univ) throws URISyntaxException {
		if (univ.getChatConsejoAlimentacionPK() == null) {
			return new ResponseEntity<ChatConsejoAlimentacion>(HttpStatus.NOT_FOUND);
		}

		try {
			ChatConsejoAlimentacion result = ChatConsejoAlimentacionService.update(univ);

			return ResponseEntity.created(new URI("/ChatConsejoAlimentacion/updated/" + result.getChatConsejoAlimentacionPK())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody ChatConsejoAlimentacionPK id) {
		ChatConsejoAlimentacionService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{a}/{b}/{c}/{d}/{e}/{f}/{g}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int a,@PathVariable int b,@PathVariable int c,@PathVariable int d,@PathVariable int e,@PathVariable int f,@PathVariable int g) {
ChatConsejoAlimentacionPK id = new ChatConsejoAlimentacionPK(a,b,c,d,e,f,g);
System.out.println("voy a borrar"+id);
ChatConsejoAlimentacionService.delete(id);
return ResponseEntity.ok().build();
}}

