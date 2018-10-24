import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class RegistroLibros extends JPanel {
    static JFormattedTextField id, Anio, Edicion, CantExit, Precio;
    static JTextField Nombre, Autor, Editorial;
    static JButton Volver, Aceptar, Limpiar;


    public RegistroLibros(){
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

        //numberFormatter.setMinimum(0);

        //fuente
        Font fuente = new Font("Chakra Petch", 14,18);

        //label y campo de codigo del libro
        JLabel idLabel = new JLabel("Codigo:");
        idLabel.setFont(fuente);
        idLabel.setBounds(20,140,80,35);
        add(idLabel);
        id = new JFormattedTextField(numberFormatter);
        id.setFont(fuente);
        id.setBorder(estilo);
        id.setBounds(100,140, 120, 35);
        add(id);

        // Label y campo del nombre
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(20,200, 90, 50);
        nombreLabel.setFont(fuente);
        add(nombreLabel);
        Nombre = new JTextField();
        Nombre.setBorder(estilo);
        Nombre.setBounds(100, 205, 180, 35);
        Nombre.setFont(fuente);
        add(Nombre);

        //label y campo del autor
        JLabel autorLabel = new JLabel("Autor:");
        autorLabel.setBounds(20,260, 60, 35);
        autorLabel.setFont(fuente);
        add(autorLabel);
        Autor = new JTextField();
        Autor.setFont(fuente);
        Autor.setBorder(estilo);
        Autor.setBounds(90, 260, 150, 35);
        add(Autor);


        //Label y campo del anio
        JLabel anioLabel = new JLabel("Año de publicacion:");
        anioLabel.setBounds(310, 140, 160, 35);
        anioLabel.setFont(fuente);
        add(anioLabel);
        Anio = new JFormattedTextField( numberFormatter);
        Anio.setBounds(480, 140, 60, 35);
        Anio.setFont(fuente);
        Anio.setBorder(estilo);
        add(Anio);

        //Label y campo de Edicion
        JLabel edicionLabel = new JLabel("Edicion:");
        edicionLabel.setBounds(310, 200, 90, 35);
        edicionLabel.setFont(fuente);
        edicionLabel.setVisible(true);
        add(edicionLabel);
        Edicion = new JFormattedTextField(numberFormatter);
        Edicion.setFont(fuente);
        Edicion.setBorder(estilo);
        Edicion.setBounds(400, 200, 90, 35);
        add(Edicion);

        //label y campo de Editorial
        JLabel editorialLabel = new JLabel("Editorial:");
        editorialLabel.setFont(fuente);
        editorialLabel.setBounds(310, 260, 80, 35);
        add(editorialLabel);
        Editorial = new JFormattedTextField(numberFormatter);
        Editorial.setFont(fuente);
        Editorial.setBorder(estilo);
        Editorial.setBounds(400, 260, 100, 35);
        add(Editorial);

        //LAbel y campo de cantidad de libros
        JLabel cantLabel = new JLabel("Cantidad de libros:");
        cantLabel.setFont(fuente);
        cantLabel.setBounds(20, 310, 160,35);
        add(cantLabel);
        CantExit = new JFormattedTextField(numberFormatter);
        CantExit.setBounds(180, 310, 50, 35);
        CantExit.setBorder(estilo);
        CantExit.setFont(fuente);
        add(CantExit);

        //Label y campo del precio
        JLabel PrecioLabel = new JLabel("Precio:");
        PrecioLabel.setBounds(20, 350, 80, 35);
        PrecioLabel.setFont(fuente);
        add(PrecioLabel);
        Precio = new JFormattedTextField(numberFormatter);
        Precio.setFont(fuente);
        Precio.setBorder(estilo);
        Precio.setBounds(90, 350, 80, 35);
        add(Precio);


        // boton volver
        Volver = new JButton("Volver", new ImageIcon("imagenes/volver.png"));
        Volver.setBounds(30, 600, 140, 50);
        Volver.setBorder(estiloBotones);
        Volver.setFont(fuente);
        add(Volver);


        // boton limpiar
        Limpiar = new JButton("Limpiar");
        Limpiar.setFont(fuente);
        Limpiar.setBorder(estiloBotones);
        Limpiar.setBounds(350, 330, 120, 45);
        add(Limpiar);

        // boton aceptar
        Aceptar = new JButton("Aceptar");
        Aceptar.setBorder(estiloBotones);
        Aceptar.setBounds(480, 330, 120, 45);
        Aceptar.setFont(fuente);
        add(Aceptar);


    }
}
