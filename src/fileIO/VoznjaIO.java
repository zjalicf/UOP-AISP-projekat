package fileIO;

import entiteti.Voznja;
import enums.StatusVoznje;

import java.io.*;
import java.util.ArrayList;

public class VoznjaIO {

    public static ArrayList<Voznja> voznjaCitanje() {
        ArrayList<Voznja> voznje = new ArrayList<Voznja>();
        try {
            File file = new File("src/txtPodaci/voznje.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linija;
            while ((linija = reader.readLine()) != null) {
                String[] value = linija.split("\\|");
                String datumPorudzbine = value[0];
                String adresaPolaska = value[1];
                String adresaDestinacije = value[2];
                String idMusterije = value[3];
                String idVozaca = value[4];
                Double predjenoKm = Double.parseDouble(value[5]);
                int trajanjeVoznje = Integer.parseInt(value[6]);
                StatusVoznje statusVoznje = StatusVoznje.valueOf(value[7]);
                String idVoznje = value[8];
                int ocenaVoznje = Integer.parseInt(value[9]);
                boolean obrisan = Boolean.parseBoolean(value[10]);

                Voznja voznja = new Voznja(datumPorudzbine, adresaPolaska, adresaDestinacije, idMusterije, idVozaca, predjenoKm, trajanjeVoznje,
                        statusVoznje, idVoznje, ocenaVoznje, obrisan);
                voznje.add(voznja);
            }
            reader.close();

        }catch(IOException e) {
            System.out.println("Greska! Citanje nije moguce");
        }
        return voznje;
    }

    public static void voznjaUpis(ArrayList<Voznja> voznje) {
        String newString = "";
        for (Voznja voznja : voznje) {
            newString += voznja.getDatumPorudzbine() + "|" + voznja.getAdresaPolaska() + "|" +
                    voznja.getAdresaDestinacije() +"|"+ voznja.getIdMusterije() + "|" + voznja.getIdVozaca() +
                    "|" + voznja.getPredjenoKm() + "|" + voznja.getTrajanjeVoznje()+ "|" + voznja.getStatusVoznje()  + "|" +voznja.getIdVoznje() +
                    "|" + voznja.getOcenaVoznje() + "|" + voznja.isObrisan() + "\n";
        }
        try {
            File file = new File("src/txtPodaci/voznje.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(newString);
            writer.close();
        }
        catch(IOException e) {
            System.out.println("Greska! Upisivanje nije moguce");
        }
    }

    public static ArrayList<Voznja> getVoznje() {
        return VoznjaIO.voznjaCitanje();
    }
}
