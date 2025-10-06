/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVista;

/**
 *
 * @author Arell
 */

public class TallerMV {
    public final int id;
    public final String nombre;
    public final String instructor;
    public final String horario;
    public final int cupo;

    public TallerMV(int id, String nombre, String instructor, String horario, int cupo) {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;
        this.horario = horario;
        this.cupo = cupo;
    }
}

