package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

public class Proximamente extends JFrame implements ActionListener {

    JPanel panel;
    JButton boton1, salir, planetas, bProx, buscar, satelites, galaxias, estrellas;

    DefaultTableModel modelo = new DefaultTableModel();
    JTable tabla = new JTable(modelo);

    public Proximamente() {
        setIconImage(getIconImage());
        setSize(900, 600); //Para establecer el tamaño de la ventana
        setTitle("Estelary"); // para establecer el titulo de la ventana
        setLocationRelativeTo(null);
        setResizable(false);
        // llama los componentes
        componentes();
        // Cerrar la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(panel);
    }

    @Override
    public Image getIconImage() {
        Image Icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/galaxia.png"));
        return Icono;
    }

    private void componentes() {
        paneles();
        etiquetas();
        botones();
    }

    private void paneles() {
        panel = new JPanel(new BorderLayout());
        panel.setLayout(null);
        panel.setBackground(Color.black);
        panel.setPreferredSize(new Dimension(0, 1100));

    }

    private void etiquetas() {
        //etiqueta cabecera
        JLabel encabezado = new JLabel("Universo");
        encabezado.setHorizontalAlignment(SwingConstants.CENTER);
        encabezado.setBounds(0, 0, 900, 25);
        encabezado.setBackground(new ColorUIResource(168, 5, 255));
        encabezado.setOpaque(true);
        panel.add(encabezado);

        JLabel label1 = new JLabel();
        label1.setForeground(Color.WHITE);
        label1.setBounds(100, 240, 180, 30);
        label1.setText("Próximamente");
        label1.setFont(new Font("courier new", 1, 20));
        panel.add(label1);

        ImageIcon img1 = new ImageIcon("src/imagenes/planetas.png");
        JLabel label2 = new JLabel();
        label2.setIcon(new ImageIcon(img1.getImage().getScaledInstance(888, 218, Image.SCALE_SMOOTH)));
        label2.setBounds(5, 70, 888, 160);
        panel.add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(10, 35, 100, 30);
        label3.setFont(new Font("courier new", 1, 20));
        label3.setForeground(Color.WHITE);
        label3.setText("Estelary");
        panel.add(label3);
    }

    private void botones() {
        //boton de inicio
        boton1 = new JButton("Inicio");
        boton1.setForeground(Color.WHITE);
        boton1.setFont(new Font("courier new", Font.BOLD, 14));
        boton1.setEnabled(true);
        boton1.setBounds(110, 38, 130, 30);
        boton1.setBackground(Color.DARK_GRAY);
        boton1.setFocusPainted(false);
        boton1.setBorderPainted(false);
        boton1.setContentAreaFilled(false);
        boton1.addActionListener(this);
        panel.add(boton1);
        panel.add(boton1);

        ImageIcon salirImagen = new ImageIcon("src/imagenes/salir.png");

        //boton de salir
        salir = new JButton();
        salir.setFont(new Font("Courier new", Font.BOLD, 14));
        salir.setBounds(830, 33, 27, 30);
        salir.setIcon(new ImageIcon(salirImagen.getImage().getScaledInstance(30, 33, Image.SCALE_SMOOTH)));
        salir.setBackground(Color.black);
        salir.setForeground(Color.white);
        salir.setDefaultCapable(false);
        salir.setBorder(null);
        salir.setEnabled(true);
        salir.setOpaque(true);
        salir.setContentAreaFilled(true);
        salir.addActionListener(this);
        panel.add(salir);

        //boton de planetas
        planetas = new JButton("Planetas");
        planetas.setFont(new Font("Courier new", Font.BOLD, 14));
        planetas.setBounds(235, 38, 130, 30);
        planetas.setBackground(Color.black);
        planetas.setForeground(Color.white);
        planetas.setDefaultCapable(false);
        planetas.setBorder(null);
        planetas.setEnabled(true);
        planetas.setOpaque(true);
        planetas.setContentAreaFilled(true);
        planetas.addActionListener(this);
        panel.add(planetas);

        //boton de proximamente
        bProx = new JButton("Próximamente");
        bProx.setFont(new Font("Courier new", Font.BOLD, 14));
        bProx.setBounds(370, 38, 130, 30);
        bProx.setBackground(Color.black);
        bProx.setForeground(Color.white);
        bProx.setDefaultCapable(false);
        bProx.setBorder(null);
        bProx.setEnabled(true);
        bProx.setOpaque(true);
        bProx.setContentAreaFilled(true);
        panel.add(bProx);

        //Botón buscar
        ImageIcon buscarImagen = new ImageIcon("src/imagenes/buscar.jpg");
        buscar = new JButton();
        buscar.setFont(new Font("Courier new", Font.BOLD, 14));
        buscar.setBounds(780, 26, 38, 40);
        buscar.setIcon(new ImageIcon(buscarImagen.getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH)));
        buscar.setBackground(Color.black);
        buscar.setForeground(Color.white);
        buscar.setDefaultCapable(false);
        buscar.setBorder(null);
        buscar.setEnabled(true);
        buscar.setOpaque(true);
        buscar.setContentAreaFilled(true);
        buscar.addActionListener(this);
        panel.add(buscar);

