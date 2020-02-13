package main;

import util.Constants;

public final class Magician implements Observator {

    //implementarea singleton a magicianului
    private static Magician thegreat = null;
    private int exist;

    private Magician() {
    }

    public static Magician getInstance() {
        if (thegreat == null) {
            return new Magician();
        }
        return thegreat;
    }

    @Override
    public void update(final String string) {
        System.out.println(string);
    }
}
