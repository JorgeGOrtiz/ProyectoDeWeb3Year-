package cu.edu.unah.Proyectov1.Alimentacion.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.Alimentacion.domain.Alimentacion;
import cu.edu.unah.Proyectov1.Alimentacion.domain.AlimentacionPK;

public interface AlimentacionRepository extends JpaRepository<Alimentacion, AlimentacionPK>{

}
