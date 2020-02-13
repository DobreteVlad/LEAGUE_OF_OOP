package players;

import angels.Angel;
import main.Observator;
import strategy.Atack;
import strategy.NormalAtack;
import strategy.Defense;
import strategy.Strategy;
import util.Constants;
import util.KnightConstants;

public class Knight extends Player {

    // pentru a putea salva modifierii pentru fiecare erou in parte
    // ii declar aici ca variabile
    // astfel devin unici pentru fiecare erou
    // iar ingerii pot modfica fara a mai avea grija ca se intersecteaza
    // modifierii de la eroi diferiti sau chiar de acelasi tip
    private float executeROGUE;
    private float executeKNIGHT;
    private float executePYROMANCER;
    private float executeWIZARD;
    private float slamROGUE;
    private float slamKNIGHT;
    private float slamPYROMANCER;
    private float slamWIZARD;

    public final void setExecuteROGUE(final float executeROGUEE) {
        this.executeROGUE = executeROGUEE;
    }

    public final void setExecuteKNIGHT(final float executeKNIGHTT) {
        this.executeKNIGHT = executeKNIGHTT;
    }

    public final void setExecutePYROMANCER(final float executePYROMANCERR) {
        this.executePYROMANCER = executePYROMANCERR;
    }

    public final void setExecuteWIZARD(final float executeWIZARDD) {
        this.executeWIZARD = executeWIZARDD;
    }

    public final void setSlamROGUE(final float slamROGUEE) {
        this.slamROGUE = slamROGUEE;
    }

    public final void setSlamKNIGHT(final float slamKNIGHTT) {
        this.slamKNIGHT = slamKNIGHTT;
    }

    public final void setSlamPYROMANCER(final float slamPYROMANCERR) {
        this.slamPYROMANCER = slamPYROMANCERR;
    }

    public final void setSlamWIZARD(final float slamWIZARDD) {
        this.slamWIZARD = slamWIZARDD;
    }

    public final float getExecuteROGUE() {
        return executeROGUE;
    }

    public final float getExecuteKNIGHT() {
        return executeKNIGHT;
    }

    public final float getExecutePYROMANCER() {
        return executePYROMANCER;
    }

    public final float getExecuteWIZARD() {
        return executeWIZARD;
    }

    public final float getSlamROGUE() {
        return slamROGUE;
    }

    public final float getSlamKNIGHT() {
        return slamKNIGHT;
    }

    public final float getSlamPYROMANCER() {
        return slamPYROMANCER;
    }

    public final float getSlamWIZARD() {
        return slamWIZARD;
    }

    Knight(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setHp(KnightConstants.getInitialHpKnight());
        this.setLevel(0);
        this.setName('K');
        this.setdamageFirstAbility(KnightConstants.getBaseDamageExecute());
        this.setdamageSecondAbility(KnightConstants.getBaseDamageSlam());
        this.setroundDamageIndicator(false);
        this.setnumberRoundsDamage(Constants.getFOUR());
        this.setmaxHp(KnightConstants.getInitialHpKnight());
        this.setincapacityMove(false);
        this.setdamageTotalNoRace(0);
        this.setFullName("Knight");
        this.setExecuteROGUE(KnightConstants.getModifierExecuteRogue());
        this.setExecuteKNIGHT(1f);
        this.setExecutePYROMANCER(KnightConstants.getModifierExecutePyromancer());
        this.setExecuteWIZARD(KnightConstants.getModifierExecuteWizard());
        this.setSlamROGUE(KnightConstants.getModifierSlamRogue());
        this.setSlamKNIGHT(KnightConstants.getModifierSlamKnight());
        this.setSlamPYROMANCER(KnightConstants.getModifierSlamPyromancer());
        this.setSlamWIZARD(KnightConstants.getModifierSlamWizard());
    }
    // Se accepta vist-ul de la fiecare inger
    public final void acceptAngel(final Angel angel) {
        angel.visit(this);
    }

