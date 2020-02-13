package angels;

import players.Rogue;
import players.Wizard;
import players.Knight;
import players.Pyromancer;
import util.LifeGiverConstants;

public class LifeGiver extends Angel {
    public LifeGiver(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setName("LifeGiver");
    }

    /**
     * @param knight
     */

    // ingerii isi aplica magia in functie de playerul pe care il viziteaza
    public void visit(final Knight knight) {
        if (knight.getHp() > 0 && knight.getHp() + LifeGiverConstants.getBonusHpKnight()
                <= knight.getmaxHp()) {
            String string = this.getName() + " helped " + knight.getFullName() + " "
                    + knight.getNumberOfPlayer();
            knight.notifyall(string);
            knight.modifyHp(LifeGiverConstants.getBonusHpKnight());
        } else if (knight.getHp() + LifeGiverConstants.getBonusHpKnight() > knight.getmaxHp()) {
            knight.setHp(knight.getmaxHp());
            String string = this.getName() + " helped " + knight.getFullName() + " "
                    + knight.getNumberOfPlayer();
            knight.notifyall(string);
        }
    }

    /**
     * @param pyromancer
     */
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHp() > 0 && pyromancer.getHp()
                + LifeGiverConstants.getBonusHpPyromancer() <= pyromancer.getmaxHp()) {
            String string = this.getName() + " helped " + pyromancer.getFullName() + " "
                    + pyromancer.getNumberOfPlayer();
            pyromancer.notifyall(string);
            pyromancer.modifyHp(LifeGiverConstants.getBonusHpPyromancer());
        } else if (pyromancer.getHp() + LifeGiverConstants.getBonusHpPyromancer()
                > pyromancer.getmaxHp()) {
            pyromancer.setHp(pyromancer.getmaxHp());
            String string = this.getName() + " helped " + pyromancer.getFullName() + " "
                    + pyromancer.getNumberOfPlayer();
            pyromancer.notifyall(string);
        }
    }

    /**
     * @param rogue
     */
    public void visit(final Rogue rogue) {
        if (rogue.getHp() > 0 && rogue.getHp() + LifeGiverConstants.getBonusHpRogue()
                <= rogue.getmaxHp()) {
            String string = this.getName() + " helped " + rogue.getFullName() + " "
                    + rogue.getNumberOfPlayer();
            rogue.notifyall(string);
            rogue.modifyHp(LifeGiverConstants.getBonusHpRogue());
        } else if (rogue.getHp() + LifeGiverConstants.getBonusHpRogue() > rogue.getmaxHp()) {
            rogue.setHp(rogue.getmaxHp());
            String string = this.getName() + " helped " + rogue.getFullName() + " "
                    + rogue.getNumberOfPlayer();
            rogue.notifyall(string);
        }
    }

    /**
     * @param wizard
     */
    public void visit(final Wizard wizard) {
        if (wizard.getHp() > 0 && wizard.getHp() + LifeGiverConstants.getBonusHpWizard()
                <= wizard.getmaxHp()) {
            String string = this.getName() + " helped " + wizard.getFullName() + " "
                    + wizard.getNumberOfPlayer();
            wizard.notifyall(string);
            wizard.modifyHp(LifeGiverConstants.getBonusHpWizard());
        } else if (wizard.getHp() + LifeGiverConstants.getBonusHpWizard() > wizard.getmaxHp()) {
            wizard.setHp(wizard.getmaxHp());
            String string = this.getName() + " helped " + wizard.getFullName() + " "
                    + wizard.getNumberOfPlayer();
            wizard.notifyall(string);
        }
    }
}
