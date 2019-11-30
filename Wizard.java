package players;
import static java.lang.Math.min;

public class Wizard extends Player {
    Wizard(int x,int y){
        this.setX(x);
        this.setY(y);
        this.setHp(400);
        this.setLevel(0);
        this.setName('W');
        this.setDamage_first_ability(0);
        this.setDamage_second_ability(0);
        this.setRound_damage_indicator(false);
        this.setNumber_rounds_damage(4);
        this.setDamage_overtime(50);
        this.setMax_hp(400);
        this.setIncapacity_move(false);
    }
    public void First_Ability(Player enemy, char land) {
        float aux=1;
        if(land=='D'){
            aux= (float) 1.1;
        }
        if(enemy.getName() == 'R'){
            this.setDamage_first_ability(Math.round(0.8f*((0.2f+0.05f*this.getLevel())*aux)*min(enemy.getMax_hp()*0.3f,enemy.getHp())));
            //System.out.println(enemy.getMax_hp() + " "+enemy.getName());
        }
        if(enemy.getName() == 'K'){
            this.setDamage_first_ability(Math.round(1.2f*((0.2f+0.05f*this.getLevel())*aux)*min(enemy.getMax_hp()*0.3f,enemy.getHp())));
        }
        if(enemy.getName() == 'P'){
            this.setDamage_first_ability(Math.round(0.9f*((0.2f+0.05f*this.getLevel())*aux)*min(enemy.getMax_hp()*0.3f,enemy.getHp())));
        }
        if(enemy.getName() == 'W'){
            this.setDamage_first_ability(Math.round(1.05f*((0.2f+0.05f*this.getLevel())*aux)*min(enemy.getMax_hp()*0.3f,enemy.getHp())));
        }
        //System.out.println(this.getDamage_first_ability()+ " ");
    }

    @Override
    public void Second_ability(Player enemy,  char land) {
        // NU STIUUUUUUUUUUUUU
        //System.out.println(enemy.getDamage_total_norace());
        if(enemy.getName()!='W') {
            float aux = 1;
            //System.out.println(enemy.getDamage_total_norace());
             float total_enemy_damage = enemy.getDamage_total_norace();
            //System.out.println(total_enemy_damage);
            enemy.Modify_damage_total_norace(-enemy.getDamage_total_norace());
            if (land == 'D') {
                aux = (float) 1.1;
            }
            if (enemy.getName() == 'R') {
                if ((0.35 + 0.02 * this.getLevel()) < 0.7) {
                    this.setDamage_second_ability(Math.round(1.2f * ((0.35f + 0.02f * this.getLevel()) * total_enemy_damage * aux)));
                } else {
                    this.setDamage_second_ability(Math.round(1.2f * (0.7f * total_enemy_damage * aux)));
                }
            }
            if (enemy.getName() == 'K') {
                if ((0.35 + 0.02 * this.getLevel()) < 0.7) {
                    this.setDamage_second_ability(Math.round(1.4f * ((0.35f + 0.02f * this.getLevel()) * total_enemy_damage * aux)));
                } else {
                    this.setDamage_second_ability(Math.round(1.4f * (0.7f * total_enemy_damage * aux)));
                }
            }
            if (enemy.getName() == 'P') {
                if ((0.35 + 0.02 * this.getLevel()) < 0.7) {
                    this.setDamage_second_ability(Math.round(1.3f * ((0.35f + 0.02f * this.getLevel()) * total_enemy_damage * aux)));
                } else {
                    this.setDamage_second_ability(Math.round(1.3f * (0.7f * total_enemy_damage * aux)));
                }
            }
            //System.out.println(this.getDamage_second_ability()+" ");
        }

    }
    public void Damage_overtime(Player enemy){
        if(this.isRound_damage_indicator()){
            // System.out.println(this.getNumber_rounds_damage());
            if(this.getNumber_rounds_damage()>=1 && this.getNumber_rounds_damage()<=3 && enemy.getName()=='R'){
                //System.out.println("da");
                this.Modify_hp(-this.getDamage_overtime());
            }
            else if(this.getNumber_rounds_damage()>=2 && this.getNumber_rounds_damage()<=3 && enemy.getName()=='P'){
                this.Modify_hp(-this.getDamage_overtime());
            }
            this.setNumber_rounds_damage(this.getNumber_rounds_damage() - 1);
            //System.out.println(this.getNumber_rounds_damage());
        }


    }
   public void Level_modifier(Player enemy){
        if(enemy.getHp() <= 0 ){
            this.Modifiy_Xp(Math.max(0, 200 -(this.getLevel()-enemy.getLevel())*40));
            if(250 + this.getLevel()*50  <= this.getXp()){
                this.setLevel(this.getLevel() + 1);
                this.setHp(400 + 30*this.getLevel());
                this.setMax_hp(this.getHp());
            }
        }
    }
    public void Total_Damage(Player enemy, char land){
        int total_damage = this.getDamage_first_ability() + this.getDamage_second_ability();
        enemy.Modify_hp(-total_damage);
        this.setDamage_first_ability(0);
        this.setDamage_second_ability(0);
    }
}
