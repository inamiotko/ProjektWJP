/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektwjp;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author iganamiotko
 */
public class GuiComponents extends JPanel implements ActionListener{
    int sx;
    /** wspolrzedna x polozenia satelity 1 */
    int kx;
     /** wspolrzedna x polozenia kamieni */
    int mx;
     /** wspolrzedna x polozenia meteorytu */
    int ry;
     /** wspolrzedna y polozenia rakiety */
    int rx;
     /** wspolrzedna x polozenia rakiety */
    int kx2;
     /** wspolrzedna x polozenia kamieni 2 */
    int sx2;
     /** wspolrzedna x polozenia satelity 2 */
    int timerDelay;
     /** wartość interwału czasowego timera odpowiedzialnego za poruszanie przeszkód */
    boolean smove;
     /** zmienna okreslajaca ruch satelity 1 */
    boolean kmove2;
     /** zmienna okreslajaca ruch kamieni 2 */
    boolean mmove;
     /** zmienna okreslajaca ruch meteorytu */
    boolean kmove;
     /** zmienna okreslajaca ruch kamieni 1 */
    boolean smove2;
     /** zmienna okreslajaca ruch satelity 2 */
    BufferedImage satellite;
     /** obraz satelity - jednej z przeszkód */
    BufferedImage meteorite;
     /** obraz meteorytu - jednej z przeszkód */
    BufferedImage rocks;
     /** obraz kamieni - jednej z przeszkód */
    BufferedImage rocket;
    /** obraz rakiety - symbolizuje gracza */
    BufferedImage menu;
    /** obraz menu - w górnym prawym rogu */
    BufferedImage bgImage1;
    /** obraz tła w 1 poziomie */
    BufferedImage bgImage2;
    /** obraz tła w 2 poziomie */
    Rectangle rocketBounds;
    /** prostokąt pokrywający granice rakiety */
    Rectangle satelliteBounds;
    /** prostokąt pokrywający granice satelity */
    Rectangle meteoriteBounds;
    /** prostokąt pokrywający granice meteorytu */
    Rectangle rocksBounds;
    /** prostokąt pokrywający granice kamienii */
    Point LTCsatellite;
    /** punkt opisujący lewy górny róg satelity */
    Point RTCrocket;
     /** punkt opisujący prawy górny róg rakiety */
    Point LTCmeteorite;
     /** punkt opisujący lewy górny róg meteorytu */
    Point LTCrocks;
     /** punkt opisujący lewy górny róg kamieni */
    Timer timer;
     /** timer obsługujący zdarzenia poruszania przeszkodami */
    int life;
     /** zmienna przechowująca zycia */
    int Widthrocket;
     /** zmienna przechowująca szerokość prostokątu pokrywającego rakiete */
    int Widthsatellite;
    /** zmienna przechowująca szerokość prostokątu pokrywającego satelite */
    int Widthrocks;
    /** zmienna przechowująca szerokość prostokątu pokrywającego kamienie */
    int Widthmeteorite;
    /** zmienna przechowująca szerokość prostokątu pokrywającego meteoryt */
    MainGamePanel parent;
    /** odwolanie się do klasy nadrzędnej */
    JLabel lives = new JLabel();
    /** utworzenie napisu pokazującego ilosc pozostałych zyc */
    JButton pause = new JButton();
    /** utworzenie przycisku pauzującego */
    JButton pasresume = new JButton();
    /** utworzenie przycisku powracającego do gry po pauzie */
   
