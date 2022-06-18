package Com.sofka.KataList.controllserviceTest;

import Com.sofka.KataList.repository.TareasRepository;
import Com.sofka.KataList.service.TareaService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TareaServiceMockTest {
    @MockBean
    TareasRepository tareasRepository;

    @Autowired
    TareaService tareaService;

    @Test
    public void testTareaMock() {

        when(tareasRepository.findAll()).thenReturn(new ArrayList<>());
        assertThat(tareaService.listaTareas()).isEmpty();
        verify(tareasRepository).findAll();
    }


}
