// remove po indexu, remove last, remove object
package strukture;

public class Lista<T> {
    private Element<T> prvi;
    private Element<T> poslednji;

public Lista() {
}

public void add(T podatak) {
    if (prvi == null) {
        prvi = new Element<T>(podatak);
        poslednji = prvi;
    } else {
        Element<T> temp = new Element<T>(podatak);
        poslednji.setSledeci(temp);
        poslednji = temp;
    }
}

// Sta ako je index out of range
    // Sta ako je poslednji
public void removeAtIndex(int index) {
    if (index == 0) {
        prvi = prvi.getSledeci();
        return;
    }
    int brojac = 0;
    for(Element<T> i = prvi; i != null; i = i.getSledeci()) {
        if(brojac == index-1) {
            i.setSledeci(i.getSledeci().getSledeci());
        }
    }
}
}
