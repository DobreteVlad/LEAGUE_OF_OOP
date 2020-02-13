package strategy;

import players.Wizard;
import players.Knight;
import players.Rogue;
import players.Pyromancer;
import util.Constants;
import util.DefenseConstants;

public class Defense implements Strategy {

    // metoda pentru fiecare tip de erou prin care isi aplica strategia de defense
    public final void applyStrategy(final Knight knight) {
        knight.setExecuteWIZARD(knight.getExecuteWIZARD()
                - DefenseConstants.getBonusDamageKnight());
        knight.setExecutePYROMANCER(knight.getExecutePYROMANCER()
                - DefenseConstants.getBonusDamageKnight());
        knight.setExecuteROGUE(knight.getExecuteROGUE() - DefenseConstants.getBonusDamageKnight());
        knight.setSlamWIZARD(knight.getSlamWIZARD() - DefenseConstants.getBonusDamageKnight());
        knight.setSlamPYROMANCER(knight.getSlamPYROMANCER()
                - DefenseConstants.getBonusDamageKnight());
        knight.setSlamROGUE(knight.getSlamROGUE() - DefenseConstants.getBonusDamageKnight());
        knight.setSlamKNIGHT(knight.getSlamKNIGHT() - DefenseConstants.getBonusDamageKnight());
        knight.addHp(knight.getHp() / Constants.getFOUR());
    }

    public final void applyStrategy(final Pyromancer pyromancer) {
        pyromancer.setFIREBLASTWIZARD(pyromancer.getFIREBLASTWIZARD()
                - DefenseConstants.getBonusDamagePyromancer());
        pyromancer.setFIREBLASTPYROMANCER(pyromancer.getFIREBLASTPYROMANCER()
                - DefenseConstants.getBonusDamagePyromancer());
        pyromancer.setFIREBLASTROGUE(pyromancer.getFIREBLASTROGUE()
                - DefenseConstants.getBonusDamagePyromancer());
        pyromancer.setFIREBLASTKNIGHT(pyromancer.getFIREBLASTKNIGHT()
                - DefenseConstants.getBonusDamagePyromancer());
        pyromancer.setIGNITEWIZARD(pyromancer.getIGNITEWIZARD()
                - DefenseConstants.getBonusDamagePyromancer());
        pyromancer.setIGNITEPYROMANCER(pyromancer.getIGNITEPYROMANCER()
                - DefenseConstants.getBonusDamagePyromancer());
        pyromancer.setIGNITEROGUE(pyromancer.getIGNITEROGUE()
                - DefenseConstants.getBonusDamagePyromancer());
        pyromancer.setIGNITEKNIGHT(pyromancer.getIGNITEKNIGHT()
                - DefenseConstants.getBonusDamagePyromancer());
        pyromancer.addHp(pyromancer.getHp() / Constants.getTHREE());
    }

    public final void applyStrategy(final Wizard wizard) {
        wizard.setDrainPYROMANCER(wizard.getDrainPYROMANCER()
                - DefenseConstants.getBonusDamageWizard());
        wizard.setDrainROGUE(wizard.getDrainROGUE()
                - DefenseConstants.getBonusDamageWizard());
        wizard.setDrainKNIGHT(wizard.getDrainKNIGHT()
                - DefenseConstants.getBonusDamageWizard());
        wizard.setDrainWIZARD(wizard.getDrainWIZARD()
                - DefenseConstants.getBonusDamageWizard());
        wizard.setDeflectPYROMANCER(wizard.getDeflectPYROMANCER()
                - DefenseConstants.getBonusDamageWizard());
        wizard.setDeflectROGUE(wizard.getDeflectROGUE()
                - DefenseConstants.getBonusDamageWizard());
        wizard.setDeflectKNIGHT(wizard.getDeflectKNIGHT()
                - DefenseConstants.getBonusDamageWizard());
        wizard.addHp(wizard.getHp() / Constants.getFIVE());
    }

    public final void applyStrategy(final Rogue rogue) {
        rogue.setBACKSTABWIZARD(rogue.getBACKSTABWIZARD()
                - DefenseConstants.getBonusDamageRogue());
        rogue.setBACKSTABPYROMANCER(rogue.getBACKSTABPYROMANCER()
                - DefenseConstants.getBonusDamageRogue());
        rogue.setBACKSTABROGUE(rogue.getBACKSTABROGUE() - DefenseConstants.getBonusDamageRogue());
        rogue.setBACKSTABKNIGHT(rogue.getBACKSTABKNIGHT()
                - DefenseConstants.getBonusDamageRogue());
        rogue.setparalysisWIZARD(rogue.getparalysisWIZARD()
                - DefenseConstants.getBonusDamageRogue());
        rogue.setparalysisPYROMANCER(rogue.getparalysisPYROMANCER()
                - DefenseConstants.getBonusDamageRogue());
        rogue.setparalysisROGUE(rogue.getparalysisROGUE()
                - DefenseConstants.getBonusDamageRogue());
        rogue.setparalysisKNIGHT(rogue.getparalysisKNIGHT()
                - DefenseConstants.getBonusDamageRogue());
        rogue.addHp(rogue.getHp() / Constants.getTWO());
    }
}
