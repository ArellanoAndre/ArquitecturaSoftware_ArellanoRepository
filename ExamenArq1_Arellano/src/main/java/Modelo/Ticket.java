/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Arell
 */

import java.time.LocalDateTime;

public class Ticket {
    private int id;                 // folio entero
    private LocalDateTime fecha;
    private Alumno alumno;
    private Taller taller;

    public Ticket(int id, LocalDateTime fecha, Alumno alumno, Taller taller) {
        this.id = id;
        this.fecha = fecha;
        this.alumno = alumno;
        this.taller = taller;
    }

    public int getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public Alumno getAlumno() { return alumno; }
    public Taller getTaller() { return taller; }

    @Override public String toString() {
        return "Ticket{" + "id=" + id + ", alumno=" + alumno.getNombre() +
                ", taller=" + taller.getNombre() + ", fecha=" + fecha + '}';
    }
}

