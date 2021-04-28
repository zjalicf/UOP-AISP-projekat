package fileIO;

import entiteti.Automobil;
import enums.Model;
import enums.Proizvodjac;
import enums.VrstaAutomobila;

import java.io.*;
import java.util.ArrayList;

public class AutomobilIO {

    public static ArrayList<Automobil> AutomobilCitanje() {
        ArrayList<Automobil> automobili = new ArrayList<Automobil>();
        try {
            File file = new File("src/txtPodaci/automobili.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linija;
            while ((linija = reader.readLine()) != null) {
                String[] value = linija.split("\\|");
                String model_ = value[0];
                Model model = Model.valueOf(model_);
                String proizvodjac_ = value[1];
                Proizvodjac proizvodjac = Proizvodjac.valueOf(proizvodjac_);
                int godinaProizvodnje = Integer.parseInt(value[2]);
                int idAutomobila = Integer.parseInt(value[3]);
                String regOznaka = value[4];
                int brojVozila = Integer.parseInt(value[5]);
                String vrstaAutomobila_ = value[6];
                VrstaAutomobila vrstaAutomobila = VrstaAutomobila.valueOf(vrstaAutomobila_);

                Automobil automobil = new Automobil(model, proizvodjac, godinaProizvodnje, idAutomobila, regOznaka,
                brojVozila, vrstaAutomobila);
                automobili.add(automobil);
            }
            reader.close();

        }catch(IOException e) {
            System.out.println("Greska! Nije moguce procitati sadrzaj fajla");
        }
        return automobili;
    }

    public static void AutomobilUpis(ArrayList<Automobil> automobili) {
        String newString = "";
        for (Automobil automobil : automobili) {
            newString += automobil.getModel() + "|" + automobil.getProizvodjac() + "|" +
                    automobil.getGodinaProizvodnje() + "|" + automobil.getIdAutomobila() + "|" + automobil.getRegOznaka() + "|" +
                    automobil.getBrojVozila()  + "|" +automobil.getVrstaAutomobila() + "\n";
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