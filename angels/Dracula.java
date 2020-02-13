package angels;

import players.Rogue;
import players.Wizard;
import players.Knight;
import players.Pyromancer;
import util.DraculaConstants;

public class Dracula extends Angel {
    Dracula(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setName("Dracula");
    }

    /**
     * @param knight
     */

    // ingerii isi aplica magia in functie de playerul pe care il viziteaza
    public void visit(final Knight knight) {
        if (knight.getHp() > 0) {
            String string = this.getName() + " hit " + knight.getFullName()
                    + " " + knight.getNumberOfPlayer();
            knight.notifyall(string);
            knight.setExecuteWIZARD(knight.getExecuteWIZARD()
                    - DraculaConstants.getDecreaseDamageKnight());
            knight.setExecutePYROMANCER(knight.getExecutePYROMANCER()
                    - DraculaConstants.getDecreaseDamageKnight());
            knight.setExecuteROGUE(knight.getExecuteROGUE()
                    - DraculaConstants.getDecreaseDamageKnight());
            knight.setSlamWIZARD(knight.getSlamWIZARD()
                    - DraculaConstants.getDecreaseDamageKnight());
            knight.setSlamPYROMANCER(knight.getSlamPYROMANCER()
                    - DraculaConstants.getDecreaseDamageKnight());
            knight.setSlamROGUE(knight.getSlamROGUE()
                    - DraculaConstants.getDecreaseDamageKnight());
            knight.setSlamKNIGHT(knight.getSlamKNIGHT()
                    - DraculaConstants.getDecreaseDamageKnight());
            knight.addHp(-DraculaConstants.getDecreaseHpKnight());
            if (knight.getHp() <= 0) {
                String string1 = "Player " + knight.getFullName() + " "
                        + knight.getNumberOfPlayer() + " was killed by an angel";
                knight.notifyall(string1);
            }
        }
    }

    /**
     * @param pyromancer
     */
    public void visit(final Pyromancer pyromancer) {
        if (pyromancer.getHp() > 0) {
            String string = this.getName() + " hit " + pyromancer.getFullName()
                    + " " + pyromancer.getNumberOfPlayer();
            pyromancer.notifyall(string);
            pyromancer.setFIREBLASTWIZARD(pyromancer.getFIREBLASTWIZARD()
                    - DraculaConstants.getDecreaseDamagePyromancer());
            pyromancer.setFIREBLASTPYROMANCER(pyromancer.getFIREBLASTPYROMANCER()
                    - DraculaConstants.getDecreaseDamagePyromancer());
            pyromancer.setFIREBLASTROGUE(pyromancer.getFIREBLASTROGUE()
                    - DraculaConstants.getDecreaseDamagePyromancer());
            pyromancer.setFIREBLASTKNIGHT(pyromancer.getFIREBLASTKNIGHT()
                    - DraculaConstants.getDecreaseDamagePyromancer());
            pyromancer.setIGNITEWIZARD(pyromancer.getIGNITEWIZARD()
                    - DraculaConstants.getDecreaseDamagePyromancer());
            pyromancer.setIGNITEPYROMANCER(pyromancer.getIGNITEPYROMANCER()
                    - DraculaConstants.getDecreaseDamagePyromancer());
            pyromancer.setIGNITEROGUE(pyromancer.getIGNITEROGUE()
                    - DraculaConstants.getDecreaseDamagePyromancer());
            pyromancer.setIGNITEKNIGHT(pyromancer.getIGNITEKNIGHT()
                    - DraculaConstants.getDecreaseDamagePyromancer());
            pyromancer.addHp(-DraculaConstants.getDecreaseHpPyromancer());
            if (pyromancer.getHp() <= 0) {
                String string1 = "Player " + pyromancer.getFullName() + " "
                        + pyromancer.getNumberOfPlayer() + " was killed by an angel";
                pyromancer.notifyall(string1);
            }
        }
    }

    /**
     * @param rogue
     */
    public void visit(final Rogue rogue) {
        if (rogue.getHp() > 0) {
            String string = this.getName() + " hit " + rogue.getFullName()
                    + " " + rogue.getNumberOfPlayer();
            rogue.notifyall(string);
            rogue.setBACKSTABWIZARD(rogue.getBACKSTABWIZARD()
                    - DraculaConstants.getDecreaseDamageRogue());
            rogue.setBACKSTABPYROMANCER(rogue.getBACKSTABPYROMANCER()
                    - DraculaConstants.getDecreaseDamageRogue());
            rogue.setBACKSTABROGUE(rogue.getBACKSTABROGUE()
                    - DraculaConstants.getDecreaseDamageRogue());
            rogue.setBACKSTABKNIGHT(rogue.getBACKSTABKNIGHT()
                    - DraculaConstants.getDecreaseDamageRogue());
            rogue.setparalysisWIZARD(rogue.getparalysisWIZARD()
                    - DraculaConstants.getDecreaseDamageRogue());
            rogue.setparalysisPYROMANCER(rogue.getparalysisPYROMANCER()
                    - DraculaConstants.getDecreaseDamageRogue());
            rogue.setparalysisROGUE(rogue.getparalysisROGUE()
                    - DraculaConstants.getDecreaseDamageRogue());
            rogue.setparalysisKNIGHT(rogue.getparalysisKNIGHT()
                    - DraculaConstants.getDecreaseDamageRogue());
            rogue.addHp(-DraculaConstants.getDecreaseHpRogue());
            if (rogue.getHp() <= 0) {
                String string1 = "Player " + rogue.getFullName() + " "
                        + rogue.getNumberOfPlayer() + " was killed by an angel";
                rogue.notifyall(string1);
            }
        }
    }

    /**
     * @param wizard
     */
    public void visit(final Wizard wizard) {
        if (wizard.getHp() > 0) {
            String string = this.getName() + " hit " + wizard.getFullName()
                    + " " + wizard.getNumberOfPlayer();
            wizard.notifyall(string);
            wizard.setDrainPYROMANCER(wizard.getDrainPYROMANCER()
                    - DraculaConstants.getDecreaseDamageWizard());
            wizard.setDrainROGUE(wizard.getDrainROGUE()
                    - DraculaConstants.getDecreaseDamageWizard());
            wizard.setDrainKNIGHT(wizard.getDrainKNIGHT()
                    - DraculaConstants.getDecreaseDamageWizard());
            wizard.setDrainWIZARD(wizard.getDrainWIZARD()
                    - DraculaConstants.getDecreaseDamageWizard());
            wizard.setDeflectPYROMANCER(wizard.getDeflectPYROMANCER()
                    - DraculaConstants.getDecreaseDamageWizard());
            wizard.setDeflectROGUE(wizard.getDeflectROGUE()
                    - DraculaConstants.getDecreaseDamageWizard());
            wizard.setDeflectKNIGHT(wizard.getDeflectKNIGHT()
                    - DraculaConstants.getDecreaseDamageWizard());
            wizard.addHp(-DraculaConstants.getDecreaseHpWizard());
            if (wizard.getHp() <= 0) {
                String string1 = "Player " + wizard.getFullName() + " "
                        + wizard.getNumberOfPlayer() + " was killed by an angel";
                wizard.notifyall(string1);
            }
        }
    }
}
