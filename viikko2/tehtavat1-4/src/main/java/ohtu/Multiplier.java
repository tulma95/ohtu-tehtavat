package ohtu;

/**
 * Multiplier
 */
public class Multiplier {
    private int value;

    public Multiplier(int value) {
        this.value = value;
    }

    public int multipliedBy(int other) {
        return value * other;
    }
}