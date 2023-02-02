/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz.tareas2;

/**
 *
 * @author Sergio
 */
public class clase {
    private int id;
    private String nombre,curso;
    private float nota;
    private int ponderacionExamen,ponderacionActividades,ponderacionProyectos;

    public clase(int id, String nombre, String curso, float nota, int ponderacionExamen, int ponderacionActividades, int ponderacionProyectos) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
        this.nota = nota;
        this.ponderacionExamen = ponderacionExamen;
        this.ponderacionActividades = ponderacionActividades;
        this.ponderacionProyectos = ponderacionProyectos;
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

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getPonderacionExamen() {
        return ponderacionExamen;
    }

    public void setPonderacionExamen(int ponderacionExamen) {
        this.ponderacionExamen = ponderacionExamen;
    }

    public int getPonderacionActividades() {
        return ponderacionActividades;
    }

    public void setPonderacionActividades(int ponderacionActividades) {
        this.ponderacionActividades = ponderacionActividades;
    }

    public int getPonderacionProyectos() {
        return ponderacionProyectos;
    }

    public void setPonderacionProyectos(int ponderacionProyectos) {
        this.ponderacionProyectos = ponderacionProyectos;
    }
    
   
    @Override
    public String toString(){
        return id+nombre+curso+nota+ponderacionActividades+ponderacionExamen+ponderacionProyectos;
    }
}
