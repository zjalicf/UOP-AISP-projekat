package strukture;

public final class Par<A, B> {
    private final A km;
    private final B vreme;

    public Par (A first, B second) {
        this.km = first;
        this.vreme = second;
    }

    public A getKm() {
        return km;
    }

    public B getVreme() {
        return vreme;
    }
}
