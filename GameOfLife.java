package GameOfLifeGUI;

//Hovedprogram
public class GameOfLife {
    public static void main(String[] args) {
        GOLview view = new GOLview();
        Verden model = new Verden(10,10);
        GOLcontrol controller = new GOLcontrol(model,view);
        controller.lagRutenett();
    }
}
