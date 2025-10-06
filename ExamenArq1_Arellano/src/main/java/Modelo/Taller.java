/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Arell
 */

public class Taller {
    private int id;
    private String nombre;
    private String instructor;
    private String horario;     // ej: "Miércoles 10:00 AM – 1:00 PM"
    private String duracion;    // ej: "3 horas (1 sesión)"
    private String lugar;       // ej: "Aula Magna, Edificio B"
    private int cupo;           // opcional: no usamos validación de cupo aquí
    private String modalidad;   // ej: "Presencial"

    public Taller(int id, String nombre, String instructor, String horario,
                  String duracion, String lugar, int cupo, String modalidad) {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;
        this.horario = horario;
        this.duracion = duracion;
        this.lugar = lugar;
        this.cupo = cupo;
        this.modalidad = modalidad;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getInstructor() { return instructor; }
    public String getHorario() { return horario; }
    public String getDuracion() { return duracion; }
    public String getLugar() { return lugar; }
    public int getCupo() { return cupo; }
    public String getModalidad() { return modalidad; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setInstructor(String instructor) { this.instructor = instructor; }
    public void setHorario(String horario) { this.horario = horario; }
    public void setDuracion(String duracion) { this.duracion = duracion; }
    public void setLugar(String lugar) { this.lugar = lugar; }
    public void setCupo(int cupo) { this.cupo = cupo; }
    public void setModalidad(String modalidad) { this.modalidad = modalidad; }

    @Override public String toString() {
        return "Taller{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
    }
}

