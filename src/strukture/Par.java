package strukture;

public final class Par<A, B> {
    private final A vreme;
    private final B brKarte;

    public Par (A vreme, B brKarte) {
        this.vreme = vreme;
        this.brKarte = brKarte;
    }

    public A getVreme() {
        return vreme;
    }

    public B getBrKarte() {
        return brKarte;
    }

    @Override
    public String toString() {
        return "Par [" + "vreme=" + vreme + ", brKarte=" + brKarte + ']';
        //da li treba Par?
    }
}
