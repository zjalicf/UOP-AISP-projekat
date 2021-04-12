package entiteti;

import enums.Model;
import enums.Proizvodjac;
import enums.VrstaAutomobila;

public class Automobil {
    private Model model;
    private Proizvodjac proizvodjac;
    private int godinaProizvodnje;
    private int idAutomobila;
    private String regOznaka;
    private int brojVozila;
    private VrstaAutomobila vrstaAutomobila;

    public Automobil() {
    }

    public Automobil(Model model, Proizvodjac proizvodjac, int godinaProizvodnje, int idAutomobila, String regOznaka, int brojVozila, VrstaAutomobila vrstaAutomobila) {
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.godinaProizvodnje = godinaProizvodnje;
        this.idAutomobila = idAutomobila;
        this.regOznaka = regOznaka;
        this.brojVozila = brojVozila;
        this.vrstaAutomobila = vrstaAutomobila;
    }
}
