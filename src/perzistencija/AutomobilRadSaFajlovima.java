package perzistencija;

import entiteti.Automobil;
import strukture.Lista;

public class AutomobilRadSaFajlovima extends RadSaFajlovima{
    @Override
    public void upis(Lista lista) {
        // upisati listu u txt
    }

    @Override
    public Lista citanje() {
        Lista<Automobil> lista = new Lista<>();
        Automobil automobil = new Automobil();
        //otvori streamIO na lokaciji fajla automobili.txt, while hasnext ucitaj ceo red, rasclani po |, 1 je model...
        //automobil.setModel()
        lista.add(automobil);
        // citati iz fajla
        return lista;
    }
}
