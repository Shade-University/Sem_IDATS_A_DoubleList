package mereni;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Random;
import kolekce.AbstrDoubleList;
import kolekce.DoubleList;

/**
 *
 * @author Tomáš Vondra
 */
public class MereniGenerator {

    private static final int HODINOVYINTERVAL = 1;

    public static Iterator<Mereni> generuj(LocalDateTime datumOd,
            LocalDateTime datumDo,
            TypSenzoruEnum typ, int idSenzoru) {
        
        DoubleList<Mereni> temp = new AbstrDoubleList<>();

        while (!datumOd.equals(datumDo)) {
            Mereni m = typ == TypSenzoruEnum.ELEKTRIKA ?
                    generujMereniElektriny(idSenzoru, datumOd) :
                    generujMereniVoda(idSenzoru, datumOd);
            temp.vlozPosledni(m);
            
            datumOd = datumOd.plusHours(HODINOVYINTERVAL);
        } //Generuje dokud datumOd nenabyde stejné hodnoty jako datum do
        
        return temp.iterator();

    }

    private static MereniElektrika generujMereniElektriny(int idSenzoru,
            LocalDateTime casMereni) {
        
        return new MereniElektrika(
                getRandom(20, 10),
                getRandom(30, 20),
                idSenzoru,
                casMereni               
        );
    }
    
    private static MereniVoda generujMereniVoda(int idSenzoru,
            LocalDateTime casMereni) {

        return new MereniVoda(
                getRandom(20, 10),
                idSenzoru,
                casMereni               
        );
    }

    private static int getRandom(int max, int min) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    } //Pomocná na vrácení random čísla v rozmezí

}
