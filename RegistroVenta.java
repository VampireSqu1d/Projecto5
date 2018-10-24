import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class RegistroVenta extends JPanel {
    static JTextField NombreLibro, NombreAlumno;
    static JFormattedTextField Precio, Recibido;


    public RegistroVenta(){
        int ancho = 1024;
        int alto = 760;
        setSize(ancho ,alto - 40);
        setLayout(null);
        setBackground(Color.pink);

        //Border de los textfield y botones
        Border estilo = BorderFactory.createLoweredBevelBorder();
        Border estiloBotones = BorderFactory.createRaisedBevelBorder();

        // formato para solo aceptar numeros
        NumberFormat formato = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(formato);
        numberFormatter.setValueClass(Long.class);
        numberFormatter.setAllowsInvalid(false);
        //numberFormatter.setMinimum(0);

        //fuente
        Font fuente = new Font("Chakra Petch", 14,18);


        //Label y campo del nombre del alumno
        JLabel NombreAlLabel = new JLabel("Nombre del Alumno:");
        NombreAlLabel.setFont(fuente);
        NombreAlLabel.setBounds(20, 140, 170, 35);
        add(NombreAlLabel);
        NombreAlumno = new JTextField();
        NombreAlumno.setFont(fuente);
        NombreAlumno.setBorder(estilo);
        NombreAlumno.setBounds(200, 140, 180, 35);
        add(NombreAlumno);

        // Label y campo del libro
        JLabel NombreLibroLabel = new JLabel("Nombre del Libro:");
        NombreLibroLabel.setFont(fuente);
        NombreLibroLabel.setBounds(20, 190, 170, 35);
        add(NombreLibroLabel);
        NombreLibro = new JTextField();
        NombreLibro.setBounds(200, 190, 170, 35);
        NombreLibro.setFont(fuente);
        NombreLibro.setBorder(estilo);
        add(NombreLibro);






    }

}
