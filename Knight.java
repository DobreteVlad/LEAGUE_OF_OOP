package players;

import util.Constants;

public class Knight extends Player {
    Knight(final int x, final int y) {
        this.setX(x);
        this.setY(y);
        this.setHp(Constants.getInitialHpKnight());
        this.setLevel(0);
        this.setName('K');
        this.setdamageFirstAbility(Constants.getBaseDamageExecute());
        this.setdamageSecondAbility(Constants.getBaseDamageSlam());
        this.setroundDamageIndicator(false);
        this.setnumberRoundsDamage(Constants.getFOUR());
        this.setmaxHp(Constants.getInitialHpKnight());
        this.setincapacityMove(false);
        this.setdamageTotalNoRace(0);
    }

    /**
     *
     * @param enemy
     * @param land
     */
    public void firstAbility(final Player enemy, final char land) {
        this.addDamageLevelFirst(Constants.getBoostDamageExecute() * this.getLevel());
        float x = this.getdamageFirstAbility();
        if (land == 'L') {
            x = (x * Constants.getLandBonusLand());
        }
        this.modifyDamageTotalNoRace(x);
        if (enemy.getName() == 'R') {
            x = (x * Constants.getExecuteRogue());
        }
        if (enemy.getName() == 'K') {
            x = (x * Constants.getExecuteKnight());
        }
        if (enemy.getName() == 'P') {
            x = (x * Constants.getExecutePyromancer());
        }
        if (enemy.getName() == 'W') {
            x = (x * Constants.getExecuteWizard());
        }
        this.setdamageFirstAbility(Math.round(x));
    }

    /**
     *
     * @param enemy
     * @param land
     */
    public void secondAbility(final Player enemy, final char land) {
        this.addDamageLevelSecond(Constants.getBoostDamageIgnite() * this.getLevel());
        float x = this.getdamageSecondAbility();
        if (land == 'L') {
            x = (x * Constants.getLandBonusLand());
        }
        this.modifyDamageTotalNoRace(x);
        if (enemy.getName() == 'R') {
            x = (x * Constants.getSlamRogue());
        }
        if (enemy.getName() == 'K') {
            x = (x * Constants.getSlamKnight());
        }
        if (enemy.getName() == 'P') {
            x = (x * Constants.getSlamPyromancer());
        }
        if (enemy.getName() == 'W') {
            x = (x * Constants.getSlamWizard());
        }
        enemy.setincapacityMove(true);
        // setez incapacitatea adversarului pentru urmatoarea runda
        this.setdamageSecondAbility(Math.round(x));
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
                        + ((this.getXp()
                        - Constants.getFIFTY() * Constants.getFIVE())
                        / Constants.getFIFTY()));
                this.setHp(Constants.getInitialHpKnight()
                        + Constants.getBoostHpKnight() * this.getLevel());
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
        // aflu daca Knight-ul se poate folosi de abilitatea speciala
        // prin care ia toata viata adversarului
        int totalDamage = this.getdamageFirstAbility()
                + this.getdamageSecondAbility();
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
        this.setdamageSecondAbility(Constants.getBaseDamageSlam());
        this.setdamageFirstAbility(Constants.getBaseDamageExecute());
    }
}
