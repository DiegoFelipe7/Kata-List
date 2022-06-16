package Com.sofka.KataList.controller;

import Com.sofka.KataList.models.TareaModel;
import Com.sofka.KataList.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @GetMapping()
    public List<TareaModel> listaTarea() {

        return this.tareaService.listaTareas();
    }
    @PostMapping()
    public TareaModel guardarTareas(@RequestBody TareaModel tareaModel) {
        return this.tareaService.guardarTarea(tareaModel);
    }

    @PutMapping(path = "/{id}")
    public TareaModel actualizarTareas(@RequestBody TareaModel tareaModel, @PathVariable("id") Long id) {
        return this.tareaService.actualizarTarea(tareaModel, id);
    }

    @DeleteMapping(path = "/del/{id}")
    public String eliminarTareas(@PathVariable("id") Long id){
        boolean ok=tareaService.eliminarTarea(id);
        if (ok) {
            return "Se elimino la tarea";
        }else {
            return "Ocurrio un error";
        }

    }
}
