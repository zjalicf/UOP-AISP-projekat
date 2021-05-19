package entiteti;

import enums.Pol;

public abstract class Korisnik {

    protected int idKorisnika;
    protected String ime;
    protected String prezime;
    protected Pol pol;
    protected String adresa;
    protected String brojTelefona;
    protected String jmbg;
    protected String username;
    protected String password;
    protected boolean obrisan;

    public Korisnik() {
        this.idKorisnika = 909093;
        this.ime = "";
        this.prezime = "";
        this.pol = Pol.Muski;
        this.adresa = "";
        this.brojTelefona = "";
        this.jmbg = "";
        this.username = "";
        this.password = "";
        this.obrisan = false;
    }

    public Korisnik(int idKorisnika, String ime, String prezime, Pol pol, String adresa, String brojTelefona, String jmbg, String username,
                    String password, boolean obrisan) {
        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.jmbg = jmbg;
        this.username = username;
        this.password = password;
        this.obrisan = obrisan;
    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    @Override
    public String toString() {
        return "Korisnik [id=" + idKorisnika + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol + ", adresa=" +
                adresa + ", brojTelefona=" + brojTelefona + ", jmbg=" + jmbg + ", username=" + username + ", password" +
                "=" + password + "]";
    }
}