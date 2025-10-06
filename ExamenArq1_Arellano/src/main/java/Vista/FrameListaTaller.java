/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import ControlPackage.Control;
import ModeloVista.TallerMV;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Arell
 */

public class FrameListaTaller extends JFrame {

    private final Control control;

    // Ids fijos para demo (ajusta según tu repositorio)
    private final List<Integer> ids = Arrays.asList(1, 2, 3);

    // Colores/estilos
    private static final Color AZUL = new Color(59, 108, 171);
    private static final Color AZUL_SUAVE = new Color(227, 237, 250);
    private static final Color GRIS_SUAVE = new Color(245, 245, 245);
    private static final Font  H1 = new Font("Segoe UI", Font.BOLD, 18);
    private static final Font  H2 = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font  P  = new Font("Segoe UI", Font.PLAIN, 13);

    public FrameListaTaller(Control control) {
        super("Talleres de la Semana ISW");
        this.control = control;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(930, 560);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(buildTopBar(), BorderLayout.NORTH);
        add(buildList(),   BorderLayout.CENTER);
        add(buildFooter(), BorderLayout.SOUTH);
    }

    // ───────────────────────────────── TOP BAR ─────────────────────────────────
    private JComponent buildTopBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(AZUL);
        bar.setBorder(new EmptyBorder(8, 12, 8, 12));

        JLabel title = new JLabel("Talleres de la Semana ISW");
        title.setForeground(Color.WHITE);
        title.setFont(H1);

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        right.setOpaque(false);

        JComboBox<String> filtro = new JComboBox<>(new String[]{"Todos"});
        filtro.setFont(P);
        filtro.setBackground(Color.WHITE);

        JTextField search = new JTextField(18);
        search.putClientProperty("JTextField.placeholderText", "Buscar");
        search.setFont(P);

        right.add(filtro);
        right.add(search);

        bar.add(title, BorderLayout.WEST);
        bar.add(right, BorderLayout.EAST);
        return bar;
    }

    // ─────────────────────────────── LISTA/CARDS ───────────────────────────────
    private JComponent buildList() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Color.WHITE);
        content.setBorder(new EmptyBorder(16, 16, 16, 16));

        for (Integer id : ids) {
            TallerMV vm = control.VerTaller(id);
            if (vm != null) {
                content.add(buildCard(vm, id));
                content.add(Box.createVerticalStrut(12));
            }
        }

        JScrollPane sp = new JScrollPane(content);
        sp.getVerticalScrollBar().setUnitIncrement(16);
        sp.setBorder(null);
        return sp;
    }

    private JComponent buildCard(TallerMV vm, int idTaller) {
        // Contenedor de tarjeta
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(225, 225, 225)),
                new EmptyBorder(14, 16, 14, 16)
        ));

        // IZQ: info
        JPanel info = new JPanel();
        info.setOpaque(false);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel(vm.nombre);
        titulo.setFont(H2);
        titulo.setForeground(new Color(55, 55, 55));

        JLabel l1 = new JLabel("Instructor: " + vm.instructor);
        l1.setFont(P);
        l1.setForeground(new Color(90, 90, 90));

        JLabel l2 = new JLabel("Horario: " + vm.horario);
        l2.setFont(P);
        l2.setForeground(new Color(90, 90, 90));

        JLabel l3 = new JLabel("Cupo: " + vm.cupo + " alumnos");
        l3.setFont(P);
        l3.setForeground(new Color(120, 120, 120));

        info.add(titulo);
        info.add(Box.createVerticalStrut(6));
        info.add(l1);
        info.add(l2);
        info.add(l3);

        // DER: botón
        JPanel right = new JPanel(new GridBagLayout());
        right.setOpaque(false);
        JButton ver = new JButton("Ver Taller");
        ver.setFont(new Font("Segoe UI", Font.BOLD, 13));
        ver.setBackground(new Color(93, 132, 196));
        ver.setForeground(Color.WHITE);
        ver.setFocusPainted(false);
        ver.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        ver.addActionListener(e -> abrirDetalle(idTaller));

        right.add(ver);

        card.add(info, BorderLayout.CENTER);
        card.add(right, BorderLayout.EAST);

        // Fondo gris claro detrás (como en la maqueta)
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setBackground(GRIS_SUAVE);
        wrapper.add(card, BorderLayout.CENTER);
        return wrapper;
    }

    // ───────────────────────────────── FOOTER ──────────────────────────────────
    private JComponent buildFooter() {
        JPanel south = new JPanel(new BorderLayout());
        south.setBackground(Color.WHITE);
        south.setBorder(new EmptyBorder(8, 16, 12, 16));

        JButton regresar = new JButton("Regresar");
        regresar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        regresar.setBackground(new Color(230, 76, 76));
        regresar.setForeground(Color.WHITE);
        regresar.setFocusPainted(false);
        regresar.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
        regresar.addActionListener(e -> dispose());

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        left.setOpaque(false);
        left.add(regresar);

        south.add(left, BorderLayout.WEST);
        return south;
    }

    // ────────────────────────────── NAVEGACIÓN ────────────────────────────────
    private void abrirDetalle(int idTaller) {
        new DialogDetalleTaller(this, control, idTaller).setVisible(true);
    }
}
