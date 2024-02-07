package ventanas;

import java.awt.Image;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.plaf.ColorUIResource;

public class Planeta extends JFrame implements ActionListener {

    //Instanciación del panel
    private final JPanel panel = new JPanel();

    //Declaración de los botones de la ventana
    private JButton inicio, planetas, buscar, salir, siguiente, anterior, botonComprar, bProx;

    //Declaración de las JLabel
    private JLabel tituloPlaneta, descripcion, precio, valorPrecio, cuadroImagen;

    //Declaración del checkbox
    private JCheckBox registro;

    //La ventana inicia con el planeta 1. Hay que cambiarlo luego segun la ventana Planetas
    private int id = 1;

    //Declaración del ImageIcon
    private ImageIcon imagenPlaneta;

    //Definición del constructor de la clase
    public Planeta() {
        setIconImage(getIconImage());
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Estelary");
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setBackground(Color.decode("#D2CFCE"));
    }

    //Método del icono de la ventana
    @Override
    public Image getIconImage() {
        Image Icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/galaxia.png"));
        return Icono;
    }

    //Método para colocar todos los botones, etiquetas, etc.
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
        panel.add(encabezado);

        //Cabezera botones
        //ImageIcon imagen2 = new ImageIcon("src/imagenes/estelary.png");
        JLabel posicionBotones = new JLabel();
        posicionBotones.setText(" Estelary");
        posicionBotones.setFont(new Font("courier new", 1, 20));
        posicionBotones.setForeground(Color.white);
        posicionBotones.setBounds(0, 25, 900, 50);
        //posicionBotones.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(100,40, Image.SCALE_DEFAULT)));
        posicionBotones.setBackground(new ColorUIResource(0, 0, 0));
        posicionBotones.setOpaque(true);
        panel.add(posicionBotones);

        //Este texto no cambia, por eso está aqui y no en mostrarInformacion
        precio = new JLabel();
        precio.setMaximumSize(new Dimension(400, 320));
        precio.setText("Precio:");
        precio.setHorizontalAlignment(SwingConstants.LEFT);
        precio.setVerticalAlignment(SwingConstants.TOP);
        precio.setFont(new Font("Courier New", Font.BOLD, 30));
        precio.setBounds(475, 410, 150, 30);
        panel.add(precio);

