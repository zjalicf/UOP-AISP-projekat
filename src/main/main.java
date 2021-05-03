package main;

import entiteti.Korisnik;
import fileIO.KorisnikIO;
import org.json.JSONException;
import utility.Vozac.DriverHandler;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        ArrayList<Korisnik> sviKorisnici = KorisnikIO.korisnikCitanje();
        System.out.println(DriverHandler.osveziVozace(sviKorisnici, "Olge Petrov 4"));
////        System.out.println(DriverHandler.osveziVozace(sviKorisnici));
//        System.out.println(sviKorisnici.get(0).getIme());
////        System.out.println(sviKorisnici);
////        Vozac tempVozac = new Vozac(3, "Jovan", "Jovanovic", Pol.Muski, "Olge Petrov 1", "061061061", "1234567891111", "jovan", "123456",
////                10000.0, 4321, 2,
////                "EiVMYXNsYSBHYWxhIDIsIE5vdmkgU2FkIDQwOTg0OCwgU2VyYmlhIjASLgoUChIJxXzQphUQW0cR7XRljMLDSqMQAioUChIJxXzQphUQW0cRh5IS37POvak");
////        sviKorisnici.add(tempVozac);
////        KorisnikIO.korisnikUpis(sviKorisnici);

    }
}