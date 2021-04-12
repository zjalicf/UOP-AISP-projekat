package strukture;

public class Element<T> { //
    private Element sledeci;
    private T podatak;

    public Element(Element sledeci) {
    this.sledeci = sledeci;
    }

    public Element(T podatak) {
    this.podatak = podatak;
    }

    public Element() {
    }

    public Element getSledeci() {
        return sledeci;
    }

    public void setSledeci(Element sledeci) {
        this.sledeci = sledeci;
    }

    public T getPodatak() {
        return podatak;
    }

    public void setPodatak(T podatak) {
        this.podatak = podatak;
    }
}
