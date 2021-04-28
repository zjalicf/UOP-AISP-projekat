package main;

import entiteti.Korisnik;
import entiteti.Musterija;
import fileIO.KorisnikIO;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
//        ArrayList<Automobil> sviAutomobili = AutomobilIO.AutomobilCitanje();
//        System.out.println(sviAutomobili);
//        Automobil temp = new Automobil();
//        temp.setModel(Model.M3);
//        sviAutomobili.add(temp);
//        System.out.println(sviAutomobili);
//        AutomobilIO.AutomobilUpis(sviAutomobili);
//        ArrayList<Korisnik> sviKorisnici = KorisnikRadSaFajlovima.KorisnikCitajIzFajla();
//        System.out.println(sviKorisnici);
//        ArrayList<Voznja> sveVoznje = VoznjeRadSaFajlovima.VoznjaCitajIzFajla();
//        System.out.println(sveVoznje);
//        Par<String, String> res = proba();
//        System.out.println(res.getKm() + " " + proba().getVreme());
        ArrayList<Korisnik> sviKorisnici = KorisnikIO.KorisnikCitanje();
        System.out.println(sviKorisnici);
        Musterija temp = new Musterija();
        temp.setIme("Jovan");
        sviKorisnici.add(temp);
        System.out.println(sviKorisnici);
        KorisnikIO.KorisnikUpis(sviKorisnici);
    }
}
