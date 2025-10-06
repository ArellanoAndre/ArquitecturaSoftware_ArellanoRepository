/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloVista;

/**
 *
 * @author Arell
 */

import Modelo.Alumno;
import Modelo.Taller;
import Modelo.TallerServicio;
import Modelo.Ticket;
import java.time.format.DateTimeFormatter;

public class ModeloV {

    private final TallerServicio servicio; // dependencia hacia Modelo de Negocios
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public ModeloV(TallerServicio servicio) {
        this.servicio = servicio;
    }

    // -------- Ver Taller (para tarjeta/lista) --------
    public TallerMV VerTaller(int id_Taller) {
        Taller t = servicio.VerTaller(id_Taller);
        if (t == null) return null;
        return new TallerMV(t.getId(), t.getNombre(), t.getInstructor(), t.getHorario(), t.getCupo());
    }

    // -------- Ver Taller (detalle) --------
    public DetalleTallerMV VerTallerDetalle(int id_Taller) {
        Taller t = servicio.VerTaller(id_Taller);
        if (t == null) return null;
        return new DetalleTallerMV(
                t.getId(), t.getNombre(), t.getInstructor(), t.getHorario(),
                t.getDuracion(), t.getLugar(), t.getCupo(), t.getModalidad()
        );
    }

    // -------- Ver Alumno --------
    public AlumnoMV VerAlumno(int id) {
        Alumno a = servicio.VerAlumno(id);
        if (a == null) return null;
        return new AlumnoMV(a.getId(), a.getNombre(), a.getGrado(), a.getPrograma(), a.getCorreo());
    }

    // -------- Validar/Inscribir y devolver Ticket para la Vista --------
    public TicketMV ValidarInscripcion(int id_Taller, int id_Alumno) {
        // La validación de “ya inscrito” ocurre dentro de TallerServicio
        Ticket ticket = servicio.ValidarInscripcion(id_Taller, id_Alumno);

        return new TicketMV(
                ticket.getId(),
                ticket.getFecha().format(fmt),
                ticket.getAlumno().getId(),
                ticket.getAlumno().getNombre(),
                ticket.getTaller().getNombre(),
                ticket.getTaller().getInstructor(),
                ticket.getTaller().getHorario()
        );
    }
}

