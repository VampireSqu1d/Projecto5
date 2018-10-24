import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroVenta extends JPanel {
    static JTextField NombreLibro, NombreAlumno;
    static JFormattedTextField Precio, Recibido;
    static JButton Volver, Aceptar, Limpiar;

    public RegistroVenta(){
        int ancho = 1024;
        int alto = 760;
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
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

        // Label y campo del precio
        JLabel PrecioLabel = new JLabel("Precio:");
        PrecioLabel.setBounds(20, 250, 80, 35);
        PrecioLabel.setFont(fuente);
        add(PrecioLabel);
        Precio = new JFormattedTextField(numberFormatter);
        Precio.setFont(fuente);
        Precio.setBorder(estilo);
        Precio.setBounds(100, 250, 90, 35);
        add(Precio);

        // Label y campo del dinero recibido
        JLabel RecibidoLabel = new JLabel("Dinero Recibido:");
        RecibidoLabel.setFont(fuente);
        RecibidoLabel.setBounds(20, 300, 150, 35);
        add(RecibidoLabel);
        Recibido = new JFormattedTextField(numberFormatter);
        Recibido.setFont(fuente);
        Recibido.setBorder(estilo);
        Recibido.setBounds(170, 300, 80, 35);
        add(Recibido);

        //boton volver
        Volver = new JButton("volver", new ImageIcon("imagenes/volver.png"));
        Volver.setBounds(30, 600, 140, 50);
        Volver.setBorder(estiloBotones);
        Volver.setFont(fuente);
        add(Volver);

        //boton limpiar
        Limpiar = new JButton("Limpiar");
        Limpiar.setBounds(20, 500, 120, 35);
        Limpiar.setFont(fuente);
        Limpiar.setBorder(estiloBotones);
        add(Limpiar);

        // boton aceptar
        Aceptar = new JButton("Aceptar");
        Aceptar.setBorder(estiloBotones);
        Aceptar.setFont(fuente);
        Aceptar.setBounds(150, 500, 120, 35);
        add(Aceptar);


        Limpiar.addActionListener(new botonLimpiar());
        Volver.addActionListener(new botin());
        Aceptar.addActionListener(new BotonAceptar(NombreLibro, NombreAlumno, Precio, Recibido));
    }

    public static class BotonAceptar implements ActionListener{
        public JTextField NombreLibro, NombreAlumno;
        public JFormattedTextField Precio, Recibido;

        public BotonAceptar(JTextField NombreLibro, JTextField NombreAlumno,
                            JFormattedTextField Precio, JFormattedTextField Recibido ){
            this.NombreAlumno = NombreAlumno; this.NombreLibro = NombreLibro;
            this.Precio = Precio; this.Recibido = Recibido;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Aceptar) {
                String precioS = Precio.getText().replace(",","");
                String recibidoS = Recibido.getText().replace(",","");
                String Venta = NombreAlumno.getText() +","+ NombreLibro.getText() + "," + precioS+","
                        + recibidoS;
                File RV = new File("RegistroVentas.txt");
                try {
                    FileWriter fw = new FileWriter(RV, true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(Venta);

                    pw.flush();
                    fw.flush();
                    pw.close();
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(RegistroVenta.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        }
    }

    public static class botin implements ActionListener{

        public  botin(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Volver){
                Main.TodoInicio.setVisible(true);
                Main.registroVenta.setVisible(false);
            }
        }
    }

    public static class botonLimpiar implements ActionListener{

        public botonLimpiar(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Limpiar){
                NombreLibro.setText(""); NombreAlumno.setText("");
                Precio.setText(""); Recibido.setText("");
            }
        }
    }


}
