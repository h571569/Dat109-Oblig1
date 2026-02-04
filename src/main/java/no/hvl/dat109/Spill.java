package no.hvl.dat109;

public class Spill {
    private Terning terning;
    private Brett brett;
    private int antallSpillerer;
    private boolean vunnet;


    public Spill(Terning terning, Brett brett, int antallSpillerer) {
        this.terning = terning;
        this.brett = brett;
        this.antallSpillerer = antallSpillerer;
    }

    public void spill() {
        
        while (!vunnet) {
            
            for (int i = 1; i < antallSpillerer+1; i++) {
                
            }

        }
    }
}
