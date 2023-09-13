package cu.edu.unah.Proyectov1.ChatConsejoCrianza.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.ChatConsejoCrianza.domain.ChatConsejoCrianza;
import cu.edu.unah.Proyectov1.ChatConsejoCrianza.domain.ChatConsejoCrianzaPK;
import cu.edu.unah.Proyectov1.ChatConsejoCrianza.domain.ChatConsejoCrianzaRepository;

@Service
public class ChatConsejoCrianzaService{

	@Autowired
	private ChatConsejoCrianzaRepository chatConsejoCrianzarepository;
	
	public ChatConsejoCrianza save(ChatConsejoCrianza chatConsejoCrianza) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (chatConsejoCrianza.getChatConsejoCrianzaPK() != null && chatConsejoCrianzarepository.existsById(chatConsejoCrianza.getChatConsejoCrianzaPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return chatConsejoCrianzarepository.save(chatConsejoCrianza);
	}

	public ChatConsejoCrianza update(ChatConsejoCrianza chatConsejoCrianza) {
		if (chatConsejoCrianza.getChatConsejoCrianzaPK() != null && !chatConsejoCrianzarepository.existsById(chatConsejoCrianza.getChatConsejoCrianzaPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return chatConsejoCrianzarepository.save(chatConsejoCrianza);
	}

	public List<ChatConsejoCrianza> findAll() {
		return chatConsejoCrianzarepository.findAll();
	}

	
	
	public ChatConsejoCrianza findId(ChatConsejoCrianzaPK id) {
		ChatConsejoCrianza univ = chatConsejoCrianzarepository.findById(id).get();
		return univ;

	}

	public void delete(ChatConsejoCrianzaPK id) {
		chatConsejoCrianzarepository.deleteById(id);
}
}
