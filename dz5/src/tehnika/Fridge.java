package tehnika;

abstract class Fridge extends Tehnika {

    private boolean morozilka;
    private boolean internet;

    @Override
    void voice() {
        System.out.println("br-r-r");
    }

    public boolean isMorozilka() {
        return morozilka;
    }

    public void setMorozilka(boolean morozilka) {
        this.morozilka = morozilka;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }
}
