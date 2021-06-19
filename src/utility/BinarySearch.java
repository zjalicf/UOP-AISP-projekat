package utility;


import entiteti.Automobil;
import entiteti.Voznja;
import entiteti.Korisnik;

import java.util.ArrayList;

public class BinarySearch {

    public Korisnik korisnikBinarySearch(ArrayList<Korisnik> lista, int target) {
        return korisnikBinarySearch(lista, target, 0, lista.size());
    }

    public Korisnik korisnikBinarySearch(ArrayList<Korisnik> lista, int target, int low, int high) {

        if(low > high) {
            return null;
        }

        int mid = (low + high) / 2;

        if (Integer.parseInt(lista.get(mid).getIdKorisnika()) == target) {
            return lista.get(mid);
        } else if (Integer.parseInt(lista.get(mid).getIdKorisnika()) > target) {
            return korisnikBinarySearch(lista, target, low, mid - 1);
        } else {
            return korisnikBinarySearch(lista, target, mid + 1, high);
        }
    }

    public Automobil automobilBinarySearch(ArrayList<Automobil> lista, int target) {
        return automobilBinarySearch(lista, target, 0, lista.size());
    }

    public Automobil automobilBinarySearch(ArrayList<Automobil> lista, int target, int low, int high) {

        if(low > high) {
            return null;
        }

        int mid = (low + high) / 2;

        if (Integer.parseInt(lista.get(mid).getIdAutomobila()) == target) {
            return lista.get(mid);
        } else if (Integer.parseInt(lista.get(mid).getIdAutomobila()) > target) {
            return automobilBinarySearch(lista, target, low, mid - 1);
        } else {
            return automobilBinarySearch(lista, target, mid + 1, high);
        }
    }

    public Voznja voznjaBinarySearch(ArrayList<Voznja> lista, int target) {
        return voznjaBinarySearch(lista, target, 0, lista.size());
    }

    public  Voznja voznjaBinarySearch(ArrayList<Voznja> lista, int target, int low, int high) {

        if(low > high) {
            return null;
        }

        int mid = (low + high) / 2;

        if (Integer.parseInt(lista.get(mid).getIdVoznje()) == target) {
            return lista.get(mid);
        } else if (Integer.parseInt(lista.get(mid).getIdVoznje()) > target) {
            return voznjaBinarySearch(lista, target, low, mid - 1);
        } else {
            return voznjaBinarySearch(lista, target,mid + 1, high);
        }
    }
}