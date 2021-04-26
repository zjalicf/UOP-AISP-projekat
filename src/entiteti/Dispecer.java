package entiteti;

import enums.Odeljenje;
import enums.Pol;

public class Dispecer extends Korisnik {

    private double plata;
    private int brTelefonskeLinije;
    private Odeljenje odeljenje;

    public Dispecer(int idKorisnika, String ime, String prezime, Pol pol, String adresa, String brojTelefona,
                    String jmbg, String username, String password, double plata, Odeljenje odeljenje) {
        super(idKorisnika, ime, prezime, pol, adresa, brojTelefona, jmbg, username, password);
        this.plata = plata;
        this.odeljenje = odeljenje;
    }

    @Override
    public String toString() {
        return "Dispecer [id=" + idKorisnika + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol
                + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", jmbg="
                + jmbg + ", username=" + username + ", password=" + password + ", odeljenje=" + getOdeljenje() + ", " +
                "plata=" +
                getPlata() + "]";
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

}