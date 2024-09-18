package GameOfLifeGUI;

import java.awt.*;
import javax.swing.*;

import GameOfLifeGUI.GOLcontrol.avsluttListener;
import GameOfLifeGUI.GOLcontrol.startListener;

public class GOLview {
    JFrame vindu = new JFrame("Game of life");
    JPanel topPanel;
    JPanel botPanel;
    JButton start = new JButton("Start");
    JButton avslutt = new JButton("Avslutt");
    JLabel antLevende = new JLabel("Antall levende: ");
    JLabel levendeTall = new JLabel();
    JButton[][] celleListe;

    //Oppretter et standard gui vindu
    GOLview(){
        
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setPreferredSize(new Dimension(600,400));
        vindu.setLocationRelativeTo(null);
        vindu.setLayout(new BoxLayout(vindu.getContentPane(), BoxLayout.Y_AXIS));
        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }
        
        topPanel = new JPanel();
        topPanel.add(antLevende);
        topPanel.add(levendeTall);
        topPanel.add(start);
        topPanel.add(avslutt);
        
        botPanel = new JPanel();
        

        vindu.add(topPanel);
        vindu.add(botPanel);
        vindu.pack();
        vindu.setVisible(true);
    }

    public void settStartKnapp(startListener funksjon){
        start.addActionListener(funksjon);
    }

    public void settAvsluttKnapp(avsluttListener funksjon){
        avslutt.addActionListener(funksjon);
    }

    public void lagCeller(int rader, int kolonner){
        celleListe = new JButton[rader][kolonner];
        for(int x=0;x<rader;x++){
            for(int y=0;y<kolonner;y++){
                celleListe[x][y]=new JButton();
            }
        }
        botPanel.setLayout(new GridLayout(rader,kolonner));
        for (int i = 0; i < celleListe.length; i++) {
            for (int j = 0; j < celleListe[i].length; j++) {
                botPanel.add(celleListe[i][j]);
            }
        }
    }

    public void skrivCeller(String[][] celleStatus, int antLevendeCeller){
        for (int i = 0; i < celleStatus.length; i++) {
            for (int j = 0; j < celleStatus[i].length; j++) {
                celleListe[i][j].setText(celleStatus[i][j]);
            }
        }
        levendeTall.setText(String.valueOf(antLevendeCeller));
    }

    
}
