package cu.edu.unah.Proyectov1.ConsejoPracticaCrianza.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.ConsejoPracticaCrianza.domain.ConsejosPracticasCrianza;

import cu.edu.unah.Proyectov1.ConsejoPracticaCrianza.domain.ConsejosPracticasCrianzaRepository;

@Service
public class ConsejosPracticasCrianzaService{

	@Autowired
	private ConsejosPracticasCrianzaRepository consejosPracticasCrianzarepository;
	
	public ConsejosPracticasCrianza save(ConsejosPracticasCrianza  consejosPracticasCrianza ) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (consejosPracticasCrianza.getIdConsejoPracticaCrianza() != null && consejosPracticasCrianzarepository.existsById(consejosPracticasCrianza.getIdConsejoPracticaCrianza())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return consejosPracticasCrianzarepository.save(consejosPracticasCrianza);
	}

	public ConsejosPracticasCrianza update(ConsejosPracticasCrianza consejosPracticasCrianza) {
		if (consejosPracticasCrianza.getIdConsejoPracticaCrianza() != null && !consejosPracticasCrianzarepository.existsById(consejosPracticasCrianza.getIdConsejoPracticaCrianza())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return consejosPracticasCrianzarepository.save(consejosPracticasCrianza);
	}

	public List<ConsejosPracticasCrianza> findAll() {
		return consejosPracticasCrianzarepository.findAll();
	}

	
	
	public ConsejosPracticasCrianza findId(int id) {
		ConsejosPracticasCrianza univ = consejosPracticasCrianzarepository.findById(id).get();
		return univ;

	}

	public void delete(int id) {
		consejosPracticasCrianzarepository.deleteById(id);
}
}
