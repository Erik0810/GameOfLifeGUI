package GameOfLifeGUI;

//Dette er modellen som holder på dataen relatert til rutenettet og rutenes status
public class Verden {

    Rutenett rutenett;
    int genNr;

    //Kall på rutenett for å initialisere oppsettet av cellene
    public Verden(int rader, int kolonner){
        rutenett = new Rutenett(rader, kolonner);
        genNr=0;
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }
    
    //Kode for å skrive ut rutenettet og cellenes status i terminal. pre-gui
    public void tegn(){
        rutenett.tegnRutenett();
        System.out.println("Dette er generasjon nummer: "+genNr);
        System.out.println("Det er: "+rutenett.antallLevende()+" levende celler");
    }
    
    //Lager en egen metode i rutenettklassen kalt oppdateringLevende for å sjekke hver enkel celle
    public void oppdatering(){
        rutenett.oppdateringLevende();
        genNr+=1;
    }
}
