package cl.duoc.jv0101.caso07.recetas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.jv0101.caso07.recetas.model.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
}
