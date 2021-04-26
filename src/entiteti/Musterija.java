package entiteti;

import enums.Pol;

public class Musterija extends Korisnik {

    // da li treba prazan konstruktor?
    public Musterija(int idKorisnika, String ime, String prezime, Pol pol, String adresa, String brojTelefona,
                     String jmbg, String username, String password) {
        super(idKorisnika, ime, prezime, pol, adresa, brojTelefona, jmbg, username, password);
    }

    @Override
    public String toString() {
        return "Musterija [id=" + idKorisnika + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol
                + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", jmbg="
                + jmbg + ", username=" + username + ", prezime=" + prezime + "]";
    }
}