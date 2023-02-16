/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package interfaz.tareas2;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.canvas.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.FileChooser;

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
    private Label smg2;

    private Pane login1;
    @FXML
    private Label msg1;
    @FXML
    private ImageView imgAlumno;
    @FXML
    private ImageView imgProfesor;
    @FXML
    private Pane elegirPersona;
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
    @FXML
    private TextField nombreClase;
    @FXML
    private Pane paneMatricular;
    @FXML
    private Pane paneCrearTarea;
    @FXML
    private Pane paneTareasAlumno;
    @FXML
    private Pane paneTareasProfesor;
    @FXML
    private Button matricularButton;
    @FXML
    private ComboBox<?> comboBoxAlumnosMatricular;
    @FXML
    private Button anadirAlumnoButton;
    private ComboBox<?> comboBoxCursosMatricular;
    @FXML
    private Button verMatricularAlumnosButton;
    @FXML
    private TextArea alumnosTextArea;
    @FXML
    private Label labelAlumnosMatriculados;
    @FXML
    private Button matricularButton1;
    @FXML
    private Label labelAsignatura1;
    private Label labelProfesorClase1;
    @FXML
    private Label labelCurso1;
    @FXML
    private Label labelCurso2;
    @FXML
    private Label labelAsignatura2;
    @FXML
    private Label labelAsignatura3;
    @FXML
    private Label labelCurso3;
    ObservableList<tarea> obs;
    ObservableList<entrega> obs2;
    String nombreClaseMatricular;
    int idClase;
    int idPersona;
    int contador = 0;
    ArrayList arrayClases = new ArrayList();
    public boolean profesor;
    private ComboBox comboBoxMatricular;
    String user;
    ArrayList<clase> datosClase = new ArrayList();
    @FXML
    private Button botonVolverClase;
    @FXML
    private Button botonAvanzarClase;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Pane paneAsignatura1;
    @FXML
    private Pane paneAsignatura2;
    @FXML
    private Pane paneAsignatura3;
    @FXML
    private Label labelClaseActual;
    @FXML
    private Pane paneNoHayClases;
    @FXML
    private ImageView imgNoHayClases;
    @FXML
    private TextField enunciadoTextField;
    @FXML
    private TextArea descripcionTextArea;
    @FXML
    private DatePicker fechaEntregaDatePicker;
    @FXML
    private TextField ponderacionTextField;
    @FXML
    private ComboBox<?> tipoTareaComboBox;
    @FXML
    private Button botonShowPaneCrearTarea;
    @FXML
    private Label msgLabelCrearTarea;
    @FXML
    private TableView<tarea> tablaTareas;
    ArrayList<tarea> listaTareas;
    ArrayList<entrega> listaEntregas;
    
    @FXML
    private TableColumn<tarea, String> nombreTarea;
    @FXML
    private TableColumn<tarea, String> tipoTarea;
    @FXML
    private TableColumn<tarea, Date> fechaEntrega;
    @FXML
    private TableColumn<tarea, Integer> idTarea;
    private int posicionTareaEnTabla;
    private int idTareaSeleccionada;
    private Label tareaDescripcion;
    @FXML
    private Label nombreTareaAlumno;
    @FXML
    private Label tareaDescripcionAlumno;
    @FXML
    private TextArea textAreaEntrega;
    @FXML
    private TextField ficheroTextField;
    @FXML
    private Button rutaFicheroButton;
    @FXML
    private Button entregarTareaButton;
    @FXML
    private ImageView imgElegirClases;
    @FXML
    private Label labelFechaEntrega;
    @FXML
    private Button buttonVerEntregas;
    @FXML
    private Pane paneEntregarTareasAlumno;
    @FXML
    private Pane PaneEditarTareaProfesor;
    private Date fecha;
    @FXML
    private Label labelEntregado;
    @FXML
    private TableView<entrega> tablaEntregas;
    @FXML
    private TableColumn<entrega, String> nombreAlumno;

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
            ResultSet rs = Conector.getSelect(consulta, conector);
            if (rs.next()) {
                idPersona = rs.getInt("id_persona");
                profesor = rs.getBoolean("profesor");
                //SELECT p.id_persona, id_clase, a.nombre FROM participaciones as par, clases as a WHERE a.id_clase = par.id_asignatura and par.id_persona, curso;
                String consultaClases = "SELECT id_persona, id_clase, clases.nombre,curso,color FROM participaciones, clases WHERE clases.id_clase = participaciones.id_asignatura and participaciones.id_persona=" + idPersona;
                ResultSet rsConsultaClases = Conector.getSelect(consultaClases, conector);
                while (rsConsultaClases.next()) {
                    int idClase = rsConsultaClases.getInt("id_clase");
                    String nombreClase = rsConsultaClases.getString("nombre");
                    String nombreCurso = rsConsultaClases.getString("curso");
                    //System.out.println(rsConsultaClases.getString("color"));
                    //Color color = Color.valueOf(rsConsultaClases.getString("color"));
                    //clase c = new clase(idClase, nombreClase, nombreCurso, color);
                    clase c = new clase(idClase, nombreClase, nombreCurso);
                    datosClase.add(c);
                }
                //Esto es muy cutre, ya se me ocurrirá una mejor forma de hacerlo xd
                if (datosClase.size() > 2) {
                    labelAsignatura3.setText(datosClase.get(2).getNombre());
                    labelCurso3.setText(datosClase.get(2).getCurso());
                    paneAsignatura3.setVisible(true);
                }
                if (datosClase.size() > 1) {
                    labelAsignatura2.setText(datosClase.get(1).getNombre());
                    labelCurso2.setText(datosClase.get(1).getCurso());
                    paneAsignatura2.setVisible(true);
                }
                if (datosClase.size() > 0) {
                    labelAsignatura1.setText(datosClase.get(0).getNombre());
                    labelCurso1.setText(datosClase.get(0).getCurso());
                    paneAsignatura1.setVisible(true);
                }
                if (datosClase.size() < 4) {
                    botonAvanzarClase.setDisable(true);
                }
                setInvisible();
                if (datosClase.size() == 0) {
                    paneNoHayClases.setVisible(true);
                    botonAvanzarClase.setVisible(false);
                    botonVolverClase.setVisible(false);
                }
                barraMenu.setVisible(true);
                clases.setVisible(true);
                cambiaTamaño(880, 650);
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
        buttonCrearCurso.setVisible(profesor);
        cambiaTamaño(880, 600);
        smg2.setText("Bienvenido " + user);
        idTareaSeleccionada=-1;
        idClase = -1;
        nombreClaseMatricular = "";
        listaTareas.clear();
        fecha=null;
    }

    @FXML
    private void salir(ActionEvent event) {
        setInvisible();
        login.setVisible(true);
        cambiaTamaño(729, 435);
        datosClase.clear();
        listaTareas.clear();
        paneAsignatura1.setVisible(false);
        paneAsignatura2.setVisible(false);
        paneAsignatura3.setVisible(false);
        botonAvanzarClase.setDisable(false);
        botonAvanzarClase.setVisible(true);
        botonVolverClase.setVisible(true);
        botonShowPaneCrearTarea.setVisible(false);
        idClase = -1;
        idTareaSeleccionada=-1;
        nombreClaseMatricular = "";
        fecha=null;
    }

    public void imagenes() {
        Image image1 = new Image(getClass().getResourceAsStream("/img/Login.png"));
        ImageView imageView1 = new ImageView(image1);
        Image image3 = new Image(getClass().getResourceAsStream("/img/alumno.png"));
        ImageView imgAlumno = new ImageView(image3);
        Image image4 = new Image(getClass().getResourceAsStream("/img/profesor.png"));
        ImageView imgProfesor = new ImageView(image4);
        Image image5 = new Image(getClass().getResourceAsStream("/img/profesor.png"));
        ImageView imgRegistrarProfesor = new ImageView(image5);
        Image image6 = new Image(getClass().getResourceAsStream("/img/alumno.png"));
        ImageView imgRegistrarAlumno = new ImageView(image5);
        Image image7 = new Image(getClass().getResourceAsStream("/img/noclasespng.png"));
        Image image8 = new Image(getClass().getResourceAsStream("/img/clases.png"));
        ImageView imgElegirClases = new ImageView(image8);
        imgElegirClases.setImage(image8);
        imgNoHayClases = new ImageView(image7);
        imgLogin.setImage(image1);
        imgAlumno.setImage(image3);
        imgProfesor.setImage(image4);
        imgRegistrarProfesor.setImage(image5);
        imgRegistrarAlumno.setImage(image6);
        imgNoHayClases.setImage(image7);

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
        paneMatricular.setVisible(false);
        paneCrearTarea.setVisible(false);
        paneTareasAlumno.setVisible(false);
        paneTareasProfesor.setVisible(false);
        verMatricularAlumnosButton.setVisible(false);
        paneNoHayClases.setVisible(false);
        botonShowPaneCrearTarea.setVisible(false);
        paneCrearTarea.setVisible(false);
        buttonCrearCurso.setVisible(false);
        buttonVerEntregas.setVisible(false);
        PaneEditarTareaProfesor.setVisible(false);
        paneEntregarTareasAlumno.setVisible(false);
    }

    public static String recuperarNombre(String cadena) {
        int posicion = cadena.indexOf("-");
        return cadena.substring(0, posicion);
    }

    public void cargarComboBoxAlumnosMatricular() {
        ResultSet rs;
        ArrayList a = new ArrayList();
        try {
            PreparedStatement pst = conector.prepareStatement("SELECT id_persona, nombre, apellidos FROM personas", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = pst.executeQuery();
            comboBoxAlumnosMatricular.getItems().clear();
            while (rs.next()) {

                String id_persona = rs.getString("id_persona");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");

                String x = id_persona + "-" + nombre + " " + apellidos;
                a.add(x);

            }
            comboBoxAlumnosMatricular.getItems().addAll(a);

        } catch (SQLException ex) {
            Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        } else {
            try {
                ResultSet rsUsuario = Conector.getSelect("SELECT * FROM personas WHERE usuario='" + usuario + "'", conector);
                String sql;
                if (!rsUsuario.next()) {
                    if (profesor) {
                        sql = "INSERT INTO personas VALUES (null,'" + nombre + "','" + apellidos + "','" + correo + "','" + usuario + "','" + pass + "',True)";
                    } else {
                        sql = "INSERT INTO personas VALUES (null,'" + nombre + "','" + apellidos + "','" + correo + "','" + usuario + "','" + pass + "',False)";
                    }
                    Statement st = conector.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    int resultado = st.executeUpdate(sql);
                    if (resultado > 0) {
                        if (profesor) {
                            msg1.setText("¡Profesor/a registrado/a correctamente!");
                        } else {
                            msg1.setText("¡Alumno/a registrado/a correctamente!");
                        }
                    }

                } else {
                    msg1.setText("El nombre de usuario ya existe!!");
                }
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

    public void rellenarAlumnosTextArea() {

        String text = comboBoxAlumnosMatricular.getValue().toString();
        alumnosTextArea.appendText(text + ", ");

    }

    @FXML
    private void crearCurso(ActionEvent event) {
        String nombre = nombreClase.getText();
        String curso = nombreCurso.getText();
        //Color color = colorPicker.getValue();
        if (nombre.equals("")) {
            labelCrearCurso.setText("Introduzca el nombre!");
        } else {
            //String insert = "INSERT INTO clases (nombre,curso,color) VALUES ('"+nombre+"','"+curso+"','"+color+"')";
            String insert = "INSERT INTO clases (nombre,curso) VALUES ('" + nombre + "','" + curso + ")";
            System.out.println(insert);
            int filas = Conector.insertTable(insert, conector);
            if (filas > 0) {
                try {
                    String select = "SELECT id_clase FROM clases ORDER BY id_clase DESC";
                    ResultSet salida = Conector.getSelect(select, conector);
                    if (salida.first()) {
                        int idClase = salida.getInt("id_clase");
                        String insertProfesor = "INSERT INTO participaciones VALUES('" + idPersona + "','" + idClase + "')";
                        System.out.println(insertProfesor);
                        int filasClase = Conector.insertTable(insertProfesor, conector);
                        if (filasClase > 0) {
                            labelCrearCurso.setText("Clase creada correctamente");
                            //clase c = new clase(idClase, nombre, curso,color);
                            clase c = new clase(idClase, nombre, curso);

                            datosClase.add(c);
                        } else {
                            labelCrearCurso.setText("Error al insertar el profesor");
                        }
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                labelCrearCurso.setText("Error al crear la clase");
            }
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
    private void mostrarMatricularAlumnos(ActionEvent event) {
        setInvisible();
        barraMenu.setVisible(true);
        paneMatricular.setVisible(true);
        cargarComboBoxAlumnosMatricular();
    }

    @FXML
    private void anadirAlumno(ActionEvent event) {
        if (!comboBoxAlumnosMatricular.getValue().equals("") || !comboBoxCursosMatricular.getValue().equals("")) {
            String alumnos = comboBoxAlumnosMatricular.getValue().toString();
            String idAlumno = comboBoxAlumnosMatricular.getValue().toString().substring(0, alumnos.indexOf("-"));
            int idPersona = Integer.parseInt(idAlumno);
            boolean esta = false;
            String cadenaAlumnos = alumnosTextArea.getText();
            String[] arrayAlumnos = cadenaAlumnos.split(", ");
            if (!cadenaAlumnos.equals("")) {
                for (int i = 0; i < arrayAlumnos.length; i++) {
                    int id = Integer.parseInt(arrayAlumnos[i].substring(0, arrayAlumnos[i].indexOf("-")));
                    if (idPersona == id) {
                        esta = true;
                    }
                }
            }
            if (!esta) {
                String consulta = "SELECT * FROM participaciones WHERE id_persona=" + idPersona + " AND id_asignatura=" + idClase;
                ResultSet rs = Conector.getSelect(consulta, conector);
                try {
                    if (rs.next()) {
                        labelAlumnosMatriculados.setText("El alumno ya está matriculado en " + nombreClaseMatricular);
                    } else {
                        rellenarAlumnosTextArea();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                labelAlumnosMatriculados.setText("El alumno ya se encuentra en la lista");
            }

        } else {
            labelAlumnosMatriculados.setText("Rellena los datos para matricular");
        }
    }

    public static void printArray(String[] arr) {
        System.out.print("[");
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println("]");
    }

    public void mensajeAlerta(String mensaje, String titulo) {

        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.show();

    }

    @FXML
    private void matricularAlumnos(ActionEvent event) {
        String sql;
        try {
            String cadenaAlumnos = alumnosTextArea.getText();
            if (cadenaAlumnos.equals("")) {
                labelAlumnosMatriculados.setText("No hay ningún alumno seleccionado");
            } else {
                System.out.println(cadenaAlumnos);
                String[] arrayAlumnos = cadenaAlumnos.split(", ");
                printArray(arrayAlumnos);
                Statement st = conector.createStatement();
                boolean insertado = false;

                for (int i = 0; i < arrayAlumnos.length; i++) {
                    int id = Integer.parseInt(arrayAlumnos[i].substring(0, arrayAlumnos[i].indexOf("-")));
                    sql = "INSERT INTO participaciones VALUES (" + id + "," + idClase + ")";
                    int resultado = st.executeUpdate(sql);
                    if (resultado > 0) {
                        insertado = true;
                    } else if (resultado <= 0) {
                        insertado = false;
                    }
                    if (insertado) {
                        labelAlumnosMatriculados.setText("¡Alumnos matriculados correctamente!");
                    } else {
                        labelAlumnosMatriculados.setText("¡ERROR! alumnos no matriculados");
                    }
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void limpiarMatriculaciones(ActionEvent event) {
        alumnosTextArea.setText("");
    }

    //Esto es una cutrada, pero funciona xd
    @FXML
    private void avanzarClase(ActionEvent event) {
        labelAsignatura1.setText(datosClase.get(contador + 1).getNombre());
        labelCurso1.setText(datosClase.get(contador + 1).getNombre());
        //paneAsignatura1.setStyle("-fx-background-color:"+datosClase.get(contador+1).getColor());
        labelAsignatura2.setText(datosClase.get(contador + 2).getNombre());
        labelCurso2.setText(datosClase.get(contador + 2).getCurso());
        //paneAsignatura2.setStyle("-fx-background-color:"+datosClase.get(contador+2).getColor());
        labelAsignatura3.setText(datosClase.get(contador + 3).getNombre());
        labelCurso3.setText(datosClase.get(contador + 3).getCurso());
        //paneAsignatura2.setStyle("-fx-background-color:"+datosClase.get(contador+3).getColor());
        contador++;
        botonVolverClase.setDisable(false);
        if (contador + 3 >= datosClase.size()) {
            botonAvanzarClase.setDisable(true);
        } else {
            botonAvanzarClase.setDisable(false);
        }

    }

    @FXML
    private void volverClase(ActionEvent event) {
        labelAsignatura1.setText(datosClase.get(contador - 1).getNombre());
        labelCurso1.setText(datosClase.get(contador - 1).getNombre());
        //paneAsignatura1.setStyle("-fx-background-color:"+datosClase.get(contador-1).getColor());
        labelAsignatura2.setText(datosClase.get(contador).getNombre());
        labelCurso2.setText(datosClase.get(contador).getCurso());
        //paneAsignatura2.setStyle("-fx-background-color:"+datosClase.get(contador).getColor());
        labelAsignatura3.setText(datosClase.get(contador + 1).getNombre());
        labelCurso3.setText(datosClase.get(contador + 1).getCurso());
        //paneAsignatura3.setStyle("-fx-background-color:"+datosClase.get(contador+1).getColor());
        contador--;
        botonAvanzarClase.setDisable(false);
        if (contador - 3 <= -3) {
            botonVolverClase.setDisable(true);
        } else {
            botonVolverClase.setDisable(false);
        }

    }

    @FXML
    private void abrirClase(MouseEvent event) {
        textAreaEntrega.setText("");
        ficheroTextField.setText("");
        Node source = (Node) event.getSource();
        if (source == paneAsignatura1) {
            nombreClaseMatricular = datosClase.get(contador).getNombre();
            labelClaseActual.setText(nombreClaseMatricular);
            idClase = datosClase.get(contador).getId();
        } else if (source == paneAsignatura2) {
            nombreClaseMatricular = datosClase.get(contador + 1).getNombre();
            labelClaseActual.setText(nombreClaseMatricular);
            idClase = datosClase.get(contador + 1).getId();
        } else if (source == paneAsignatura3) {
            nombreClaseMatricular = datosClase.get(contador + 2).getNombre();
            labelClaseActual.setText(nombreClaseMatricular);
            idClase = datosClase.get(contador + 2).getId();
        }
        setInvisible();
        botonShowPaneCrearTarea.setVisible(profesor);
        verMatricularAlumnosButton.setVisible(profesor);
        clase.setVisible(true);
        barraMenu.setVisible(true);
        cambiaTamaño(880, 600);
        Pane header = (Pane) tablaTareas.lookup("TableHeaderRow");
        header.setVisible(false);
        Pane header2 = (Pane) tablaEntregas.lookup("TableHeaderRow");
        header2.setVisible(false);
        listaTareas = new ArrayList<>();
        obs = FXCollections.observableArrayList();
        try {
            String consulta = "SELECT * FROM tareas WHERE id_asignatura=" + idClase + " ORDER BY fecha_de_entrega";
            System.out.println(consulta);
            ResultSet rs = Conector.getSelect(consulta, conector);
            while (rs.next()) {
                int id = rs.getInt("id_tarea");
                String nombre = rs.getString("enunciado");
                String tipo = rs.getString("tipo_tarea");
                Date fecha = rs.getDate("fecha_de_entrega");
                String desc = rs.getString("descripcion");
                tarea t = new tarea(id, nombre, tipo, fecha, desc);
                listaTareas.add(t);
                obs.add(t);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
        }

        rellenaTabla();
        idTarea.setVisible(false);
    }

    private void rellenaTabla() {

        Iterator iter = listaTareas.iterator();
        nombreTarea.setCellValueFactory(new PropertyValueFactory("nombre"));
        tipoTarea.setCellValueFactory(new PropertyValueFactory("tipo"));
        fechaEntrega.setCellValueFactory(new PropertyValueFactory("fecha"));
        idTarea.setCellValueFactory(new PropertyValueFactory("id"));
        tablaTareas.setItems(obs);
    }

        private void rellenaTablaEntregas() {
        Iterator iter = listaEntregas.iterator();
        nombreAlumno.setCellValueFactory(new PropertyValueFactory("nombre"));
        tablaEntregas.setItems(obs2);
    }

    
    
    @FXML
    private void crearCursoCancelar(ActionEvent event) {
        paneCrearCurso.setVisible(false);
        clases.setDisable(false);
        menu.setDisable(false);
    }

    @FXML
    private void buttonAddTarea(ActionEvent event) {

        try {
            String enunciado = enunciadoTextField.getText();
            String descripcion = descripcionTextArea.getText();
            String tipoTarea = "", fechaEntrega = "";
            try {
                tipoTarea = tipoTareaComboBox.getValue().toString();
                fechaEntrega = fechaEntregaDatePicker.getValue().toString();
            } catch (NullPointerException ex) {
                System.out.println("tal");
            }
            String fechaLimite = "2023/2/24";
            String ponderacionTarea = ponderacionTextField.getText();
            Pattern p = Pattern.compile("\\d{1,100}");
            Matcher m = p.matcher(ponderacionTarea);
            if (enunciado.equals("")) {
                msgLabelCrearTarea.setText("El enunciado no puede estar vacío");
            } else if (tipoTarea.equals("")) {
                msgLabelCrearTarea.setText("Introduce un tipo de tarea");
            } else if (fechaEntrega.equals("")) {
                fechaEntregaDatePicker.setValue(LocalDate.now().plusDays(7));
            } else if (!m.matches()) {
                msgLabelCrearTarea.setText("Introduzca la ponderacion correctamente (1-100)");
            } else {
                Statement st = conector.createStatement();
                String sql = "INSERT INTO tareas (enunciado, descripcion, tipo_tarea, fecha_de_entrega, fecha_limite, id_asignatura, ponderacion_tarea) VALUES"
                        + " ('" + enunciado + "','" + descripcion + "','" + tipoTarea + "','" + fechaEntrega + "','" + fechaLimite + "'," + idClase + "," + ponderacionTarea + ")";
                System.out.println(sql);
                int resultado = st.executeUpdate(sql);
                if (resultado > 0) {
                    msgLabelCrearTarea.setText("Tarea registrada correctamente");
                } else {
                    msgLabelCrearTarea.setText("¡ERROR!");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void showPaneCrearTarea(ActionEvent event) {
        setInvisible();
        barraMenu.setVisible(true);
        paneCrearTarea.setVisible(true);
        tipoTareaComboBox.getItems().clear();
        ArrayList tareas = new ArrayList();
        tareas.add("Actividad");
        tareas.add("Examen");
        tareas.add("Proyecto");
        tipoTareaComboBox.getItems().addAll(tareas);
    }

    private final ListChangeListener<tarea> selectorTablaTareas = new ListChangeListener<tarea>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends tarea> c) {

        }

    };

        private final ListChangeListener<entrega> selectorTablaEntregas = new ListChangeListener<entrega>() {
        @Override
        public void onChanged(ListChangeListener.Change<? extends entrega> c) {

        }

    };

    
    private void ponerTareaSelecionada() {
        final tarea t = getTablaTareasSeleccionada();
        posicionTareaEnTabla = listaTareas.indexOf(t);
        if (t != null) {
            nombreTareaAlumno.setText(t.getNombre());
            tareaDescripcionAlumno.setText(t.getDesc());
            fechaEntrega.setText(t.getFecha().toString());
            fecha = t.getFecha();
            idTareaSeleccionada = t.getId();
        }
    }
    
    private void ponerEntregaSelecionada() {
        final entrega e = getTablaEntregasSeleccionada();
        posicionTareaEnTabla = listaEntregas.indexOf(e);
        if (e != null) {
            nombreTareaAlumno.setText(e.getNombre());
        }
    }

    public entrega getTablaEntregasSeleccionada() {
        if (tablaTareas != null) {
            List<entrega> tabla = (List<entrega>) tablaEntregas.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final entrega competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }
    public tarea getTablaTareasSeleccionada() {
        if (tablaTareas != null) {
            List<tarea> tabla = tablaTareas.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final tarea competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    @FXML
    private void abrirTarea(MouseEvent event) {
        ponerTareaSelecionada();
        setInvisible();
        paneTareasAlumno.setVisible(true);
        barraMenu.setVisible(true);
        buttonVerEntregas.setVisible(profesor);
        if(profesor)
            PaneEditarTareaProfesor.setVisible(true);
        else
            paneEntregarTareasAlumno.setVisible(true);
    }

    @FXML
    private void rutaFichero(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Archivo de la entrega");

        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll();

        // Obtener la imagen seleccionada
        File file = fileChooser.showOpenDialog(null);
        String ruta = file.getAbsoluteFile().toString();

        ficheroTextField.setText(ruta);
    }

    @FXML
    private void entregarTarea(ActionEvent event) {
        final tarea t = getTablaTareasSeleccionada();
        int id_tarea = t.getId();
        String entrega = textAreaEntrega.getText();
        String ruta = ficheroTextField.getText();
        
        try {
            
            Statement st = conector.createStatement();
            if (!profesor) {
                String sql = "INSERT INTO entregas (id_persona,id_tarea,entregado,fichero,entrega) VALUES (" + idPersona + "," + id_tarea + "," + true + ",'" + ruta + "','" + entrega + "')";
                int res = st.executeUpdate(sql);
                
                if (res > 0) {
                    mensajeAlerta("¡Tarea entregada correctamente!", "Tarea entregada");
                    String consultaFecha = "SELECT (fecha_de_entrega) FROM tareas WHERE id_tarea="+id_tarea;
                    ResultSet rs = Conector.getSelect(consultaFecha, conector);
                    if(rs.next()){
                        Date fechaEntrega = rs.getDate("fecha_de_entrega");
                        if(fecha.after(fechaEntrega))
                            labelEntregado.setText("Entregado");
                        else
                            labelEntregado.setText("Entregado con retraso");
                    }
                } else {
                    mensajeAlerta("¡ERROR!", "¡ERROR!");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void verEntregas(ActionEvent event) {
        listaEntregas = new ArrayList<>();
        obs2 = FXCollections.observableArrayList();
        try {
            setInvisible();
            barraMenu.setVisible(true);
            paneTareasProfesor.setVisible(true);
            String consulta = "SELECT entregas.id_entrega,entregas.id_persona,nota,id_tarea,fichero,entrega, personas.nombre FROM entregas,personas WHERE entregado=1 AND id_tarea="+idTareaSeleccionada+" AND entregas.id_persona=personas.id_persona";
            System.out.println(consulta);
            ResultSet rs = Conector.getSelect(consulta, conector);
            if(rs!=null){
                while (rs.next()) {
                    int id = rs.getInt("id_entrega");
                    int id_persona = rs.getInt("id_persona");
                    int id_tarea = rs.getInt("id_tarea");
                    String nombre = rs.getString("nombre");
                    String fichero = rs.getString("fichero");
                    String texto = rs.getString("entrega");
                    entrega e = new entrega(id, id_persona, nombre,texto, fichero);
                    listaEntregas.add(e);
                    obs2.add(e);
                }
                rellenaTablaEntregas();
            }
        } catch (SQLException ex) {
            System.out.println("ERROR xD");
        }
        
        
    }
}