        //Llamada al método mostrarInformacion(id);
        mostrarInformacion(id);

    }

    //Método donde se almacena toda la información que varía con el planeta
    private void mostrarInformacion(int id) {
        this.id = id;
        //Llamo al método obtenerNombre(id) y saco toda la info de la base
        ArrayList dato = GestorBD.getInstance().obtenerNombre(id);

        //Instanciación del título, muestra el nombre
        tituloPlaneta = new JLabel((dato.get(0)).toString());
        tituloPlaneta.setHorizontalAlignment(SwingConstants.LEFT);
        tituloPlaneta.setFont(new Font("Courier New", Font.BOLD, 30));
        tituloPlaneta.setBounds(475, 90, 200, 100);
        //Lo añado al panel
        panel.add(tituloPlaneta);

        //Instanciación de la descripción
        descripcion = new JLabel();
        descripcion.setMaximumSize(new Dimension(400, 320));
        //Miro si hay varios colores o solo uno
        if (dato.get(5).toString().split(",").length > 1) {
            descripcion.setText("<html>El planeta <b style=color:" + colorRandom() + ";'>" + dato.get(0) + "</b> se caracteriza por tener un tamaño de <u>"
                    + dato.get(2) + "</u> km^3 con una masa de <u>" + dato.get(6) + "</u> kg. Por otra parte, la temperatura media es de <u>" + dato.get(3) + "</u>ºC."
                    + "La gravedad de este planeta es <u>" + dato.get(4) + "</u> m/s^2. Los colores principales de este planeta son el " + dato.get(5) + ".<html>");
        } else {
            descripcion.setText("<html>El planeta <b style=color:" + colorRandom() + ";'>" + dato.get(0) + "</b> se caracteriza por tener un tamaño de <u>"
                    + dato.get(2) + "</u> km^3 con una masa de <u>" + dato.get(6) + "</u> kg. Por otra parte, la temperatura media es de <u>" + dato.get(3) + "</u>ºC."
                    + "La gravedad de este planeta es <u>" + dato.get(4) + "</u> m/s^2. El color principal de este planeta es el " + dato.get(5) + ".<html>");
        }
        descripcion.setHorizontalAlignment(SwingConstants.LEFT);
        descripcion.setVerticalAlignment(SwingConstants.TOP);
        descripcion.setFont(new Font("Courier New", Font.BOLD, 20));
        descripcion.setBounds(475, 160, 400, 240);
        descripcion.setOpaque(true);
        //Lo añado al panel
        panel.add(descripcion);

        //Instanciación del precio
        valorPrecio = new JLabel();
        valorPrecio.setMaximumSize(new Dimension(400, 320));
        valorPrecio.setText((String) dato.get(1) + " $");
        valorPrecio.setForeground(Color.blue);
        valorPrecio.setFont(new Font("Courier New", Font.BOLD, 20));
        valorPrecio.setHorizontalAlignment(SwingConstants.LEFT);
        valorPrecio.setVerticalAlignment(SwingConstants.TOP);
        valorPrecio.setBounds(475, 445, 220, 30);
        //Lo añado al panel
        panel.add(valorPrecio);

        //Imagen planeta sistema solar (1-8) o muestra la predeterminada
        if (id > 0 && id < 9) {
            imagenPlaneta = new ImageIcon("src/imagenes/" + id + ".png");
        } else {
            imagenPlaneta = new ImageIcon("src/imagenes/planetaPredeterminado.png");
        }
        //Declaro la imagen
        cuadroImagen = new JLabel();
        cuadroImagen.setBounds(30, 100, 425, 425);
        //Con este método, la imagen se ajusta automáticamente al cuadro
        Icon icon = new ImageIcon(
                imagenPlaneta.getImage().getScaledInstance(cuadroImagen.getWidth(), cuadroImagen.getHeight(), Image.SCALE_DEFAULT)
        );
        cuadroImagen.setIcon(icon);
        //Añado la imagen al panel
        panel.add(cuadroImagen);
    }

    /*Método que se utiliza para borrar la información del planeta previo y 
      obtener la del siguiente planeta
     */
    public void recalcularInformacion(int id) {
        //Elimino todos los elementos que cambian según el planeta
        panel.remove(tituloPlaneta);
        panel.remove(descripcion);
        panel.remove(valorPrecio);
        panel.remove(cuadroImagen);
        panel.revalidate();
        //Refresca la ventana
        panel.repaint();
        //Calculo la nueva información
        mostrarInformacion(id);
    }

    /*Método con el que obtenengo un hexadecimal aleatorio, para cambiar el color
      del planeta en la descripción de la ventana
     */
    private String colorRandom() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        String color = "";

        for (int i = 0; i < 6; i++) {
            color += list.get((int) (Math.random() * 15));
        }

        return "#" + color;
    }

    //Método para colocar el panel
    private void colocarPaneles() {
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    //Método con el que se colocan los botones
    private void colocarBotones() {

        //Botón inicio
        inicio = new JButton("Inicio");
        inicio.setFont(new Font("Courier new", Font.BOLD, 14));
        inicio.setBounds(110, 38, 130, 30);
        inicio.setBackground(Color.black);
        inicio.setForeground(Color.white);
        inicio.setDefaultCapable(false);
        inicio.setBorder(null);
        inicio.setEnabled(true);
        panel.add(inicio);
        inicio.addActionListener(this);

        //Botón planetas
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
        panel.add(buscar);

        //Botón salir
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
        panel.add(salir);

        //Botón siguiente, este botón permite buscar el siguiente planeta, id+1,
        siguiente = new JButton();
        siguiente.setText("Siguiente");
        siguiente.setFont(new Font("Courier new", Font.BOLD, 10));
        siguiente.setBounds(770, 80, 90, 35);
        siguiente.setBackground(Color.white);
        siguiente.setForeground(Color.black);
        siguiente.setDefaultCapable(false);
        siguiente.setEnabled(true);
        siguiente.setOpaque(true);
        siguiente.setContentAreaFilled(true);
        siguiente.addActionListener(this);
        panel.add(siguiente);

        //Botón anterior, este botón permite buscar el planeta anterior, id-1,
        anterior = new JButton();
        anterior.setText("Anterior");
        anterior.setFont(new Font("Courier new", Font.BOLD, 10));
        anterior.setBounds(680, 80, 90, 35);
        anterior.setBackground(Color.white);
        anterior.setForeground(Color.black);
        anterior.setDefaultCapable(false);
        anterior.setEnabled(true);
        anterior.setOpaque(true);
        anterior.setContentAreaFilled(true);
        anterior.addActionListener(this);
        panel.add(anterior);

        //Botón con el que se realiza la compra del planeta
        botonComprar = new JButton();
        botonComprar.setText("Comprar");
        botonComprar.setFont(new Font("Courier new", Font.BOLD, 15));
        botonComprar.setBounds(725, 438, 100, 50);
        botonComprar.setBackground(Color.white);
        botonComprar.setForeground(Color.black);
        botonComprar.setDefaultCapable(false);
        botonComprar.setEnabled(true);
        botonComprar.setOpaque(true);
        botonComprar.setContentAreaFilled(true);
        botonComprar.addActionListener(this);
        //Método para saber si el ratón está encima o no del botón
        botonComprar.addMouseListener(new java.awt.event.MouseAdapter() {
            //Método que se llama si el ratón ha entrado en el botón
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMouseEntered(evt);
            }

            //Método que se llama si el ratón no ha entrado en el botón
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMouseExited(evt);
            }
        });
        panel.add(botonComprar);

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

        //Este checkbox me permite saber que ha leido las condiciones
        registro = new JCheckBox("He leido y acepto las condiciones de uso");
        registro.setBounds(475, 510, 700, 20);
        registro.setOpaque(false);
        panel.add(registro);

        //Método si ha pulsado el botón siguiente
        ActionListener oyenteRegistro = (ActionEvent e) -> {
            if (id < 20) {
                id++;
            } else if (id == 20) {
                id = 1;
            }
            recalcularInformacion(id);
        };
        siguiente.addActionListener(oyenteRegistro);

        //Método si ha pulsado el botón anterior
        ActionListener oyenteRegistro2 = (ActionEvent e) -> {
            if (id > 1) {
                id--;
            } else if (id == 1) {
                id = 20;
            }

            recalcularInformacion(id);
        };
        anterior.addActionListener(oyenteRegistro2);

    }

    /*Cambio el tamaño del botón si está encima para que parezca dinámico
      y que se puede pulsar
     */
    private void btnMouseEntered(java.awt.event.MouseEvent evt) {
        if (registro.isSelected()) {
            botonComprar.setBackground(Color.decode("#90FA33"));
        } else {
            botonComprar.setBackground(Color.decode("#FB2020"));
        }
        botonComprar.setBounds(710, 420, 150, 75);
        botonComprar.setFont(new Font("Courier new", Font.BOLD, 22));
    }

    /*Método que recoloca el botón al original cuando el ratón salga del botón*/
    private void btnMouseExited(java.awt.event.MouseEvent evt) {
        botonComprar.setBackground(Color.white);
        botonComprar.setBounds(725, 438, 100, 50);
        botonComprar.setFont(new Font("Courier new", Font.BOLD, 15));
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
            UIManager.put("OptionPane.background", Color.decode("#FFFFFF"));
            UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFFFFF"));
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
                recalcularInformacion(GestorBD.getInstance().obtenerId(opcion.toString()));
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
        } else if (e.getSource() == botonComprar && registro.isSelected()) {
            ImageIcon imgLabel = new ImageIcon("src/imagenes/tick3.png");
            JOptionPane.showMessageDialog(this,
                    "La compra se ha realizado correctamente.\nQue disfrute de su planeta!",
                    "Mensaje de compra",
                    JOptionPane.QUESTION_MESSAGE,
                    imgLabel
            );
            Planetas catalogoPlanetas = new Planetas();
            catalogoPlanetas.setVisible(true);
            setVisible(false);
        } else if (e.getSource() == botonComprar && !registro.isSelected()) {
            JOptionPane.showMessageDialog(this,
                    "Acepte las concidiones para realizar la compra",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}