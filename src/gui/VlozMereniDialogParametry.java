
package gui;

import java.time.LocalDateTime;
import mereni.TypSenzoruEnum;

/**
 *
 * @author Tomáš Vondra
 */
public class VlozMereniDialogParametry {
    
    private int idSenzoru;
    private TypSenzoruEnum typ;
    private LocalDateTime casMereni;
    private int spotreba;

    public int getIdSenzoru() {
        return idSenzoru;
    }

    public void setIdSenzoru(int idSenzoru) {
        this.idSenzoru = idSenzoru;
    }

    public TypSenzoruEnum getTyp() {
        return typ;
    }

    public void setTyp(TypSenzoruEnum typ) {
        this.typ = typ;
    }

    public LocalDateTime getCasMereni() {
        return casMereni;
    }

    public void setCasMereni(LocalDateTime casMereni) {
        this.casMereni = casMereni;
    }

    public int getSpotreba() {
        return spotreba;
    }

    public void setSpotreba(int spotreba) {
        this.spotreba = spotreba;
    }
    
    

    public VlozMereniDialogParametry(int idSenzoru, TypSenzoruEnum typ, LocalDateTime casMereni,
            int spotreba) {
        this.idSenzoru = idSenzoru;
        this.typ = typ;
        this.casMereni = casMereni;
        this.spotreba = spotreba;
    }

}
