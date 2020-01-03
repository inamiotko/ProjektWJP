/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektwjp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author iganamiotko
 */
public class Info extends JPanel
{
    JTextArea area = new JTextArea();
    /** utworzenie pola tekstowego*/
    JButton exit = new JButton("Powrót");
    /** utworzenie przycisku wracającego do menu*/
    
    /** Konstruktor - dodanie elemtów panelu
     * modyfikacja ich i umiejscowienie ich w 
     * panelu oraz dodanie wczytywania tekstu z 
     * pliku tekstowego
     */
    public Info() 
    {
        area.setLineWrap(true);
        area.setEditable(false);
        area.setBounds(100, 100, 800, 200);
        area.setMargin( new Insets(10,10,10,10));
        area.setWrapStyleWord(true);
        area.setFont(new Font("MonoSpaced", Font.BOLD, 17));
        exit.setBounds(450, 600, 100, 50);
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        try
        {
            area.read(new FileReader("resources/info.txt"),null);
        }
        catch(IOException ioe)
        {}
        add(area);
        add(exit);
        setVisible(true);
    }
}
