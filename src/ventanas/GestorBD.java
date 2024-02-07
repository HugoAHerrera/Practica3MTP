package ventanas;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorBD {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    String driver = "org.sqlite.JDBC";

    //Constructor 
    private GestorBD() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mtpUniverso.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("Error driver " + e);
        } catch (SQLException e) {
            System.out.println("Error sql " + e);
        }

    }

    //Instancia 
    private static GestorBD INSTANCE = new GestorBD();

    //Método que devuelve la única instancia (Singleton)
    public static GestorBD getInstance() {
        return INSTANCE;
    }

    //Método  para hacer login
    public int validarUsuario(String usuario, String clave) {
        int resultado = 0;
        String sentencia = "Select * from usuario where correo='" + usuario + "' and contraseña = '" + clave + "'";
        try {
            resultSet = statement.executeQuery(sentencia);

            if (resultSet.next()) {
                resultado = 1;

            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos, inténtelo de nuevo");
            }
        } catch (SQLException e) {
            System.out.println("Error sql " + e);
        }
        return resultado;

    }

    //Método para insertar usuarios
    public int agregarUsuario(String usuario, String clave) {
        String sentencia = "Insert into usuario (correo,contraseña) values('" + usuario + "','" + clave + "')";
        int resultado = 0;
        try {
            int resultSet = statement.executeUpdate(sentencia);
            resultado = 1;
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Nombre de usuario no disponible!", "Error", JOptionPane.ERROR_MESSAGE);

        }
        return resultado;
    }

    //Método para obtener  una lista con los nombres de los planetas
    public ArrayList<String> getNombres() {
        ArrayList<String> nombres = new ArrayList<String>();
        String sentencia = "select nombre from planeta;";
        try {
            ResultSet result = statement.executeQuery(sentencia);

            while (result.next()) {
                nombres.add(result.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error sql " + e);
        }
        return nombres;
    }

    //Método con el que se obtiene la información del planeta
    public ArrayList<String> obtenerNombre(int id) {
        ArrayList<String> informacion = new ArrayList<String>();
        String sentencia = "select * from planeta where  id = " + "'" + id + "'";
        try {
            ResultSet result = statement.executeQuery(sentencia);

            while (result.next()) {
                informacion.add(result.getString("nombre"));
                informacion.add(result.getString("precio"));
                informacion.add(result.getString("tamaño"));
                informacion.add(result.getString("temperatura"));
                informacion.add(result.getString("gravedad"));
                informacion.add(result.getString("color"));
                informacion.add(result.getString("masa"));
            }
        } catch (SQLException e) {
            System.out.println("Error sql " + e);
        }
        return informacion;
    }

    //Método con el que obtengo el id del planeta
    public int obtenerId(String nombre) {
        String informacion = "";
        String sentencia = "select * from planeta where  nombre = " + "'" + nombre + "'";
        try {
            ResultSet result = statement.executeQuery(sentencia);
            while (result.next()) {
                informacion = result.getString("id");
            }
        } catch (SQLException e) {
            System.out.println("Error sql " + e);
        }
        return Integer.parseInt(informacion);
    }

    public ArrayList<String> buscador() {
        ArrayList<String> informacion = new ArrayList<String>();
        String sentencia = "select * from planeta";
        try {
            ResultSet result = statement.executeQuery(sentencia);
            while (result.next()) {
                informacion.add(result.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error sql " + e);
        }
        return informacion;
    }

    public ArrayList<String> listaEstrellas() {
        ArrayList<String> informacion = new ArrayList<String>();
        String sentencia = "select * from estrella";
        try {
            ResultSet result = statement.executeQuery(sentencia);
            while (result.next()) {
                String fila = "";
                fila += result.getString("nombre") + ": " + result.getString("constelacion");
                informacion.add(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error sql " + e);
        }
        return informacion;
    }

    public ArrayList<String> listaGalaxias() {
        ArrayList<String> informacion = new ArrayList<String>();
        String sentencia = "select * from galaxia";
        try {
            ResultSet result = statement.executeQuery(sentencia);
            while (result.next()) {
                String fila = "";
                fila += result.getString("nombre") + ": " + result.getString("constelación");
                informacion.add(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error sql " + e);
        }
        return informacion;
    }

    public ArrayList<String> listaSatelites() {
        ArrayList<String> informacion = new ArrayList<String>();
        String sentencia = "select * from satelite";
        try {
            ResultSet result = statement.executeQuery(sentencia);
            while (result.next()) {
                String fila = "";
                fila += result.getString("nombre") + " perteneciente a " + result.getString("SateliteDe");
                informacion.add(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error sql " + e);
        }
        return informacion;
    }

}
