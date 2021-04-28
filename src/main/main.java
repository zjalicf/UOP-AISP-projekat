/*
 TODO:
    1. prijava na sistem
    2. CRUD
    3. prikaz voznji
    4. dodeljivanje voznje
    5. osvezavanje vozaca
    6. najblizi vozac
    7. kombinovana pretraga
    8. prihvati/odbij voznju
    9. zavrsi voznju
    10. naruci voznju (za musteriju)
    11. oceni vozaca
    12. zavrsiti sopstvene liste
    13. ceo GUI
 */

// napravio sam samo konstruktor koji je prazan i konstruktor koji zahteva sve paramtere popunjene
// a posto sam u ovim testovima u main metodi setovao samo po jednu stvar cisto da se vidi da radi,
// u fajl ce biti upisane null vrednosti pored te koje je setovana, pa ponovno pokretanje nece raditi!
// OBRISITE NOVU LINIJU KOJA SE UPISE U FAJL! (voznje.txt, automobili.txt, korisnici.txt)
package main;

import entiteti.Automobil;
import entiteti.Korisnik;
import entiteti.Musterija;
import entiteti.Voznja;
import enums.Model;
import fileIO.AutomobilIO;
import fileIO.KorisnikIO;
import fileIO.VoznjaIO;
import strukture.Par;
import java.io.IOException;
import java.util.ArrayList;
import static utility.MapsCalc.proba;

public class Main {

    public static void main(String[] args) throws IOException {

//      sve postale klase koje ce biti potrebne su navedene i napravljene u utility paketu
//      samo sam naveo nazive klasa koje ce imati metode koje ce raditi svako svoj deo

//      moja struktura Par koja vraca preko Google API razdaljinu u km (getKm)
//      i vreme od adrese do adrese (getVreme)
        Par<String, String> res = proba();
        System.out.println(res.getKm() + " " + proba().getVreme());

        //Testiranje entitea Automobila, nadam se da sam ispostovao koncepte OOP
        ArrayList<Automobil> sviAutomobili = AutomobilIO.AutomobilCitanje(); // Ucitavanje automobila u listu koja je za sada iz java util
        System.out.println(sviAutomobili);
        Automobil tempAutomobil = new Automobil(); // Instanciranje objekta Automobil
        tempAutomobil.setModel(Model.M3); // Samo sam postavio Model, mogao sam sve ali ovo je cisto da se vidi da radi
        sviAutomobili.add(tempAutomobil);
        System.out.println(sviAutomobili);

        AutomobilIO.AutomobilUpis(sviAutomobili); // Upis u fajl

        // Isto kao za automobile
        ArrayList<Korisnik> sviKorisnici = KorisnikIO.KorisnikCitanje();
        System.out.println(sviKorisnici);
        Musterija tempKorisnik = new Musterija();
        tempKorisnik.setIme("Jovan");
        sviKorisnici.add(tempKorisnik);
        System.out.println(sviKorisnici);

        KorisnikIO.KorisnikUpis(sviKorisnici);

        // Isto kao za automobile
        ArrayList<Voznja> sveVoznje = VoznjaIO.VoznjaCitanje();
        System.out.println(sveVoznje);
        Voznja tempVoznja = new Voznja();
        tempVoznja.setOcenaVoznje(3);
        sveVoznje.add(tempVoznja);
        System.out.println(sveVoznje);

        VoznjaIO.VoznjaUpis(sveVoznje);
    }
}
