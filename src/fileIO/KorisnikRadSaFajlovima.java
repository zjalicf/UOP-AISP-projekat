package fileIO;

import entiteti.Dispecer;
import entiteti.Korisnik;
import entiteti.Musterija;
import enums.Odeljenje;
import enums.Pol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KorisnikRadSaFajlovima {

    public static ArrayList<Korisnik> KorisnikCitajIzFajla() {
        ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
        try {
            File file = new File("src/txtPodaci/korisnici.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linija;
            while ((linija = reader.readLine()) != null) {
                String[] value = linija.split("\\|");
                int idKorisnika = Integer.parseInt(value[0]);
                String ime = value[1];
                String prezime = value[2];
                Pol pol = Pol.valueOf(value[3]);
                String adresa = value[4];
                String brojTelefona = value[5];
                String jmbg = value[6];
                String username = value[7];
                String password = value[8];
                String tip = value[9];

                switch (tip) {
                    case "dispecer": {
                        double plata = Double.parseDouble(value[10]);
                        Odeljenje odeljenje = Odeljenje.valueOf(value[11]);
                        Dispecer dispecer = new Dispecer(idKorisnika, ime, prezime, pol, adresa, brojTelefona, jmbg,
                                username, password, plata, odeljenje);
                        korisnici.add(dispecer);
                        break;
                    }
//                    case "vozac": {
//                        double plata = Double.parseDouble(value[10]);
//                        Vozac vozac = new Serviser(id, ime, prezime, pol, adresa, brojTelefona, korisnickoIme,
//                                lozinka, jmbg, plata, specijalizacija, obrisan);
//                        korisnici.add(serviser);
//                        break;
//                    }
                    case "musterija": {
                        Musterija musterija = new Musterija(idKorisnika, ime, prezime, pol, adresa, brojTelefona, jmbg
                                , username, password);
                        korisnici.add(musterija);
                        break;
                    }
                }
            }
            reader.close();

        }catch(IOException e) {
            System.out.println("Greska! Nije moguce procitati sadrzaj fajla");
        }
        return korisnici;
    }

//    public static void AutomobilUpisiUFajl(ArrayList<Automobil> automobili) {
//        String newString = "";
//        for (Automobil automobil : automobili) {
//            newString += automobil.getModel() +"|"+ automobil.getProizvodjac() +"|"+
//                    automobil.getGodinaProizvodnje() +"|"+ automobil.getIdAutomobila() +"|"+ automobil.getRegOznaka() +
//                    "|"+ automobil.getBrojVozila()  +"|"+automobil.getVrstaAutomobila() +"\n";
//        }
//        try {
//            File file = new File("src/txtPodaci/automobili.txt");
//            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//            writer.write(newString);
//            writer.close();
//        }
//        catch(IOException e) {
//            System.out.println("Greska prilikom ucitavanja datoteke: " + e.getMessage());
//        }
//    }
}
