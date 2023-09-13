package cu.edu.unah.Proyectov1.Diagnostico.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.Diagnostico.domain.Diagnostico;
import cu.edu.unah.Proyectov1.Diagnostico.domain.DiagnosticoPK;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, DiagnosticoPK>{

}
