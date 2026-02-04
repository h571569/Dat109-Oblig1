package no.hvl.dat109;

public class Spill {
    // private Brett brett;
    private int antallSpillerer;
    private boolean vunnet = false;



    public Spill(int antallSpillerer) {
        this.antallSpillerer = antallSpillerer;
    }

    public void spill() {
        Brikke[] brikker = new Brikke[antallSpillerer];
        for (int x = 0; x < antallSpillerer; x++) {
            brikker[x] = new Brikke(0, x+1);
        }

        while (!vunnet) {
            
            for (int i = 0; i < antallSpillerer && (!vunnet); i++) {
                int sum = Terning.trill();
                if (brikker[i].getPosisjon()+sum < 100) {
                    brikker[i].setPosisjon(brikker[i].getPosisjon()+sum);
                    System.out.println(brikker[i].getBrikkeId()+ " er på rute "+ brikker[i].getPosisjon()+ " og fikk terningkast: " + sum);
                } else if (brikker[i].getPosisjon()+sum == 100) {
                    System.out.println("Brikke: "+ brikker[i].getBrikkeId()+ " Har vunnet!");
                    vunnet = true;
                } else {
                    System.out.println(brikker[i].getBrikkeId()+ " fikk for mye!");
                }
                sum = 0;
            }

        }
    }
}
