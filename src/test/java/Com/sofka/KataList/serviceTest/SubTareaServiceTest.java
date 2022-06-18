package Com.sofka.KataList.serviceTest;

import Com.sofka.KataList.models.SubTareasModel;
import Com.sofka.KataList.models.TareaModel;
import Com.sofka.KataList.repository.SubTareasRepository;
import Com.sofka.KataList.repository.TareasRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class SubTareaServiceTest {
    @Autowired
    TareasRepository tareasRepository;
    @Autowired
    SubTareasRepository subTareasRepository;

    @Test
    public void testGuardarSubTarea(){
        TareaModel tareamodel=new TareaModel("Comida");
        TareaModel TareaModelRegistrado = tareasRepository.save(tareamodel);
        assertNotNull(TareaModelRegistrado);
        SubTareasModel submodel=new SubTareasModel("Arroz","incompleto",TareaModelRegistrado);
        SubTareasModel rolmodelRegistro = subTareasRepository.save(submodel);
        assertNotNull(rolmodelRegistro);

    }

    @Test
    public void testlistaSubtareas(){
        List<SubTareasModel> rolesModelList=(List<SubTareasModel>) subTareasRepository.findAll();
        assertThat(rolesModelList).size().isGreaterThan(0);
    }
}
