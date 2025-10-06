/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import ControlPackage.Control;
import ModeloVista.AlumnoMV;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Arell
 */

public class DialogIngresoID extends JDialog {

    private final Control control;
    private final int idTaller;
    private final JTextField txtId = new JTextField(14);

    // Colores y tipografías
    private static final Color AZUL = new Color(59, 108, 171);
    private static final Font  H1   = new Font("Segoe UI", Font.BOLD, 16);
    private static final Font  P    = new Font("Segoe UI", Font.PLAIN, 13);

    public DialogIngresoID(Frame owner, Control control, int idTaller) {
        super(owner, "Ingreso de ID", true);
        this.control = control;
        this.idTaller = idTaller;

        setSize(420, 220);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        add(buildTopBar(), BorderLayout.NORTH);
        add(buildCenter(), BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);
    }

    // ──────────────────────────────── TOP BAR ────────────────────────────────
    private JComponent buildTopBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(AZUL);
        bar.setBorder(new EmptyBorder(8, 12, 8, 12));

        JLabel title = new JLabel("Ingreso de ID");
        title.setForeground(Color.WHITE);
        title.setFont(H1);

        bar.add(title, BorderLayout.WEST);
        return bar;
    }

    // ──────────────────────────────── CENTER ────────────────────────────────
    private JComponent buildCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        center.setBorder(new EmptyBorder(30, 20, 30, 20));
        center.setBackground(Color.WHITE);

        JLabel lbl = new JLabel("Ingresa el número de ID:");
        lbl.setFont(P);
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtId.setMaximumSize(new Dimension(180, 28));
        txtId.setFont(P);
        txtId.setHorizontalAlignment(JTextField.CENTER);
        txtId.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                new EmptyBorder(6, 8, 6, 8)
        ));

        center.add(lbl);
        center.add(Box.createVerticalStrut(10));
        center.add(txtId);
        return center;
    }

    // ──────────────────────────────── FOOTER ────────────────────────────────
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

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnAceptar.setBackground(new Color(93, 132, 196));
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setFocusPainted(false);
        btnAceptar.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnAceptar.addActionListener(e -> consultarAlumno());

        right.add(btnCancelar);
        right.add(btnAceptar);
        south.add(right, BorderLayout.EAST);

        return south;
    }

    // ──────────────────────────────── LOGIC ────────────────────────────────
    private void consultarAlumno() {
        try {
            int idAlumno = Integer.parseInt(txtId.getText().trim());
            AlumnoMV alumno = control.VerAlumno(idAlumno);
            if (alumno == null) {
                JOptionPane.showMessageDialog(this, "ID no encontrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            new DialogDetalleAlumno((Frame) getOwner(), control, idTaller, alumno).setVisible(true);
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
