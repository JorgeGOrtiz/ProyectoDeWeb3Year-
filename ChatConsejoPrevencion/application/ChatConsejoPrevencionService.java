package cu.edu.unah.Proyectov1.ChatConsejoPrevencion.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.ChatConsejoPrevencion.domain.ChatConsejoPrevencion;
import cu.edu.unah.Proyectov1.ChatConsejoPrevencion.domain.ChatConsejoPrevencionPK;
import cu.edu.unah.Proyectov1.ChatConsejoPrevencion.domain.ChatConsejoPrevencionRepository;

@Service
public class ChatConsejoPrevencionService{

	@Autowired
	private ChatConsejoPrevencionRepository chatConsejoPrevencionrepository;
	
	public ChatConsejoPrevencion save(ChatConsejoPrevencion chatConsejoPrevencion) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (chatConsejoPrevencion.getChatConsejoPrevencionPK() != null && chatConsejoPrevencionrepository.existsById(chatConsejoPrevencion.getChatConsejoPrevencionPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return chatConsejoPrevencionrepository.save(chatConsejoPrevencion);
	}

	public ChatConsejoPrevencion update(ChatConsejoPrevencion chatConsejoPrevencion) {
		if (chatConsejoPrevencion.getChatConsejoPrevencionPK() != null && !chatConsejoPrevencionrepository.existsById(chatConsejoPrevencion.getChatConsejoPrevencionPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return chatConsejoPrevencionrepository.save(chatConsejoPrevencion);
	}

	public List<ChatConsejoPrevencion> findAll() {
		return chatConsejoPrevencionrepository.findAll();
	}

	
	
	public ChatConsejoPrevencion findId(ChatConsejoPrevencionPK id) {
		ChatConsejoPrevencion univ = chatConsejoPrevencionrepository.findById(id).get();
		return univ;

	}

	public void delete(ChatConsejoPrevencionPK id) {
		chatConsejoPrevencionrepository.deleteById(id);
}
}
