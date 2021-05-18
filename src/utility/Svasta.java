package utility;

import entiteti.Automobil;
import entiteti.Korisnik;
import fileIO.AutomobilIO;
import fileIO.KorisnikIO;

import java.util.ArrayList;

public class Svasta {

    static ArrayList<Korisnik> sviKorisnici = KorisnikIO.korisnikCitanje();
    public static ArrayList<Korisnik> getKorisnici() {
        return sviKorisnici;
    }

    public static ArrayList<String> getIdSvihAutomobila() {
        ArrayList<String> automobiliId = new ArrayList<>();
        ArrayList<Automobil> sviAutomobili = AutomobilIO.automobilCitanje();
        for (Automobil automobil: sviAutomobili) {
            automobiliId.add(automobil.getIdAutomobila() + "");
        }
        return automobiliId;
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
