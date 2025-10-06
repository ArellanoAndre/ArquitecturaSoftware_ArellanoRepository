/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import ControlPackage.Control;
import ModeloVista.DetalleTallerMV;
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

public class DialogDetalleTaller extends JDialog {

    private final Control control;
    private final int idTaller;

    // Colores y tipografías consistentes con FrameListaTaller
    private static final Color AZUL = new Color(59, 108, 171);
    private static final Font  H1   = new Font("Segoe UI", Font.BOLD, 16);
    private static final Font  H2   = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font  P    = new Font("Segoe UI", Font.PLAIN, 13);

    public DialogDetalleTaller(Frame owner, Control control, int idTaller) {
        super(owner, "Detalle del taller", true);
        this.control = control;
        this.idTaller = idTaller;

        setSize(800, 420);
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

        JLabel title = new JLabel("Detalles del taller");
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

        DetalleTallerMV vm = control.VerTallerDetalle(idTaller);

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(225, 225, 225)),
                new EmptyBorder(16, 18, 16, 18)
        ));

        if (vm != null) {
            JLabel titulo = new JLabel(vm.nombre);
            titulo.setFont(H2);
            titulo.setForeground(new Color(55, 55, 55));

            JLabel l1 = line("Instructor: ", vm.instructor);
            JLabel l2 = line("Horario: ", vm.horario);
            JLabel l3 = line("Duración: ", vm.duracion);
            JLabel l4 = line("Lugar: ", vm.lugar);
            JLabel l5 = line("Cupo: ", vm.cupo + " alumnos");
            JLabel l6 = line("Modalidad: ", vm.modalidad);

            card.add(titulo);
            card.add(Box.createVerticalStrut(8));
            card.add(l1); card.add(l2); card.add(l3);
            card.add(l4); card.add(l5); card.add(l6);
        } else {
            JLabel notFound = new JLabel("Taller no encontrado.");
            notFound.setFont(P);
            card.add(notFound);
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

    // ───────────────────────────────── FOOTER ─────────────────────────────────
    private JComponent buildFooter() {
        JPanel south = new JPanel(new BorderLayout());
        south.setBackground(Color.WHITE);
        south.setBorder(new EmptyBorder(10, 18, 12, 18));

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        right.setOpaque(false);

        JButton btnCancel = new JButton("Cancelar");
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCancel.setBackground(new Color(230, 76, 76));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFocusPainted(false);
        btnCancel.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnCancel.addActionListener(e -> dispose());

        JButton btnInscribir = new JButton("Inscribirse");
        btnInscribir.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnInscribir.setBackground(new Color(93, 132, 196));
        btnInscribir.setForeground(Color.WHITE);
        btnInscribir.setFocusPainted(false);
        btnInscribir.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btnInscribir.addActionListener(e ->
                new DialogIngresoID((Frame) getOwner(), control, idTaller).setVisible(true)
        );

        right.add(btnCancel);
        right.add(btnInscribir);

        south.add(right, BorderLayout.EAST);
        return south;
    }
}
