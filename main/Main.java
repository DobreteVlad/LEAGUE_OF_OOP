package main;

import angels.Angel;
import angels.AngelFactory;
import fileio.FileSystem;
import players.Player;
import players.PlayerFactory;
import util.Terrain;

import java.io.PrintStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


public final class Main {
    private Main() {

    }

    public static void main(final String[] args) {

        ArrayList<Player> myplayers = new ArrayList<Player>();
        Magician magician = Magician.getInstance();
        HashMap<Integer, ArrayList<Angel>> myHashAngels = new HashMap<Integer, ArrayList<Angel>>();
        int n, m;

        try {
            FileSystem fs = new FileSystem(args[0], args[1]);
            n = fs.nextInt();
            m = fs.nextInt();
            String q;
            char[][] land = new char[n][m];
            for (int i = 0; i < n; i++) {
                q = fs.nextWord();
                for (int j = 0; j < m; j++) {
                    land[i][j] = q.charAt(j);
                }
            }
            int p;
            Terrain mymap = Terrain.getInstance();
            Terrain.makemap(land);
            p = fs.nextInt();
            for (int i = 0; i < p; i++) {
                String name = fs.nextWord();
                int x = fs.nextInt();
                int y = fs.nextInt();
                myplayers.add(i, PlayerFactory.getInstance()
                        .createPlayer(name, x, y));
                myplayers.get(i).setNumberOfPlayer(i);
                myplayers.get(i).addobservers(magician);
            }
            int r;
            r = fs.nextInt();
            char[][] moveMatrix = new char[r][p];
            for (int i = 0; i < r; i++) {
                String direction = fs.nextWord();
                for (int j = 0; j < p; j++) {
                    moveMatrix[i][j] = direction.charAt(j);
                }
            }
            for (int i = 0; i < r; i++) {
                int number = fs.nextInt();
                ArrayList<Angel> myangels = new ArrayList<Angel>();
                for (int j = 0; j < number; j++) {
                    String str = fs.nextWord();
                    String[] components = str.split(",");
                    String angel = components[0];
                    int x = Integer.parseInt(components[1]);
                    int y = Integer.parseInt(components[2]);

                    myangels.add(j, AngelFactory.getInstance().createAngel(angel, x, y));
                }
                myHashAngels.put(i, myangels);
            }
            try {
                PrintStream o = new PrintStream(new File(args[1]));
                System.setOut(o);

                // mutarea jucatorilor, dupa comenzi
                for (int k = 0; k < r; k++) {
                    int f = k + 1;
                    for (int i = 0; i < p - 1; i++) {
                        for (int j = i + 1; j < p; j++) {
                            myplayers.get(j).damageOvertime(myplayers.get(i), k);
                            myplayers.get(i).damageOvertime(myplayers.get(j), k);
                        }
                    }

                    for (int i = 0; i < p; i++) {
                        if (!myplayers.get(i).isincapacityMove()) {
                            myplayers.get(i).chooseStrategy();
                        }

                    }
                    System.out.println("~~ Round " + f + " ~~");
                    for (int l = 0; l < p; l++) {

                        // daca jucatorul este afectat de abilitatea de incapacitare,
                        // acesta nu misca
                        if (moveMatrix[k][l] == 'U' && !myplayers.get(l).isincapacityMove()) {
                            myplayers.get(l).setX(myplayers.get(l).getX() - 1);
                            moveMatrix[k][l] = '_';
                        }
                        if (moveMatrix[k][l] == 'D' && !myplayers.get(l).isincapacityMove()) {
                            myplayers.get(l).setX(myplayers.get(l).getX() + 1);
                            moveMatrix[k][l] = '_';
                        }
                        if (moveMatrix[k][l] == 'L' && !myplayers.get(l).isincapacityMove()) {
                            myplayers.get(l).setY(myplayers.get(l).getY() - 1);
                            moveMatrix[k][l] = '_';
                        }
                        if (moveMatrix[k][l] == 'R' && !myplayers.get(l).isincapacityMove()) {
                            myplayers.get(l).setY(myplayers.get(l).getY() + 1);
                            moveMatrix[k][l] = '_';
                        }

                        myplayers.get(l).setincapacityMove(false);
                    }
                    // incep lupta, afland mai intai daca jucatorii se afla in aceeasi celula
                    for (int i = 0; i < p - 1; i++) {
                        for (int j = i + 1; j < p; j++) {
                            if (myplayers.get(i).getX() == myplayers.get(j).getX()
                                    && myplayers.get(i).getY() == myplayers.get(j).getY()
                                    && myplayers.get(i).getHp()
                                    > 0 && myplayers.get(j).getHp() > 0
                                    && myplayers.get(i).getName()
                                    != 'W') {
                                // aplic mai intai dmgOvertime
                                if (myplayers.get(i).getHp() > 0) {
                                    myplayers.get(i).firstAbility(myplayers.get(j),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(i).secondAbility(myplayers.get(j),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(i).totalDamage(myplayers.get(j),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(j).firstAbility(myplayers.get(i),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(j).secondAbility(myplayers.get(i),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(j).totalDamage(myplayers.get(i),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(i).levelModifier(myplayers.get(j));
                                    myplayers.get(j).levelModifier(myplayers.get(i));
                                }
                            } else if (myplayers.get(i).getX() == myplayers.get(j).getX()
                                    && myplayers.get(i).getY() == myplayers.get(j).getY()
                                    && myplayers.get(i).getHp() > 0 && myplayers.get(j).getHp()
                                    > 0) {
                                if (myplayers.get(j).getHp() > 0) {
                                    myplayers.get(j).firstAbility(myplayers.get(i),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(j).secondAbility(myplayers.get(i),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(j).totalDamage(myplayers.get(i),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(i).firstAbility(myplayers.get(j),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(i).secondAbility(myplayers.get(j),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(i).totalDamage(myplayers.get(j),
                                            Terrain.position(myplayers.get(i).getX(),
                                                    myplayers.get(i).getY()));
                                    myplayers.get(j).levelModifier(myplayers.get(i));
                                    myplayers.get(i).levelModifier(myplayers.get(j));
                                }
                            }
                        }
                    }
                    for (int l = 0; l < myHashAngels.get(k).size(); l++) {
                        myHashAngels.get(k).get(l).addobservers(magician);
                        String string = "Angel " + myHashAngels.get(k).get(l).getName()
                                + " was spawned at " + myHashAngels.get(k).get(l).getX()
                                + " " + myHashAngels.get(k).get(l).getY();
                        myHashAngels.get(k).get(l).notifyall(string);
                        for (int i = 0; i < p; i++) {
                            if (myplayers.get(i).getX() == myHashAngels.get(k).get(l).getX()
                                    && myplayers.get(i).getY()
                                    == myHashAngels.get(k).get(l).getY()) {
                                myplayers.get(i).acceptAngel(myHashAngels.get(k).get(l));
                            }
                        }
                    }
                }
                System.out.println("~~ Results ~~");
                for (int i = 0; i < p; i++) {
                    if (myplayers.get(i).getHp() <= 0) {
                        String string = myplayers.get(i).getName() + " " + "dead";
                        myplayers.get(i).notifyall(string);
                    } else {
                        String string = myplayers.get(i).getName() + " "
                                + myplayers.get(i).getLevel() + " " + myplayers.get(i).getXp()
                                + " " + myplayers.get(i).getHp() + " " + myplayers.get(i).getX()
                                + " " + myplayers.get(i).getY();
                        myplayers.get(i).notifyall(string);
                    }
                }
            } catch (Exception var8) {
                var8.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
