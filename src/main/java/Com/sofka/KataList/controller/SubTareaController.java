package Com.sofka.KataList.controller;


import Com.sofka.KataList.models.SubTareasModel;
import Com.sofka.KataList.service.SubTareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para las subtareas las cuales trae el listado
 *
 * @author Diego felipe muñoz mosquera
 * @version 1.0.0 17-06-2022
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/subtareas")
public class SubTareaController {
    /**
     * Servicion del las sub tareas el cual tra los metodos para guardar , listar,eliminar,actualizar subtareas
     */
    @Autowired
    private SubTareasService subTareasService;

    /**
     *Enpont get para traer la lista de subtareas
     * @return lista de subtareas
     */
    @GetMapping()
    public List<SubTareasModel> listasubTarea() {
        return this.subTareasService.listaSubTareas();
    }

    /**
     *
     * @param subTareasModel recibe la informacion del fron end en formato json
     * @return objeto almacenado
     */

    @PostMapping()
    public SubTareasModel guardarsubTareas(@RequestBody SubTareasModel subTareasModel) {
        return this.subTareasService.guardarSubTareas(subTareasModel);
    }

    /**
     *
     * @param subTareasModel recibe la informacion del fron end en formato json
     * @param id parametro que se recibe por medio de la url
     * @return objeto almacenado
     */

    @PutMapping(path = "/{id}")
    public SubTareasModel actualizarsubTareas(@RequestBody SubTareasModel subTareasModel, @PathVariable("id") Long id) {
        return this.subTareasService.actualizarSubTarea(subTareasModel, id);
    }

    /**
     *
     * @param id parametro que se recibe por medio de la url
     * @return el objeto eliminado
     */
    @DeleteMapping(path = "/del/{id}")
    public String eliminarsubTareas(@PathVariable("id") Long id) {
        boolean ok = this.subTareasService.eliminarSubTarea(id);
        if (ok) {
            return "Se elimino la tarea";
        } else {
            return "Ocurrio un error";
        }

    }
}
