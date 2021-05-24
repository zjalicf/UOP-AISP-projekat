package fileIO;

import entiteti.Dispecer;
import entiteti.Korisnik;
import entiteti.Musterija;
import entiteti.Vozac;
import enums.Odeljenje;
import enums.Pol;

import java.io.*;
import java.util.ArrayList;

public class KorisnikIO {

    public static ArrayList<Korisnik> korisnikCitanje() {
        ArrayList<Korisnik> korisnici = new ArrayList<>();
        try {
            File file = new File("src/txtPodaci/korisnici.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linija;
            while ((linija = reader.readLine()) != null) {
                String[] value = linija.split("\\|");
                String idKorisnika = value[0];
                String ime = value[1];
                String prezime = value[2];
                Pol pol = Pol.valueOf(value[3]);
                String adresa = value[4];
                String brojTelefona = value[5];
                String jmbg = value[6];
                String username = value[7];
                String password = value[8];
                boolean obrisan = Boolean.parseBoolean(value[9]);
                String tip = value[10];

                switch (tip) {
                    case "dispecer": {
                        double plata = Double.parseDouble(value[11]);
                        Odeljenje odeljenje = Odeljenje.valueOf(value[12]);
                        int brTelefonskeLinije = Integer.parseInt(value[13]);
                        Dispecer dispecer = new Dispecer(idKorisnika, ime, prezime, pol, adresa, brojTelefona, jmbg,
                                username, password, obrisan, plata, odeljenje, brTelefonskeLinije);
                        korisnici.add(dispecer);
                        break;
                    }
                    case "vozac": {
                        double plata = Double.parseDouble(value[11]);
                        int brKarte = Integer.parseInt(value[12]);
                        String idAutomobila = value[13];;
                        String lokacija = value[14];
                        Vozac vozac = new Vozac(idKorisnika, ime, prezime, pol, adresa, brojTelefona, jmbg,
                                username, password, obrisan, plata, brKarte, idAutomobila, lokacija);
                        korisnici.add(vozac);
                        break;
                    }
                    case "musterija": {
                        Musterija musterija = new Musterija(idKorisnika, ime, prezime, pol, adresa, brojTelefona, jmbg
                                , username, password, obrisan);
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

    public static void korisnikUpis(ArrayList<Korisnik> korisnici) {
        String newString = "";
        for (Korisnik korisnik : korisnici) {
            if (korisnik instanceof Dispecer) {
                newString += korisnik.getIdKorisnika() + "|" + korisnik.getIme() + "|" +
                        korisnik.getPrezime() + "|" + korisnik.getPol() + "|" + korisnik.getAdresa()
                        + "|" + korisnik.getBrojTelefona() + "|" + korisnik.getJmbg() + "|" + korisnik.getUsername() +
                        "|" + korisnik.getPassword() + "|" + korisnik.isObrisan() + "|" + "dispecer" + "|" + ((Dispecer) korisnik).getPlata() +
                        "|" + ((Dispecer) korisnik).getOdeljenje() + "|" + ((Dispecer) korisnik).getBrTelefonskeLinije() + "\n";
            }
            else if (korisnik instanceof Musterija) {
                newString += korisnik.getIdKorisnika() + "|" + korisnik.getIme() + "|" +
                        korisnik.getPrezime() + "|" + korisnik.getPol() + "|" + korisnik.getAdresa()
                        + "|" + korisnik.getBrojTelefona() + "|" + korisnik.getJmbg() + "|" + korisnik.getUsername() +
                        "|" + korisnik.getPassword() + "|" + korisnik.isObrisan() + "|" + "musterija" + "\n";
            }
            else {
                newString += korisnik.getIdKorisnika() + "|" + korisnik.getIme() + "|" +
                        korisnik.getPrezime() + "|" + korisnik.getPol() + "|" + korisnik.getAdresa()
                        + "|" + korisnik.getBrojTelefona() + "|" + korisnik.getJmbg() + "|" + korisnik.getUsername() +
                        "|" + korisnik.getPassword() + "|" + korisnik.isObrisan() + "|" + "vozac" + "|" + ((Vozac) korisnik).getPlata() + "|" + ((Vozac) korisnik).getBrKarte() + "|" +
                        ((Vozac) korisnik).getIdAutomobila() + "|" + ((Vozac) korisnik).getLokacija() + "\n";
            }
        }
        try {
            File file = new File("src/txtPodaci/korisnici.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(newString);
            writer.close();
        }
        catch(IOException e) {
            System.out.println("Greska! Upisivanje nije moguce");
        }
    }
}
