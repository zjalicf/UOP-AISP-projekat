package main;

import entiteti.Korisnik;
import fileIO.KorisnikRadSaFajlovima;

import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) throws IOException {
//        mapsCalc.proba();
        getAutomobili();
    }
    public static void getAutomobili() {
//        ArrayList<Automobil> sviAutomobili = AutomobilRadSaFajlovima.AutomobilCitajIzFajla();
//        System.out.println(sviAutomobili);
//        Automobil temp = new Automobil();
//        temp.setModel(Model.M3);
//        sviAutomobili.add(temp);
//        System.out.println(sviAutomobili);
//        AutomobilRadSaFajlovima.AutomobilUpisiUFajl(sviAutomobili);
        ArrayList<Korisnik> sviKorisnici = KorisnikRadSaFajlovima.KorisnikCitajIzFajla();
        System.out.println(sviKorisnici);
    }
}
