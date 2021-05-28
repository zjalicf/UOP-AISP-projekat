package main;

import GUI.FrameLauncher;

public class Main {
    public static void main(String[] args) {
        FrameLauncher.launchLoginFrame();
    }
}

// Primeri login podataka za korisnike (username:password):
// Dispecer Marko - marko:123
// Vozac Stefan - stefan:123
// Musterija Jelena - jelena:123

// Kada musterija narucuje voznju, adresa polaska i dolaska mora biti pravilno zapisana.
// Primer:
//        Adresa polaska: Rumenacka 11
//        Adresa dolaksa: Arse Teodorovica 5

// Promene u tabelama nisu live, dovoljno je samo izaci iz prozora tabela i kliknuti opet.
// Na primer obrisemo vozaca iz tabele, izadjemo iz prozora, kliknemo opet vozaci i on nece biti u tabeli.