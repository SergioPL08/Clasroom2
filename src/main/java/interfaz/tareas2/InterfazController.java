/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.tareas2;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Window;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
/**
 * FXML Controller class
 *
 * @author Sergio
 */
public class InterfazController implements Initializable {

    @FXML
    private HBox barraMenu;
    @FXML
    private ToolBar menu;
    @FXML
    private Pane clases;
    @FXML
    private Pane clase;
    @FXML
    private Pane login;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private ImageView imgLogin;
    @FXML
    private Label msg;

    Connection conector;
    @FXML
    private ImageView clase1;
    @FXML
    private ImageView clase2;
    @FXML
    private ImageView clase7;
    @FXML
    private Label smg2;

    String user;
    private Pane login1;
    @FXML
    private Label msg1;
    @FXML
    private ImageView imgAlumno;
    @FXML
    private ImageView imgProfesor;
    @FXML
    private Pane elegirPersona;
    public boolean profesor;
    @FXML
    private TextField usuarioTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField passwordConfirmarTextField;
    @FXML
    private TextField apellidosTextField;
    @FXML
    private TextField correoTextField;
    @FXML
    private Pane registrar;
    @FXML
    private Button botonAtras;
    @FXML
    private ImageView imgRegistrarProfesor;
    @FXML
    private ImageView imgRegistrarAlumno;
    private Button crearCurso;
    @FXML
    private Pane paneCrearCurso;
    @FXML
    private TextField nombreCurso;
    @FXML
    private Label labelCrearCurso;
    @FXML
    private Button buttonCrearCurso;
    private TextField nombreAsignatura;
    @FXML
    private GridPane gridClases;
    String idPersona;
    
