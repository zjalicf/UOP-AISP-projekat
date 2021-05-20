package entiteti;

import enums.Pol;

public class Musterija extends Korisnik {

    public Musterija(String idKorisnika, String ime, String prezime, Pol pol, String adresa, String brojTelefona,
                     String jmbg, String username, String password, boolean obrisan) {
        super(idKorisnika, ime, prezime, pol, adresa, brojTelefona, jmbg, username, password, obrisan);
    }

    public Musterija() {}

    @Override
    public String toString() {
        return "Musterija [id=" + idKorisnika + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol
                + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", jmbg="
                + jmbg + ", username=" + username + ", password=" + password + ", obrisan=" + obrisan + "]";
    }
}