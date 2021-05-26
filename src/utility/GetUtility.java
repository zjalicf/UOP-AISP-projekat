package utility;

import entiteti.*;
import fileIO.AutomobilIO;
import fileIO.KorisnikIO;
import fileIO.VoznjaIO;

import java.util.ArrayList;

public class GetUtility {

    static ArrayList<Korisnik> sviKorisnici = KorisnikIO.korisnikCitanje();

    public static ArrayList<Korisnik> getKorisnici() {
        return sviKorisnici;
    }

//    public static ArrayList<Musterija> getMusterije() {
//        ArrayList<Musterija> sveMusterije = new ArrayList<>();
//        for(Korisnik korisnik : getKorisnici()) {
//            if(korisnik instanceof Musterija) {
//                sveMusterije.add((Musterija) korisnik);
//            }
//        }
//        return sveMusterije;
//    }

    public static ArrayList<Dispecer> getDispeceri() {
        ArrayList<Dispecer> sviDispeceri = new ArrayList<>();
        for(Korisnik korisnik : getKorisnici()) {
            if(korisnik instanceof Dispecer) {
                sviDispeceri.add((Dispecer) korisnik);
            }
        }
        return sviDispeceri;
    }

    public static ArrayList<Vozac> getVozaci() {
        ArrayList<Vozac> sviVozaci = new ArrayList<>();
        for(Korisnik korisnik : getKorisnici()) {
            if(korisnik instanceof Vozac) {
                sviVozaci.add((Vozac) korisnik);
            }
        }
        return sviVozaci;
    }


    public static ArrayList<String> getIdSvihAutomobila() {
        ArrayList<String> automobiliId = new ArrayList<>();
        ArrayList<Automobil> sviAutomobili = AutomobilIO.automobilCitanje();
        for (Automobil automobil: sviAutomobili) {
            automobiliId.add(automobil.getIdAutomobila() + "");
        }
        return automobiliId;
    }

    public static ArrayList<Voznja> getVoznje() {
        return VoznjaIO.voznjaCitanje();
    }

    public static ArrayList<String> getIdSvihKorisnika() {
        ArrayList<String> IdSvihKorisnika = new ArrayList<String>();
        ArrayList<Korisnik> sviKorisnici = KorisnikIO.korisnikCitanje();
        for(Korisnik korisnik : sviKorisnici) {
            IdSvihKorisnika.add((String.valueOf(korisnik.getIdKorisnika())));
        }
        return IdSvihKorisnika;
    }
}
