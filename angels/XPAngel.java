package angels;

import players.Rogue;
import players.Wizard;
import players.Knight;
import players.Pyromancer;
import util.Constants;

public class XPAngel extends Angel {
    XPAngel(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setName("XPAngel");
    }

    // ingerii isi aplica magia in functie de playerul pe care il viziteaza
    /**
     * @param knight
     */
    public void visit(final Knight knight) {
        if (knight.getHp() > 0) {
            String string = this.getName() + " helped " + knight.getFullName() + " "
                    + knight.getNumberOfPlayer();
            knight.notifyall(string);
            if (knight.getXp() + Constants.getFIFTY() - Constants.getFIVE()
                    >= Constants.getFIFTY() * Constants.getFIVE()
                    + knight.getLevel() * Constants.getFIFTY()) {
                knight.setLevel(knight.getLevel() + 1);
                knight.setHp(knight.getmaxHp() + Constants.getTWO() * Constants.getFOURTY());
                knight.setmaxHp(knight.getHp());
                String string1 = knight.getFullName() + " " + knight.getNumberOfPlayer()
                        + " reached level " + knight.getLevel();
                knight.notifyall(string1);
            }
            knight.setXp(knight.getXp() + Constants.getFIFTY() - Constants.getFIVE());
        }
    }

    /**
     * @param pyromancer
     */
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHp() > 0) {
            String string = this.getName() + " helped " + pyromancer.getFullName() + " "
                    + pyromancer.getNumberOfPlayer();
            pyromancer.notifyall(string);
            pyromancer.setXp(pyromancer.getXp() + Constants.getFIFTY());
            if (pyromancer.getXp() >= Constants.getFIFTY() * Constants.getFIVE()) {
                pyromancer.setLevel(pyromancer.getLevel() + 1);
                pyromancer.setHp(pyromancer.getmaxHp() + Constants.getFIFTY());
                pyromancer.setmaxHp(pyromancer.getHp());
                String string1 = pyromancer.getFullName() + " " + pyromancer.getNumberOfPlayer()
                        + " reached level " + pyromancer.getLevel();
                pyromancer.notifyall(string1);
            }
        }
    }

    /**
     * @param rogue
     */
    public void visit(final Rogue rogue) {
        if (rogue.getHp() > 0) {
            String string = this.getName() + " helped " + rogue.getFullName() + " "
                    + rogue.getNumberOfPlayer();
            rogue.notifyall(string);
            if (rogue.getXp() + Constants.getFOURTY() >= Constants.getFIFTY() * Constants.getFIVE()
                    + (rogue.getLevel()) * Constants.getFIFTY()) {
                rogue.setLevel(rogue.getLevel() + 1);
                rogue.setHp(rogue.getmaxHp() + Constants.getFOURTY());
                rogue.setmaxHp(rogue.getHp());
                String string1 = rogue.getFullName() + " " + rogue.getNumberOfPlayer()
                        + " reached level " + rogue.getLevel();
                rogue.notifyall(string1);
            }
            rogue.setXp(rogue.getXp() + Constants.getFOURTY());
        }
    }

    /**
     * @param wizard
     */
    public void visit(final Wizard wizard) {
        if (wizard.getHp() > 0) {
            String string = this.getName() + " helped " + wizard.getFullName() + " "
                    + wizard.getNumberOfPlayer();
            wizard.notifyall(string);
            if (wizard.getXp() + Constants.getTEN() * Constants.getSIX() >= Constants.getFIFTY()
                    * Constants.getFIVE()
                    + wizard.getLevel() * Constants.getFIFTY()) {
                wizard.setLevel(wizard.getLevel() + 1);
                wizard.setHp(wizard.getmaxHp() + Constants.getTEN() * Constants.getTHREE());
                wizard.setmaxHp(wizard.getHp());
                String string1 = wizard.getFullName() + " " + wizard.getNumberOfPlayer()
                        + " reached level " + wizard.getLevel();
                wizard.notifyall(string1);
            }
            wizard.setXp(wizard.getXp() + Constants.getTEN() * Constants.getSIX());
            if (wizard.getXp() >= Constants.getFIFTY() * Constants.getFIVE()
                    + wizard.getLevel() * Constants.getFIFTY()) {
                wizard.setLevel(wizard.getLevel() + 1);
                wizard.setHp(wizard.getmaxHp() + Constants.getTEN() * Constants.getTHREE());
                wizard.setmaxHp(wizard.getHp());
                String string2 = wizard.getFullName() + " " + wizard.getNumberOfPlayer()
                        + " reached level " + wizard.getLevel();
                wizard.notifyall(string2);
            }
        }

    }

}