    // In functie de cerinta, playerul alege una din cele 3 strategii
    public final void chooseStrategy() {
        if (this.getHp() > this.getmaxHp() / Constants.getTHREE() && this.getHp() < this.getmaxHp()
                / Constants.getTWO()) {
            Strategy mystrategy = new Atack();
            mystrategy.applyStrategy(this);
        } else if (this.getHp() < this.getmaxHp() / Constants.getTHREE()) {
            Strategy mystrategy = new Defense();
            mystrategy.applyStrategy(this);
        } else {
            Strategy mystrategy = new NormalAtack();
            mystrategy.applyStrategy(this);
        }

    }

    @Override
    public final void addobservers(final Observator magician) {
        this.observer.add(magician);
    }

    // daca apare o notificare, magicianul este anuntat
    @Override
    public final void notifyall(final String thestring) {
        for (int i = 0; i < observer.size(); i++) {
            observer.get(i).update(thestring);
        }
    }

    /**
     * @param enemy
     * @param land
     */
    public void firstAbility(final Player enemy, final char land) {
        this.addDamageLevelFirst(KnightConstants.getBoostDamageExecute() * this.getLevel());
        float x = this.getdamageFirstAbility();
        if (land == 'L') {
            x = (Math.round(x * KnightConstants.getLandBonusLand()));
        }
        this.modifyDamageTotalNoRace(x);
        if (enemy.getName() == 'R') {
            x = (x * this.getExecuteROGUE());
        }
        if (enemy.getName() == 'K') {
            x = (x * this.getExecuteKNIGHT());
        }
        if (enemy.getName() == 'P') {
            x = (x * this.getExecutePYROMANCER());
        }
        if (enemy.getName() == 'W') {
            x = (x * this.getExecuteWIZARD());
        }
        this.setdamageFirstAbility(Math.round(x));
    }

    /**
     * @param enemy
     * @param land
     */
    public void secondAbility(final Player enemy, final char land) {
        this.addDamageLevelSecond(KnightConstants.getBoostDamageSlam() * this.getLevel());
        float x = this.getdamageSecondAbility();
        if (land == 'L') {
            x = (Math.round(x * KnightConstants.getLandBonusLand()));
        }
        this.modifyDamageTotalNoRace(x);
        if (enemy.getName() == 'R') {
            x = (x * this.getSlamROGUE());
        }
        if (enemy.getName() == 'K') {
            x = (x * this.getSlamKNIGHT());
        }
        if (enemy.getName() == 'P') {
            x = (x * this.getSlamPYROMANCER());
        }
        if (enemy.getName() == 'W') {
            x = (x * this.getSlamWIZARD());
        }
        enemy.setincapacityMove(true);
        // setez incapacitatea adversarului pentru urmatoarea runda
        this.setdamageSecondAbility(Math.round(x));
    }

    /**
     * @param enemy
     * @param k
     */
    public void damageOvertime(final Player enemy, final int k) {
        // scad damage-ul primit in overtime in functie de adversar
        // numarul de runde depinde de adversar si teren

        if (this.isroundDamageIndicator()) {
            if (this.isbigOvertime() && k != 0) {
                if (this.getnumberRoundsDamage() >= Constants.getFOUR()
                        && this.getnumberRoundsDamage() <= Constants.getSIX()
                        && enemy.getName() == 'R') {
                    this.modifyHp(-this.getdamageOvertime());
                    this.setincapacityMove(true);
                }
                if (this.getnumberRoundsDamage() == Constants.getTHREE()) {
                    this.setbigOvertime(false);
                }
            }
            if (this.getnumberRoundsDamage() >= 1
                    && this.getnumberRoundsDamage() <= Constants.getTHREE()
                    && enemy.getName() == 'R') {
                this.modifyHp(-this.getdamageOvertime());
                this.setincapacityMove(true);
            } else if (this.getnumberRoundsDamage() >= 2
                    && this.getnumberRoundsDamage() <= Constants.getTHREE()
                    && enemy.getName() == 'P') {
                this.modifyHp(-this.getdamageOvertime());
            }
        }
        this.setnumberRoundsDamage(this.getnumberRoundsDamage() - 1);
        if (this.getnumberRoundsDamage() == 0) {
            this.setroundDamageIndicator(false);
        }
        if (this.getHp() <= 0) {
            this.setdeadFromOvertime(1);
        }
    }

