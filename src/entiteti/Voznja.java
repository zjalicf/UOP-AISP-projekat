package entiteti;

import enums.StatusVoznje;

public class Voznja {
    private String datumPorudzbine;
    private String adresaPolaska;
    private String adresaDestinacije;
    private String idMusterije;
    private String idVozaca;
    private Double predjenoKm;
    private int trajanjeVoznje;
    private StatusVoznje statusVoznje;
    private String idVoznje;
    private int ocenaVoznje;
    private boolean obrisan;

    public Voznja(String datumPorudzbine, String adresaPolaska, String adresaDestinacije, String idMusterije, String idVozaca, Double predjenoKm,
                  int trajanjeVoznje, StatusVoznje statusVoznje, String idVoznje, int ocenaVoznje, boolean obrisan) {
        this.datumPorudzbine = datumPorudzbine;
        this.adresaPolaska = adresaPolaska;
        this.adresaDestinacije = adresaDestinacije;
        this.idMusterije = idMusterije;
        this.idVozaca = idVozaca;
        this.predjenoKm = predjenoKm;
        this.trajanjeVoznje = trajanjeVoznje;
        this.statusVoznje = statusVoznje;
        this.idVoznje = idVoznje;
        this.ocenaVoznje = ocenaVoznje;
        this.obrisan = obrisan;
    }

    public Voznja() {
        this.adresaPolaska = "";
        this.adresaDestinacije = "";
        this.idMusterije = "0";
        this.idVozaca = "0";
        this.predjenoKm = 0.0;
        this.trajanjeVoznje = 0;
        this.statusVoznje = StatusVoznje.ODBIJENA;
        this.idVoznje = "0";
        this.ocenaVoznje = 0;
        this.obrisan = false;
    }

    public String getDatumPorudzbine() {
        return datumPorudzbine;
    }

    public void setDatumPorudzbine(String datumPorudzbine) {
        this.datumPorudzbine = datumPorudzbine;
    }

    public String getAdresaPolaska() {
        return adresaPolaska;
    }

    public void setAdresaPolaska(String adresaPolaska) {
        this.adresaPolaska = adresaPolaska;
    }

    public String getAdresaDestinacije() {
        return adresaDestinacije;
    }

    public void setAdresaDestinacije(String adresaDestinacije) {
        this.adresaDestinacije = adresaDestinacije;
    }

    public String getIdMusterije() {
        return idMusterije;
    }

    public void setIdMusterije(String idMusterije) {
        this.idMusterije = idMusterije;
    }

    public String getIdVozaca() {
        return idVozaca;
    }

    public void setIdVozaca(String idVozaca) {
        this.idVozaca = idVozaca;
    }

    public Double getPredjenoKm() {
        return predjenoKm;
    }

    public void setPredjenoKm(Double predjenoKm) {
        this.predjenoKm = predjenoKm;
    }

    public int getTrajanjeVoznje() {
        return trajanjeVoznje;
    }

    public void setTrajanjeVoznje(int trajanjeVoznje) {
        this.trajanjeVoznje = trajanjeVoznje;
    }

    public StatusVoznje getStatusVoznje() {
        return statusVoznje;
    }

    public void setStatusVoznje(StatusVoznje statusVoznje) {
        this.statusVoznje = statusVoznje;
    }

    public String getIdVoznje() {
        return idVoznje;
    }

    public void setIdVoznje(String idVoznje) {
        this.idVoznje = idVoznje;
    }

    public int getOcenaVoznje() {
        return ocenaVoznje;
    }

    public void setOcenaVoznje(int ocenaVoznje) {
        this.ocenaVoznje = ocenaVoznje;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    @Override
    public String toString() {
        return "Voznja [" +
                "datumPorudzbine=" + datumPorudzbine +
                ", adresaPolaska='" + adresaPolaska + '\'' +
                ", adresaDestinacije='" + adresaDestinacije + '\''
                + ", idMusterije='" + idMusterije + '\'' +
                ", idVozaca='" + idVozaca + '\'' +
                ", predjenoKm='" + predjenoKm + '\'' +
                ", trajanjeVoznje='" + trajanjeVoznje + '\'' +
                ", statusVoznje=" + statusVoznje + ", idVoznje="
                + idVoznje + ", ocenaVoznje=" + ocenaVoznje +  ", obrisan=" + obrisan + ']';
    }
}