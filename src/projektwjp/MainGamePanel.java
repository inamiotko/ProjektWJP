/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektwjp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author iganamiotko
 */
public class MainGamePanel extends JFrame implements ActionListener
{
    Boolean skok = false;
     /** zmienna opisująca stan skoku */ 
    int jumpHeight;
     /** zmienna przechowująca wartość przeskakiwaną */
    int timer2Delay;
     /** wartość interwału timera */
    Timer timer2; 
     /** timer obsługujący skok rakiety */
    boolean jump;
     /** zmienna opisująca stan skoku */ 
    boolean jumpDir = false;
    /** zmienna opisująca stan skoku */ 
    GuiComponents p;
    /** stworzenie obiektu klasy GuiComponents */
    MenuPanel m;
    /** stworzenie obiektu klasy MenuPanel */
    Results r;
    /** stworzenie obiektu klasy Results */
    NewGame ng;
    /** stworzenie obiektu klasy NewGame */
    Info in;
    /** stworzenie obiektu klasy Info */
    int licznik = 0;
    /** stworzenie zmiennej przechowującej ilość uzbieranych punktów */
    int lvl;
    /** zmienna przechowująca numery poziomów */
    
    /** Konstruktor - dodanie wszystkich paneli i elementów do okna,
     * ustawienie wielkosci i szerokosci okna i paneli
     * ustawienie opóżnienia timera
     * obsługa wszystkich przycisków gry
     */
    public MainGamePanel()
    { 
        timer2Delay = 18;
        timer2 = new Timer(timer2Delay, this);
        ng = new NewGame();
        p = new GuiComponents(this);
        m = new MenuPanel();
        in = new Info();
        r = new Results(this);
        lvl = 1;
        setLayout(null);
        add(m);
        add(p);
        add(r);
        add(ng);
        add(in);
        m.setBounds(0,0,1024,768);
        p.setBounds(0,0,1024,768);
        r.setBounds(0,0,1024,768);
        ng.setBounds(0,0,1024,768);
        in.setBounds(0,0,1024,768);
        in.setVisible(false);
        m.setVisible(false);
        p.setVisible(true);
        r.setVisible(false);
        ng.setVisible(false);
        pack();
        setSize(1024, 768);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Kosmiczne Porządki");
        
        
        m.resume.addActionListener(new ActionListener() //przycisk powrót w menu
        {
            public void actionPerformed(ActionEvent event) 
            {
                if(p.life > 0)
                {
                    p.setVisible(true);
                    m.setVisible(false);
                    r.setVisible(false);
                    in.setVisible(false);
                }
                else
                {
                    p.setVisible(false);
                    m.setVisible(true);
                    r.setVisible(false);     
                    in.setVisible(false);
                }
            }
        });
        m.exit.addActionListener(new ActionListener() // przycisk wyjście w menu
        {
            public void actionPerformed(ActionEvent event) 
            {
                System.exit(0);
            }
        });
        m.results.addActionListener(new ActionListener() // przycisk wyniki w menu
        {
            public void actionPerformed(ActionEvent event) 
            {
                r.setVisible(true);
                p.setVisible(false);
                m.setVisible(false);
                in.setVisible(false);
                r.updatepoints();
            }
        });
        r.returnr.addActionListener(new ActionListener() // przycisk powrót w panelu Results
        {
           public void actionPerformed(ActionEvent event) 
            {
                r.setVisible(false);
                p.setVisible(false);
                m.setVisible(true);
                in.setVisible(false);
            } 
        });
        m.newgame.addActionListener(new ActionListener() // przycisk Nowa Gra w Menu
        {
            public void actionPerformed(ActionEvent event) 
            {
                ng.setVisible(true);
                p.setVisible(false);
                m.setVisible(false);
                r.setVisible(false);
                in.setVisible(false);
                
            }
        });
        ng.start.addActionListener(new ActionListener() // przycisk start w panelu NewGame
        {
            public void actionPerformed(ActionEvent event) 
            { 
                ng.setVisible(false);
                p.setVisible(true);
                m.setVisible(false);
                in.setVisible(false);
                r.setVisible(false);
                p.revalidate();
                p.life = 5;
                licznik = 0;
                lvl = 1;
                timer2Delay = 18;
                p.timerDelay = 100; 
                timer2.setDelay(timer2Delay);
                p.timer.setDelay(p.timerDelay);
                p.timer.start();
            }
        });
        m.nextlvl.addActionListener(new ActionListener() // przycisk Następny Poziom w Menu
        {
            public void actionPerformed(ActionEvent event) 
            {
               
                lvl = 2;
                p.timerDelay = 50;
                timer2Delay = 9;
                p.timer.setDelay(p.timerDelay);
                timer2.setDelay(timer2Delay);
                p.timer.start();
                p.pasresume.setVisible(false);
                p.pause.setVisible(true);
                m.setVisible(false);
                ng.setVisible(false);
                r.setVisible(false);
                in.setVisible(false);
                p.revalidate();
                p.setVisible(true);
                if(p.life==0)
                {
                m.setVisible(true);
                ng.setVisible(false);
                r.setVisible(false);
                in.setVisible(false);
                p.setVisible(false);
                }
            }
        });
        m.info.addActionListener(new ActionListener()   // przycisk info w Menu
        {
            public void actionPerformed(ActionEvent event) 
            {
                in.setVisible(true);
                p.setVisible(false);
                m.setVisible(false);
                r.setVisible(false);
                ng.setVisible(false);
            }
        });
        in.exit.addActionListener(new ActionListener() // przycisk Powrót w panelu Info
        {
            public void actionPerformed(ActionEvent event) 
            {
                in.setVisible(false);
                r.setVisible(false);
                p.setVisible(false);
                m.setVisible(true);
                ng.setVisible(false);
            }
        });
        p.pause.addActionListener(new ActionListener() // przycisk pauza w głównym oknie gry
        {
            public void actionPerformed(ActionEvent event) 
            {
               p.timer.stop();
               p.pasresume.setVisible(true);
               p.pause.setVisible(false);
            }
        });
        p.pasresume.addActionListener(new ActionListener() // przycisk wznów w głównym oknie gry
        {
            public void actionPerformed(ActionEvent event) 
            {
               p.timer.start();
               p.pasresume.setVisible(false);
               p.pause.setVisible(true);
            }
        });
        
        p.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                int y = e.getY();
                int x = e.getX();
                if((x>=0 && x<=p.RTCrocket.x + p.Widthrocket) && (y>=p.RTCrocket.y && y<=p.RTCrocket.y + 85) && !jump)
                {
                    jumpHeight = 0;
                    jump = true;
                    timer2.start();
                } 
                if((x>=920 && x<=1002) && (y>=50 && y<=90))
                {  
                   m.end.setVisible(false);
                   p.timer.stop();
                   p.setVisible(false);
                   m.setVisible(true);
                   ng.setVisible(false);
                   in.setVisible(false);
                   r.setVisible(false);
                }
           }
       });   
    }
    /** Metoda obsługi ruchu rakietu po przyciśnięciu myszki
     * przy przeskoczeniu przeszkody licznik zwiększa się o 1
     * @param e zdarzenie wywołujące animacje skoku rakiety
     */
    public void actionPerformed(ActionEvent e)  
    {
        if(jumpHeight<=100 && !jumpDir)jumpHeight+=3;
        else 
        {
            jumpDir = true;
            jumpHeight -= 3;
        }
        
        p.ry = 600-jumpHeight;
        
        if(jumpHeight<=0)
        {
            timer2.stop();
            jump = false;
            jumpDir = false;
            skok = true;
        }
        if(p.rx >= p.sx+p.Widthsatellite && jumpHeight<=0 || p.rx >= p.mx+p.Widthmeteorite && jumpHeight<=0 || p.rx >= p.kx+p.Widthrocks + 20  && jumpHeight<=0 || p.rx >= p.kx2+p.Widthrocks  && jumpHeight<=0 || p.rx >= p.sx2+p.Widthsatellite  && jumpHeight<=0) 
        {
            licznik++;
        } 
    }
    /** Funkcja uruchamiająca 2 poziom
     * po osiągnięciu konkretnej ilości 
     * punktów
     */
    public void pointsnxtlvl()
    {
        if(licznik >= 10 && lvl == 1)
        {
            lvl = 2;
            p.timerDelay = 50;
            timer2Delay = 9;
            p.revalidate();
            p.timer.setDelay(p.timerDelay);
            timer2.setDelay(timer2Delay);
            m.setVisible(false);
            ng.setVisible(false);
            r.setVisible(false);
            p.setVisible(true);
            in.setVisible(false);
        }
    }
}


