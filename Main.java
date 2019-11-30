package main;
import fileio.FileSystem;
import players.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Player> myplayers=new ArrayList<Player>();
        int N,M;
        try {
            FileSystem fs = new FileSystem(args[0], args[1]);
            N=fs.nextInt();
            M=fs.nextInt();
            String p;
            char[][] land=new char[N][M];
            for(int i=0;i<N;i++){
                p=fs.nextWord();
                for(int j=0;j<M;j++){
                    land[i][j]=p.charAt(j);
                }
            }
            int P;
            P = fs.nextInt();
            for(int i = 0; i < P; i++){
                String name = fs.nextWord();
                int x = fs.nextInt();
                int y = fs.nextInt();
                myplayers.add(i, PlayerFactory.getInstance().CreatePlayer(name, x, y));
            }

            int R;
            R = fs.nextInt();
            char[][] move_matrix= new char[R][P];
//            System.out.println(R + "  " + P);
//            System.out.println(fs.nextWord().charAt(0));
//            System.out.println(fs.nextWord().charAt(0));

              for (int i = 0; i < R; i++) {
                  String direction = fs.nextWord();
                  for (int j = 0; j < P; j++) {
                      move_matrix[i][j] = direction.charAt(j);
                  }
              }
        }catch (Exception e1) {
            e1.printStackTrace();
        }

    }
}
