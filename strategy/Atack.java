package strategy;

import players.Rogue;
import players.Pyromancer;
import players.Knight;
import players.Wizard;

import util.Constants;
import util.AtackConstants;

public class Atack implements Strategy {

    // metoda pentru fiecare tip de erou prin care isi aplica strategia de atac
    public final void applyStrategy(final Knight knight) {
        knight.setExecuteWIZARD(knight.getExecuteWIZARD() + AtackConstants.getBonusDamageKnight());
        knight.setExecutePYROMANCER(knight.getExecutePYROMANCER()
                + AtackConstants.getBonusDamageKnight());
        knight.setExecuteROGUE(knight.getExecuteROGUE() + AtackConstants.getBonusDamageKnight());
        knight.setSlamWIZARD(knight.getSlamWIZARD() + AtackConstants.getBonusDamageKnight());
        knight.setSlamPYROMANCER(knight.getSlamPYROMANCER()
                + AtackConstants.getBonusDamageKnight());
        knight.setSlamROGUE(knight.getSlamROGUE() + AtackConstants.getBonusDamageKnight());
        knight.setSlamKNIGHT(knight.getSlamKNIGHT() + AtackConstants.getBonusDamageKnight());
        knight.modifyHp(-knight.getHp() / Constants.getFIVE());
    }

    public final void applyStrategy(final Pyromancer pyromancer) {
        pyromancer.setFIREBLASTWIZARD(pyromancer.getFIREBLASTWIZARD()
                + AtackConstants.getBonusDamagePyromancer());
        pyromancer.setFIREBLASTPYROMANCER(pyromancer.getFIREBLASTPYROMANCER()
                + AtackConstants.getBonusDamagePyromancer());
        pyromancer.setFIREBLASTROGUE(pyromancer.getFIREBLASTROGUE()
                + AtackConstants.getBonusDamagePyromancer());
        pyromancer.setFIREBLASTKNIGHT(pyromancer.getFIREBLASTKNIGHT()
                + AtackConstants.getBonusDamagePyromancer());
        pyromancer.setIGNITEWIZARD(pyromancer.getIGNITEWIZARD()
                + AtackConstants.getBonusDamagePyromancer());
        pyromancer.setIGNITEPYROMANCER(pyromancer.getIGNITEPYROMANCER()
                + AtackConstants.getBonusDamagePyromancer());
        pyromancer.setIGNITEROGUE(pyromancer.getIGNITEROGUE()
                + AtackConstants.getBonusDamagePyromancer());
        pyromancer.setIGNITEKNIGHT(pyromancer.getIGNITEKNIGHT()
                + AtackConstants.getBonusDamagePyromancer());
        pyromancer.addHp(-pyromancer.getHp() / Constants.getFOUR());
    }

    public final void applyStrategy(final Wizard wizard) {
        wizard.setDrainPYROMANCER(wizard.getDrainPYROMANCER()
                + AtackConstants.getBonusDamageWizard());
        wizard.setDrainROGUE(wizard.getDrainROGUE() + AtackConstants.getBonusDamageWizard());
        wizard.setDrainKNIGHT(wizard.getDrainKNIGHT() + AtackConstants.getBonusDamageWizard());
        wizard.setDrainWIZARD(wizard.getDrainWIZARD() + AtackConstants.getBonusDamageWizard());
        wizard.setDeflectPYROMANCER(wizard.getDeflectPYROMANCER()
                + AtackConstants.getBonusDamageWizard());
        wizard.setDeflectROGUE(wizard.getDeflectROGUE() + AtackConstants.getBonusDamageWizard());
        wizard.setDeflectKNIGHT(wizard.getDeflectKNIGHT()
                + AtackConstants.getBonusDamageWizard());
        wizard.addHp(-wizard.getHp() / Constants.getTEN());
    }

    public final void applyStrategy(final Rogue rogue) {
        rogue.setBACKSTABWIZARD(rogue.getBACKSTABWIZARD() + AtackConstants.getBonusDamageRogue());
        rogue.setBACKSTABPYROMANCER(rogue.getBACKSTABPYROMANCER()
                + AtackConstants.getBonusDamageRogue());
        rogue.setBACKSTABROGUE(rogue.getBACKSTABROGUE() + AtackConstants.getBonusDamageRogue());
        rogue.setBACKSTABKNIGHT(rogue.getBACKSTABKNIGHT() + AtackConstants.getBonusDamageRogue());
        rogue.setparalysisWIZARD(rogue.getparalysisWIZARD()
                + AtackConstants.getBonusDamageRogue());
        rogue.setparalysisPYROMANCER(rogue.getparalysisPYROMANCER()
                + AtackConstants.getBonusDamageRogue());
        rogue.setparalysisROGUE(rogue.getparalysisROGUE() + AtackConstants.getBonusDamageRogue());
        rogue.setparalysisKNIGHT(rogue.getparalysisKNIGHT()
                + AtackConstants.getBonusDamageRogue());
        rogue.addHp(-rogue.getHp() / Constants.getSEVEN());
    }
}
