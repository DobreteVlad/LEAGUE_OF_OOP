package players;

public class Rogue extends Player {
    Rogue(int x, int y){
        this.setX(x);
        this.setY(y);
        this.setHp(600);
        this.setLevel(0);
        this.setName('R');
        this.setDamage_first_ability(200);
        this.setDamage_second_ability(40);
        this.setRound_damage_indicator(false);
        this.setNumber_rounds_damage(4);
        this.setDamage_overtime(50);
        this.setMax_hp(600);
        this.setIncapacity_move(false);
        this.setDamage_total_norace(0);
        this.setBackstab_numberhits(2);
    }
    public void First_Ability(Player enemy, char land) {
        //Nu am implementat BACKSTAB-ul
        this.setBackstab_numberhits(this.getBackstab_numberhits()+1);
        this.AddDamage_Level_First(20*this.getLevel());
        float x = this.getDamage_first_ability();
        if(this.getBackstab_numberhits()==3 && land == 'W'){
            x=(float)(x*1.5);
            this.setBackstab_numberhits(0);
        }
        if(land=='W'){
            x= (float) (x*1.15);
        }
        if(this.getBackstab_numberhits() == 3 && land== 'W'){
            x= (float) (x*1.5);
        }
        else if(this.getBackstab_numberhits() == 3){
            this.setBackstab_numberhits(0);
        }
        this.Modify_damage_total_norace(Math.round(x));
        //System.out.println(this.getDamage_total_norace());
        if(enemy.getName() == 'R'){
            x= (float) (x*1.2);
        }
        if(enemy.getName() == 'K'){
            x= (float) (x*0.9);
        }
        if(enemy.getName() == 'P'){
            x= (float) (x*1.25);
        }
        if(enemy.getName() == 'W'){
            x= (float) (x*1.25);
        }
        this.setDamage_first_ability(Math.round(x));
        // System.out.println(this.getDamage_first_ability()+ " ");
    }

    @Override
    public void Second_ability(Player enemy, char land) {
        this.AddDamage_Level_First(10*this.getLevel());
        enemy.setRound_damage_indicator(true);
        float x = this.getDamage_second_ability();
        if(enemy.getNumber_rounds_damage()==3)
        if(land=='W')
            enemy.setNumber_rounds_damage(6);
        if(land=='W'){
            x= (float) (x*1.15);
        }
        this.Modify_damage_total_norace(Math.round(x));
        //System.out.println(this.getDamage_total_norace());
        if(enemy.getName() == 'R'){
            x= (float) (x*0.9);;
        }
        if(enemy.getName() == 'K'){
            x= (float) (x*0.8);;
        }
        if(enemy.getName() == 'P'){
            x= (float) (x*1.2);;
        }
        if(enemy.getName() == 'W'){
            x= (float) (x*1.25);;
        }
        enemy.setDamage_overtime(Math.round(x));
        this.setDamage_second_ability(Math.round(x));
       // System.out.println(this.getDamage_second_ability()+ " ");
       // System.out.println(this.getDamage_total_norace());
    }
    public void Damage_overtime(Player enemy){
        if(this.isRound_damage_indicator()){
            // System.out.println(this.getNumber_rounds_damage());
            System.out.println("da");
            System.out.println(this.getNumber_rounds_damage());
            if(this.getNumber_rounds_damage()>=1 && this.getNumber_rounds_damage()<=3 && enemy.getName()=='R'){
                //System.out.println("da");
                this.Modify_hp(-this.getDamage_overtime());
            }
            else if(this.getNumber_rounds_damage()>=2 && this.getNumber_rounds_damage()<=3 && enemy.getName()=='P'){
                this.Modify_hp(-this.getDamage_overtime());
                //System.out.println("Da");
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
                this.setHp(600 + 40*this.getLevel());
                this.setMax_hp(this.getHp());
            }
        }
    }
    public void Total_Damage(Player enemy, char land){
        int total_damage = this.getDamage_first_ability() + this.getDamage_second_ability();
        enemy.Modify_hp(-total_damage);
        this.setDamage_first_ability(200);
        this.setDamage_second_ability(40);
    }


}
