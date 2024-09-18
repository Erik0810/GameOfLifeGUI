package GameOfLifeGUI;

//Implementasjon av rutenettet brukt av Verden
public class Rutenett {
    int antRader;
    int antKolonner;
    Celle[][] rutene;

    public Rutenett(int rader, int kolonner){
        antRader=rader;
        antKolonner=kolonner;
        rutene = new Celle[rader][kolonner];
    }

    public void lagCelle(int rad,int kol){
        Celle cellen= new Celle();
        if(Math.random()<=0.3333){
            cellen.settLevende();
        }
        rutene[rad][kol]=cellen;
    }
    
    public void fyllMedTilfeldigeCeller(){
        for(int x=0;x<rutene.length;x++){
            for(int y=0;y<rutene[x].length;y++){
                lagCelle(x,y);
            }
        }
    }

    public Celle hentCelle(int rad, int kol){
        if(rad<rutene.length&&rad>=0){
            if(kol<rutene[rad].length&&kol>=0){
                return rutene[rad][kol];
            }
        }
        return null;
    }

    //Kode for å skrive ut rutenettet og cellenes status i terminal. pre-gui
    public void tegnRutenett(){
        for(int x=0;x<10;x++){
            System.out.println(" ");
        }
        for(int x=0;x<rutene.length;x++){
            System.out.println("");
            System.out.print("+");
            for(int z=0;z<rutene[x].length;z++){
                System.out.print("---+");
            } 
            System.out.println("");
            for(int y=0;y<rutene[x].length;y++){
                System.out.print("| "+rutene[x][y].hentStatusTegn()+" ");
            }
            System.out.print("|");
        }
        System.out.println("");
        System.out.print("+");
        for(int z=0;z<antKolonner;z++){
            System.out.print("---+");
        }
        System.out.println(" "); 
    }

    public void settNaboer(int rad, int kol){
        if(hentCelle(rad-1,kol-1)!=null){
            rutene[rad][kol].leggTilNabo(rutene[rad-1][kol-1]);
        }
        if(hentCelle(rad-1,kol)!=null){
            rutene[rad][kol].leggTilNabo(rutene[rad-1][kol]);
        }
        if(hentCelle(rad-1,kol+1)!=null){
            rutene[rad][kol].leggTilNabo(rutene[rad-1][kol+1]);
        }
        if(hentCelle(rad,kol-1)!=null){
            rutene[rad][kol].leggTilNabo(rutene[rad][kol-1]);
        }
        if(hentCelle(rad,kol+1)!=null){
            rutene[rad][kol].leggTilNabo(rutene[rad][kol+1]);
        }
        if(hentCelle(rad+1,kol-1)!=null){
            rutene[rad][kol].leggTilNabo(rutene[rad+1][kol-1]);
        }
        if(hentCelle(rad+1,kol)!=null){
            rutene[rad][kol].leggTilNabo(rutene[rad+1][kol]);
        }
        if(hentCelle(rad+1,kol+1)!=null){
            rutene[rad][kol].leggTilNabo(rutene[rad+1][kol+1]);
        }
    }

    //Oppdaterer naboene til hver enkelt celle
    public void kobleAlleCeller(){
        for(int x=0;x<rutene.length;x++){
            for(int y=0;y<rutene[x].length;y++){
                settNaboer(x, y);
            }
        }
    }

    public int antallLevende(){
        int teller=0;
        for(int x=0;x<rutene.length;x++){
            for(int y=0;y<rutene[x].length;y++){
                if(rutene[x][y].erLevende()){
                    teller+=1;
                }
            }
        }
        return teller;
    }

    //Iterer over en nøstet for løkke 2 ganger for å først oppdatere antallet levende naboer og deretter statusen basert på det
    public void oppdateringLevende(){
        for(int x=0;x<rutene.length;x++){
            for(int y=0;y<rutene[x].length;y++){
                rutene[x][y].tellLevendeNaboer();
            }
        }
        for(int x=0;x<rutene.length;x++){
            for(int y=0;y<rutene[x].length;y++){
                rutene[x][y].oppdaterStatus();
            }
        }
    }
}