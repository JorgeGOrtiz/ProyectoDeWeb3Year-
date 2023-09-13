package cu.edu.unah.Proyectov1.Animal.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.Animal.domain.Animal;
import cu.edu.unah.Proyectov1.Animal.domain.AnimalPK;


public interface AnimalRepository extends JpaRepository<Animal, AnimalPK>{

}
