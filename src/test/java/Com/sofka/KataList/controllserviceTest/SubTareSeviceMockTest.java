package Com.sofka.KataList.controllserviceTest;

import Com.sofka.KataList.repository.SubTareasRepository;
import Com.sofka.KataList.service.SubTareasService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SubTareSeviceMockTest {
    @MockBean
    SubTareasRepository subTareasRepository;

    @Autowired
    SubTareasService subTareasService;

    @Test
    public void testTareaMock() {

        when(subTareasRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(subTareasService.listaSubTareas()).isEmpty();
        verify(subTareasRepository).findAll();
    }
}
