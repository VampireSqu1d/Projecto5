import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroAlumno extends JPanel {

    public static JButton volvera, limpiara, aceptara;
    public static JTextField expediente, nombre, lic, librosp, diasp, fdev;

    public RegistroAlumno(){
        int ancho = 1024;
        int alto = 760;
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
        setLayout(null);

        //fuente
        Font fuente = new Font("Chakra Petch", 14,18);

        //fondo
        JPanel ContenedorImagen = new JPanel();
        JLabel unison = new JLabel(new ImageIcon("imagenes/fondo.jpg"));
        ContenedorImagen.setBounds(0,-50, Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);


        JPanel palumnos = new JPanel(null);
        Border bordeperron = new TitledBorder(new EtchedBorder(), "Registrar Alumnos");//borde del panel, puedes comentarlo si quieres
        palumnos.setBorder(bordeperron);

        JLabel expedienteperron = new JLabel("Expediente:");
        expedienteperron.setFont(fuente);
        JLabel nombreperron = new JLabel("Nombre Completo:");
        nombreperron.setFont(fuente);
        JLabel licenciaturaperrona = new JLabel("Licenciatura:");
        licenciaturaperrona.setFont(fuente);
        JLabel librosperrones = new JLabel("Libros Prestados:");
        librosperrones.setFont(fuente);
        JLabel diasperrones = new JLabel("Dias de Prestamo:");
        diasperrones.setFont(fuente);
        JLabel fechaperrona = new JLabel("Fecha de devolucion:");
        fechaperrona.setFont(fuente);

        expediente = new JTextField();
        nombre = new JTextField();
        lic = new JTextField();
        librosp = new JTextField();
        diasp = new JTextField();
        fdev = new JTextField();

        volvera = new JButton("Volver", new ImageIcon("imagenes/volver.png"));
        volvera.setFont(fuente);
        limpiara = new JButton("Limpiar");
        limpiara.setFont(fuente);
        aceptara = new JButton("Aceptar");
        aceptara.setFont(fuente);


        expedienteperron.setBounds(100, 200, 150, 20);//ps a partir de aqui son las posiciones de los componentes
        nombreperron.setBounds(100, 250, 150, 20);//este primer parrafo son labels
        licenciaturaperrona.setBounds(100, 300, 150, 20);
        librosperrones.setBounds(100, 350, 150, 20);
        diasperrones.setBounds(100, 400, 150, 20);
        fechaperrona.setBounds(100, 450, 170, 20);

        expediente.setBounds(300, 200, 200, 20);//este son los textfield
        nombre.setBounds(300, 250, 200, 20);
        lic.setBounds(300, 300, 200, 20);
        librosp.setBounds(300, 350, 200, 20);
        diasp.setBounds(300, 400, 200, 20);
        fdev.setBounds(300, 450, 200, 20);

        volvera.setBounds(200, 600, 140, 40);//este sonb los botones
        limpiara.setBounds(1000, 600, 140, 40);
        aceptara.setBounds(850, 600, 140, 40);

        add(expedienteperron);//labels
        add(nombreperron);
        add(licenciaturaperrona);
        add(librosperrones);
        add(diasperrones);
        add(fechaperrona);

        add(expediente);//textfield
        add(nombre);
        add(lic);
        add(librosp);
        add(diasp);
        add(fdev);

        add(volvera);//botones
        add(limpiara);
        add(aceptara);

        // añade fondo
        ContenedorImagen.add(unison);
        add(ContenedorImagen);

        volvera.addActionListener(new botin());
        limpiara.addActionListener(new botonLimpiar());

        //add(palumnos);
    }

    public static class botin implements ActionListener {

        public  botin(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == volvera){
                Main.TodoInicio.setVisible(true);
                Main.registroAlumno.setVisible(false);
            }
        }
    }

    public static class botonLimpiar implements ActionListener {

        public botonLimpiar() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == limpiara) {
                nombre.setText("");
                expediente.setText("");
                lic.setText("");
                fdev.setText("");
                librosp.setText("");
                diasp.setText("");
            }
        }
    }

    }
