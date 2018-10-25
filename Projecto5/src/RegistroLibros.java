import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroLibros extends JPanel {

    static JTextField Nombre, Autor, Editorial, id, Anio, Edicion, CantExit, Precio;
    static JButton Volver, Aceptar, Limpiar;

    public RegistroLibros(){
        int ancho = 1024;
        int alto = 760;
        setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
        setLayout(null);
        setBackground(Color.pink);

        JPanel ContenedorImagen = new JPanel();
        JLabel unison = new JLabel(new ImageIcon("imagenes/fondo.jpg"));
        ContenedorImagen.setBounds(0,-50, Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);



        //Border de los textfield y botones
        Border estilo = BorderFactory.createLineBorder(Color.black, 1,true);
        Border estiloBotones = BorderFactory.createRaisedBevelBorder();

        // formato para solo aceptar numeros
        NumberFormat formato = NumberFormat.getIntegerInstance();
        NumberFormatter numberFormatter = new NumberFormatter(formato);
        numberFormatter.setValueClass(Long.class);
        numberFormatter.setAllowsInvalid(false);

        //fuente
        Font fuente = new Font("Chakra Petch", 14,18);

        //label y campo de codigo del libro
        JLabel idLabel = new JLabel("Codigo:");
        idLabel.setFont(fuente);
        idLabel.setBounds(20,150,80,35);
        add(idLabel);
        id = new JTextField();
        id.setFont(fuente);
        id.setBorder(estilo);
        id.setBounds(100,150, 120, 35);
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
        Autor.setBounds(100, 260, 180, 35);
        add(Autor);

        //Label y campo del anio
        JLabel anioLabel = new JLabel("Año de publicacion:");
        anioLabel.setBounds(310, 150, 160, 35);
        anioLabel.setFont(fuente);
        add(anioLabel);
        Anio = new JTextField();
        Anio.setBounds(480, 150, 60, 35);
        Anio.setFont(fuente);
        Anio.setBorder(estilo);
        add(Anio);

        //Label y campo de Edicion
        JLabel edicionLabel = new JLabel("Edicion:");
        edicionLabel.setBounds(310, 200, 90, 35);
        edicionLabel.setFont(fuente);
        edicionLabel.setVisible(true);
        add(edicionLabel);
        Edicion = new JTextField();
        Edicion.setFont(fuente);
        Edicion.setBorder(estilo);
        Edicion.setBounds(400, 200, 90, 35);
        add(Edicion);

        //label y campo de Editorial
        JLabel editorialLabel = new JLabel("Editorial:");
        editorialLabel.setFont(fuente);
        editorialLabel.setBounds(310, 260, 80, 35);
        add(editorialLabel);
        Editorial = new JTextField();
        Editorial.setFont(fuente);
        Editorial.setBorder(estilo);
        Editorial.setBounds(400, 260, 100, 35);
        add(Editorial);

        //Label y campo de cantidad de libros
        JLabel cantLabel = new JLabel("Cantidad de libros:");
        cantLabel.setFont(fuente);
        cantLabel.setBounds(20, 310, 160,35);
        add(cantLabel);
        CantExit = new JTextField();
        CantExit.setBounds(180, 310, 50, 35);
        CantExit.setBorder(estilo);
        CantExit.setFont(fuente);
        add(CantExit);

        //Label y campo del precio
        JLabel PrecioLabel = new JLabel("Precio:");
        PrecioLabel.setBounds(20, 360, 80, 35);
        PrecioLabel.setFont(fuente);
        add(PrecioLabel);
        Precio = new JTextField();
        Precio.setFont(fuente);
        Precio.setBorder(estilo);
        Precio.setBounds(90, 360, 80, 35);
        add(Precio);

        // boton volver
        Volver = new JButton("Volver", new ImageIcon("imagenes/volver.png"));
        Volver.setBounds(30, 580, 140, 50);
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

        ContenedorImagen.add(unison);
        add(ContenedorImagen);

        Volver.addActionListener(new bot());
        Limpiar.addActionListener(new bot());
        Aceptar.addActionListener(new botonGuardar(id, Anio, Edicion, CantExit, Precio, Nombre, Autor, Editorial));

    }

    public static class botonGuardar implements ActionListener{

        public JTextField Nombre, Autor, Editorial,id, Anio, Edicion, CantExit, Precio;

        public botonGuardar(JTextField id, JTextField Anio,JTextField Edicion,
        JTextField CantExit, JTextField Precio, JTextField Nombre,JTextField Autor,JTextField Editorial){
            this.id = id; this.Anio = Anio; this.Edicion = Edicion; this.CantExit = CantExit;
            this.Precio = Precio; this.Nombre = Nombre; this.Autor = Autor; this.Editorial = Editorial;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String libro = id.getText() +"," + Anio.getText()+ "," + Edicion.getText() + "," + CantExit.getText()
                    + "," + Precio.getText()+ "," + Nombre.getText() + "," + Autor.getText() + "," + Editorial.getText() ;

            File un = new File("RegistroLibros.txt");
            try {
                FileWriter we = new FileWriter(un, true);
                PrintWriter sa = new PrintWriter(we);
                sa.println(libro);

                sa.flush();
                sa.close();
                we.close();
            }
            catch (IOException ex) {
                Logger.getLogger(RegistroLibros.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static class bot implements ActionListener{

        public bot(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == Volver){
                Main.TodoInicio.setVisible(true);
                Main.registroLibro.setVisible(false);
            }
            if (e.getSource() == Limpiar){
                id.setText(""); Anio.setText(""); Edicion.setText(""); CantExit.setText("");
                Precio.setText(""); Nombre.setText(""); Autor.setText(""); Editorial.setText("");
            }
        }
    }
}
