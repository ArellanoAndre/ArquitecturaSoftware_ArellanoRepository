/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import ControlPackage.Control;
import Modelo.ServicioAcademico;
import Modelo.TallerServicio;
import Modelo.TalleresRepo;
import Modelo.TicketRepo;
import ModeloVista.ModeloV;
import Vista.FrameListaTaller;
import javax.swing.SwingUtilities;

/**
 *
 * @author Arell
 */
public class ExamenArq1_Arellano {

    public static void main(String[] args) {
        System.out.println("Hello World!");
          SwingUtilities.invokeLater(() -> {
            // --- Modelo de Negocios (con datos hardcodeados en los repos)
            TalleresRepo talleresRepo = new TalleresRepo();
            ServicioAcademico servicioAcademico = new ServicioAcademico();
            TicketRepo ticketRepo = new TicketRepo();
            TallerServicio tallerServicio = new TallerServicio(talleresRepo, servicioAcademico, ticketRepo);

            // --- Modelo Vista y Control
            ModeloV modeloV = new ModeloV(tallerServicio);
            Control control = new Control(modeloV);

            // --- Pantalla inicial (Lista de Talleres)
            FrameListaTaller frame = new FrameListaTaller(control);
            frame.setVisible(true);
        });
    }
    }

