package players;

import angels.Angel;
import main.Observator;
import strategy.Atack;
import strategy.Defense;
import strategy.NormalAtack;
import strategy.Strategy;
import util.PyromancerConstants;
import util.Constants;

public class Pyromancer extends Player {

    // pentru a putea salva modifierii pentru fiecare erou in parte
    // ii declar aici ca variabile
    // astfel devin unici pentru fiecare erou
    // iar ingerii pot modfica fara a mai avea grija ca se intersecteaza
    // modifierii de la eroi diferiti sau chiar de acelasi tip
    private float fireblastROGUE;
    private float fireblastKNIGHT;
    private float fireblastPYROMANCER;
    private float fireblastWIZARD;
    private float igniteROGUE;
    private float igniteKNIGHT;
    private float ignitePYROMANCER;
    private float igniteWIZARD;

    public final void setFIREBLASTROGUE(final float fireblastROGUEE) {
        this.fireblastROGUE = fireblastROGUEE;
    }

    public final void setFIREBLASTKNIGHT(final float fireblastKNIGHTT) {
        this.fireblastKNIGHT = fireblastKNIGHTT;
    }

    public final void setFIREBLASTPYROMANCER(final float fireblastPYROMANCERT) {
        this.fireblastPYROMANCER = fireblastPYROMANCERT;
    }

    public final void setFIREBLASTWIZARD(final float fireblastWIZARDD) {
        this.fireblastWIZARD = fireblastWIZARDD;
    }

    public final void setIGNITEROGUE(final float igniteROGUEE) {
        this.igniteROGUE = igniteROGUEE;
    }

    public final void setIGNITEKNIGHT(final float igniteKNIGHTT) {
        this.igniteKNIGHT = igniteKNIGHTT;
    }

    public final void setIGNITEPYROMANCER(final float ignitePYROMANCERR) {
        this.ignitePYROMANCER = ignitePYROMANCERR;
    }

    public final void setIGNITEWIZARD(final float igniteWIZARDD) {
        this.igniteWIZARD = igniteWIZARDD;
    }

    public final float getFIREBLASTROGUE() {
        return fireblastROGUE;
    }

    public final float getFIREBLASTKNIGHT() {
        return fireblastKNIGHT;
    }

    public final float getFIREBLASTPYROMANCER() {
        return fireblastPYROMANCER;
    }

    public final float getFIREBLASTWIZARD() {
        return fireblastWIZARD;
    }

    public final float getIGNITEROGUE() {
        return igniteROGUE;
    }

    public final float getIGNITEKNIGHT() {
        return igniteKNIGHT;
    }

    public final float getIGNITEPYROMANCER() {
        return ignitePYROMANCER;
    }

    public final float getIGNITEWIZARD() {
        return igniteWIZARD;
    }

    Pyromancer(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setHp(PyromancerConstants.getInitialHpPyromancer());
        this.setLevel(0);
        this.setXp(0);
        this.setName('P');
        this.setdamageFirstAbility(PyromancerConstants.getBaseDamageFireblast());
        this.setdamageSecondAbility(PyromancerConstants.getBaseDamageIgnite());
        this.setroundDamageIndicator(false);
        this.setnumberRoundsDamage(Constants.getFOUR());
        this.setdamageOvertime(PyromancerConstants.getOvertimeDamageIgnite());
        this.setmaxHp(PyromancerConstants.getInitialHpPyromancer());
        this.setincapacityMove(false);
        this.setdamageTotalNoRace(0);
        this.setdeadFromOvertime(0);
        this.setFullName("Pyromancer");
        this.setFIREBLASTROGUE(PyromancerConstants.getModifierFireblastRogue());
        this.setFIREBLASTKNIGHT(PyromancerConstants.getModifierFireblastKnight());
        this.setFIREBLASTPYROMANCER(PyromancerConstants.getModifierFireblastPyromancer());
        this.setFIREBLASTWIZARD(PyromancerConstants.getModifierFireblastWizard());
        this.setIGNITEROGUE(PyromancerConstants.getModifierIgniteRogue());
        this.setIGNITEKNIGHT(PyromancerConstants.getModifierIgniteKnight());
        this.setIGNITEPYROMANCER(PyromancerConstants.getModifierIgnitePyromancer());
        this.setIGNITEWIZARD(PyromancerConstants.getModifierIgniteWizard());
    }
    // Se accepta vist-ul de la fiecare inger
    public final void acceptAngel(final Angel angel) {
        angel.visit(this);

    }

