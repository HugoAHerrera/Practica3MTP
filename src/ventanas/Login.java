package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Dulibeth
 */
public class Login extends JFrame implements ActionListener, KeyListener {

    JPanel panelLogin = new JPanel();
    JButton login, registro;
    JTextField caja1;
    JPasswordField caja2;

    public Login() {
        setIconImage(getIconImage());
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Estelary");
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //Añade icono
    @Override
    public Image getIconImage() {
        Image Icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/galaxia.png"));
        return Icono;
    }

    private void iniciarComponentes() {
        colocarPaneles();
        colocarBotones();
        colocarCajasTexto();
        colocarEtiquetas();
    }

    //Añadir paneles
    private void colocarPaneles() {
        panelLogin.setLayout(null);
        this.getContentPane().add(panelLogin);
    }

    //Añadir etiquetas
    private void colocarEtiquetas() {

        //CUADRADO DE BOTON registrarse
        ImageIcon cuadro2 = new ImageIcon("src/imagenes/cuadro.png");
        JLabel et7 = new JLabel();
        et7.setBounds(360, 415, 150, 30);
        et7.setIcon(new ImageIcon(cuadro2.getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        panelLogin.add(et7);

        //CUADRADO DE BOTON login
        ImageIcon cuadro = new ImageIcon("src/imagenes/cuadro.png");
        JLabel et6 = new JLabel();
        et6.setBounds(360, 380, 150, 30);
        et6.setIcon(new ImageIcon(cuadro.getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
        panelLogin.add(et6);

        //CONTRASEÑA
        JLabel et5 = new JLabel();
        et5.setText("CONTRASEÑA");
        et5.setBounds(360, 280, 150, 70);
        et5.setHorizontalAlignment(SwingConstants.CENTER);
        et5.setFont(new Font("Courier New", Font.BOLD, 15));
        panelLogin.add(et5);

        //USUARIO
        JLabel et1 = new JLabel();
        et1.setText("USUARIO");
        et1.setBounds(395, 230, 70, 20);
        et1.setHorizontalAlignment(SwingConstants.CENTER);
        et1.setFont(new Font("Courier New", Font.BOLD, 15));
        panelLogin.add(et1);

        //Icono de login
        ImageIcon login = new ImageIcon("src/imagenes/login.png");
        JLabel et4 = new JLabel();
        et4.setBounds(365, 100, 130, 130);
        et4.setIcon(new ImageIcon(login.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH)));
        panelLogin.add(et4);

        // Circulo blanco
        ImageIcon circulo = new ImageIcon("src/imagenes/cirucloBlanco.png");
        JLabel et3 = new JLabel();
        et3.setBounds(180, 30, 500, 500);
        et3.setIcon(new ImageIcon(circulo.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        panelLogin.add(et3);

        //Imagen de fondo
        ImageIcon imagen = new ImageIcon("src/imagenes/fondo2.jpg");
        JLabel et2 = new JLabel();
        et2.setBounds(0, 0, 900, 600);
        et2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH)));
        panelLogin.add(et2);
    }

    //Añadir botones
    private void colocarBotones() {

        //Boton login
        login = new JButton("Login");
        login.setBounds(380, 380, 110, 30);
        setEnabled(true);
        login.setOpaque(false);
        login.setContentAreaFilled(false);
        login.setBorderPainted(false);
        login.setFont(new Font("Courier new", Font.BOLD, 14));
        login.setForeground(Color.BLACK);
        login.addKeyListener(this);
        login.addActionListener(this);
        panelLogin.add(login);

        //Boton Registrarse
        registro = new JButton("Registrarse");
        registro.setBounds(371, 415, 140, 30);
        setEnabled(true);
        registro.setOpaque(false);
        registro.setContentAreaFilled(false);
        registro.setBorderPainted(false);
        registro.setFont(new Font("Courier new", Font.BOLD, 14));
        registro.setForeground(Color.BLACK);
        registro.addActionListener(this);
        panelLogin.add(registro);

    }

    //Añadir cajas de texto
    private void colocarCajasTexto() {
        //Caja usuario
        caja1 = new JTextField();
        caja1.setBounds(360, 260, 150, 30);
        caja1.setFont(new Font("Courier new", Font.BOLD, 12));
        caja1.addKeyListener(this);
        panelLogin.add(caja1);

        //Caja contraseña
        caja2 = new JPasswordField();
        caja2.setBounds(360, 335, 150, 30);
        caja2.setFont(new Font("Courier new", Font.BOLD, 12));
        caja2.addKeyListener(this);
        panelLogin.add(caja2);
    }

    //EVENTOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String usuario = caja1.getText();
            String clave = String.valueOf(caja2.getPassword());
            if (usuario.isEmpty() || clave.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo(s) incompleto(s)", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (GestorBD.getInstance().validarUsuario(usuario, clave) == 1) {
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                setVisible(false);
            }
        } else if (e.getSource() == registro) {
            Registro registro = new Registro();
            registro.setVisible(true);
            setVisible(false);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        char teclaLogin = e.getKeyChar();

        if (teclaLogin == KeyEvent.VK_ENTER) {
            login.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
    


