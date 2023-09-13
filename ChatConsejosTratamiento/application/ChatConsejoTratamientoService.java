package cu.edu.unah.Proyectov1.ChatConsejosTratamiento.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.ChatConsejosTratamiento.domain.ChatConsejosTratamiento;
import cu.edu.unah.Proyectov1.ChatConsejosTratamiento.domain.ChatConsejosTratamientoPK;
import cu.edu.unah.Proyectov1.ChatConsejosTratamiento.domain.ChatConsejosTratamientoRepository;

@Service
public class ChatConsejoTratamientoService{

	@Autowired
	private ChatConsejosTratamientoRepository chatConsejosTratamientorepository;
	
	public ChatConsejosTratamiento save(ChatConsejosTratamiento chatConsejosTratamiento) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (chatConsejosTratamiento.getChatConsejosTratamientoPK() != null && chatConsejosTratamientorepository.existsById(chatConsejosTratamiento.getChatConsejosTratamientoPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return chatConsejosTratamientorepository.save(chatConsejosTratamiento);
	}

	public ChatConsejosTratamiento update(ChatConsejosTratamiento chatConsejosTratamiento) {
		if (chatConsejosTratamiento.getChatConsejosTratamientoPK() != null && !chatConsejosTratamientorepository.existsById(chatConsejosTratamiento.getChatConsejosTratamientoPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return chatConsejosTratamientorepository.save(chatConsejosTratamiento);
	}

	public List<ChatConsejosTratamiento> findAll() {
		return chatConsejosTratamientorepository.findAll();
	}

	
	
	public ChatConsejosTratamiento findId(ChatConsejosTratamientoPK id) {
		ChatConsejosTratamiento univ = chatConsejosTratamientorepository.findById(id).get();
		return univ;

	}

	public void delete(ChatConsejosTratamientoPK id) {
		chatConsejosTratamientorepository.deleteById(id);
}
}
