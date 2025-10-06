/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Arell
 */

public class Alumno {
    private int id;
    private String nombre;
    private String grado;       // ej: "3°"
    private String programa;    // ej: "Ingeniería en Software"
    private String correo;

    public Alumno(int id, String nombre, String grado, String programa, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.grado = grado;
        this.programa = programa;
        this.correo = correo;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getGrado() { return grado; }
    public String getPrograma() { return programa; }
    public String getCorreo() { return correo; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setGrado(String grado) { this.grado = grado; }
    public void setPrograma(String programa) { this.programa = programa; }
    public void setCorreo(String correo) { this.correo = correo; }

    @Override public String toString() {
        return "Alumno{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
    }
}
