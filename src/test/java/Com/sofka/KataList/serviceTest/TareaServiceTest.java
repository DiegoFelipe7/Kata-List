package Com.sofka.KataList.serviceTest;

import Com.sofka.KataList.models.TareaModel;
import Com.sofka.KataList.repository.TareasRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TareaServiceTest {
    @Autowired
    TareasRepository tareasRepository;
    @Test
    public void testGuardarTarea(){
        TareaModel tareaModel=new TareaModel("Deportes");
        TareaModel tareaModel1 = tareasRepository.save(tareaModel);
        assertNotNull(tareaModel1);
    }


    @Test
    public void testListarTarea(){
        List<TareaModel> usuarioModelList=(List<TareaModel>) tareasRepository.findAll();
        assertThat(usuarioModelList).size().isGreaterThan(0);
    }
}
