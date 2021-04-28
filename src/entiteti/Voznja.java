package entiteti;

import enums.StatusVoznje;

import java.time.LocalDateTime;

public class Voznja {
    private LocalDateTime datumPorudzbine;
    private String adresaPolaska;
    private String adresaDestinacije;
    private String idMusterije;
    private String idVozaca;
    private Double predjenoKm;
    private String trajanjeVoznje;
    private StatusVoznje statusVoznje;
    private int idVoznje;

    public Voznja(LocalDateTime datumPorudzbine, String adresaPolaska, String adresaDestinacije, String idMusterije,
                  String idVozaca, Double predjenoKm, String trajanjeVoznje, StatusVoznje statusVoznje, int idVoznje) {
        this.datumPorudzbine = datumPorudzbine;
        this.adresaPolaska = adresaPolaska;
        this.adresaDestinacije = adresaDestinacije;
        this.idMusterije = idMusterije;
        this.idVozaca = idVozaca;
        this.predjenoKm = predjenoKm;
        this.trajanjeVoznje = trajanjeVoznje;
        this.statusVoznje = statusVoznje;
        this.idVoznje = idVoznje;
    }

    public LocalDateTime getDatumPorudzbine() {
        return datumPorudzbine;
    }

    public void setDatumPorudzbine(LocalDateTime datumPorudzbine) {
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

    public void setIdVozaca(String ideVozaca) {
        this.idVozaca = idVozaca;
    }

    public Double getPredjenoKm() {
        return predjenoKm;
    }

    public void setPredjenoKm(Double predjenoKm) {
        this.predjenoKm = predjenoKm;
    }

    public String getTrajanjeVoznje() {
        return trajanjeVoznje;
    }

    public void setTrajanjeVoznje(String trajanjeVoznje) {
        this.trajanjeVoznje = trajanjeVoznje;
    }

    public StatusVoznje getStatusVoznje() {
        return statusVoznje;
    }

    public void setStatusVoznje(StatusVoznje statusVoznje) {
        this.statusVoznje = statusVoznje;
    }

    public int getIdVoznje() {
        return idVoznje;
    }

    public void setIdVoznje(int idVoznje) {
        this.idVoznje = idVoznje;
    }

    @Override
    public String toString() {
        return "Voznja [" +
                "datumPorudzbine=" + datumPorudzbine +
                ", adresaPolaska='" + adresaPolaska + '\'' +
                ", adresaDestinacije='" + adresaDestinacije + '\'' +
                ", idMusterije='" + idMusterije + '\'' +
                ", idVozaca='" + idVozaca + '\'' +
                ", predjenoKm='" + predjenoKm + '\'' +
                ", trajanjeVoznje='" + trajanjeVoznje + '\'' +
                ", statusVoznje=" + statusVoznje +
                ", idVoznje=" + idVoznje +
                ']';
    }
}