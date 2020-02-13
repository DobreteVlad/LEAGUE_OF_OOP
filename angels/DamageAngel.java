package angels;

import players.Rogue;
import players.Wizard;
import players.Knight;
import players.Pyromancer;
import util.DamageAngelConstants;

public class DamageAngel extends Angel {

    DamageAngel(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setName("DamageAngel");
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
            knight.setExecuteWIZARD(knight.getExecuteWIZARD()
                    + DamageAngelConstants.getBonusDamageKnight());
            knight.setExecutePYROMANCER(knight.getExecutePYROMANCER()
                    + DamageAngelConstants.getBonusDamageKnight());
            knight.setExecuteROGUE(knight.getExecuteROGUE()
                    + DamageAngelConstants.getBonusDamageKnight());
            knight.setSlamWIZARD(knight.getSlamWIZARD()
                    + DamageAngelConstants.getBonusDamageKnight());
            knight.setSlamPYROMANCER(knight.getSlamPYROMANCER()
                    + DamageAngelConstants.getBonusDamageKnight());
            knight.setSlamROGUE(knight.getSlamROGUE()
                    + DamageAngelConstants.getBonusDamageKnight());
            knight.setSlamKNIGHT(knight.getSlamKNIGHT()
                    + DamageAngelConstants.getBonusDamageKnight());
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
            pyromancer.setFIREBLASTWIZARD(pyromancer.getFIREBLASTWIZARD()
                    + DamageAngelConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTPYROMANCER(pyromancer.getFIREBLASTPYROMANCER()
                    + DamageAngelConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTROGUE(pyromancer.getFIREBLASTROGUE()
                    + DamageAngelConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTKNIGHT(pyromancer.getFIREBLASTKNIGHT()
                    + DamageAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEWIZARD(pyromancer.getIGNITEWIZARD()
                    + DamageAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEPYROMANCER(pyromancer.getIGNITEPYROMANCER()
                    + DamageAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEROGUE(pyromancer.getIGNITEROGUE()
                    + DamageAngelConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEKNIGHT(pyromancer.getIGNITEKNIGHT()
                    + DamageAngelConstants.getBonusDamagePyromancer());
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
                    + DamageAngelConstants.getBonusDamageRogue());
            rogue.setBACKSTABPYROMANCER(rogue.getBACKSTABPYROMANCER()
                    + DamageAngelConstants.getBonusDamageRogue());
            rogue.setBACKSTABROGUE(rogue.getBACKSTABROGUE()
                    + DamageAngelConstants.getBonusDamageRogue());
            rogue.setBACKSTABKNIGHT(rogue.getBACKSTABKNIGHT()
                    + DamageAngelConstants.getBonusDamageRogue());
            rogue.setparalysisWIZARD(rogue.getparalysisWIZARD()
                    + DamageAngelConstants.getBonusDamageRogue());
            rogue.setparalysisPYROMANCER(rogue.getparalysisPYROMANCER()
                    + DamageAngelConstants.getBonusDamageRogue());
            rogue.setparalysisROGUE(rogue.getparalysisROGUE()
                    + DamageAngelConstants.getBonusDamageRogue());
            rogue.setparalysisKNIGHT(rogue.getparalysisKNIGHT()
                    + DamageAngelConstants.getBonusDamageRogue());
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
                    + DamageAngelConstants.getBonusDamageWizard());
            wizard.setDrainROGUE(wizard.getDrainROGUE()
                    + DamageAngelConstants.getBonusDamageWizard());
            wizard.setDrainKNIGHT(wizard.getDrainKNIGHT()
                    + DamageAngelConstants.getBonusDamageWizard());
            wizard.setDrainWIZARD(wizard.getDrainWIZARD()
                    + DamageAngelConstants.getBonusDamageWizard());
            wizard.setDeflectPYROMANCER(wizard.getDeflectPYROMANCER()
                    + DamageAngelConstants.getBonusDamageWizard());
            wizard.setDeflectROGUE(wizard.getDeflectROGUE()
                    + DamageAngelConstants.getBonusDamageWizard());
            wizard.setDeflectKNIGHT(wizard.getDeflectKNIGHT()
                    + DamageAngelConstants.getBonusDamageWizard());
        }
    }
}
