package Com.sofka.KataList.service;

import Com.sofka.KataList.models.TareaModel;
import Com.sofka.KataList.repository.TareasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TareaService {
    @Autowired
    private TareasRepository tareasRepository;

    public List<TareaModel> listaTareas(){
        return (List<TareaModel>) tareasRepository.findAll();
    }

    public TareaModel guardarTarea(TareaModel tareaModel){
        return tareasRepository.save(tareaModel);
    }

    public TareaModel actualizarTarea(TareaModel tareaModel, Long id){
        tareaModel.setId(id);
        return tareasRepository.save(tareaModel);
    }

    public boolean eliminarTarea(Long id){
        try {
            tareasRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