        //satelites
        ImageIcon img = new ImageIcon("src/imagenes/luna2-2.gif");
        satelites = new JButton();
        satelites.setIcon(img);
        satelites.setText("Satélites");
        satelites.setFont(new Font("georgia", Font.BOLD, 16));
        satelites.setForeground(Color.white);
        satelites.setHorizontalTextPosition(SwingConstants.CENTER);
        satelites.setVerticalTextPosition(SwingConstants.BOTTOM);
        satelites.setBackground(Color.black);
        satelites.setBounds(50, 300, 300, 220);
        satelites.setBorderPainted(false);
        satelites.setContentAreaFilled(false);
        satelites.addActionListener(this);
        satelites.setOpaque(false);
        panel.add(satelites);

        //galaxias
        ImageIcon imgG = new ImageIcon("src/imagenes/galaxia.gif");
        galaxias = new JButton();
        galaxias.setIcon(imgG);
        galaxias.setText("Galaxias");
        galaxias.setFont(new Font("georgia", Font.BOLD, 16));
        galaxias.setForeground(Color.white);
        galaxias.setHorizontalTextPosition(SwingConstants.CENTER);
        galaxias.setVerticalTextPosition(SwingConstants.BOTTOM);
        galaxias.setBackground(Color.black);
        galaxias.setBounds(320, 300, 300, 190);
        galaxias.setBorderPainted(false);
        galaxias.setContentAreaFilled(false);
        galaxias.addActionListener(this);
        galaxias.setOpaque(false);
        panel.add(galaxias);

        //estrellas
        ImageIcon imgE = new ImageIcon("src/imagenes/estrella-2.gif");
        estrellas = new JButton();
        estrellas.setIcon(imgE);
        estrellas.setText("Estrellas");
        estrellas.setFont(new Font("georgia", Font.BOLD, 16));
        estrellas.setForeground(Color.white);
        estrellas.setHorizontalTextPosition(SwingConstants.CENTER);
        estrellas.setVerticalTextPosition(SwingConstants.BOTTOM);
        estrellas.setBackground(Color.black);
        estrellas.setBounds(550, 280, 300, 210);
        estrellas.setBorderPainted(false);
        estrellas.setContentAreaFilled(false);
        estrellas.addActionListener(this);
        estrellas.setOpaque(false);
        panel.add(estrellas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            Inicio i = new Inicio();
            i.setVisible(true);
            setVisible(false);
        } else if (e.getSource() == salir) {
            UIManager.put("OptionPane.background", Color.decode("#FFFFFF"));
            UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFFFFF"));
            int opcionSalir = JOptionPane.showConfirmDialog(this,
                    "¿Desea cerrar sesión?",
                    "Cerrar sesión",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            switch (opcionSalir) {
                case JOptionPane.NO_OPTION:
                    break;
                case JOptionPane.YES_OPTION:
                    Login login = new Login();
                    login.setVisible(true);
                    setVisible(false);
                    break;
                default:
            }
        } else if (e.getSource() == planetas) {
            Planetas p = new Planetas();
            p.setVisible(true);
            setVisible(false);
        } else if (e.getSource() == buscar) {
            String[] nombres = GestorBD.getInstance().buscador().toArray(new String[0]);;
            Object opcion;
            ImageIcon imgLabel = new ImageIcon("src/imagenes/planetaBusca2.png");
            UIManager.put("OptionPane.background", Color.decode("#FFFFFF"));
            UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFFFFF"));
            opcion = JOptionPane.showInputDialog(this,
                    "Seleccione el planeta deseado",
                    "Buscador de planetas",
                    JOptionPane.QUESTION_MESSAGE,
                    imgLabel,
                    nombres,
                    nombres[0]);
            if (opcion != null || "".equals(opcion)) {
                Planeta planeta = new Planeta();
                planeta.recalcularInformacion(GestorBD.getInstance().obtenerId(opcion.toString()));
                planeta.setVisible(true);
                setVisible(false);
            }
        } else if (e.getSource() == satelites) {
            UIManager.put("OptionPane.background", Color.decode("#FCFFC5"));
            UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FCFFC5"));
            JOptionPane.showMessageDialog(this,
                    GestorBD.getInstance().listaSatelites().toArray(),
                    "Próximamente",
                    JOptionPane.PLAIN_MESSAGE);
        } else if (e.getSource() == estrellas) {
            UIManager.put("OptionPane.background", Color.decode("#FF9090"));
            UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FF9090"));
            JOptionPane.showMessageDialog(this,
                    GestorBD.getInstance().listaEstrellas().toArray(),
                    "Próximamente",
                    JOptionPane.PLAIN_MESSAGE);
        } else if (e.getSource() == galaxias) {
            UIManager.put("OptionPane.background", Color.decode("#BCFCFF"));
            UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#BCFCFF"));
            JOptionPane.showMessageDialog(this,
                    GestorBD.getInstance().listaGalaxias().toArray(),
                    "Próximamente",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
}
