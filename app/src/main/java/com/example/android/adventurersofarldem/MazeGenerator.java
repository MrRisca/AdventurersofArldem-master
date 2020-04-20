package com.example.android.adventurersofarldem;

import java.util.Collections;
import java.util.Arrays;



public class MazeGenerator {
    private int x;
    private int y;
    public int[][] maze;

    public MazeGenerator(int x, int y) {
        this.x = x;
        this.y = y;
        maze = new int[this.x][this.y];
        generateMaze(0, 0);

        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[i].length; j++){
                int cell = maze[i][j];

                System.out.println("Row "+i+" column "+j+" can move:");
                String dirString = "";
                for(DIR direction : DIR.values()){
                    if((cell & direction.bit) != 0){
                        dirString += direction.name();
                    }
                }
                System.out.println(dirString);
            }
        }
    }

    public boolean canMoveNorthFrom(int row, int col){
        return canMoveDirectionFrom(DIR.N, row, col);
    }
    public boolean canMoveSouthFrom(int row, int col){
        return canMoveDirectionFrom(DIR.S, row, col);
    }
    public boolean canMoveEastFrom(int row, int col){
        return canMoveDirectionFrom(DIR.E, row, col);
    }
    public boolean canMoveWestFrom(int row, int col){
        return canMoveDirectionFrom(DIR.W, row, col);
    }
    private boolean canMoveDirectionFrom(DIR dir, int row, int col){
        return (maze[row][col] & dir.bit) != 0;
    }

    public void display() {

        for (int i = 0; i < y; i++) {
            // draw the north edge
            for (int j = 0; j < x; j++) {
                System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");
            }
            System.out.println("+");
            // draw the west edge
            for (int j = 0; j < x; j++) {
                System.out.print((maze[j][i] & 8) == 0 ? "|   " : "    ");
            }
            System.out.println("|");
        }
        // draw the bottom line
        for (int j = 0; j < x; j++) {
            System.out.print("+---");
        }
        System.out.println("+");

    }

    private void generateMaze(int cx, int cy) {
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs) {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, x) && between(ny, y)
                    && (maze[nx][ny] == 0)) {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                generateMaze(nx, ny);
            }
        }
    }

    private static boolean between(int v, int upper) {
        return (v >= 0) && (v < upper);
    }

    private enum DIR {
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
        private final int bit;
        private final int dx;
        private final int dy;
        private DIR opposite;

        // use the static initializer to resolve forward references
        static {
            N.opposite = S;
            S.opposite = N;
            E.opposite = W;
            W.opposite = E;
        }

        private DIR(int bit, int dx, int dy) {
            this.bit = bit;
            this.dx = dx;
            this.dy = dy;
        }
    };


}