package mereni;

import java.time.LocalDateTime;

/**
 *
 * @author Tomáš Vondra
 */
public class MereniElektrika extends Mereni {
    
    private double spotrebaNT;
    private double spotrebaVT;

    public double getSpotrebaNT() {
        return spotrebaNT;
    }

    public void setSpotrebaNT(double spotrebaNT) {
        this.spotrebaNT = spotrebaNT;
    }

    public double getSpotrebaVT() {
        return spotrebaVT;
    }

    public void setSpotrebaVT(double spotrebaVT) {
        this.spotrebaVT = spotrebaVT;
    }

    public MereniElektrika(double spotrebaNT, double spotrebaVT,
            int idSenzor, LocalDateTime casMereni) {
        super(idSenzor, TypSenzoruEnum.ELEKTRIKA, casMereni);
        this.spotrebaNT = spotrebaNT;
        this.spotrebaVT = spotrebaVT;
    }

    @Override
    public String toString() {
        return super.toString() + " [Spotřeba: " + spotrebaNT + "NT, " + spotrebaVT + "VT]";
    }
    
    

}
