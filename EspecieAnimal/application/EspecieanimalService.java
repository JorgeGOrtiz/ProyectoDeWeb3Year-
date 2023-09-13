package cu.edu.unah.Proyectov1.EspecieAnimal.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.EspecieAnimal.domian.Especieanimal;
import cu.edu.unah.Proyectov1.EspecieAnimal.domian.EspecieanimalPK;
import cu.edu.unah.Proyectov1.EspecieAnimal.domian.EspecieanimalRepository;

@Service
public class EspecieanimalService {

	@Autowired
	private EspecieanimalRepository especieanimalrepository;
	
	public Especieanimal save(Especieanimal especieanimal) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (especieanimal.getEspecieanimalPK() != null) {
			boolean existe = especieanimalrepository.existsById(especieanimal.getEspecieanimalPK());
			if (existe) {
				throw new EntityExistsException("There is already existing entity with such ID in the database.");
			}
		}

		return especieanimalrepository.save(especieanimal);
	}

	public Especieanimal update(Especieanimal especieanimal) {
		if (especieanimal.getEspecieanimalPK() != null && !especieanimalrepository.existsById(especieanimal.getEspecieanimalPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return especieanimalrepository.save(especieanimal);
	}

	public List<Especieanimal> findAll() {
		return especieanimalrepository.findAll();
	}

	
	
	public Especieanimal findId(EspecieanimalPK id) {
		Especieanimal univ = especieanimalrepository.findById(id).get();
		return univ;

	}

	public void delete(EspecieanimalPK id) {
		especieanimalrepository.deleteById(id);
}
}
