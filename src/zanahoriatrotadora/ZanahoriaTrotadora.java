/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zanahoriatrotadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Nelson
 */
public class ZanahoriaTrotadora {

    public static boolean a = true;
    public static boolean b = false;
    public static boolean c = false;
    public static String jugadoresstr = "";
    public static int jugadores;
    public static String cadena ="";
    public static JButton boton1 = new JButton();
    public static JButton boton2 = new JButton();
    public static JButton boton3 = new JButton();
    public static JButton boton4 = new JButton();
    public static JButton boton5 = new JButton();
    
    public static void Ventana(){
        JFrame ventanaInicial = new JFrame("Zanahoria Trotadora - "+cadena);
        ventanaInicial.setLocation(200 ,0);
        ventanaInicial.setSize(200 ,300);
        ventanaInicial.setVisible(true);
        ventanaInicial.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
//        Tablero matriz  = new Tablero(13, 17, cadena, jugadores);
    }
    
    public static void Menu() throws FileNotFoundException, IOException{
        File dir = new File("maps/");
        final String[] ficheros = dir.list();
        String[] humans ={"2","3"};

        if (ficheros == null) {
            System.out.println("No hay ficheros en el directorio especificado");
        } else {
            
            final JFrame menu = new JFrame("Gallinero Explosivo");
            menu.setSize(400,400);//tamaño de la ventana
            menu.setLayout(null);
            menu.setLocation(200,200);//ubicación respecto pixel 0,0(esq sup izq)
            menu.setVisible(true);
            menu.setResizable(false);

            DefaultComboBoxModel laLista = new DefaultComboBoxModel(ficheros) ;
            DefaultComboBoxModel laOtraLista = new DefaultComboBoxModel(humans) ;

            final JComboBox listaPlayers = new JComboBox(laOtraLista);
            final JComboBox listaMapas = new JComboBox(laLista);

            final JLabel texto1 = new JLabel("Lista de Mapas:");
            final JLabel texto2 = new JLabel("Cantidad Jugadores:");
            
            final JMenuBar menubar = new JMenuBar();
            
            final JMenu archivo = new JMenu("Archivo");
            final JMenu ayuda = new JMenu("Ayuda");
            
            final JMenuItem newgame = new JMenuItem("Partida Nueva");
            final JMenuItem instrucciones = new JMenuItem("Instrucciones");
            
            newgame.addActionListener((new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    boton1.setVisible(true);
                    boton2.setVisible(false);
                    boton3.setVisible(true);
                    boton4.setVisible(false);
                    boton5.setVisible(true);
                    texto1.setVisible(true);
                    texto2.setVisible(false);
                    listaMapas.setVisible(true);
                    listaPlayers.setVisible(false);
                }
            }));
            
            menu.setJMenuBar(menubar);
            menubar.add(archivo);
            menubar.add(ayuda);
            archivo.add(newgame);
            ayuda.add(instrucciones);
            
            boton1.setSize(150,30);
            boton2.setSize(150,30);
            boton3.setSize(150,30);
            boton4.setSize(150,30);
            boton5.setSize(150,30);

            texto1.setSize(140,20);
            texto2.setSize(140,20);

            listaMapas.setSize(210,20);
            listaPlayers.setSize(210,20);

            boton1.setText("Aceptar1");
            boton2.setText("Aceptar2");
            boton3.setText("Regresar");
            boton4.setText("Regresar");
            boton5.setText("Al Azar");

            boton1.setLocation(10,50);
            boton2.setLocation(10,50);
            boton3.setLocation(10,90);
            boton4.setLocation(10,90);
            boton5.setLocation(10,130);

            texto1.setLocation(10,10);
            texto2.setLocation(10,10);

            listaMapas.setLocation(170,10);
            listaPlayers.setLocation(170,10);
            
            menu.add(texto1);
            menu.add(texto2);
            menu.add(boton1);
            menu.add(boton2);
            menu.add(boton3);
            menu.add(boton4);
            menu.add(boton5);
            menu.add(listaPlayers);
            menu.add(listaMapas);

            boton1.setVisible(false);
            boton2.setVisible(false);
            boton3.setVisible(false);
            boton4.setVisible(false);
            boton5.setVisible(false);

            texto1.setVisible(false);
            texto2.setVisible(false);

            listaMapas.setVisible(false);
            listaPlayers.setVisible(false);
                    
            boton1.addActionListener((new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    boton1.setVisible(false);
                    boton2.setVisible(true);
                    boton3.setVisible(false);
                    boton4.setVisible(true);
                    boton5.setVisible(false);
                    texto1.setVisible(false);
                    texto2.setVisible(true);
                    listaMapas.setVisible(false);
                    listaPlayers.setVisible(true);
                    cadena = (String) listaMapas.getSelectedItem();                    
                }
            }));

            boton2.addActionListener((new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    jugadoresstr = (String) listaPlayers.getSelectedItem();
                    jugadores = Integer.parseInt(jugadoresstr);
                    menu.dispose();
                    Ventana();
                    b = true;                    
                    c = true;
                }
            }));

            boton3.addActionListener((new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    boton1.setVisible(false);
                    boton2.setVisible(false);
                    boton3.setVisible(false);
                    boton4.setVisible(false);
                    boton5.setVisible(false);
                    texto1.setVisible(false);
                    texto2.setVisible(false);
                    listaMapas.setVisible(false);
                    listaPlayers.setVisible(false);
                }
            }));

            boton4.addActionListener((new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    boton1.setVisible(true);
                    boton2.setVisible(false);
                    boton3.setVisible(true);
                    boton4.setVisible(false);
                    boton5.setVisible(true);
                    texto1.setVisible(true);
                    texto2.setVisible(false);
                    listaMapas.setVisible(true);
                    listaPlayers.setVisible(false);
                }
            }));
            
            boton5.addActionListener((new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    boton1.setVisible(false);
                    boton2.setVisible(true);
                    boton3.setVisible(false);
                    boton4.setVisible(true);
                    boton5.setVisible(false);
                    texto1.setVisible(false);
                    texto2.setVisible(true);
                    listaMapas.setVisible(false);
                    listaPlayers.setVisible(true); 
                    cadena = ficheros[(int)Math.floor(Math.random()*ficheros.length)];
                }
            }));
            
            menu.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
        }
    }
    
    public static void main(String[] args) throws IOException {
        Menu();
    }
    
}
