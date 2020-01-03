/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektwjp;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author iganamiotko
 */
public class Results extends JPanel
{
    JLabel resultr = new JLabel();
    /** utworzenie napisu wyświetlającego wynik */
    JButton returnr = new JButton("powrót");
    /** utworzenie przycisku wracającego do menu */
    MainGamePanel parent;
    /** odwołanie do klasy nadrzędnej */
    
    /** Konstruktor - umiejscownienie elementów panelu,
     * dodanie ich do panelu
     * @param p obiekt klasy MainGamePanel
     */
    public Results(MainGamePanel p)
    {
        parent = p;
        setLayout(null);
        setBackground(Color.GRAY);
        returnr.setBounds(415, 300, 200, 50);
        resultr.setBounds(345, 100,1000,300);
        resultr.setForeground(Color.white);
        resultr.setFont(new Font("MonoSpaced", Font.BOLD, 18));
        add(resultr);
        add(returnr);
        setVisible(true);
    } 
    /**  Metoda odpowiedzialna za wypisanie 
     *  właściwej wartości punktów w labelu 
     */
    public void updatepoints()
    {
        resultr.setText("Twoj obecnie uzyskany wynik to: " + parent.licznik);
    }
}
