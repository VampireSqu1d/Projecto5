import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main(){
        //BorderLayout principal = new BorderLayout();
        //setLayout(principal);
        setLayout(null);
        setTitle("Sistema Bibliotecario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon("imagenes/unison-logo.jpeg");
        setIconImage(logo.getImage());

        setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height - 35);
        Font fuente = new Font("Chakra Petch", 14,24);

        /*//imagen unison
        JPanel ContenedorImagen = new JPanel();
        JLabel unison = new JLabel(new ImageIcon("imagenes/rsz_1unison.jpg"));
        ContenedorImagen.add(unison);
        add(ContenedorImagen, principal.NORTH);

        // Panel de Inicio
        JPanel inicio = new JPanel();
        add(inicio, principal.CENTER);
        inicio.setSize(ancho/5, alto/5);
        //boton para registrar
        JButton RegistroLibro = new JButton("Registrar Libro");
        RegistroLibro.setFont(fuente);
        RegistroLibro.setSize(ancho/10, alto/10);
        inicio.add(RegistroLibro);

        // boton registro alumnos
        JButton RegistroAlumno = new JButton("Registrar Alumno");
        RegistroAlumno.setFont(fuente);
        RegistroAlumno.setSize(ancho/10, alto/10);
        inicio.add(RegistroAlumno);

        // boton prestamos
        JButton Prestamo = new JButton("Prestamo");
        Prestamo.setFont(fuente);
        Prestamo.setSize(ancho/10, alto/10);
        inicio.add(Prestamo);

        // boton vender
        JButton Vender = new JButton("Vender Libro");
        Vender.setFont(fuente);
        Vender.setSize(100, 100);
        inicio.add(Vender);*/
        add(new RegistroLibros());
        //add(new RegistroVenta());


        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

}
