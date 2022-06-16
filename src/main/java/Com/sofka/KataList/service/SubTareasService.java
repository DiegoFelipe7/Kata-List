package Com.sofka.KataList.service;

import Com.sofka.KataList.models.SubTareasModel;
import Com.sofka.KataList.repository.SubTareasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubTareasService {
    @Autowired
    private SubTareasRepository subTareasRepository;

    public List<SubTareasModel> listaSubTareas(){
        return (List<SubTareasModel>) subTareasRepository.findAll();
    }

    public SubTareasModel guardarSubTareas(SubTareasModel subTareasModel){
        return subTareasRepository.save(subTareasModel);
    }


    public SubTareasModel actualizarSubTarea(SubTareasModel subTareasModel , Long id){
        subTareasModel.setId(id);
        return subTareasRepository.save(subTareasModel);
    }

    public boolean eliminarSubTarea(Long id){
        try {
            subTareasRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return  false;
        }
    }
}
