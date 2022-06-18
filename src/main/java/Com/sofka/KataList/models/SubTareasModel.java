package Com.sofka.KataList.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Entidad de la subtareas
 *
 * @author Diego felipe muñoz
 * @version 1.0.0 17-06-2022
 * @since 1.0.0
 **/

@Entity
@Table(name = "sub_tarea")
public class SubTareasModel {
    /**
     * Atributos de la clase
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "estado", nullable = false)
    private String estado;
    /**
     * punto de enlace con la clase tarea
     * muchas subtareas tiene una tarea
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TareaModel.class)
    @JoinColumn(name = "id_subtareas")
    @JsonBackReference
    private TareaModel id_subtareas;


    public SubTareasModel(Long id, String nombre, String estado, TareaModel id_subtareas) {
        Id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.id_subtareas = id_subtareas;
    }

    public SubTareasModel( String nombre, String estado, TareaModel id_subtareas) {
        this.nombre = nombre;
        this.estado = estado;
        this.id_subtareas = id_subtareas;
    }


    public SubTareasModel() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TareaModel getId_subtareas() {
        return id_subtareas;
    }

    public void setId_subtareas(TareaModel id_subtareas) {
        this.id_subtareas = id_subtareas;
    }
}
