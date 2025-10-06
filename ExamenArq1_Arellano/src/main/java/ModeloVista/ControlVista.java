/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVista;

/**
 *
 * @author Arell
 */

public class ControlVista {
    public TallerMV taller;
    public DetalleTallerMV detalle;
    public AlumnoMV alumno;
    public TicketMV ticket;

    public void limpiar() {
        taller = null;
        detalle = null;
        alumno = null;
        ticket = null;
    }
}
