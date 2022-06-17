package Com.sofka.KataList.service;

import Com.sofka.KataList.models.SubTareasModel;
import Com.sofka.KataList.repository.SubTareasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Subtarea servicio
 *
 * @author Diego felipe muñoz mosquera
 * @version 1.0.0 17-06-2022
 * @since 1.0.0
 */
@Service
public class SubTareasService {
    @Autowired
    private SubTareasRepository subTareasRepository;

    /**
     * Metodo que retorna la lista de tareas
     * @return lista de subtareas
     */
    public List<SubTareasModel> listaSubTareas(){
        return (List<SubTareasModel>) subTareasRepository.findAll();
    }

    /**
     * Metodo para almacenar sub tareas
     * @param subTareasModel  subtarea que envia el controlador
     * @return subtarea almacenada
     */
    public SubTareasModel guardarSubTareas(SubTareasModel subTareasModel){
        return subTareasRepository.save(subTareasModel);
    }

    /**
     *
     * @param subTareasModel subtarea que envia el controlador
     * @param id id de la sub tarea
     * @return subtarea alcualizada
     */
    public SubTareasModel actualizarSubTarea(SubTareasModel subTareasModel , Long id){
        subTareasModel.setId(id);
        return subTareasRepository.save(subTareasModel);
    }

    /**
     * Metodo para eliminar
     * @param id parametro que enviar el controlado
     * @return verdade o falso depende si elimino
     */
    public boolean eliminarSubTarea(Long id){
        try {
            subTareasRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return  false;
        }
    }
}
