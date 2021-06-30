package utility;


import entiteti.Automobil;
import entiteti.Korisnik;
import entiteti.Voznja;
import strukture.Lista;

import java.util.ArrayList;

public class BinarySearch {

    public static Korisnik korisnikBinarySearch(Lista<Korisnik> lista, int target) {
        return korisnikBinarySearch(lista, target, 0, lista.getSize());
    }

    public static Korisnik korisnikBinarySearch(Lista<Korisnik> lista, int target, int low, int high) {
        if(low >= target) {
            int mid = (low + high) / 2;

            if (Integer.parseInt(lista.getElement(mid).getIdKorisnika()) == high) {
                return lista.getElement(mid);
            }

            if (Integer.parseInt(lista.getElement(mid).getIdKorisnika()) > high) {
                return korisnikBinarySearch(lista, target, mid - 1, high);
            }

            return korisnikBinarySearch(lista, mid + 1, low, high);
        }
        return null;
    }

    public static Automobil automobilBinarySearch(ArrayList<Automobil> lista, int target) {
        return automobilBinarySearch(lista, target, 0, lista.size());
    }

    public static Automobil automobilBinarySearch(ArrayList<Automobil> lista, int target, int low, int high) {
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

    public static Voznja voznjaBinarySearch(ArrayList<Voznja> lista, int target) {
        return voznjaBinarySearch(lista, target, 0, lista.size());
    }

    public static Voznja voznjaBinarySearch(ArrayList<Voznja> lista, int target, int low, int high) {
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