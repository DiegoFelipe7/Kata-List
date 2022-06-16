package Com.sofka.KataList.controller;


import Com.sofka.KataList.models.SubTareasModel;
import Com.sofka.KataList.service.SubTareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/subtareas")
public class SubTareaController {
    @Autowired
    private SubTareasService subTareasService;

    @GetMapping()
    public List<SubTareasModel> listasubTarea() {

        return this.subTareasService.listaSubTareas();
    }
    @PostMapping()
    public SubTareasModel guardarsubTareas(@RequestBody SubTareasModel subTareasModel) {
        return this.subTareasService.guardarSubTareas(subTareasModel);
    }

    @PutMapping(path = "/{id}")
    public SubTareasModel actualizarsubTareas(@RequestBody SubTareasModel subTareasModel, @PathVariable("id") Long id) {
        return this.subTareasService.actualizarSubTarea(subTareasModel, id);
    }

    @DeleteMapping(path = "/del/{id}")
    public String eliminarsubTareas(@PathVariable("id") Long id){
        boolean ok=this.subTareasService.eliminarSubTarea(id);
        if (ok) {
            return "Se elimino la tarea";
        }else {
            return "Ocurrio un error";
        }

    }
}
