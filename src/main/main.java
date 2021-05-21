package main;

import GUI.FrameLauncher;
import org.json.JSONException;

import java.io.IOException;

// ZA UKLANJANJE REDA LIVE, MOZDA MOZE I TAKO DA SE DODA!
//                    DefaultTableModel dtm = (DefaultTableModel)tabela.getModel();
//                    dtm.removeRow(red);
public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        FrameLauncher.launchLoginFrame();
//        ArrayList<Korisnik> sviKorisnici = KorisnikIO.korisnikCitanje();
//        System.out.println(DriverHandler.osveziVozace(sviKorisnici, "Olge Petrov 4"));
//        System.out.println(sviKorisnici.get(0).getIme());
////        System.out.println(sviKorisnici);
////        Vozac tempVozac = new Vozac(3, "Jovan", "Jovanovic", Pol.Muski, "Olge Petrov 1", "061061061", "1234567891111", "jovan", "123456",
////                10000.0, 4321, 2,
////                "EiVMYXNsYSBHYWxhIDIsIE5vdmkgU2FkIDQwOTg0OCwgU2VyYmlhIjASLgoUChIJxXzQphUQW0cR7XRljMLDSqMQAioUChIJxXzQphUQW0cRh5IS37POvak");
////        sviKorisnici.add(tempVozac);
////        KorisnikIO.korisnikUpis(sviKorisnici);

    }
}