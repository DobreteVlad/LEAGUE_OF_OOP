package main;

import fileio.FileSystem;
import players.Player;
import players.PlayerFactory;
import java.io.PrintStream;
import java.io.File;
import java.util.ArrayList;

public final class Main {
    private Main() {

    }
    public static void main(final String[] args) {
        ArrayList<Player> myplayers = new ArrayList<Player>();
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
            p = fs.nextInt();
            for (int i = 0; i < p; i++) {
                String name = fs.nextWord();
                int x = fs.nextInt();
                int y = fs.nextInt();
                myplayers.add(i, PlayerFactory.getInstance()
                        .createPlayer(name, x, y));
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
            for (int k = 0; k < r; k++) {
                for (int l = 0; l < p; l++) {
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
                for (int i = 0; i < p - 1; i++) {
                    for (int j = i + 1; j < p; j++) {
                        if (myplayers.get(i).getX() == myplayers.get(j).getX()
                                && myplayers.get(i).getY() == myplayers.get(j).getY()
                                && myplayers.get(i).getHp()
                                > 0 && myplayers.get(j).getHp() > 0 && myplayers.get(i).getName()
                                != 'W') {
                            myplayers.get(i).damageOvertime(myplayers.get(j), k);
                            if (myplayers.get(i).getHp() > 0) {
                                myplayers.get(i).firstAbility(myplayers.get(j),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(i).secondAbility(myplayers.get(j),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(i).totalDamage(myplayers.get(j),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(j).damageOvertime(myplayers.get(i), k);
                                myplayers.get(j).firstAbility(myplayers.get(i),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(j).secondAbility(myplayers.get(i),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(j).totalDamage(myplayers.get(i),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(i).levelModifier(myplayers.get(j));
                                myplayers.get(j).levelModifier(myplayers.get(i));
                            } else {
                                myplayers.get(j).damageOvertime(myplayers.get(i), k);
                            }
                        } else if (myplayers.get(i).getX() == myplayers.get(j).getX()
                                && myplayers.get(i).getY() == myplayers.get(j).getY()
                                && myplayers.get(i).getHp() > 0 && myplayers.get(j).getHp() > 0) {
                            myplayers.get(j).damageOvertime(myplayers.get(i), k);
                            if (myplayers.get(j).getHp() > 0) {
                                myplayers.get(j).firstAbility(myplayers.get(i),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(j).secondAbility(myplayers.get(i),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(j).totalDamage(myplayers.get(i),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(i).damageOvertime(myplayers.get(j), k);
                                myplayers.get(i).firstAbility(myplayers.get(j),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(i).secondAbility(myplayers.get(j),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(i).totalDamage(myplayers.get(j),
                                        land[myplayers.get(i).getX()][myplayers.get(i).getY()]);
                                myplayers.get(j).levelModifier(myplayers.get(i));
                                myplayers.get(i).levelModifier(myplayers.get(j));
                            } else {
                                myplayers.get(i).damageOvertime(myplayers.get(j), k);
                            }
                        }

                    }
                }
            }
            try {
                PrintStream o = new PrintStream(new File(args[1]));
                System.setOut(o);
                for (int i = 0; i < p; i++) {
                    if (myplayers.get(i).getHp() <= 0) {
                        System.out.println(myplayers.get(i).getName() + " " + "dead");
                    } else {
                        System.out.println(myplayers.get(i).getName() + " "
                                + myplayers.get(i).getLevel() + " " + myplayers.get(i).getXp()
                                + " " + myplayers.get(i).getHp() + " " + myplayers.get(i).getX()
                                + " " + myplayers.get(i).getY());
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
