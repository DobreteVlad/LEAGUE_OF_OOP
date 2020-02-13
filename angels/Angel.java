package angels;

import main.Observator;
import players.Rogue;
import players.Wizard;
import players.Knight;
import players.Pyromancer;

import java.util.ArrayList;


public abstract class Angel {

    // clasa abstract pentru ingeri
    // in funcite de caracteristicile fiecaruia
    // se suprascriu cele 4 vist-uri
    private int x;
    private int y;
    private String name;

    public final void setObserver(final ArrayList<Observator> observer) {
        this.observer = observer;
    }

    public final ArrayList<Observator> getObserver() {
        return observer;
    }

    private ArrayList<Observator> observer = new ArrayList<>();

    public final void addobservers(final Observator magician) {
        this.observer.add(magician);
    }

    // daca apare vreo modificare facuta de ingeri, este anuntat magicianul
    public final void notifyall(final String thestring) {
        for (int i = 0; i < observer.size(); i++) {
            observer.get(i).update(thestring);
        }
    }

    /**
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param x
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * @param y
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * @param knight
     */
    public abstract void visit(Knight knight);

    /**
     * @param pyromancer
     */
    public abstract void visit(Pyromancer pyromancer);

    /**
     * @param rogue
     */
    public abstract void visit(Rogue rogue);

    /**
     * @param wizard
     */
    public abstract void visit(Wizard wizard);
}
