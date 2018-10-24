import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public static JButton RegistroLibro, RegistroAlumno, Prestamo, Vender;
    public static JPanel TodoInicio;
    public static RegistroLibros registroLibro;
    public static RegistroVenta registroVenta;

    public Main(){
        setLayout(null);
        setTitle("Sistema Bibliotecario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("imagenes/unison-logo.jpg");
        setIconImage(logo.getImage());
        int ancho = 1024;
        int alto = 720;
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
        Font fuente = new Font("Chakra Petch", 14,24);

        TodoInicio = new JPanel();
        TodoInicio.setLayout(null);
        TodoInicio.setBounds(0,0, 1024, 720);
        add(TodoInicio);

        //imagen unison
        JPanel ContenedorImagen = new JPanel();
        JLabel unison = new JLabel(new ImageIcon("imagenes/rsz_1unison.jpg"));
        ContenedorImagen.setBounds(350, 10, 600, 200);
        ContenedorImagen.add(unison);
        TodoInicio.add(ContenedorImagen);

        //boton para registrar
        RegistroLibro  = new JButton("Registrar Libro");
        RegistroLibro.setFont(fuente);
        RegistroLibro.setLocation(500, 250);
        RegistroLibro.setSize(ancho/4, alto/10);
        TodoInicio.add(RegistroLibro);

        // boton registro alumnos
        RegistroAlumno = new JButton("Registrar Alumno");
        RegistroAlumno.setFont(fuente);
        RegistroAlumno.setLocation(500, 350);
        RegistroAlumno.setSize(ancho/4, alto/10);
        TodoInicio.add(RegistroAlumno);

        // boton prestamos
        Prestamo = new JButton("Prestamo");
        Prestamo.setFont(fuente);
        Prestamo.setLocation(500, 450);
        Prestamo.setSize(ancho/4, alto/10);
        TodoInicio.add(Prestamo);

        // boton vender
        Vender = new JButton("Vender Libro");
        Vender.setFont(fuente);
        Vender.setLocation(500, 550);
        Vender.setSize(ancho/4, alto/10);
        TodoInicio.add(Vender);

        // panel de registros libros
        registroLibro = new RegistroLibros();
        registroLibro.setVisible(false);
        add(registroLibro);

        // panel de registro de venta
        registroVenta = new RegistroVenta();
        registroVenta.setVisible(false);
        add(registroVenta);

        // ActionListeners de todos los botones
        Prestamo.addActionListener(new Botones());
        RegistroLibro.addActionListener(new Botones());
        Vender.addActionListener(new Botones());
        RegistroAlumno.addActionListener(new Botones());

        setVisible(true);
    }

    public static class Botones implements ActionListener{

        public  Botones(){ }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Prestamo){
                TodoInicio.setVisible(false);

            }
            if (e.getSource() == RegistroLibro){
                TodoInicio.setVisible(false);
                registroLibro.setVisible(true);
            }
            if (e.getSource() == Vender){
                TodoInicio.setVisible(false);
                registroVenta.setVisible(true);
            }
            if (e.getSource() == RegistroAlumno){
                TodoInicio.setVisible(false);

            }
        }
    }

    public static void main(String[] args) { new Main();
    }

}
