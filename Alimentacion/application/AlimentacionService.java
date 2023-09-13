package cu.edu.unah.Proyectov1.Alimentacion.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.Alimentacion.domain.Alimentacion;
import cu.edu.unah.Proyectov1.Alimentacion.domain.AlimentacionPK;
import cu.edu.unah.Proyectov1.Alimentacion.domain.AlimentacionRepository;

@Service
public class AlimentacionService {

	@Autowired
	private AlimentacionRepository alimentacionrepository;
	
	public Alimentacion save(Alimentacion alimentacion) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (alimentacion.getAlimentacionPK() != null && alimentacionrepository.existsById(alimentacion.getAlimentacionPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return alimentacionrepository.save(alimentacion);
	}

	public Alimentacion update(Alimentacion alimentacion) {
		if (alimentacion.getAlimentacionPK() != null && !alimentacionrepository.existsById(alimentacion.getAlimentacionPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return alimentacionrepository.save(alimentacion);
	}

	public List<Alimentacion> findAll() {
		return alimentacionrepository.findAll();
	}

	
	
	public Alimentacion findId(AlimentacionPK id) {
		Alimentacion univ = alimentacionrepository.findById(id).get();
		return univ;

	}

	public void delete(AlimentacionPK id) {
		alimentacionrepository.deleteById(id);
}
}
