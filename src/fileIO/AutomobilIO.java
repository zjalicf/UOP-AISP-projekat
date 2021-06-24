package fileIO;

import entiteti.Automobil;
import enums.Model;
import enums.Proizvodjac;
import enums.VrstaAutomobila;
import strukture.Lista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AutomobilIO {

    public static Lista<Automobil> automobilCitanje() {
        Lista<Automobil> automobili = new Lista<>();
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
                String idAutomobila = value[3];
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
            System.out.println("Greska! Citanje nije moguce");
        }
        return automobili;
    }

    public static Lista<String> getIdSvihAutomobila() {
        Lista<String> automobiliId = new Lista<>();
        Lista<Automobil> sviAutomobili = automobilCitanje();
        for (Automobil automobil: sviAutomobili) {
            automobiliId.add(automobil.getIdAutomobila() + "");
        }
        return automobiliId;
    }
}