    // In functie de cerinta, playerul alege una din cele 3 strategii
    public final void chooseStrategy() {
        if (this.getHp() > this.getmaxHp() / Constants.getFOUR() && this.getHp()
                < this.getmaxHp() / Constants.getTHREE()) {
            Strategy mystrategy = new Atack();
            mystrategy.applyStrategy(this);
        } else if (this.getHp() < this.getmaxHp() / Constants.getFOUR()) {
            Strategy mystrategy = new Defense();
            mystrategy.applyStrategy(this);
        } else {
            Strategy mystrategy = new NormalAtack();
            mystrategy.applyStrategy(this);
        }

    }

    @Override
    public final void addobservers(final Observator magician) {
        observer.add(magician);
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
        // aflu damage-ul total pentru prima abilitate in functie de land si race modifier
        this.addDamageLevelFirst(PyromancerConstants.getBoostDamageFireblast() * this.getLevel());
        float x = this.getdamageFirstAbility();
        if (land == 'V') {
            x = ((x * PyromancerConstants.getLandBonusVolcano()));
        }
        this.modifyDamageTotalNoRace(Math.round(x));
        if (enemy.getName() == 'R') {
            x = (x * this.getFIREBLASTROGUE());
        }
        if (enemy.getName() == 'K') {
            x = (x * this.getFIREBLASTKNIGHT());
        }
        if (enemy.getName() == 'P') {
            x = (x * this.getFIREBLASTPYROMANCER());
        }
        if (enemy.getName() == 'W') {
            x = (x * this.getFIREBLASTWIZARD());
        }
        this.setdamageFirstAbility(Math.round(x));
    }

    /**
     * @param enemy
     * @param land
     */
    public void secondAbility(final Player enemy, final char land) {
        // aflu damage-ul total pentru a doua abilitate
        // setez conditia de dmgOvertime a adversarului
        enemy.setroundDamageIndicator(true);
        float k = PyromancerConstants.getOvertimeDamageIgnite()
                + PyromancerConstants.getBoostOvertimeDamageIgnite() * this.getLevel();
        this.addDamageLevelSecond(PyromancerConstants.getBoostDamageIgnite()
                * this.getLevel());
        float x = this.getdamageSecondAbility();
        if (land == 'V') {
            x = ((x * PyromancerConstants.getLandBonusVolcano()));
            k = ((k * PyromancerConstants.getLandBonusVolcano()));
        }
        this.modifyDamageTotalNoRace(Math.round(x));
        if (enemy.getName() == 'R') {
            x = (x * this.getIGNITEROGUE());
            k = (k * this.getIGNITEROGUE());
        }
        if (enemy.getName() == 'K') {
            x = (x * this.getIGNITEKNIGHT());
            k = (k * this.getIGNITEKNIGHT());
        }
        if (enemy.getName() == 'P') {
            x = (x * this.getIGNITEPYROMANCER());
            k = (k * this.getIGNITEPYROMANCER());
        }
        if (enemy.getName() == 'W') {
            x = (x * this.getIGNITEWIZARD());
            k = (k * this.getIGNITEWIZARD());
        }
        this.setdamageSecondAbility(Math.round(x));
        enemy.setdamageOvertime(Math.round(k));
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
            } else if (this.getnumberRoundsDamage() >= Constants.getTWO()
                    && this.getnumberRoundsDamage() <= Constants.getTHREE()
                    && enemy.getName() == 'P') {
                this.modifyHp(-this.getdamageOvertime());
            }
        }
        this.setnumberRoundsDamage(this.getnumberRoundsDamage() - 1);
        if (this.getnumberRoundsDamage() == 0) {
            this.setroundDamageIndicator(false);
        }
        // daca cumva moare din damageOvertime retin pentru a nu
        // considera cresterea nivelului de XP
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
                this.setHp(this.getmaxHp() + Constants.getFIFTY());
                this.setmaxHp(this.getHp());
            }
            this.modifiyXp(Math.max(0, Constants.getFIFTY() * Constants.getFOUR() - (auxx
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
        int totalDamage = this.getdamageFirstAbility()
                + this.getdamageSecondAbility();
        if (enemy.getHp() > 0 && enemy.getHp() - totalDamage <= 0) {
            String string = "Player " + enemy.getFullName() + " " + enemy.getNumberOfPlayer()
                    + " was killed by " + this.getFullName() + " " + this.getNumberOfPlayer();
            this.notifyall(string);
        }
        enemy.modifyHp(-totalDamage);
        // calculezz dmg-ul total, il scad din viata adversarului si resetez
        // puterile inapoi la base dmg
        this.setdamageFirstAbility(PyromancerConstants.getBaseDamageFireblast());
        this.setdamageSecondAbility(PyromancerConstants.getBaseDamageIgnite());
    }
}
