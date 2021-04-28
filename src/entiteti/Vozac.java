package entiteti;

import enums.Pol;

public class Vozac extends Korisnik {

    private double plata;
    private int brKarte;
    private int idAutomobila;
    private String lokacija;

    public Vozac(int idKorisnika, String ime, String prezime, Pol pol, String adresa, String brojTelefona,
                 String jmbg, String username, String password, double plata, int brKarte, int idAutomobila, String lokacija) {
        super(idKorisnika, ime, prezime, pol, adresa, brojTelefona, jmbg, username, password);
        this.plata = plata;
        this.brKarte = brKarte;
        this.idAutomobila = idAutomobila;
        this.lokacija = lokacija;
    }

    public int getBrKarte() {
        return brKarte;
    }

    public void setBrKarte(int brKarte) {
        this.brKarte = brKarte;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public int getIdAutomobila() {
        return idAutomobila;
    }

    public void setIdAutomobila(int idAutomobila) {
        this.idAutomobila = idAutomobila;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    @Override
    public String toString() {
        return "Vozac [id=" + idKorisnika + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol
                + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", jmbg="
                + jmbg + ", username=" + username + ", password=" + password + ", plata=" + getPlata() + ", idAutomobila=" + getIdAutomobila() +
                ", brKarte=" + getBrKarte() + ", lokacija=" + getLokacija() + "]";
    }

}