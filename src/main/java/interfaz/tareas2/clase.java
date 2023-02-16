/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.tareas2;

import javafx.scene.paint.Color;

/**
 *
 * @author Sergio
 */
public class clase {
    private int id;
    private String nombre,curso;
    private Color color;
    public clase(int id, String nombre, String curso, Color color) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.color = color;
    }

    public clase(int id, String nombre, String curso) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


    
   
    @Override
    public String toString(){
        return id+nombre+curso;
    }
}
