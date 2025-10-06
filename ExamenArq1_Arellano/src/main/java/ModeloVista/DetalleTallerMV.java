/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVista;

/**
 *
 * @author Arell
 */

public class DetalleTallerMV {
    public final int id;
    public final String nombre;
    public final String instructor;
    public final String horario;
    public final String duracion;
    public final String lugar;
    public final int cupo;
    public final String modalidad;

    public DetalleTallerMV(int id, String nombre, String instructor, String horario,
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
}

