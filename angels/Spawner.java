package angels;

import players.Rogue;
import players.Wizard;
import players.Knight;
import players.Pyromancer;
import util.SpawnerConstants;

public class Spawner extends Angel {
    Spawner(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setName("Spawner");
    }

    /**
     * @param knight
     */

    // ingerii isi aplica magia in functie de playerul pe care il viziteaza
    public void visit(final Knight knight) {
        if (knight.getHp() <= 0) {
            String string = this.getName() + " helped " + knight.getFullName() + " "
                    + knight.getNumberOfPlayer();
            knight.notifyall(string);
            knight.setHp(SpawnerConstants.getNewHpKnight());
            String string1 = "Player " + knight.getFullName() + " " + knight.getNumberOfPlayer()
                    + " was brought to life by an angel";
            knight.notifyall(string1);
        }
    }

    /**
     * @param pyromancer
     */
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHp() <= 0) {
            String string = this.getName() + " helped " + pyromancer.getFullName() + " "
                    + pyromancer.getNumberOfPlayer();
            pyromancer.notifyall(string);
            pyromancer.setHp(SpawnerConstants.getNewHpPyromancer());
            String string1 = "Player " + pyromancer.getFullName() + " "
                    + pyromancer.getNumberOfPlayer() + " was brought to life by an angel";
            pyromancer.notifyall(string1);
        }
    }

    /**
     * @param rogue
     */
    public void visit(final Rogue rogue) {
        if (rogue.getHp() <= 0) {
            String string = this.getName() + " helped " + rogue.getFullName() + " "
                    + rogue.getNumberOfPlayer();
            rogue.notifyall(string);
            rogue.setHp(SpawnerConstants.getNewHpRogue());
            String string1 = "Player " + rogue.getFullName() + " " + rogue.getNumberOfPlayer()
                    + " was brought to life by an angel";
            rogue.notifyall(string1);
        }
    }

    /**
     * @param wizard
     */
    public void visit(final Wizard wizard) {
        if (wizard.getHp() <= 0) {
            String string = this.getName() + " helped " + wizard.getFullName() + " "
                    + wizard.getNumberOfPlayer();
            wizard.notifyall(string);
            wizard.setHp(SpawnerConstants.getNewHpWizard());
            String string1 = "Player " + wizard.getFullName() + " " + wizard.getNumberOfPlayer()
                    + " was brought to life by an angel";
            wizard.notifyall(string1);
        }
    }
}
