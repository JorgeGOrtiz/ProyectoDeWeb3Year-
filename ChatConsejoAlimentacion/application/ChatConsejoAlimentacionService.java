package cu.edu.unah.Proyectov1.ChatConsejoAlimentacion.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.ChatConsejoAlimentacion.domain.ChatConsejoAlimentacion;
import cu.edu.unah.Proyectov1.ChatConsejoAlimentacion.domain.ChatConsejoAlimentacionPK;
import cu.edu.unah.Proyectov1.ChatConsejoAlimentacion.domain.ChatConsejoAlimentacionRepository;

@Service
public class ChatConsejoAlimentacionService {

	@Autowired
	private ChatConsejoAlimentacionRepository chatConsejoAlimentacionrepository;
	
	public ChatConsejoAlimentacion save(ChatConsejoAlimentacion chatConsejoAlimentacion) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (chatConsejoAlimentacion.getChatConsejoAlimentacionPK() != null && chatConsejoAlimentacionrepository.existsById(chatConsejoAlimentacion.getChatConsejoAlimentacionPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return chatConsejoAlimentacionrepository.save(chatConsejoAlimentacion);
	}

	public ChatConsejoAlimentacion update(ChatConsejoAlimentacion chatConsejoAlimentacion) {
		if (chatConsejoAlimentacion.getChatConsejoAlimentacionPK() != null && !chatConsejoAlimentacionrepository.existsById(chatConsejoAlimentacion.getChatConsejoAlimentacionPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return chatConsejoAlimentacionrepository.save(chatConsejoAlimentacion);
	}

	public List<ChatConsejoAlimentacion> findAll() {
		return chatConsejoAlimentacionrepository.findAll();
	}

	
	
	public ChatConsejoAlimentacion findId(ChatConsejoAlimentacionPK id) {
		ChatConsejoAlimentacion univ = chatConsejoAlimentacionrepository.findById(id).get();
		return univ;

	}

	public void delete(ChatConsejoAlimentacionPK id) {
		chatConsejoAlimentacionrepository.deleteById(id);
}
}
