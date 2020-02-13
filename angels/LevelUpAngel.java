package angels;

import players.Rogue;
import players.Wizard;
import players.Knight;
import players.Pyromancer;
import util.Constants;
import util.PyromancerConstants;
import util.KnightConstants;
import util.WizardConstants;
import util.RogueConstants;
import util.LevelUpAngelConstants;

public class LevelUpAngel extends Angel {
    LevelUpAngel(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setName("LevelUpAngel");
    }

    /**
     * @param knight
     */

    // ingerii isi aplica magia in functie de playerul pe care il viziteaza
    public void visit(final Knight knight) {
        if (knight.getHp() > 0) {
            String string = this.getName() + " helped " + knight.getFullName()
                    + " " + knight.getNumberOfPlayer();
            knight.notifyall(string);
            knight.setXp(Constants.getFIFTY() * Constants.getFIVE() + knight.getLevel()
                    * Constants.getFIFTY());
            knight.setLevel(knight.getLevel() + 1);
            knight.setHp(KnightConstants.getInitialHpKnight() + knight.getLevel()
                    * KnightConstants.getBoostHpKnight());
            knight.setmaxHp(knight.getHp());
            knight.setExecuteWIZARD(knight.getExecuteWIZARD()
                    + LevelUpAngelConstants.getBonusDamageKnight());
            knight.setExecutePYROMANCER(knight.getExecutePYROMANCER()
                    + LevelUpAngelConstants.getBonusDamageKnight());
            knight.setExecuteROGUE(knight.getExecuteROGUE()
                    + LevelUpAngelConstants.getBonusDamageKnight());
            knight.setSlamWIZARD(knight.getSlamWIZARD()
                    + LevelUpAngelConstants.getBonusDamageKnight());
            knight.setSlamPYROMANCER(knight.getSlamPYROMANCER()
                    + LevelUpAngelConstants.getBonusDamageKnight());
            knight.setSlamROGUE(knight.getSlamROGUE()
                    + LevelUpAngelConstants.getBonusDamageKnight());
            knight.setSlamKNIGHT(knight.getSlamKNIGHT()
                    + LevelUpAngelConstants.getBonusDamageKnight());
            String string1 = knight.getFullName() + " " + knight.getNumberOfPlayer()
                    + " reached level " + knight.getLevel();
            knight.notifyall(string1);
        }
    }

    /**
     * @param pyromancer
     */
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHp() > 0) {
            String string = this.getName() + " helped " + pyromancer.getFullName()
                    + " " + pyromancer.getNumberOfPlayer();
            pyromancer.notifyall(string);
            pyromancer.setXp(Constants.getFIFTY() * Constants.getFIVE() + pyromancer.getLevel()
                    * Constants.getFIFTY());
            pyromancer.setLevel(pyromancer.getLevel() + 1);
            pyromancer.setHp(PyromancerConstants.getInitialHpPyromancer() + pyromancer.getLevel()
                    * PyromancerConstants.getBoostHpPyromancer());
            pyromancer.setmaxHp(pyromancer.getHp());
            pyromancer.setFIREBLASTWIZARD(pyromancer.getFIREBLASTWIZARD()
                    + LevelUpAngelConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTPYROMANCER(pyromancer.getFIREBLASTPYROMANCER()
                    + LevelUpAngelConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTROGUE(pyromancer.getFIREBLASTROGUE()
                    + LevelUpAngelConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTKNIGHT(pyromancer.getFIREBLASTKNIGHT()
                    + LevelUpAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEWIZARD(pyromancer.getIGNITEWIZARD()
                    + LevelUpAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEPYROMANCER(pyromancer.getIGNITEPYROMANCER()
                    + LevelUpAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEROGUE(pyromancer.getIGNITEROGUE()
                    + LevelUpAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEKNIGHT(pyromancer.getIGNITEKNIGHT()
                    + LevelUpAngelConstants.getBonusDamagePyromancer());
            String string1 = pyromancer.getFullName() + " " + pyromancer.getNumberOfPlayer()
                    + " reached level " + pyromancer.getLevel();
            pyromancer.notifyall(string1);
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
            rogue.setXp(Constants.getFIFTY() * Constants.getFIVE() + rogue.getLevel()
                    * Constants.getFIFTY());
            rogue.setLevel(rogue.getLevel() + 1);
            rogue.setHp(RogueConstants.getInitialHpRogue() + rogue.getLevel()
                    * RogueConstants.getBoostHpRogue());
            rogue.setmaxHp(rogue.getHp());
            rogue.setBACKSTABWIZARD(rogue.getBACKSTABWIZARD()
                    + LevelUpAngelConstants.getBonusDamageRogue());
            rogue.setBACKSTABPYROMANCER(rogue.getBACKSTABPYROMANCER()
                    + LevelUpAngelConstants.getBonusDamageRogue());
            rogue.setBACKSTABROGUE(rogue.getBACKSTABROGUE()
                    + LevelUpAngelConstants.getBonusDamageRogue());
            rogue.setBACKSTABKNIGHT(rogue.getBACKSTABKNIGHT()
                    + LevelUpAngelConstants.getBonusDamageRogue());
            rogue.setparalysisWIZARD(rogue.getparalysisWIZARD()
                    + LevelUpAngelConstants.getBonusDamageRogue());
            rogue.setparalysisPYROMANCER(rogue.getparalysisPYROMANCER()
                    + LevelUpAngelConstants.getBonusDamageRogue());
            rogue.setparalysisROGUE(rogue.getparalysisROGUE()
                    + LevelUpAngelConstants.getBonusDamageRogue());
            rogue.setparalysisKNIGHT(rogue.getparalysisKNIGHT()
                    + LevelUpAngelConstants.getBonusDamageRogue());
            String string1 = rogue.getFullName() + " " + rogue.getNumberOfPlayer()
                    + " reached level " + rogue.getLevel();
            rogue.notifyall(string1);
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
            wizard.setXp(Constants.getFIFTY() * Constants.getFIVE() + wizard.getLevel()
                    * Constants.getFIFTY());
            wizard.setLevel(wizard.getLevel() + 1);
            wizard.setHp(WizardConstants.getInitialHpWizard() + wizard.getLevel()
                    * WizardConstants.getBoostHpWizard());
            wizard.setmaxHp(wizard.getHp());
            wizard.setDrainPYROMANCER(wizard.getDrainPYROMANCER()
                    + LevelUpAngelConstants.getBonusDamageWizard());
            wizard.setDrainROGUE(wizard.getDrainROGUE()
                    + LevelUpAngelConstants.getBonusDamageWizard());
            wizard.setDrainKNIGHT(wizard.getDrainKNIGHT()
                    + LevelUpAngelConstants.getBonusDamageWizard());
            wizard.setDrainWIZARD(wizard.getDrainWIZARD()
                    + LevelUpAngelConstants.getBonusDamageWizard());
            wizard.setDeflectPYROMANCER(wizard.getDeflectPYROMANCER()
                    + LevelUpAngelConstants.getBonusDamageWizard());
            wizard.setDeflectROGUE(wizard.getDeflectROGUE()
                    + LevelUpAngelConstants.getBonusDamageWizard());
            wizard.setDeflectKNIGHT(wizard.getDeflectKNIGHT()
                    + LevelUpAngelConstants.getBonusDamageWizard());
            String string1 = wizard.getFullName() + " " + wizard.getNumberOfPlayer()
                    + " reached level " + wizard.getLevel();
            wizard.notifyall(string1);
        }
    }
}
