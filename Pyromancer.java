package players;
import util.Constants;

public class Pyromancer extends Player {
    Pyromancer(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setHp(Constants.getInitialHpPyromancer());
        this.setLevel(0);
        this.setXp(0);
        this.setName('P');
        this.setdamageFirstAbility(Constants.getBaseDamageFireblast());
        this.setdamageSecondAbility(Constants.getBaseDamageIgnite());
        this.setroundDamageIndicator(false);
        this.setnumberRoundsDamage(Constants.getFOUR());
        this.setdamageOvertime(Constants.getOvertimeDamageIgnite());
        this.setmaxHp(Constants.getInitialHpPyromancer());
        this.setincapacityMove(false);
        this.setdamageTotalNoRace(0);
        this.setdeadFromOvertime(0);
    }

    /**
     *
     * @param enemy
     * @param land
     */
    public void firstAbility(final Player enemy, final char land) {
        // aflu damage-ul total pentru prima abilitate in functie de land si race modifier
        this.addDamageLevelFirst(Constants.getBoostDamageFireblast() * this.getLevel());
        float x = this.getdamageFirstAbility();
        if (land == 'V') {
            x = (x * Constants.getLandBonusVolcano());
        }
        this.modifyDamageTotalNoRace(Math.round(x));
        if (enemy.getName() == 'R') {
            x = (x * Constants.getFireblastRogue());
        }
        if (enemy.getName() == 'K') {
            x = (x * Constants.getFireblastKnight());
        }
        if (enemy.getName() == 'P') {
            x = (x * Constants.getFireblastPyromancer());
        }
        if (enemy.getName() == 'W') {
            x = (x * Constants.getFireblastWizard());
        }
        this.setdamageFirstAbility(Math.round(x));
    }

    /**
     *
     * @param enemy
     * @param land
     */
    public void secondAbility(final Player enemy, final char land) {
        // aflu damage-ul total pentru a doua abilitate
        // setez conditia de dmgOvertime a adversarului
        enemy.setroundDamageIndicator(true);
        float k = Constants.getOvertimeDamageIgnite()
                + Constants.getBoostOvertimeDamageIgnite() * this.getLevel();
        this.addDamageLevelSecond(Constants.getBoostDamageIgnite()
                * this.getLevel());
        float x = this.getdamageSecondAbility();
        if (land == 'V') {
            x = (x * Constants.getLandBonusVolcano());
            k = (k * Constants.getLandBonusVolcano());
        }
        this.modifyDamageTotalNoRace(Math.round(x));
        if (enemy.getName() == 'R') {
            x = (x * Constants.getIgniteRogue());
            k = (k * Constants.getIgniteRogue());
        }
        if (enemy.getName() == 'K') {
            x = (x * Constants.getIgniteKnight());
            k = (k * Constants.getIgniteKnight());
        }
        if (enemy.getName() == 'P') {
            x = (x * Constants.getIgnitePyromancer());
            k = (k * Constants.getIgnitePyromancer());
        }
        if (enemy.getName() == 'W') {
            x = (x * Constants.getIgniteWizard());
            k = (k * Constants.getIgniteWizard());
        }
        this.setdamageSecondAbility(Math.round(x));
        enemy.setdamageOvertime(Math.round(k));
    }

    /**
     *
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
     *
     * @param enemy
     */
    public void levelModifier(final Player enemy) {
        // daca adversarul este mort si nu din overtime
        // implementez cresterea in nivel
        // Totodata, resetez si viata dupa indicatii
        if (enemy.getHp() <= 0 && this.getdeadFromOvertime() == 0) {
            this.modifiyXp(Math.max(0, Constants.getFIFTY()
                    * Constants.getFOUR() - (this.getLevel()
                    - enemy.getLevel()) * Constants.getFOURTY()));
            if (this.getXp() >= Constants.getFIFTY() * Constants.getFIVE()) {
                this.setLevel(this.getLevel() + 1
                        + ((this.getXp() - Constants.getFIFTY()
                        * Constants.getFIVE()) / Constants.getFIFTY()));
                this.setHp(Constants.getInitialHpPyromancer()
                        + Constants.getBoostHpPyromancer() * this.getLevel());
                this.setmaxHp(this.getHp());
            }
        }
    }

    /**
     *
     * @param enemy
     * @param land
     */
    public void totalDamage(final Player enemy, final char land) {
        int totalDamage = this.getdamageFirstAbility()
                + this.getdamageSecondAbility();
        enemy.modifyHp(-totalDamage);
        // calculezz dmg-ul total, il scad din viata adversarului si resetez
        // puterile inapoi la base dmg
        this.setdamageFirstAbility(Constants.getBaseDamageFireblast());
        this.setdamageSecondAbility(Constants.getBaseDamageIgnite());
    }
}
