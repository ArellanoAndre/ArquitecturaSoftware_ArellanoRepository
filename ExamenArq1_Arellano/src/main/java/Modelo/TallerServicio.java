/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Arell
 */


public class TallerServicio {
    private final TalleresRepo talleresRepo;
    private final ServicioAcademico servicioAcademico;
    private final TicketRepo ticketRepo;

    public TallerServicio(TalleresRepo talleresRepo, ServicioAcademico servicioAcademico, TicketRepo ticketRepo) {
        this.talleresRepo = talleresRepo;
        this.servicioAcademico = servicioAcademico;
        this.ticketRepo = ticketRepo;
    }

    public Taller VerTaller(int id_Taller) {
        return talleresRepo.buscarPorId(id_Taller);
    }

    public Alumno VerAlumno(int id) {
        return servicioAcademico.buscarPorId(id);
    }

    

public Ticket ValidarInscripcion(int id_Taller, int id_Alumno) {
    // 1) Obtener entidades
    Alumno alumno = servicioAcademico.buscarPorId(id_Alumno);
    if (alumno == null) {
        throw new IllegalArgumentException("Alumno no encontrado: " + id_Alumno);
    }

    Taller taller = talleresRepo.buscarPorId(id_Taller);
    if (taller == null) {
        throw new IllegalArgumentException("Taller no encontrado: " + id_Taller);
    }

    // 2) Única validación de negocio: no duplicar inscripción
    if (ticketRepo.existsByAlumnoAndTaller(id_Alumno, id_Taller)) {
        throw new IllegalStateException("El alumno ya está inscrito en este taller.");
    }

    // 3) Crear ticket (folio entero autogenerado en el repo)
    Ticket ticket = ticketRepo.save(alumno, taller);

    // 4) Restar un cupo al taller (sin dejar valores negativos)
    int cupoActual = taller.getCupo();
    if (cupoActual > 0) {
        taller.setCupo(cupoActual - 1);
    } else {
        // Si no quieres permitir inscribir con cupo 0, aquí podrías lanzar excepción.
        // throw new IllegalStateException("No hay cupo disponible para este taller.");
        taller.setCupo(0);
    }

    return ticket;
}


}