    /** Konstruktor - wczytanie obrazków, ustawienie parametrów początkowych obiektów
     *  uruchomienie timera i ustawienie jego parametrów
     * @param p obiekt klasy MainGamePanel
     */ 
    public GuiComponents(MainGamePanel p) 
    {
        life = 5;
        timerDelay = 100;
        timer = new Timer(timerDelay, this);
        parent = p;
        sx = 1200;
        kx = 800;
        mx = 250;
        ry = 600;
        rx = 0;
        kx2 = 1400;
        sx2 = 1600;
        timer.start();
        try 
        {
            bgImage1 = ImageIO.read(new File("resources/kosmos.jpg"));
            bgImage2 = ImageIO.read(new File("resources/kosmos2.jpg"));
            satellite = ImageIO.read(new File("resources/satelita.png"));
            meteorite = ImageIO.read(new File("resources/meteoryt.png"));
            rocks = ImageIO.read(new File("resources/kamienie.png"));
            rocket = ImageIO.read(new File("resources/rakieta.png"));
            menu = ImageIO.read(new File("resources/menu.png"));

            rocketBounds = new Rectangle();
            satelliteBounds = new Rectangle();
            meteoriteBounds = new Rectangle();
            rocksBounds = new Rectangle();

            LTCsatellite = satelliteBounds.getLocation();
            RTCrocket = rocketBounds.getLocation();
            LTCmeteorite = meteoriteBounds.getLocation();
            LTCrocks = rocksBounds.getLocation();
            
            Widthsatellite = satelliteBounds.width;
            Widthrocks = rocksBounds.width;
            Widthmeteorite = meteoriteBounds.width;
            Widthrocket = rocketBounds.width;
        } 
        catch (IOException ex) {}
        setOpaque(false);
        lives.setBounds(300, 200, 500, 50);
        lives.setForeground(Color.WHITE);
        pause.setBounds(10,20,100,50);
        pause.setText("PAUZA");
        pasresume.setBounds(10,100,100,50);
        pasresume.setText("WZNÓW");
        add(pasresume);
        pasresume.setVisible(false);
        add(pause);
        add(lives);
    }
    /** Metoda rysowania grafiki */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(parent.lvl == 1)
        g2d.drawImage(bgImage1,0,0,null );
        if(parent.lvl == 2)
        g2d.drawImage(bgImage2,0,0,null );
        g2d.drawImage(satellite, sx, 630, null);
        g2d.drawImage(rocks, kx, 635, null);
        g2d.drawImage(rocks, kx2, 635, null);
        g2d.drawImage(meteorite, mx, 632, null);
        g2d.drawImage(satellite, sx2, 630, null);
        g2d.drawImage(rocket, rx, ry, null);
        g2d.drawImage(menu, 920 , 50 , null); 
        
        LTCsatellite.setLocation(sx, 630);
        RTCrocket.setLocation(rx+95,ry);
        LTCmeteorite.setLocation(mx,632);
        LTCrocks.setLocation(kx,635);
    }   
    /** Główna pętla gry - animacja przeszkód
     * ustawianie nowych współrzędnych przeszkód
     * wywoływanie pozostałych funkcji kontrolujacych gre
     * @param e zdarzenie wywołujące metode poruszania przeszkodami
     */
    @Override
    public void actionPerformed(ActionEvent e)  
    {
        
        if(sx >= 300) smove = true;
        if (sx <= -50) smove = false;

        if(smove) sx-=10;
        else sx = 1030;

        if(kx >= 500) kmove = true;
        if (kx <= -50) kmove = false;

        if(kmove) kx-=10;
        else kx = 1030;

        if(mx >= 800) mmove = true;
        if (mx <= -50) mmove = false;

        if(mmove) mx-=10;
        else mx = 1030;
        
        if(kx2 >= 100) kmove2 = true;
        if (kx2 <= -50) kmove2 = false;
        
        if(kmove2) kx2-=10;
        else kx2 = 1030;
        
        if(sx2 >= 100) smove2 = true;
        if (sx2 <= -50) smove2 = false;
        
        if(smove2) sx2-=10;
        else sx2 = 1030;
      
        repaint();
        hits();
        parent.pointsnxtlvl();
        nroflives();
        endGame();
    }    
    /** Funkcja liczenia uderzeń rakiety w przeszkody
     * 
     */

    protected void hits()
    {
        if((Math.abs(sx - (rx + 50))<=7)&& (!parent.jump))
        {
            life--;
        } 
        if((Math.abs(kx - (rx + 50))<=5) && (!parent.jump))
        {
            life--;
        }
         if((Math.abs(mx - (rx + 50))<=5) && (!parent.jump))
        {
            life--;
        }
        if((Math.abs(kx2 - (rx + 50))<=5) && (!parent.jump))
        {
            life--;
        }
        if((Math.abs(sx2 - (rx + 50))<=7) && (!parent.jump))
        {
            life--;
        }
    }
    /** Funkcja wypisywania aktualnej 
     * ilości żyć w labelu w górnej części ekranu gry
     */
    public void nroflives()
    {   
        lives.setText("Twoja aktualna ilość żyć wynosi: "+ life);
        lives.setFont(new Font("MonoSpaced", Font.BOLD, 15));
        if(life <= 3)lives.setForeground(Color.red);
        if(life>3)lives.setForeground(Color.white);
    }
    /** Funkcja kończąca grę
     * w przypadku 0 ilości żyć
     */
    public void endGame()
    {
        if(life == 0)
        {
            parent.m.end.setVisible(true);
            timer.stop();
            setVisible(false);
            parent.m.setVisible(true);
        }
    }
}
