package fileIO;

import entiteti.Voznja;
import enums.StatusVoznje;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VoznjeIO {

    public static ArrayList<Voznja> VoznjaCitajIzFajla() {
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        try {
            File file = new File("src/txtPodaci/voznje.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linija;
            while ((linija = reader.readLine()) != null) {
                String[] value = linija.split("\\|");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                String str = value[0];
                LocalDateTime termin = LocalDateTime.parse(str, formatter);
                String polazak = value[1];
                String destinacija = value[2];
                String imeMusterije = value[3];
                String imeVozaca = value[4];
                Double predjenoKm = Double.parseDouble(value[5]);
                String trajanjeVoznje = value[6];
                StatusVoznje statusVoznje = StatusVoznje.valueOf(value[7]);
                int idVoznje = Integer.parseInt(value[8]);

                Voznja voznja = new Voznja(termin, polazak, destinacija, imeMusterije, imeVozaca, predjenoKm,
                        trajanjeVoznje, statusVoznje, idVoznje);
                voznje.add(voznja);
            }
            reader.close();

        }catch(IOException e) {
            System.out.println("Greska! Nije moguce procitati sadrzaj fajla");
        }
        return voznje;
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
