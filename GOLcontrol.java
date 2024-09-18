package GameOfLifeGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Kontroller klasse for å binde sammen Verden og GOLview
public class GOLcontrol {
    private Verden verden;
    private GOLview view;
    String[][] statusCeller;

    public GOLcontrol(Verden verden, GOLview view){
        this.verden=verden;
        this.view=view;
        statusCeller=new String[verden.rutenett.antRader][verden.rutenett.antKolonner];
        this.view.settStartKnapp(new startListener());
        this.view.settAvsluttKnapp(new avsluttListener());
    }

    class startListener implements ActionListener{

        Timer timer = new Timer(2000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent x) {
                oppdaterView();
            }
        });

        public void actionPerformed(ActionEvent e){
            if (timer.isRunning()==false) {
                timer.setRepeats(true);
                timer.start();
            }
        }

        public void stoppTimer() {
            if (timer.isRunning()) {
                timer.stop();
            }
        }
    }

    class avsluttListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }

    public void lagRutenett(){
        int rader=verden.rutenett.antRader;
        int kolonner=verden.rutenett.antKolonner;
        view.lagCeller(rader,kolonner);
        settStatusCeller();
        view.skrivCeller(statusCeller,verden.rutenett.antallLevende());
    }

    //Oppdaterer først rutene i modellen, og deretter i gui vinduet
    public void oppdaterView(){
        verden.oppdatering();
        settStatusCeller();
        view.skrivCeller(statusCeller,verden.rutenett.antallLevende());
    }

    public void settStatusCeller(){
        for (int i = 0; i < verden.rutenett.rutene.length; i++) {
            for (int j = 0; j < verden.rutenett.rutene[i].length; j++) {
                if(verden.rutenett.rutene[i][j].erLevende()){
                    statusCeller[i][j]="*";
                } else {
                    statusCeller[i][j]=" ";
                }
            }
        }
    }
}