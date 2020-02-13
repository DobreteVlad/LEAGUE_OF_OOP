package angels;

import players.Rogue;
import players.Wizard;
import players.Knight;
import players.Pyromancer;

public class TheDoomer extends Angel {
    TheDoomer(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setName("TheDoomer");
    }

    /**
     * @param knight
     */

    // ingerii isi aplica magia in functie de playerul pe care il viziteaza
    public void visit(final Knight knight) {
        if (knight.getHp() > 0) {
            String string = this.getName() + " hit " + knight.getFullName() + " "
                    + knight.getNumberOfPlayer();
            knight.notifyall(string);
            knight.addHp(-knight.getHp());
            String string1 = "Player " + knight.getFullName() + " " + knight.getNumberOfPlayer()
                    + " was killed by an angel";
            knight.notifyall(string1);
        }
    }

    /**
     * @param pyromancer
     */
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHp() > 0) {
            String string = this.getName() + " hit " + pyromancer.getFullName() + " "
                    + pyromancer.getNumberOfPlayer();
            pyromancer.notifyall(string);
            pyromancer.addHp(-pyromancer.getHp());
            String string1 = "Player " + pyromancer.getFullName() + " "
                    + pyromancer.getNumberOfPlayer() + " was killed by an angel";
            pyromancer.notifyall(string1);
        }
    }

    /**
     * @param rogue
     */
    public void visit(final Rogue rogue) {
        if (rogue.getHp() > 0) {
            String string = this.getName() + " hit " + rogue.getFullName() + " "
                    + rogue.getNumberOfPlayer();
            rogue.notifyall(string);
            rogue.addHp(-rogue.getHp());
            String string1 = "Player " + rogue.getFullName() + " " + rogue.getNumberOfPlayer()
                    + " was killed by an angel";
            rogue.notifyall(string1);
        }
    }

    /**
     * @param wizard
     */
    public void visit(final Wizard wizard) {
        if (wizard.getHp() > 0) {
            String string = this.getName() + " hit " + wizard.getFullName() + " "
                    + wizard.getNumberOfPlayer();
            wizard.notifyall(string);
            wizard.addHp(-wizard.getHp());
            String string1 = "Player " + wizard.getFullName() + " " + wizard.getNumberOfPlayer()
                    + " was killed by an angel";
            wizard.notifyall(string1);
        }
    }
}
