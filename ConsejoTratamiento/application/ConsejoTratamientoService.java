package cu.edu.unah.Proyectov1.ConsejoTratamiento.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.ConsejoTratamiento.domain.ConsejoTratamiento;
import cu.edu.unah.Proyectov1.ConsejoTratamiento.domain.ConsejoTratamientoPK;
import cu.edu.unah.Proyectov1.ConsejoTratamiento.domain.ConsejoTratamientoRepository;

@Service
public class ConsejoTratamientoService{

	@Autowired
	private ConsejoTratamientoRepository consejoTratamientorepository;
	
	public ConsejoTratamiento save(ConsejoTratamiento consejoTratamiento) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (consejoTratamiento.getConsejoTratamientoPK() != null && consejoTratamientorepository.existsById(consejoTratamiento.getConsejoTratamientoPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return consejoTratamientorepository.save(consejoTratamiento);
	}

	public ConsejoTratamiento update(ConsejoTratamiento consejoTratamiento) {
		if (consejoTratamiento.getConsejoTratamientoPK() != null && !consejoTratamientorepository.existsById(consejoTratamiento.getConsejoTratamientoPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return consejoTratamientorepository.save(consejoTratamiento);
	}

	public List<ConsejoTratamiento> findAll() {
		return consejoTratamientorepository.findAll();
	}

	
	
	public ConsejoTratamiento findId(ConsejoTratamientoPK id) {
		ConsejoTratamiento univ = consejoTratamientorepository.findById(id).get();
		return univ;

	}

	public void delete(ConsejoTratamientoPK id) {
		consejoTratamientorepository.deleteById(id);
}
}
