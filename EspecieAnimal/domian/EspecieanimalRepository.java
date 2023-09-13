package cu.edu.unah.Proyectov1.EspecieAnimal.domian;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.EspecieAnimal.domian.Especieanimal;
import cu.edu.unah.Proyectov1.EspecieAnimal.domian.EspecieanimalPK;

public interface EspecieanimalRepository extends JpaRepository<Especieanimal, EspecieanimalPK>{

}
