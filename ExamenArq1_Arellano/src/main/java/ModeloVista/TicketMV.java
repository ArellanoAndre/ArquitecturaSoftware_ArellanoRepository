/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVista;

/**
 *
 * @author Arell
 */

public class TicketMV {
    public final int id;               // folio entero
    public final String fecha;         // ya formateada p/mostrar
    public final int idAlumno;
    public final String nombreAlumno;
    public final String nombreTaller;
    public final String instructor;
    public final String horario;

    public TicketMV(int id, String fecha, int idAlumno, String nombreAlumno,
                    String nombreTaller, String instructor, String horario) {
        this.id = id;
        this.fecha = fecha;
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.nombreTaller = nombreTaller;
        this.instructor = instructor;
        this.horario = horario;
    }
}