    /**
     * @param enemy
     */
    public void levelModifier(final Player enemy) {
        // daca adversarul este mort si nu din overtime
        // implementez cresterea in nivel
        // Totodata, resetez si viata dupa indicatii
        int level = this.getLevel();
        if (enemy.getHp() <= 0 && this.getdeadFromOvertime() == 0 && this.getHp() > 0) {
            int auxx = this.getLevel();
            while (this.getXp() + Math.max(0, Constants.getFIFTY() * Constants.getFOUR()
                    - (auxx - enemy.getLevel()) * Constants.getFOURTY()) >= Constants.getFIFTY()
                    * Constants.getFIVE() + this.getLevel()
                    * Constants.getFIFTY()) {
                this.setLevel(this.getLevel() + 1);
                this.setHp(this.getmaxHp() + Constants.getFOURTY() * Constants.getTWO());
                this.setmaxHp(this.getHp());
            }
            this.modifiyXp(Math.max(0, Constants.getFIFTY()
                    * Constants.getFOUR() - (auxx
                    - enemy.getLevel()) * Constants.getFOURTY()));

            if (level < this.getLevel()) {
                int aux = this.getLevel() - level;
                for (int i = 0; i < aux; i++) {
                    level++;
                    String string = this.getFullName() + " " + this.getNumberOfPlayer()
                            + " reached level " + level;
                    this.notifyall(string);
                }
            }
        }
    }

    /**
     * @param enemy
     * @param land
     */
    public void totalDamage(final Player enemy, final char land) {
        // aflu daca Knight-ul se poate folosi de abilitatea speciala
        // prin care ia toata viata adversarului
        int totalDamage = this.getdamageFirstAbility()
                + this.getdamageSecondAbility();
        if (enemy.getHp() > 0 && enemy.getHp() - totalDamage <= 0) {
            String string = "Player " + enemy.getFullName() + " " + enemy.getNumberOfPlayer()
                    + " was killed by " + this.getFullName() + " " + this.getNumberOfPlayer();
            this.notifyall(string);
        }
        if (enemy.getHp() <= (enemy.getmaxHp() * ((float) (Constants.getTWO()
                / Constants.getTEN()) + ((float) (1 / Constants.getTEN()
                / Constants.getTEN())
                * this.getLevel()))) && (float) (Constants.getTWO()
                / Constants.getTEN())
                + ((float) (1 / Constants.getTEN() / Constants.getTEN())
                * this.getLevel()) <= (float) (Constants.getFOUR()
                / Constants.getTEN())) {
            enemy.setHp(0);
        } else if ((float) (Constants.getTWO()
                / Constants.getTEN()) + ((float) (1 / Constants.getTEN()
                / Constants.getTEN()) * this.getLevel())
                > (float) (Constants.getFOUR() / Constants.getTEN())
                && enemy.getHp() <= (enemy.getmaxHp()
                * (float) (Constants.getFOUR() / Constants.getTEN()))) {
            enemy.setHp(0);
        } else {
            enemy.modifyHp(-totalDamage);
        }
        // calculezz dmg-ul total, il scad din viata adversarului si resetez
        // puterile inapoi la base dmg
        this.setdamageSecondAbility(KnightConstants.getBaseDamageSlam());
        this.setdamageFirstAbility(KnightConstants.getBaseDamageExecute());

    }
}
