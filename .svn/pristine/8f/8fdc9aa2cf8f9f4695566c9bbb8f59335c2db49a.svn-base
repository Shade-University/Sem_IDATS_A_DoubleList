package mereni;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Tomáš Vondra
 */
public abstract class Mereni implements Serializable {

    private static final long serialVersionUID = 1L;

    protected final int idSenzor;
    protected final TypSenzoruEnum typSenzoru;
    protected final LocalDateTime casMereni;

    public Mereni(int idSenzor, TypSenzoruEnum typSenzoru, LocalDateTime casMereni) {
        this.idSenzor = idSenzor;
        this.typSenzoru = typSenzoru;
        this.casMereni = casMereni;
    }

    @Override
    public String toString() {

        String formatDateTime = casMereni.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH"));
        return "Mereni{" + "idSenzor=" + idSenzor + ", typSenzoru=" + typSenzoru + ", casMereni=" + formatDateTime + '}';
    }

}
