package fileIO;

import entiteti.Voznja;
import enums.StatusVoznje;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VoznjaIO {

    public static ArrayList<Voznja> VoznjaCitanje() {
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        try {
            File file = new File("src/txtPodaci/voznje.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linija;
            while ((linija = reader.readLine()) != null) {
                String[] value = linija.split("\\|");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                String tempStr = value[0];
                LocalDateTime datumPorudzbine = LocalDateTime.parse(tempStr, formatter);
                String adresaPolaska = value[1];
                String adresaDestinacije = value[2];
                int idMusterije = Integer.parseInt(value[3]);
                int idVozaca = Integer.parseInt(value[4]);
                Double predjenoKm = Double.parseDouble(value[5]);
                String trajanjeVoznje = value[6];
                StatusVoznje statusVoznje = StatusVoznje.valueOf(value[7]);
                int idVoznje = Integer.parseInt(value[8]);
                int ocenaVoznje = Integer.parseInt(value[9]);

                Voznja voznja = new Voznja(datumPorudzbine, adresaPolaska, adresaDestinacije, idMusterije, idVozaca, predjenoKm, trajanjeVoznje,
                        statusVoznje, idVoznje, ocenaVoznje);
                voznje.add(voznja);
            }
            reader.close();

        }catch(IOException e) {
            System.out.println("Greska! Nije moguce procitati sadrzaj fajla");
        }
        return voznje;
    }

    public static void VoznjaUpis(ArrayList<Voznja> voznje) {
        String newString = "";
        for (Voznja voznja : voznje) {
            newString += voznja.getDatumPorudzbine() + "|" + voznja.getAdresaPolaska() + "|" +
                    voznja.getAdresaDestinacije() +"|"+ voznja.getIdMusterije() + "|" + voznja.getIdVozaca() +
                    "|" + voznja.getPredjenoKm() + "|" + voznja.getTrajanjeVoznje()+ "|" + voznja.getStatusVoznje()  + "|" +voznja.getIdVoznje() +
                    "|" + voznja.getOcenaVoznje() + "\n";
        }
        try {
            File file = new File("src/txtPodaci/automobili.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(newString);
            writer.close();
        }
        catch(IOException e) {
            System.out.println("Greska! Upisivanje nije moguce");
        }
    }
}
