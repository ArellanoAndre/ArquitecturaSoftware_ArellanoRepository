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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;



public class TicketRepo {

    private final List<Ticket> listaTicket = new ArrayList<>();
    private final AtomicInteger secuencia = new AtomicInteger(1000); // folios: 1001, 1002, ...

    /** Devuelve una copia de la lista (para no exponer la interna). */
    public List<Ticket> findAll() {
        return new ArrayList<>(listaTicket);
    }

    /** Busca un ticket por su folio (id). */
    public Ticket findById(int id) {
        for (Ticket t : listaTicket) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    /** Todos los tickets de un alumno. */
    public List<Ticket> findByAlumno(int idAlumno) {
        return listaTicket.stream()
                .filter(t -> t.getAlumno().getId() == idAlumno)
                .collect(Collectors.toList());
    }

    /** Todos los tickets de un taller. */
    public List<Ticket> findByTaller(int idTaller) {
        return listaTicket.stream()
                .filter(t -> t.getTaller().getId() == idTaller)
                .collect(Collectors.toList());
    }

    /** ¿Existe ya inscripción de ese alumno en ese taller? (Regla de negocio principal). */
    public boolean existsByAlumnoAndTaller(int idAlumno, int idTaller) {
        return listaTicket.stream().anyMatch(t ->
                t.getAlumno().getId() == idAlumno && t.getTaller().getId() == idTaller);
    }

    /**
     * Crea y persiste un ticket nuevo para (alumno,taller).
     * Genera el folio entero automáticamente.
     */
    public Ticket save(Alumno alumno, Taller taller) {
        int nuevoFolio = secuencia.incrementAndGet();
        Ticket t = new Ticket(nuevoFolio, LocalDateTime.now(), alumno, taller);
        listaTicket.add(t);
        return t;
    }

    /** Elimina un ticket por id. */
    public boolean deleteById(int id) {
        return listaTicket.removeIf(t -> t.getId() == id);
    }

    /** Vacía el repositorio (útil en pruebas). */
    public void clear() {
        listaTicket.clear();
        secuencia.set(1000);
    }

    /** Cantidad de tickets almacenados. */
    public int size() {
        return listaTicket.size();
    }

    public List<Ticket> getListaTicket() {
        return listaTicket;
    }

    public AtomicInteger getSecuencia() {
        return secuencia;
    }
    
    
}


