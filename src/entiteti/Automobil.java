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

    public Automobil(Model model, Proizvodjac proizvodjac, int godinaProizvodnje, int idAutomobila, String regOznaka,
                     int brojVozila, VrstaAutomobila vrstaAutomobila) {
        this.model = model;
        this.proizvodjac = proizvodjac;
        this.godinaProizvodnje = godinaProizvodnje;
        this.idAutomobila = idAutomobila;
        this.regOznaka = regOznaka;
        this.brojVozila = brojVozila;
        this.vrstaAutomobila = vrstaAutomobila;
    }

    // da li treba da se stavi konstruktor sa "" i default enums?

    public Automobil() {
        //sta ce mi ovaj prazan?
    }

    @Override
    public String toString() {
        return "Automobil [model=" + model + ", proizvodjac=" + proizvodjac + ", godinaProizvodnje=" + godinaProizvodnje
                + ", id=" + idAutomobila + ", regOznaka=" + regOznaka + ", brojVozila=" + brojVozila + ", " +
                "vrstaAutomobila=" + vrstaAutomobila + "]";
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public int getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(int godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public int getIdAutomobila() {
        return idAutomobila;
    }

    public void setIdAutomobila(int idAutomobila) {
        this.idAutomobila = idAutomobila;
    }

    public String getRegOznaka() {
        return regOznaka;
    }

    public void setRegOznaka(String regOznaka) {
        this.regOznaka = regOznaka;
    }

    public int getBrojVozila() {
        return brojVozila;
    }

    public void setBrojVozila(int brojVozila) {
        this.brojVozila = brojVozila;
    }

    public VrstaAutomobila getVrstaAutomobila() {
        return vrstaAutomobila;
    }

    public void setVrstaAutomobila(VrstaAutomobila vrstaAutomobila) {
        this.vrstaAutomobila = vrstaAutomobila;
    }
}
