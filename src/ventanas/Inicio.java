package ventanas;

import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class Inicio extends JFrame implements ActionListener {

    JButton inicio, planetas, buscar, salir, compraYa, bProx;
    JPanel panelInicio = new JPanel();

    public Inicio() {
        setIconImage(getIconImage());
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Estelary");
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public Image getIconImage() {
        Image Icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/galaxia.png"));
        return Icono;
    }

    private void iniciarComponentes() {
        colocarPaneles();
        colocarBotones();
        colocarEtiquetas();
    }

    private void colocarEtiquetas() {

        //Cabezera morada
        JLabel encabezado = new JLabel("Universo");
        encabezado.setHorizontalAlignment(SwingConstants.CENTER);
        encabezado.setBounds(0, 0, 900, 25);
        encabezado.setBackground(new ColorUIResource(168, 5, 255));
        encabezado.setOpaque(true);
        panelInicio.add(encabezado);

        //Cabezera botones
        JLabel label3 = new JLabel();
        label3.setBounds(10, 35, 100, 30);
        label3.setFont(new Font("courier new", 1, 20));
        label3.setForeground(Color.WHITE);
        label3.setText("Estelary");
        panelInicio.add(label3);

        //Imagen de fondo
        ImageIcon imagen = new ImageIcon("src/imagenes/fondoInicio.jpg");
        JLabel fondoInicio = new JLabel();
        fondoInicio.setBounds(0, 75, 950, 600);
        fondoInicio.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH)));
        panelInicio.add(fondoInicio);
    }

    private void colocarPaneles() {
        panelInicio.setLayout(null);
        panelInicio.setBackground(Color.BLACK);
        this.getContentPane().add(panelInicio);
    }

    private void colocarBotones() {

        //Boton inicio
        inicio = new JButton("Inicio");
        inicio.setFont(new Font("Courier new", Font.BOLD, 14));
        inicio.setBounds(110, 38, 130, 30);
        inicio.setBackground(Color.black);
        inicio.setForeground(Color.white);
        inicio.setDefaultCapable(false);
        inicio.setBorder(null);
        inicio.setEnabled(true);
        panelInicio.add(inicio);
        inicio.addActionListener(this);

        //Boton planetas
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
        panelInicio.add(planetas);

        //Botón buscar
        ImageIcon buscarImagen = new ImageIcon("src/imagenes/buscar.jpg");
        buscar = new JButton();
        buscar.setFont(new Font("Courier new", Font.BOLD, 14));
        buscar.setBounds(780, 28, 38, 47);
        buscar.setIcon(new ImageIcon(buscarImagen.getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH)));
        buscar.setBackground(Color.black);
        buscar.setForeground(Color.white);
        buscar.setDefaultCapable(false);
        buscar.setBorder(null);
        buscar.setEnabled(true);
        buscar.setOpaque(true);
        buscar.setContentAreaFilled(true);
        buscar.addActionListener(this);
        panelInicio.add(buscar);

        //Boton salir
        ImageIcon salirImagen = new ImageIcon("src/imagenes/salir.png");
        salir = new JButton();
        salir.setFont(new Font("Courier new", Font.BOLD, 14));
        salir.setBounds(830, 38, 27, 30);
        salir.setIcon(new ImageIcon(salirImagen.getImage().getScaledInstance(30, 33, Image.SCALE_SMOOTH)));
        salir.setBackground(Color.black);
        salir.setForeground(Color.white);
        salir.setDefaultCapable(false);
        salir.setBorder(null);
        salir.setEnabled(true);
        salir.setOpaque(true);
        salir.setContentAreaFilled(true);
        salir.addActionListener(this);
        panelInicio.add(salir);

        //Boton buscar
        compraYa = new JButton();
        compraYa.setText("¡Compra Ya!");
        compraYa.setFont(new Font("Courier new", Font.BOLD, 20));
        compraYa.setBounds(350, 230, 190, 110);
        compraYa.setForeground(Color.white);
        compraYa.setDefaultCapable(false);
        compraYa.setEnabled(true);
        compraYa.setBackground(Color.black);
        compraYa.setBorderPainted(false);
        compraYa.setContentAreaFilled(true);
        compraYa.setOpaque(true);
        compraYa.addActionListener(this);
        panelInicio.add(compraYa);

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
        panelInicio.add(bProx);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inicio) {
            Inicio i = new Inicio();
            i.setVisible(true);
            setVisible(false);
        } else if (e.getSource() == planetas) {
            Planetas p = new Planetas();
            p.setVisible(true);
            setVisible(false);
        } else if (e.getSource() == bProx) {
            Proximamente prox = new Proximamente();
            prox.setVisible(true);
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
        } else if (e.getSource() == compraYa) {
            JOptionPane.showConfirmDialog(this,
                    "No se admiten devoluciones.",
                    "Información",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            Planetas catalogoPlanetas = new Planetas();
            catalogoPlanetas.setVisible(true);
            setVisible(false);
        }
    }
}
