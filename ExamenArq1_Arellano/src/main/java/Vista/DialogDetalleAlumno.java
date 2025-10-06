/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import ControlPackage.Control;
import ModeloVista.AlumnoMV;
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

public class DialogDetalleAlumno extends JDialog {

    private final Control control;
    private final int idTaller;
    private final AlumnoMV alumno;

    // Paleta y tipografías para mantener consistencia visual
    private static final Color AZUL = new Color(59, 108, 171);
    private static final Font  H1   = new Font("Segoe UI", Font.BOLD, 16);
    private static final Font  H2   = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font  P    = new Font("Segoe UI", Font.PLAIN, 13);

    public DialogDetalleAlumno(Frame owner, Control control, int idTaller, AlumnoMV alumno) {
        super(owner, "Detalles del Alumno", true);
        this.control = control;
        this.idTaller = idTaller;
        this.alumno = alumno;

        setSize(800, 380);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        add(buildTopBar(), BorderLayout.NORTH);
        add(buildContent(), BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);
    }

    // ───────────────────────────────── TOP BAR ─────────────────────────────────
    private JComponent buildTopBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(AZUL);
        bar.setBorder(new EmptyBorder(8, 12, 8, 12));

        JLabel title = new JLabel("Detalles del alumno");
        title.setForeground(Color.WHITE);
        title.setFont(H1);

        bar.add(title, BorderLayout.WEST);
        return bar;
    }

    // ───────────────────────────────── CONTENT ────────────────────────────────
    private JComponent buildContent() {
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

        JLabel titulo = new JLabel("Datos del Alumno:");
        titulo.setFont(H2);
        titulo.setForeground(new Color(55, 55, 55));

        JLabel l1 = line("ID: ", String.valueOf(alumno.id));
        JLabel l2 = line("Nombre: ", alumno.nombre);
        JLabel l3 = line("Semestre: ", alumno.grado);
        JLabel l4 = line("Programa: ", alumno.programa);
        JLabel l5 = line("Correo: ", alumno.correo);

        card.add(titulo);
        card.add(Box.createVerticalStrut(8));
        card.add(l1); card.add(l2); card.add(l3); card.add(l4); card.add(l5);

        wrapper.add(card, BorderLayout.CENTER);
        return wrapper;
    }

    private JLabel line(String label, String value) {
        JLabel l = new JLabel(label + value);
        l.setFont(P);
        l.setForeground(new Color(85, 85, 85));
        return l;
    }

    // ───────────────────────────────── FOOTER ─────────────────────────────────
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

        JButton btnContinuar = new JButton("Aceptar");
        btnContinuar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnContinuar.setBackground(new Color(93, 132, 196));
        btnContinuar.setForeground(Color.WHITE);
        btnContinuar.setFocusPainted(false);
        btnContinuar.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnContinuar.addActionListener(e -> {
            new DialogConfirmar((Frame) getOwner(), control, idTaller, alumno.id).setVisible(true);
            dispose();
        });

        right.add(btnCancelar);
        right.add(btnContinuar);

        south.add(right, BorderLayout.EAST);
        return south;
    }
}
