package mereni;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kolekce.AbstrDoubleList;
import kolekce.DoubleList;
import kolekce.KolekceException;

/**
 *
 * @author Tomáš Vondra
 */
public class SpravceMereni implements Iterable<Mereni> {

    private final DoubleList<Mereni> mereniList;

    public SpravceMereni() {
        mereniList = new AbstrDoubleList<>();
    }

    public void vlozMereni(Mereni mereni, PoziceEnum pozice) throws KolekceException {
        switch (pozice) {
            case PRVNI:
                mereniList.vlozPrvni(mereni);
                break;
            case POSLEDNI:
                mereniList.vlozPosledni(mereni);
                break;
            case PREDCHUDCE:
                mereniList.vlozPredchudce(mereni);
                break;
            case NASLEDNIK:
                mereniList.vlozNaslednika(mereni);
                break;
            default:
                throw new AssertionError();
        }

    }

    public Mereni zpristupniMereni(PoziceEnum pozice) throws NoSuchElementException, KolekceException {

        Mereni output = null;
        switch (pozice) {
            case PRVNI:
                output = mereniList.zpristupniPrvni();
                break;
            case POSLEDNI:
                output = mereniList.zpristupniPosledni();
                break;
            case PREDCHUDCE:
                output = mereniList.zpristupniPredchudce();
                break;
            case NASLEDNIK:
                output = mereniList.zpristupniNaslednika();
                break;
            case AKTUALNI:
                output = mereniList.zpristupniAktualni();
                break;
            default:
                throw new AssertionError();
        }
        return output;
    }

    public Mereni odeberMereni(PoziceEnum pozice) throws KolekceException {
        Mereni output = null;
        switch (pozice) {
            case PRVNI:
                output = mereniList.odeberPrvni();
                break;
            case POSLEDNI:
                output = mereniList.odeberPosledni();
                break;
            case PREDCHUDCE:
                output = mereniList.odeberPredchudce();
                break;
            case NASLEDNIK:
                output = mereniList.odeberNaslednika();
                break;
            case AKTUALNI:
                output = mereniList.odeberAktualni();
                break;
            default:
                throw new AssertionError();
        }
        return output;
    }

    public DoubleList<Mereni> mereniDen(int idSenzoru, LocalDate datum) {
        DoubleList<Mereni> temp = new AbstrDoubleList<>();

        for (Mereni mereni : mereniList) {
            if (mereni.casMereni.toLocalDate().getDayOfWeek() == datum.getDayOfWeek() //Projíždí seznam a hledá stejné dny a stejný senzor
                    && mereni.idSenzor == idSenzoru) {
                temp.vlozPosledni(mereni);
            }
        }
        return temp;

    }

    public double maxSpotreba(int idSenzoru, LocalDateTime datumOd,
            LocalDateTime datumDo) {
        double max = Integer.MIN_VALUE;

        for (Mereni mereni : mereniList) {
            if (mereni.idSenzor != idSenzoru) {
                continue;
            } else if (!(mereni.casMereni.isAfter(datumOd)
                    && mereni.casMereni.isBefore(datumDo))) {
                continue;
            } //validace. Pokud nemá stejný senzor nebo není v čas. rozmení, přeskočí

            if (mereni instanceof MereniVoda) { //Získání max pro vodu
                MereniVoda voda = (MereniVoda) mereni;
                double vodaMax = voda.getSpotrebaM3();

                if (vodaMax > max) {
                    max = vodaMax;
                }

            } else if (mereni instanceof MereniElektrika) { //Max pro elektřinu
                MereniElektrika elektrika = (MereniElektrika) mereni;
                double elektrikaMax = elektrika.getSpotrebaNT()
                        + elektrika.getSpotrebaVT();

                if (elektrikaMax > max) {
                    max = elektrikaMax;
                }
            }

        }

        return max;
    }

    public void zrus() {
        mereniList.zrus();
    }

    @Override
    public Iterator<Mereni> iterator() {
        return mereniList.iterator();
    }

}
