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
public class MenuPanel extends JPanel 
{
    JButton newgame = new JButton("Nowa Gra");
    /** utworzenie przycisku uruchamiającego nową grę*/
    JButton resume = new JButton("Powrot");
    /** utworzenie przycisku wracającego do gry */
    JButton exit = new JButton("Wyjscie");
    /** utworzenie przycisku zamykającego program*/
    JButton results = new JButton("Wyniki");
    /** utworzenie przycisku pokazującego wyniki */
    JButton nextlvl = new JButton("Następny poziom");
    /** utworzenie przycisku uruchomiającego następny poziom*/
    JLabel label = new JLabel("MENU");
    /** utworzenie napisu MENU */
    JButton info = new JButton("Info");
    /** utworzenie przycisku otwierającego ciekawostki*/
    JLabel end = new JLabel("Koniec Gry! Straciłeś wszystkie życia, aby wrócić do gry wćisnij Nowa Gra");
    /** utworzenie napisu o przegranej*/
    
    /** Konstruktor - tworzenie panelu Menu
     * ustawienie lokalizacji przycisków i napisów, 
     * ustawienie ich [arametrów oraz dodanie wszystkich 
     * elementów do panelu
     */
    public MenuPanel()
    {
        setLayout(null);
        setBackground(Color.DARK_GRAY);
        end.setFont(new Font("MonoSpaced", Font.BOLD, 15));
        end.setForeground(Color.WHITE);
        end.setBounds(150, 100, 1000, 100);
        newgame.setBounds(415, 200, 200, 50);
        resume.setBounds(415, 300, 200, 50);
        exit.setBounds(415, 600, 200, 50);
        results.setBounds(415, 400, 200, 50);
        nextlvl.setBounds(415, 500, 200, 50);
        info.setBounds(900, 10, 100, 50 );
        label.setBounds(455, 50, 300, 72);
        label.setForeground(Color.white);
        label.setFont(new Font("MonoSpaced", Font.BOLD, 48));
        end.setVisible(false);
        add(end);
        add(info);
        add(newgame);
        add(resume);
        add(exit);
        add(results);
        add(label);
        add(nextlvl);
        setVisible(true);    
    }
}
