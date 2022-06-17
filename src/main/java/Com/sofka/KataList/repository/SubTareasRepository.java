package Com.sofka.KataList.repository;

import Com.sofka.KataList.models.SubTareasModel;
import org.springframework.data.repository.CrudRepository;
/**
 * repositorio para subtareas el cual herada todos los metodos de crudRepository
 *
 * @author Diego felipe muñoz mosquera
 * @version 1.0.0 17-06-2022
 * @since 1.0.0
 */
public interface SubTareasRepository extends CrudRepository<SubTareasModel , Long> {
}
