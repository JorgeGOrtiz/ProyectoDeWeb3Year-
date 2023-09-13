package cu.edu.unah.Proyectov1.ConsejosPreventivos.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.ConsejosPreventivos.domain.ConsejosPreventivos;

import cu.edu.unah.Proyectov1.ConsejosPreventivos.domain.ConsejosPreventivosRepository;

@Service
public class ConsejosPreventivosService{

	@Autowired
	private ConsejosPreventivosRepository consejosPreventivosrepository;
	
	public ConsejosPreventivos save(ConsejosPreventivos  ConsejosPreventivos ) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (ConsejosPreventivos.getIdConsejosPreventivos() != null && consejosPreventivosrepository.existsById(ConsejosPreventivos.getIdConsejosPreventivos())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return consejosPreventivosrepository.save(ConsejosPreventivos);
	}

	public ConsejosPreventivos update(ConsejosPreventivos ConsejosPreventivos) {
		if (ConsejosPreventivos.getIdConsejosPreventivos() != null && !consejosPreventivosrepository.existsById(ConsejosPreventivos.getIdConsejosPreventivos())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return consejosPreventivosrepository.save(ConsejosPreventivos);
	}

	public List<ConsejosPreventivos> findAll() {
		return consejosPreventivosrepository.findAll();
	}

	
	
	public ConsejosPreventivos findId(int id) {
		ConsejosPreventivos univ = consejosPreventivosrepository.findById(id).get();
		return univ;

	}

	public void delete(int id) {
		consejosPreventivosrepository.deleteById(id);
}
}
