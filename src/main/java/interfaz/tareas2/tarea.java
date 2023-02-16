/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.tareas2;

import java.sql.Date;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Sergio
 */
public class tarea {
    int id,id_tarea,id_persona;
    String nombre,tipo,desc,fichero,entrega;
    Date fecha;

    public tarea(int id, String nombre, String tipo, Date fecha,String desc) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.desc=desc;
    }
    
    public tarea(int id, int id_persona, int id_tarea, String fichero, String entrega) {
        this.id = id;
        this.id_persona = id_persona;
        this.id_tarea = id_tarea;
        this.fichero = fichero;
        this.entrega = entrega;
    }
    
    public tarea(tarea t) {
        this.id = t.id;
        this.nombre = t.nombre;
        this.tipo = t.tipo;
        this.fecha = t.fecha;
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    @Override
    public String toString(){
        return ""+id;
    }
}
