package entiteti;

import enums.Odeljenje;
import enums.Pol;

public class Dispecer extends Korisnik {

    private double plata;
    private int brTelefonskeLinije;
    private Odeljenje odeljenje;

    public Dispecer(int idKorisnika, String ime, String prezime, Pol pol, String adresa, String brojTelefona,
                    String jmbg, String username, String password, double plata, Odeljenje odeljenje,
                    int brTelefonskeLinije) {
        super(idKorisnika, ime, prezime, pol, adresa, brojTelefona, jmbg, username, password);
        this.plata = plata;
        this.odeljenje = odeljenje;
        this.brTelefonskeLinije = brTelefonskeLinije;
    }

    @Override
    public String toString() {
        return "Dispecer [id=" + idKorisnika + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol
                + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", jmbg="
                + jmbg + ", username=" + username + ", password=" + password + ", plata=" + getPlata() + ", " +
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