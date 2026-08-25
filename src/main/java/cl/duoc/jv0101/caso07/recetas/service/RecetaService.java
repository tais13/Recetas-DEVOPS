package cl.duoc.jv0101.caso07.recetas.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import cl.duoc.jv0101.caso07.recetas.model.Receta;
import cl.duoc.jv0101.caso07.recetas.repository.RecetaRepository;

@Service
public class RecetaService {

    private final RecetaRepository repository;

    public RecetaService(RecetaRepository repository) {
        this.repository = repository;
    }

    public List<Receta> findAll() {
        return repository.findAll();
    }

    public Optional<Receta> findById(Long id) {
        return repository.findById(id);
    }

    public Receta create(Receta recurso) {
        return repository.save(recurso);
    }

    public Optional<Receta> update(Long id, Receta datos) {
        return repository.findById(id).map(existente -> {
            existente.setNombre(datos.getNombre());
            existente.setMedicamento(datos.getMedicamento());
            existente.setFarmacia(datos.getFarmacia());
            return repository.save(existente);
        });
    }

    public boolean delete(Long id) {
        return repository.findById(id).map(existente -> {
            repository.delete(existente);
            return true;
        }).orElse(false);
    }
}
