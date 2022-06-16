package Com.sofka.KataList.repository;

import Com.sofka.KataList.models.TareaModel;
import org.springframework.data.repository.CrudRepository;

public interface TareasRepository extends CrudRepository<TareaModel , Long> {
}
