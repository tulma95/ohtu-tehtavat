package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

class Nollaa extends Komento {

    private int edellinenTulos;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        this.edellinenTulos = sovellus.tulos();
        sovellus.nollaa();
        tuloskentta.setText(sovellus.tulos() + "");
        nollaa.disableProperty().set(true);
        undo.disableProperty().set(false);

    }

    @Override
    public void peru() {

        sovellus.plus(edellinenTulos);
        tuloskentta.setText(sovellus.tulos() + "");

        undo.disableProperty().set(true);
    }

}

class Summa extends Komento {

    private String edellinenLuku;

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        try {
            edellinenLuku = syotekentta.getText();
            sovellus.plus(Integer.parseInt(syotekentta.getText()));
            tuloskentta.setText(sovellus.tulos() + "");
            syotekentta.setText("");

            if (sovellus.tulos() == 0) {
                nollaa.disableProperty().set(true);
            } else {
                nollaa.disableProperty().set(false);
            }
            undo.disableProperty().set(false);

        } catch (Exception e) {
        }
    }

    @Override
    public void peru() {
        sovellus.miinus(Integer.parseInt(edellinenLuku));
        tuloskentta.setText(sovellus.tulos() + "");
        undo.disableProperty().set(true);
    }

}

class Erotus extends Komento {

    private String edellinenLuku;

    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        try {
            edellinenLuku = syotekentta.getText();
            sovellus.miinus(Integer.parseInt(syotekentta.getText()));
            tuloskentta.setText(sovellus.tulos() + "");
            syotekentta.setText("");

            if (sovellus.tulos() == 0) {
                nollaa.disableProperty().set(true);
            } else {
                nollaa.disableProperty().set(false);
            }
        } catch (Exception e) {
        }
        undo.disableProperty().set(false);

    }

    @Override
    public void peru() {
        sovellus.plus(Integer.parseInt(edellinenLuku));
        tuloskentta.setText(sovellus.tulos() + "");
        undo.disableProperty().set(true);
    }

}
