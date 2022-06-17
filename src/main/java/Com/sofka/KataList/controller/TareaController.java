package Com.sofka.KataList.controller;

import Com.sofka.KataList.models.TareaModel;
import Com.sofka.KataList.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controlador para las tareas
 *
 * @author Diego felipe muñoz mosquera
 * @version 1.0.0 17-06-2022
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/tareas")
public class TareaController {
    /**
     * Servicion del las tareas el cual tra los metodos para guardar , listar,eliminar,actualizar subtareas
     */
    @Autowired
    private TareaService tareaService;
    /**
     *Enpont get para traer las tareas
     * @return lista de tareas
     */
    @GetMapping()
    public List<TareaModel> listadeTareas() {
        return this.tareaService.listaTareas();
    }

    /**
     *
     * @param tareaModel recibe la informacion del fron end en formato json
     * @return objeto almacenado
     */

    @PostMapping()
    public TareaModel guardarTareas(@RequestBody TareaModel tareaModel) {
        return this.tareaService.guardarTarea(tareaModel);
    }

    /**
     *
     * @param tareaModel  recibe la informacion del fron end en formato json
     * @param id parametro que se recibe por medio de la url
     * @return objeto almacenado
     */

    @PutMapping(path = "/{id}")
    public TareaModel actualizarTareas(@RequestBody TareaModel tareaModel, @PathVariable("id") Long id) {
        return this.tareaService.actualizarTarea(tareaModel, id);
    }
    /**
     *
     * @param id parametro que se recibe por medio de la url
     * @return el objeto eliminado
     */
    @DeleteMapping(path = "/del/{id}")
    public String eliminarTareas(@PathVariable("id") Long id) {
        boolean ok = tareaService.eliminarTarea(id);
        if (ok) {
            return "Se elimino la tarea correctamente";
        } else {
            return "Ocurrio un error en ";
        }

    }
}
