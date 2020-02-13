package strategy;

import players.Wizard;
import players.Knight;
import players.Rogue;
import players.Pyromancer;

public interface Strategy {

    // interfata pentru cele 3 strategii cu implementari pentru toate tipurile de erou
    void applyStrategy(Knight knight);

    void applyStrategy(Pyromancer pyromancer);

    void applyStrategy(Wizard wizard);

    void applyStrategy(Rogue rogue);

}
