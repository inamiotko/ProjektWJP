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
public class NewGame extends JPanel
{
    JButton start = new JButton("START");
    /** utworzenie przycisku rozpoczynającego grę */
    JLabel howto = new JLabel();
    /** utworzenie napisu mowiącego o wciśnięciu START */
    
    /** Konstruktor - stworzenie elementów,
     * ustawienie ich parametrów i dodanie
     * ich do panelu
     */
    protected NewGame()
    {
        setLayout(null);
        setBackground(Color.GRAY);
        start.setBounds(415, 300, 200, 50);
        howto.setBounds(345, 100,1000,300);
        howto.setText("Aby rozpocząć nową grę wciśnij start...");
        howto.setForeground(Color.white);
        howto.setFont(new Font("MonoSpaced", Font.BOLD, 18));
        add(start);
        add(howto);
        setVisible(true);  
    }  
}
