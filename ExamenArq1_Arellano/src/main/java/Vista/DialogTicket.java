/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import ModeloVista.TicketMV;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Arell
 */

public class DialogTicket extends JDialog {

    private static final Color AZUL = new Color(59, 108, 171);
    private static final Font H1 = new Font("Segoe UI", Font.BOLD, 16);
    private static final Font H2 = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font P  = new Font("Segoe UI", Font.PLAIN, 13);

    public DialogTicket(Frame owner, TicketMV ticket) {
        super(owner, "Ticket de inscripción", true);
        setSize(800, 420);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        add(buildTopBar(), BorderLayout.NORTH);
        add(buildContent(ticket), BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);
    }

    // ─────────────────────────── TOP BAR ───────────────────────────
    private JComponent buildTopBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(AZUL);
        bar.setBorder(new EmptyBorder(8, 12, 8, 12));

        JLabel title = new JLabel("Ticket de inscripción");
        title.setForeground(Color.WHITE);
        title.setFont(H1);

        bar.add(title, BorderLayout.WEST);
        return bar;
    }

    // ─────────────────────────── CONTENT ───────────────────────────
    private JComponent buildContent(TicketMV ticket) {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(new Color(245, 245, 245));
        wrapper.setBorder(new EmptyBorder(18, 18, 18, 18));

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(225, 225, 225)),
                new EmptyBorder(16, 18, 16, 18)
        ));

        JLabel titulo = new JLabel("Ticket de inscripción - Semana de ISW");
        titulo.setFont(H2);
        titulo.setForeground(new Color(55, 55, 55));

        JLabel folio = line("Folio: ", String.valueOf(ticket.id));
        JLabel fecha = line("Fecha de emisión: ", String.valueOf(ticket.fecha));

        JLabel subt1 = new JLabel("Datos del Alumno:");
        subt1.setFont(H2);
        subt1.setForeground(new Color(55, 55, 55));
        subt1.setBorder(new EmptyBorder(10, 0, 0, 0));

        JLabel alumnoId = line("ID: ", String.valueOf(ticket.idAlumno));
        JLabel alumnoNom = line("Nombre: ", ticket.nombreAlumno);

        JLabel subt2 = new JLabel("Datos del Taller:");
        subt2.setFont(H2);
        subt2.setForeground(new Color(55, 55, 55));
        subt2.setBorder(new EmptyBorder(10, 0, 0, 0));

        JLabel tallerNom = line("Nombre: ", ticket.nombreTaller);
        JLabel tallerIns = line("Instructor: ", ticket.instructor);
        JLabel tallerHor = line("Horario: ", ticket.horario);

        card.add(titulo);
        card.add(Box.createVerticalStrut(6));
        card.add(folio);
        card.add(fecha);
        card.add(subt1);
        card.add(alumnoId);
        card.add(alumnoNom);
        card.add(subt2);
        card.add(tallerNom);
        card.add(tallerIns);
        card.add(tallerHor);

        wrapper.add(card, BorderLayout.CENTER);
        return wrapper;
    }

    private JLabel line(String label, String value) {
        JLabel l = new JLabel(label + value);
        l.setFont(P);
        l.setForeground(new Color(85, 85, 85));
        return l;
    }

    // ─────────────────────────── FOOTER ───────────────────────────
    private JComponent buildFooter() {
        JPanel south = new JPanel(new BorderLayout());
        south.setBackground(Color.WHITE);
        south.setBorder(new EmptyBorder(10, 18, 12, 18));

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        right.setOpaque(false);

        JButton btnCerrar = new JButton("Regresar");
        btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCerrar.setBackground(new Color(230, 76, 76));
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnCerrar.addActionListener(e -> {
            dispose();      // Cierra el diálogo actual
            System.exit(0); // Termina toda la aplicación
        });

        right.add(btnCerrar);
        south.add(right, BorderLayout.EAST);
        return south;
    }
}
