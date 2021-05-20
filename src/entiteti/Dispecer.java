package entiteti;

import enums.Odeljenje;
import enums.Pol;

public class Dispecer extends Korisnik {

    private double plata;
    private Odeljenje odeljenje;
    private int brTelefonskeLinije;


    public Dispecer(String idKorisnika, String ime, String prezime, Pol pol, String adresa, String brojTelefona,
                    String jmbg, String username, String password, boolean obrisan, double plata, Odeljenje odeljenje,
                    int brTelefonskeLinije) {
        super(idKorisnika, ime, prezime, pol, adresa, brojTelefona, jmbg, username, password, obrisan);
        this.plata = plata;
        this.odeljenje = odeljenje;
        this.brTelefonskeLinije = brTelefonskeLinije;
    }

    public Dispecer() {
        this.plata = 0.0;
        this.odeljenje = Odeljenje.prijem;
        this.brTelefonskeLinije = 0;
    }

    @Override
    public String toString() {
        return "Dispecer [id=" + idKorisnika + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol
                + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", jmbg="
                + jmbg + ", username=" + username + ", password=" + password + ", obrisan=" + obrisan + ", plata=" + getPlata() + ", " +
                "odeljenje=" + getOdeljenje() + ", brTelefonskeLinije=" + getBrTelefonskeLinije() + "]";
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public Odeljenje getOdeljenje() {
        return odeljenje;
    }

    public void setOdeljenje(Odeljenje odeljenje) {
        this.odeljenje = odeljenje;
    }

    public int getBrTelefonskeLinije() {
        return brTelefonskeLinije;
    }

    public void setBrTelefonskeLinije(int brTelefonskeLinije) {
        this.brTelefonskeLinije = brTelefonskeLinije;
    }
}