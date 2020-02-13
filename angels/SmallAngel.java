package angels;

import players.Rogue;
import players.Wizard;
import players.Knight;
import players.Pyromancer;
import util.SmallAngelConstants;

public class SmallAngel extends Angel {
    SmallAngel(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setName("SmallAngel");
    }

    /**
     * @param knight
     */

    // ingerii isi aplica magia in functie de playerul pe care il viziteaza
    public void visit(final Knight knight) {
        if (knight.getHp() > 0) {
            String string = this.getName() + " helped " + knight.getFullName() + " "
                    + knight.getNumberOfPlayer();
            knight.notifyall(string);
            knight.setExecuteWIZARD(knight.getExecuteWIZARD()
                    + SmallAngelConstants.getBonusDamageKnight());
            knight.setExecutePYROMANCER(knight.getExecutePYROMANCER()
                    + SmallAngelConstants.getBonusDamageKnight());
            knight.setExecuteROGUE(knight.getExecuteROGUE()
                    + SmallAngelConstants.getBonusDamageKnight());
            knight.setSlamWIZARD(knight.getSlamWIZARD()
                    + SmallAngelConstants.getBonusDamageKnight());
            knight.setSlamPYROMANCER(knight.getSlamPYROMANCER()
                    + SmallAngelConstants.getBonusDamageKnight());
            knight.setSlamROGUE(knight.getSlamROGUE()
                    + SmallAngelConstants.getBonusDamageKnight());
            knight.setSlamKNIGHT(knight.getSlamKNIGHT()
                    + SmallAngelConstants.getBonusDamageKnight());
            knight.addHp(SmallAngelConstants.getBonusHpKnight());
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
            pyromancer.setFIREBLASTWIZARD(pyromancer.getFIREBLASTWIZARD()
                    + SmallAngelConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTPYROMANCER(pyromancer.getFIREBLASTPYROMANCER()
                    + SmallAngelConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTROGUE(pyromancer.getFIREBLASTROGUE()
                    + SmallAngelConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTKNIGHT(pyromancer.getFIREBLASTKNIGHT()
                    + SmallAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEWIZARD(pyromancer.getIGNITEWIZARD()
                    + SmallAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEPYROMANCER(pyromancer.getIGNITEPYROMANCER()
                    + SmallAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEROGUE(pyromancer.getIGNITEROGUE()
                    + SmallAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEKNIGHT(pyromancer.getIGNITEKNIGHT()
                    + SmallAngelConstants.getBonusDamagePyromancer());
            pyromancer.addHp(SmallAngelConstants.getBonusHpPyromancer());
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
            rogue.setBACKSTABWIZARD(rogue.getBACKSTABWIZARD()
                    + SmallAngelConstants.getBonusDamageRogue());
            rogue.setBACKSTABPYROMANCER(rogue.getBACKSTABPYROMANCER()
                    + SmallAngelConstants.getBonusDamageRogue());
            rogue.setBACKSTABROGUE(rogue.getBACKSTABROGUE()
                    + SmallAngelConstants.getBonusDamageRogue());
            rogue.setBACKSTABKNIGHT(rogue.getBACKSTABKNIGHT()
                    + SmallAngelConstants.getBonusDamageRogue());
            rogue.setparalysisWIZARD(rogue.getparalysisWIZARD()
                    + SmallAngelConstants.getBonusDamageRogue());
            rogue.setparalysisPYROMANCER(rogue.getparalysisPYROMANCER()
                    + SmallAngelConstants.getBonusDamageRogue());
            rogue.setparalysisROGUE(rogue.getparalysisROGUE()
                    + SmallAngelConstants.getBonusDamageRogue());
            rogue.setparalysisKNIGHT(rogue.getparalysisKNIGHT()
                    + SmallAngelConstants.getBonusDamageRogue());
            rogue.addHp(SmallAngelConstants.getBonusHpRogue());
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
            wizard.setDrainPYROMANCER(wizard.getDrainPYROMANCER()
                    + SmallAngelConstants.getBonusDamageWizard());
            wizard.setDrainROGUE(wizard.getDrainROGUE()
                    + SmallAngelConstants.getBonusDamageWizard());
            wizard.setDrainKNIGHT(wizard.getDrainKNIGHT()
                    + SmallAngelConstants.getBonusDamageWizard());
            wizard.setDrainWIZARD(wizard.getDrainWIZARD()
                    + SmallAngelConstants.getBonusDamageWizard());
            wizard.setDeflectPYROMANCER(wizard.getDeflectPYROMANCER()
                    + SmallAngelConstants.getBonusDamageWizard());
            wizard.setDeflectROGUE(wizard.getDeflectROGUE()
                    + SmallAngelConstants.getBonusDamageWizard());
            wizard.setDeflectKNIGHT(wizard.getDeflectKNIGHT()
                    + SmallAngelConstants.getBonusDamageWizard());
            wizard.addHp(SmallAngelConstants.getBonusHpWizard());
        }
    }
}
