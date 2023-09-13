package cu.edu.unah.Proyectov1.ConsejoDeAlimentacion.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.ConsejoDeAlimentacion.domain.ConsejoAlimentacion;
import cu.edu.unah.Proyectov1.ConsejoDeAlimentacion.domain.ConsejoAlimentacionPK;
import cu.edu.unah.Proyectov1.ConsejoDeAlimentacion.domain.ConsejoAlimentacionRepository;

@Service
public class ConsejoAlimentacionService {

	@Autowired
	private ConsejoAlimentacionRepository consejoAlimentacionrepository;
	
	public ConsejoAlimentacion save(ConsejoAlimentacion consejoAlimentacion) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (consejoAlimentacion.getConsejoAlimentacionPK() != null && consejoAlimentacionrepository.existsById(consejoAlimentacion.getConsejoAlimentacionPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return consejoAlimentacionrepository.save(consejoAlimentacion);
	}

	public ConsejoAlimentacion update(ConsejoAlimentacion consejoAlimentacion) {
		if (consejoAlimentacion.getConsejoAlimentacionPK() != null && !consejoAlimentacionrepository.existsById(consejoAlimentacion.getConsejoAlimentacionPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return consejoAlimentacionrepository.save(consejoAlimentacion);
	}

	public List<ConsejoAlimentacion> findAll() {
		return consejoAlimentacionrepository.findAll();
	}

	
	
	public ConsejoAlimentacion findId(ConsejoAlimentacionPK id) {
		ConsejoAlimentacion univ = consejoAlimentacionrepository.findById(id).get();
		return univ;

	}

	public void delete(ConsejoAlimentacionPK id) {
		consejoAlimentacionrepository.deleteById(id);
}
}
