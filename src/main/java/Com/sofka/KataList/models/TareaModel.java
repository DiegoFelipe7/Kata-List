package Com.sofka.KataList.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Entidad de la  tareas
 *
 * @author Diego felipe muñoz
 * @version 1.0.0 17-06-2022
 * @since 1.0.0
 **/
@Entity
@Table(name = "tarea")
public class TareaModel {
    /**
     * Atributos de la clase
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    @Column(name = "nombre" , nullable = false ,length = 225)
    private String nombre;
    /**
     * punto de enlaze con la clase subtarea
     * una tarea tiene muchas subtareas
     */
    @OneToMany(mappedBy = "id_subtareas",
            targetEntity = SubTareasModel.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<SubTareasModel> subtarea=new ArrayList<>();

    public List<SubTareasModel> getSubtarea() {
        return subtarea;
    }

    public void setSubtarea(List<SubTareasModel> subtarea) {
        this.subtarea = subtarea;
    }

    public TareaModel(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TareaModel(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
