/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import ControlPackage.Control;
import ModeloVista.DetalleTallerMV;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Arell
 */


public class DialogConfirmar extends JDialog {

    private final Control control;
    private final int idTaller;
    private final int idAlumno;

    // Paleta/estilos
    private static final Color AZUL = new Color(59, 108, 171);
    private static final Font  H1   = new Font("Segoe UI", Font.BOLD, 16);
    private static final Font  H2   = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font  P    = new Font("Segoe UI", Font.PLAIN, 13);

    public DialogConfirmar(Frame owner, Control control, int idTaller, int idAlumno) {
        super(owner, "Confirmar inscripción", true);
        this.control = control;
        this.idTaller = idTaller;
        this.idAlumno = idAlumno;

        setSize(800, 380);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        add(buildTopBar(), BorderLayout.NORTH);
        add(buildContent(), BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);
    }

    // ─────────────── TOP BAR ───────────────
    private JComponent buildTopBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(AZUL);
        bar.setBorder(new EmptyBorder(8, 12, 8, 12));

        JLabel title = new JLabel("Confirmar inscripción");
        title.setForeground(Color.WHITE);
        title.setFont(H1);

        bar.add(title, BorderLayout.WEST);
        return bar;
    }

    // ─────────────── CONTENT ───────────────
    private JComponent buildContent() {
        DetalleTallerMV det = control.VerTallerDetalle(idTaller);

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

        if (det != null) {
            JLabel titulo = new JLabel(det.nombre);
            titulo.setFont(H2);
            titulo.setForeground(new Color(55, 55, 55));

            JLabel l1 = line("Instructor: ", det.instructor);
            JLabel l2 = line("Horario: ", det.horario);
            JLabel l3 = line("Cupo: ", det.cupo + " alumnos");

            JLabel pregunta = new JLabel("¿Desea confirmar la inscripción?");
            pregunta.setFont(P);
            pregunta.setForeground(new Color(70, 70, 70));
            pregunta.setBorder(new EmptyBorder(12, 0, 0, 0));

            card.add(titulo);
            card.add(Box.createVerticalStrut(8));
            card.add(l1); card.add(l2); card.add(l3);
            card.add(pregunta);
        } else {
            card.add(new JLabel("Taller no encontrado."));
        }

        wrapper.add(card, BorderLayout.CENTER);
        return wrapper;
    }

    private JLabel line(String label, String value) {
        JLabel l = new JLabel(label + value);
        l.setFont(P);
        l.setForeground(new Color(85, 85, 85));
        return l;
    }

    // ─────────────── FOOTER ───────────────
    private JComponent buildFooter() {
        JPanel south = new JPanel(new BorderLayout());
        south.setBackground(Color.WHITE);
        south.setBorder(new EmptyBorder(10, 18, 12, 18));

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        right.setOpaque(false);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCancelar.setBackground(new Color(230, 76, 76));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnCancelar.addActionListener(e -> dispose());

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnConfirmar.setBackground(new Color(93, 132, 196));
        btnConfirmar.setForeground(Color.WHITE);
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnConfirmar.addActionListener(e -> confirmar());

        right.add(btnCancelar);
        right.add(btnConfirmar);

        south.add(right, BorderLayout.EAST);
        return south;
    }

    // ─────────────── ACTION ───────────────
    private void confirmar() {
        try {
            TicketMV ticket = control.ValidarInscripcion(idTaller, idAlumno);
            new DialogTicket((Frame) getOwner(), ticket).setVisible(true);
            dispose();
        } catch (IllegalStateException dup) {
            JOptionPane.showMessageDialog(this, dup.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalArgumentException notFound) {
            JOptionPane.showMessageDialog(this, notFound.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

