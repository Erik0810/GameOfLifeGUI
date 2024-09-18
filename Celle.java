package GameOfLifeGUI;

//Cellene som inngår i rutenettet
public class Celle {
    
    Boolean status;
    Celle[] naboer;
    int antNaboer;
    int antLevendeNaboer;

public Celle(){
    status = false;
    naboer=new Celle[8];
    antNaboer=0;
    antLevendeNaboer=0;
}

public void settDoed(){
    status=false;
}

public void settLevende(){
    status=true;
}

public Boolean erLevende(){
    return status;
}

public char hentStatusTegn(){
    if(status==true){
        return 'O';
    } else{
        return '.';
    }
}

public void leggTilNabo(Celle nabo){
    naboer[antNaboer]=nabo;
    antNaboer+=1;
}

public int tellLevendeNaboer(){
    antLevendeNaboer=0;
    for(int x =0;x<naboer.length;x++){
        if(naboer[x]!=null){
            if(naboer[x].erLevende()){
                antLevendeNaboer+=1;
        }
        }
    }
    return antLevendeNaboer;
}

public void oppdaterStatus(){
    if(status){
        if(antLevendeNaboer>2){
            status=false;
        } if(antLevendeNaboer==2||antLevendeNaboer==3){
            status=true;
        } else{
            status=false;
        }
    } else{
        if(antLevendeNaboer==3){
            status=true;
        }
    }
}
}
