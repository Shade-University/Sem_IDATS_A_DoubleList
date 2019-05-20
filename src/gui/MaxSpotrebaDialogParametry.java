
package gui;

import java.time.LocalDateTime;

/**
 *
 * @author Tomáš Vondra
 */
public class MaxSpotrebaDialogParametry {
    
    private int idSenzor;
    private LocalDateTime odDatum;
    private LocalDateTime doDatum;

    public int getIdSenzor() {
        return idSenzor;
    }

    public void setIdSenzor(int idSenzor) {
        this.idSenzor = idSenzor;
    }

    public LocalDateTime getOdDatum() {
        return odDatum;
    }

    public void setOdDatum(LocalDateTime odDatum) {
        this.odDatum = odDatum;
    }

    public LocalDateTime getDoDatum() {
        return doDatum;
    }

    public void setDoDatum(LocalDateTime doDatum) {
        this.doDatum = doDatum;
    }

    public MaxSpotrebaDialogParametry(int idSenzor, LocalDateTime odDatum, LocalDateTime doDatum) {
        this.idSenzor = idSenzor;
        this.odDatum = odDatum;
        this.doDatum = doDatum;
    }

}
