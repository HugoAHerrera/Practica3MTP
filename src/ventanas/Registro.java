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
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Dulibeth
 */
public class Registro extends JFrame implements ActionListener, KeyListener {

    JPanel panelRegistro = new JPanel();
    JButton atras, registrarse;
    JTextField caja1;
    JPasswordField caja2, caja3;

    public Registro() {

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
        colocarCajasTexto();
        colocarBotones();
        colocarEtiquetas();
    }

    private void colocarPaneles() {
        panelRegistro.setLayout(null);
        panelRegistro.setBackground(Color.BLACK);
        this.getContentPane().add(panelRegistro);
    }

    private void colocarEtiquetas() {

        //TITULO
        JLabel et0 = new JLabel();
        et0.setText("Registro");
        et0.setBounds(265, 110, 400, 40);
        et0.setForeground(Color.white);
        et0.setHorizontalAlignment(SwingConstants.CENTER);
        et0.setFont(new Font("Courier New", Font.BOLD, 25));
        panelRegistro.add(et0);

        //CONTRASEÑA
        JLabel et1 = new JLabel();
        et1.setText("CONTRASEÑA");
        et1.setBounds(250, 280, 150, 70);
        et1.setForeground(Color.white);
        et1.setHorizontalAlignment(SwingConstants.CENTER);
        et1.setFont(new Font("Courier New", Font.BOLD, 15));
        panelRegistro.add(et1);

        //CONFIRMAR CONTRASEÑA
        JLabel et6 = new JLabel();
        et6.setText("CONFIRMAR CONTRASEÑA");
        et6.setBounds(190, 360, 200, 50);
        et6.setForeground(Color.white);
        et6.setHorizontalAlignment(SwingConstants.CENTER);
        et6.setFont(new Font("Courier New", Font.BOLD, 15));
        panelRegistro.add(et6);

        //USUARIO
        JLabel et2 = new JLabel();
        et2.setText("NOMBRE DE USUARIO");
        et2.setBounds(200, 220, 200, 50);
        et2.setForeground(Color.WHITE);
        et2.setHorizontalAlignment(SwingConstants.CENTER);
        et2.setFont(new Font("Courier New", Font.BOLD, 15));
        panelRegistro.add(et2);

        //EMAIL_IMAGEN
        ImageIcon email = new ImageIcon("src/imagenes/correo-electronico.png");
        JLabel et3 = new JLabel();
        et3.setBounds(570, 220, 45, 45);
        et3.setIcon(new ImageIcon(email.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
        panelRegistro.add(et3);

        //CONTRASEÑA_IMAGEN
        ImageIcon contra = new ImageIcon("src/imagenes/contra.png");
        JLabel et4 = new JLabel();
        et4.setBounds(570, 290, 50, 50);
        et4.setIcon(new ImageIcon(contra.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        panelRegistro.add(et4);

        //Cuadro
        ImageIcon cuadro = new ImageIcon("src/imagenes/cuadrado.png");
        JLabel et5 = new JLabel();
        et5.setBounds(340, 90, 250, 80);
        et5.setIcon(new ImageIcon(cuadro.getImage().getScaledInstance(250, 80, Image.SCALE_SMOOTH)));
        panelRegistro.add(et5);
    }

    private void colocarBotones() {

        //Boton CHECK resgistrarse
        ImageIcon check = new ImageIcon("src/imagenes/controlar.png");
        registrarse = new JButton();
        registrarse.setBounds(450, 430, 50, 50);
        registrarse.setBorder(null);
        registrarse.setIcon(new ImageIcon(check.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        registrarse.setBackground(Color.BLACK);
        registrarse.addActionListener(this);
        panelRegistro.add(registrarse);

        //BOTON ATRAS
        ImageIcon flecha = new ImageIcon("src/imagenes/flechaAtras.png");
        atras = new JButton();
        atras.setBounds(30, 20, 60, 60);
        atras.setBorder(null);
        atras.setIcon(new ImageIcon(flecha.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
        atras.setBackground(Color.black);
        atras.addActionListener(this);
        panelRegistro.add(atras);

    }

    private void colocarCajasTexto() {
        //Caja usuario
        caja1 = new JTextField();
        caja1.setBounds(400, 230, 150, 30);
        caja1.setFont(new Font("Courier new", Font.BOLD, 12));
        caja1.addKeyListener(this);
        panelRegistro.add(caja1);

        //Caja contraseña
        caja2 = new JPasswordField();
        caja2.setBounds(400, 300, 150, 30);
        caja2.setFont(new Font("Courier new", Font.BOLD, 12));
        caja2.addKeyListener(this);
        panelRegistro.add(caja2);

        //Caja contraseña
        caja3 = new JPasswordField();
        caja3.setBounds(400, 370, 150, 30);
        caja3.setFont(new Font("Courier new", Font.BOLD, 12));
        caja3.addKeyListener(this);
        panelRegistro.add(caja3);
    }

    // EVENTOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarse) {
            String usuario = caja1.getText();
            String clave = String.valueOf(caja2.getText());
            String clave2 = String.valueOf(caja3.getText());
            if (!(usuario.isEmpty()) && !(clave.isEmpty()) && !(clave2.isEmpty())) {
                if (clave.equalsIgnoreCase(clave2)) {
                    if (GestorBD.getInstance().agregarUsuario(usuario, clave) == 1) {
                        Login login = new Login();
                        login.setVisible(true);
                        this.setVisible(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas son distintas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campo(s) incompleto(s)", "Error", JOptionPane.ERROR_MESSAGE);;
            }
        } else if (e.getSource() == atras) {
            Login login = new Login();
            login.setVisible(true);
            setVisible(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char teclaCheck = e.getKeyChar();

        if (teclaCheck == KeyEvent.VK_ENTER) {
            registrarse.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
