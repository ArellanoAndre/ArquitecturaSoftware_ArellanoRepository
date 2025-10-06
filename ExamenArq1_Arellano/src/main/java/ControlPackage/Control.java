/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlPackage;

import ModeloVista.AlumnoMV;
import ModeloVista.DetalleTallerMV;
import ModeloVista.ModeloV;
import ModeloVista.TallerMV;
import ModeloVista.TicketMV;

/**
 *
 * @author Arell
 */



public class Control {

    private final ModeloV modeloV;

    public Control(ModeloV modeloV) {
        this.modeloV = modeloV;
    }

    /** Devuelve datos mínimos para tarjetas/lista de talleres */
    public TallerMV VerTaller(int id_Taller) {
        return modeloV.VerTaller(id_Taller);
    }

    /** Devuelve datos completos para la pantalla de detalle */
    public DetalleTallerMV VerTallerDetalle(int id_Taller) {
        return modeloV.VerTallerDetalle(id_Taller);
    }

    /** Devuelve datos del alumno para la pantalla “Detalles del Alumno” */
    public AlumnoMV VerAlumno(int id) {
        return modeloV.VerAlumno(id);
    }

    /** Ejecuta la inscripción (valida duplicidad en el Modelo de Negocios) y regresa el Ticket para la Vista */
    public TicketMV ValidarInscripcion(int id_Taller, int id_Alumno) {
        return modeloV.ValidarInscripcion(id_Taller, id_Alumno);
    }
}

