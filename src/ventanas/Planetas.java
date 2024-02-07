package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollPaneUI;

/**
 *
 * @author Xavier Mora
 *
 */
public class Planetas extends JFrame implements ActionListener {

    JPanel panel, panel2, controlPanel;
    JButton boton1, salir, planetas, buscar, bProx;
    JScrollPane scrollPane;
    JButton[] boton = new JButton[20];

    public Planetas() {
        setIconImage(getIconImage());
        scrollPane = new JScrollPane();
        setSize(900, 600); //Para establecer el tamaño de la ventana
        setTitle("Estelary"); // para establecer el titulo de la ventana
        setLocationRelativeTo(null);
        setResizable(false);
        componentes();// llama los componentes
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cerrar la ventana
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
        botonesDelPanel();
        scrollPane();
    }

    private void paneles() {
        panel = new JPanel(new BorderLayout());
        panel.setLayout(null);
        panel.setBackground(Color.black);
        panel.setPreferredSize(new Dimension(0, 1100));

        panel2 = new JPanel();
        panel2.setBackground(Color.black);
        panel2.setLayout(new GridLayout(5, 4));
        panel2.setSize(10, 10);
        panel2.setVisible(true);
        panel2.setBounds(100, 280, 700, 800);
    }

    private void botonesDelPanel() {

        for (int i = 0; i < GestorBD.getInstance().getNombres().size(); i++) {
            boton[i] = new JButton();
        }

        for (int i = 0; i < 8; i++) {
            ImageIcon img = new ImageIcon("src/imagenes/" + GestorBD.getInstance().getNombres().get(i) + ".png");
            boton[i].setIcon(img);
            boton[i].setText(GestorBD.getInstance().getNombres().get(i));
            boton[i].setForeground(Color.white);
            boton[i].setFont(new Font("georgia", 2, 12));
            boton[i].setHorizontalTextPosition(SwingConstants.CENTER);
            boton[i].setVerticalTextPosition(SwingConstants.BOTTOM);
            boton[i].setBackground(Color.black);
            boton[i].setBorderPainted(false);
            boton[i].setContentAreaFilled(false);
            boton[i].addActionListener(new MiBoton(i + 1, this));
            boton[i].setOpaque(false);
            panel2.add(boton[i]);
        }

        for (int i = 8; i < GestorBD.getInstance().getNombres().size(); i++) {
            ImageIcon img = new ImageIcon("src/imagenes/planetDefault.png");
            boton[i].setIcon(img);
            boton[i].setText(GestorBD.getInstance().getNombres().get(i));
            boton[i].setForeground(Color.white);
            boton[i].setFont(new Font("georgia", 2, 12));
            boton[i].setHorizontalTextPosition(SwingConstants.CENTER);
            boton[i].setVerticalTextPosition(SwingConstants.BOTTOM);
            boton[i].setBackground(Color.black);
            boton[i].setBorderPainted(false);
            boton[i].setContentAreaFilled(false);
            boton[i].addActionListener(new MiBoton(i + 1, this));
            boton[i].setOpaque(false);
            panel2.add(boton[i]);
        }
    }

    private void scrollPane() {
        //Barra de desplazamiento
        scrollPane.setViewportView(panel);
        panel.add(panel2, BorderLayout.CENTER);
        scrollPane.setBackground(Color.BLACK);
        scrollPane.setUI(new BasicScrollPaneUI());
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);
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
        label1.setBounds(100, 240, 100, 30);
        label1.setText("Planetas");
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
        panel.add(planetas);

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
        bProx.addActionListener(this);
        panel.add(bProx);
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
        } else if (e.getSource() == buscar) {
            String[] nombres = GestorBD.getInstance().buscador().toArray(new String[0]);;
            Object opcion;
            ImageIcon imgLabel = new ImageIcon("src/imagenes/planetaBusca2.png");
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
        } else if (e.getSource() == bProx) {
            Proximamente prox = new Proximamente();
            prox.setVisible(true);
            setVisible(false);
        }
    }
}
