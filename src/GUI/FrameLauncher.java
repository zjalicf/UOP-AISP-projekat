package GUI;

import GUI.Dispecer.*;
import GUI.Musterija.ListaVoznjiMusterijaFrame;
import GUI.Musterija.MusterijaFrame;
import GUI.Musterija.NaruciVoznjuFrame;
import GUI.Musterija.OceniVoznjuFrame;
import GUI.Vozac.ListaVoznjiVozacFrame;
import GUI.Vozac.VozacFrame;
import GUI.Vozac.ZavrsiVoznjuFrame;
import entiteti.Korisnik;

import javax.swing.*;

public class FrameLauncher {
    public static void launchListaVoznjiDispecerFrame() {
        ListaVoznjiDispecerFrame listaVoznjiDispecerFrame = new ListaVoznjiDispecerFrame();
        listaVoznjiDispecerFrame.setVisible(true);
        listaVoznjiDispecerFrame.setBounds(20, 20, 1200, 184);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaVoznjiDispecerFrame.setResizable(false);
    }

    public static void launchListaVoznjiVozacFrame(Korisnik ulogovani) {
        ListaVoznjiVozacFrame listaVoznjiVozacFrame = new ListaVoznjiVozacFrame(ulogovani);
        listaVoznjiVozacFrame.setVisible(true);
        listaVoznjiVozacFrame.setBounds(20, 20, 1200, 184);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaVoznjiVozacFrame.setResizable(false);
    }

    public static void launchListaKorisnikaFrame(int tip) {
        ListaKorisnikaFrame listaKorisnikaFrame = new ListaKorisnikaFrame(tip);
        listaKorisnikaFrame.setVisible(true);
        listaKorisnikaFrame.setBounds(20, 20, 1114, 184);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaKorisnikaFrame.setResizable(false);
    }

    public static void launchDodajDispeceraFrame() {
        DodajDispeceraFrame dodajDispeceraFrame = new DodajDispeceraFrame();
        dodajDispeceraFrame.setVisible(true);
        dodajDispeceraFrame.setBounds(20, 20, 234, 384);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dodajDispeceraFrame.setResizable(false);
    }

    public static void launchDodajVozacaFrame() {
        DodajVozacaFrame dodajVozacaFrame = new DodajVozacaFrame();
        dodajVozacaFrame.setVisible(true);
        dodajVozacaFrame.setBounds(20, 20, 234, 384);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dodajVozacaFrame.setResizable(false);
    }

    public static void launchDodajKorisnikaFrame(int tip) {
        if (tip == 0) {
            launchDodajVozacaFrame();
        } else if (tip == 1) {
            launchDodajDispeceraFrame();
        } else {
            System.out.println("fatal error");
        }
    }

    public static void launchNaruciVoznjuFrame(Korisnik ulogovani) {
        NaruciVoznjuFrame naruciVoznjuFrame = new NaruciVoznjuFrame(ulogovani);
        naruciVoznjuFrame.setVisible(true);
        naruciVoznjuFrame.setBounds(0, 20, 396, 430);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        naruciVoznjuFrame.setResizable(false);
    }

    public static void launchLoginFrame() {
        MainFrame loginFrame = new MainFrame();
        loginFrame.setTitle("STATIM TAXI SERVIS");
        loginFrame.setVisible(true);
        loginFrame.setBounds(10, 10, 520, 566);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
    }

    public static void launchDispecerFrame(Korisnik ulogovani) {
        DispecerFrame dispecerFrame = new DispecerFrame(ulogovani);
        dispecerFrame.setVisible(true);
        dispecerFrame.setTitle("Dobrodosli, " + ulogovani.getIme() + " " + ulogovani.getPrezime());
        dispecerFrame.setBounds(10, 10, 350, 230);
//        dispecerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispecerFrame.setResizable(false);
//        LoginFrame.this.dispose();
//        LoginFrame.this.setVisible(false);
    }

    public static void launchMusterijaFrame(Korisnik ulogovani) {
        MusterijaFrame musterijaFrame = new MusterijaFrame(ulogovani);
        musterijaFrame.setVisible(true);
        musterijaFrame.setTitle("Dobrodosli, " + ulogovani.getIme() + " " + ulogovani.getPrezime());
        musterijaFrame.setBounds(10, 10, 350, 230);
//        musterijaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        musterijaFrame.setResizable(false);
    }

    public static void launchVozacFrame(Korisnik ulogovani) {
        VozacFrame vozacFrame = new VozacFrame(ulogovani);
        vozacFrame.setVisible(true);
        vozacFrame.setTitle("Dobrodosli, " + ulogovani.getIme() + " " + ulogovani.getPrezime());
        vozacFrame.setBounds(10, 10, 350, 230);
//        vozacFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vozacFrame.setResizable(false);
    }

    public static void launchListaVoznjiMusterijaFrame() {
        ListaVoznjiMusterijaFrame listaVoznjiMusterijaFrame = new ListaVoznjiMusterijaFrame();
        listaVoznjiMusterijaFrame.setVisible(true);
        listaVoznjiMusterijaFrame.setBounds(20, 20, 1000, 200);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaVoznjiMusterijaFrame.setResizable(false);
    }

    public static void launchZavrsiVoznjuFrame(String voznjaId) {
        ZavrsiVoznjuFrame listaVoznjiMusterijaFrame = new ZavrsiVoznjuFrame(voznjaId);
        listaVoznjiMusterijaFrame.setVisible(true);
        listaVoznjiMusterijaFrame.setBounds(20, 20, 185, 180);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaVoznjiMusterijaFrame.setResizable(false);
    }

    public static void launchIzmeniDispeceraFrame(String korisnikId) {
        IzmeniDispeceraFrame izmeniDispeceraFrame = new IzmeniDispeceraFrame(korisnikId);
        izmeniDispeceraFrame.setVisible(true);
        izmeniDispeceraFrame.setBounds(20, 20, 234, 384);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        izmeniDispeceraFrame.setResizable(false);
    }

    public static void launchIzmeniVozacaFrame(String korisnikId) {
        IzmeniVozacaFrame izmeniVozacaFrame = new IzmeniVozacaFrame(korisnikId);
        izmeniVozacaFrame .setVisible(true);
        izmeniVozacaFrame .setBounds(20, 20, 234, 384);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        izmeniVozacaFrame .setResizable(false);
    }

    public static void launchIzmeniVoznjuFrame(String voznjaId) {
        IzmeniVoznjuFrame izmeniVoznjuFrame = new IzmeniVoznjuFrame(voznjaId);
        izmeniVoznjuFrame.setVisible(true);
        izmeniVoznjuFrame.setBounds(20, 20, 234, 384);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        izmeniVoznjuFrame.setResizable(false);
    }

    public static void launchPretraziVoznje(JTable tabela) {
        PretraziVoznjeFrame pretraziVoznjeFrame = new PretraziVoznjeFrame(tabela);
        pretraziVoznjeFrame.setVisible(true);
        pretraziVoznjeFrame.setBounds(20, 20, 234, 384);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pretraziVoznjeFrame.setResizable(false);
    }

    public static void launchOceniVoznju(String voznjaId) {
        OceniVoznjuFrame oceniVoznjuFrame = new OceniVoznjuFrame(voznjaId);
        oceniVoznjuFrame.setVisible(true);
        oceniVoznjuFrame.setBounds(20, 20, 200, 200);
//        listaKorisnikaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oceniVoznjuFrame.setResizable(false);
    }

}
