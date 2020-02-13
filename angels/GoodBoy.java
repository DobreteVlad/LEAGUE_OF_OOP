package angels;

import players.Rogue;
import players.Wizard;
import players.Knight;
import players.Pyromancer;
import util.GoodBoyConstants;


public class GoodBoy extends Angel {
    GoodBoy(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setName("GoodBoy");
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
                    + GoodBoyConstants.getBonusDamageWizard());
            knight.setExecutePYROMANCER(knight.getExecutePYROMANCER()
                    + GoodBoyConstants.getBonusDamageWizard());
            knight.setExecuteROGUE(knight.getExecuteROGUE()
                    + GoodBoyConstants.getBonusDamageWizard());
            knight.setSlamWIZARD(knight.getSlamWIZARD()
                    + GoodBoyConstants.getBonusDamageWizard());
            knight.setSlamPYROMANCER(knight.getSlamPYROMANCER()
                    + GoodBoyConstants.getBonusDamageWizard());
            knight.setSlamROGUE(knight.getSlamROGUE()
                    + GoodBoyConstants.getBonusDamageWizard());
            knight.setSlamKNIGHT(knight.getExecuteKNIGHT()
                    + GoodBoyConstants.getBonusDamageWizard());
            knight.addHp(GoodBoyConstants.getBonusHpKnight());
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
                    + GoodBoyConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTPYROMANCER(pyromancer.getFIREBLASTPYROMANCER()
                    + GoodBoyConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTROGUE(pyromancer.getFIREBLASTROGUE()
                    + GoodBoyConstants.getBonusDamagePyromancer());
            pyromancer.setFIREBLASTKNIGHT(pyromancer.getFIREBLASTKNIGHT()
                    + GoodBoyConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEWIZARD(pyromancer.getIGNITEWIZARD()
                    + GoodBoyConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEPYROMANCER(pyromancer.getIGNITEPYROMANCER()
                    + GoodBoyConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEROGUE(pyromancer.getIGNITEROGUE()
                    + GoodBoyConstants.getBonusDamagePyromancer());
            pyromancer.setIGNITEKNIGHT(pyromancer.getIGNITEKNIGHT()
                    + GoodBoyConstants.getBonusDamagePyromancer());
            pyromancer.addHp(GoodBoyConstants.getBonusHpPyromancer());
        }
    }

    /**
     * @param rogue
     */
    public void visit(final Rogue rogue) {
        if (rogue.getHp() > 0) {
            String string = this.getName() + " helped " + rogue.getFullName()
                    + " " + rogue.getNumberOfPlayer();
            rogue.notifyall(string);
            rogue.setBACKSTABWIZARD(rogue.getBACKSTABWIZARD()
                    + GoodBoyConstants.getBonusDamageRogue());
            rogue.setBACKSTABPYROMANCER(rogue.getBACKSTABPYROMANCER()
                    + GoodBoyConstants.getBonusDamageRogue());
            rogue.setBACKSTABROGUE(rogue.getBACKSTABROGUE()
                    + GoodBoyConstants.getBonusDamageRogue());
            rogue.setBACKSTABKNIGHT(rogue.getBACKSTABKNIGHT()
                    + GoodBoyConstants.getBonusDamageRogue());
            rogue.setparalysisWIZARD(rogue.getparalysisWIZARD()
                    + GoodBoyConstants.getBonusDamageRogue());
            rogue.setparalysisPYROMANCER(rogue.getparalysisPYROMANCER()
                    + GoodBoyConstants.getBonusDamageRogue());
            rogue.setparalysisROGUE(rogue.getparalysisROGUE()
                    + GoodBoyConstants.getBonusDamageRogue());
            rogue.setparalysisKNIGHT(rogue.getparalysisKNIGHT()
                    + GoodBoyConstants.getBonusDamageRogue());
            rogue.addHp(GoodBoyConstants.getBonusHpRogue());
        }
    }

    /**
     * @param wizard
     */
    public void visit(final Wizard wizard) {
        if (wizard.getHp() > 0) {
            String string = this.getName() + " helped " + wizard.getFullName()
                    + " " + wizard.getNumberOfPlayer();
            wizard.notifyall(string);
            wizard.setDrainPYROMANCER(wizard.getDrainPYROMANCER()
                    + GoodBoyConstants.getBonusDamageWizard());
            wizard.setDrainROGUE(wizard.getDrainROGUE()
                    + GoodBoyConstants.getBonusDamageWizard());
            wizard.setDrainKNIGHT(wizard.getDrainKNIGHT()
                    + GoodBoyConstants.getBonusDamageWizard());
            wizard.setDrainWIZARD(wizard.getDrainWIZARD()
                    + GoodBoyConstants.getBonusDamageWizard());
            wizard.setDeflectPYROMANCER(wizard.getDeflectPYROMANCER()
                    + GoodBoyConstants.getBonusDamageWizard());
            wizard.setDeflectROGUE(wizard.getDeflectROGUE()
                    + GoodBoyConstants.getBonusDamageWizard());
            wizard.setDeflectKNIGHT(wizard.getDeflectKNIGHT()
                    + GoodBoyConstants.getBonusDamageWizard());
            wizard.addHp(GoodBoyConstants.getBonusHpWizard());
        }
    }
}
