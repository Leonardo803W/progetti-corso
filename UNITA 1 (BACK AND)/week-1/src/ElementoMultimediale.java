abstract class ElementoMultimediale {

    protected String titolo;
    protected int durata;

    public ElementoMultimediale (String title, int duration) {

        this.titolo = title;
        this.durata = duration;
    }

    public abstract void esegui();
}