    ArrayList arrayClases;
    @FXML
    private TextField nombreClase;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conector = Conector.makeConnect();
        setInvisible();
        login.setVisible(true);
        imagenes();
    }

    @FXML
    public void clase() {
        setInvisible();
        clase.setVisible(true);
        barraMenu.setVisible(true);
        cambiaTamaño(880, 600);
    }

    @FXML
    public void iniciaSesion() {
        user = username.getText();
        String pass = password.getText();

        try {
            String consulta = "SELECT * FROM personas WHERE usuario='" + user + "' AND password ='" + pass + "'";
            //System.out.println(consulta);
            Statement st = conector.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(consulta);
            if (rs.first()) {
                String sqlid = "SELECT id_persona FROM personas WHERE usuario='" + user + "'";
                ResultSet rsgetid = st.executeQuery(sqlid);
                if (rsgetid.first()) {
                    idPersona = rsgetid.getString(1);
                    String esprofe = "SELECT (profesor) FROM personas WHERE id_persona='" + idPersona + "'";
                    ResultSet rsesprofe = st.executeQuery(esprofe);
                    if(rsesprofe.first())
                        profesor=true;
                    else
                        profesor=false;
                }
                setInvisible();
                barraMenu.setVisible(true);
                clases.setVisible(true);
                cambiaTamaño(880, 600);
                smg2.setText("¡Bienvenido " + user + "!");
                buttonCrearCurso.setVisible(profesor);
            } else {
                msg.setText("Usuario o contraseña incorrectos");
            }
        } catch (SQLException ex) {
            msg.setText("Usuario o contraseña incorrectos");
        }

    }

    @FXML
    public void home() {
        setInvisible();
        barraMenu.setVisible(true);
        clases.setVisible(true);
        cambiaTamaño(880, 600);
        smg2.setText("Bienvenido " + user);
        
    }

    @FXML
    private void salir(ActionEvent event) {
        setInvisible();
        login.setVisible(true);
        cambiaTamaño(729, 435);
    }

    public void imagenes() {
        Image image1 = new Image(getClass().getResourceAsStream("/img/Login.png"));
        ImageView imageView1 = new ImageView(image1);
        Image image2 = new Image(getClass().getResourceAsStream("/img/interfaces.png"));
        ImageView imageView2 = new ImageView(image2);
        Image image3 = new Image(getClass().getResourceAsStream("/img/alumno.png"));
        ImageView imgAlumno = new ImageView(image3);
        Image image4 = new Image(getClass().getResourceAsStream("/img/profesor.png"));
        ImageView imgProfesor = new ImageView(image4);
        Image image5 = new Image(getClass().getResourceAsStream("/img/profesor.png"));
        ImageView imgRegistrarProfesor = new ImageView(image5);
        Image image6 = new Image(getClass().getResourceAsStream("/img/alumno.png"));
        ImageView imgRegistrarAlumno = new ImageView(image5);
        imgLogin.setImage(image1);
        clase1.setImage(image2);
        imgAlumno.setImage(image3);
        imgProfesor.setImage(image4);
        imgRegistrarProfesor.setImage(image5);
        imgRegistrarAlumno.setImage(image6);
                
    }

    public void cambiaTamaño(int width, int height) {
        Window win = App.getScene().getWindow();
        win.setWidth(width);
        win.setHeight(height);
    }

    public static boolean comprobarNoNumeros(String str) {
        //Comprobamos los caracteres de la cadena
        for (int i = 0; i < str.length(); i++) {
            //Si se encuentra un número, devolvemos false
            if (Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        //Si no se ha encontrado ningún número, devolvemos true
        return true;
    }

    public static boolean validarCorreo(String correo) {
        String patronCorreo = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return correo.matches(patronCorreo);
    }

    public void setInvisible() {
        clase.setVisible(false);
        barraMenu.setVisible(false);
        login.setVisible(false);
        clases.setVisible(false);
        registrar.setVisible(false);
        elegirPersona.setVisible(false);
        imgRegistrarProfesor.setVisible(false);
        imgRegistrarAlumno.setVisible(false);
        paneCrearCurso.setVisible(false);
    }

    @FXML
    private void crearCuenta(MouseEvent event) {
        setInvisible();
        elegirPersona.setVisible(true);
    }

    @FXML
    private void crearAlumno(MouseEvent event) {
        profesor = false;
        setInvisible();
        registrar.setVisible(true);
        cambiaTamaño(730, 552);
        imgRegistrarAlumno.setVisible(true);
    }

    @FXML
    private void crearProfesor(MouseEvent event) {
        profesor = true;
        setInvisible();
        registrar.setVisible(true);
        cambiaTamaño(730, 552);
        imgRegistrarProfesor.setVisible(true);
    }

    @FXML
    private void registrarPersona(ActionEvent event) throws InterruptedException {

        String usuario = usuarioTextField.getText().trim();
        String pass = passwordTextField.getText().trim();
        String nombre = nombreTextField.getText().trim();
        String apellidos = apellidosTextField.getText().trim();
        String correo = correoTextField.getText().trim();
        String passConfirmar = passwordConfirmarTextField.getText().trim();

        if (usuarioTextField.getText().equals("") || passwordTextField.getText().equals("") || nombreTextField.getText().equals("") || apellidosTextField.getText().equals("") || correoTextField.getText().equals("") || passwordConfirmarTextField.getText().equals("")) {
            msg1.setText("¡ERROR! Debes rellenar todos los campos.");
        } else if (!comprobarNoNumeros(nombre) || !comprobarNoNumeros(apellidos)) {
            msg1.setText("¡ERROR! Introduce un nombre y apellido válido.");
        } else if (!validarCorreo(correo)) {
            msg1.setText("¡ERROR! Introduce un correo electrónico válido.");
        } else if (!pass.equals(passConfirmar)) {
            msg1.setText("¡ERROR! Las contraseñas no coinciden.");
        }
        else {
            try {
                ResultSet rsUsuario = Conector.getSelect("SELECT * FROM personas WHERE usuario='"+usuario+"'", conector);
                String sql;
                if(!rsUsuario.next()){
                    if (profesor) 
                        sql = "INSERT INTO personas VALUES (null,'" + nombre + "','" + apellidos + "','" + correo + "','" + usuario + "','" + pass + "',True)";
                    else
                        sql = "INSERT INTO personas VALUES (null,'" + nombre + "','" + apellidos + "','" + correo + "','" + usuario + "','" + pass + "',False)";
                    Statement st = conector.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    int resultado = st.executeUpdate(sql);
                    if (resultado > 0) {
                        if(profesor)
                            msg1.setText("¡Profesor/a registrado/a correctamente!");
                        else
                            msg1.setText("¡Alumno/a registrado/a correctamente!");
                    }
                        
                }
                else
                    msg1.setText("El nombre de usuario ya existe!!");
            } catch (SQLException ex) {
                Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void volverLogin(ActionEvent event) {

        setInvisible();
        login.setVisible(true);
        usuarioTextField.setText("");
        passwordTextField.setText("");
        passwordConfirmarTextField.setText("");
        nombreTextField.setText("");
        apellidosTextField.setText("");
        correoTextField.setText("");
        msg1.setText("");

    }

    
    
    @FXML
    private void crearCurso(ActionEvent event) {
        String nombre = nombreClase.getText();
        String curso = nombreCurso.getText();
        if(nombre.equals(""))
            labelCrearCurso.setText("Introduzca el nombre!");
        else{
            String insert = "INSERT INTO clases (nombre,curso) VALUES ('"+nombre+"','"+curso+"')";
            System.out.println(insert);
            int filas = Conector.insertTable(insert, conector);
            if(filas>0){
                try {
                    String select = "SELECT id_clase FROM clases ORDER BY id_clase DESC";
                    ResultSet salida = Conector.getSelect(select, conector);
                    if(salida.first()){
                        String idClase = salida.getString(1);
                        String insertProfesor = "INSERT INTO participaciones VALUES('"+idPersona+"','"+idClase+"')";
                        System.out.println(insertProfesor);
                        int filasClase = Conector.insertTable(insertProfesor, conector);
                        if(filasClase>0){
                            labelCrearCurso.setText("Clase creada correctamente");
                            arrayClases.add(idClase);
                        }
                        else
                            labelCrearCurso.setText("Error al insertar el profesor");
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }
            else
                labelCrearCurso.setText("Error al crear la clase");
            paneCrearCurso.setVisible(false);
            clases.setDisable(false);
            menu.setDisable(false);
        }
    }

    @FXML
    private void showCrearCurso(ActionEvent event) {
        paneCrearCurso.setVisible(true);
        clases.setDisable(true);
        menu.setDisable(true);
    }


    @FXML
    private void matricularAlumnos(ActionEvent event) {
        
    }

}
