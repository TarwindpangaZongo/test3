package com.example.test3;

public class Room {


    static public class Building {

        public final boolean isInfected;
        public boolean visited = false;

        Building(boolean infected) {
            isInfected = infected;
        }

    }


    private static int returnSize(Building[][] cells, int x, int y) {
        if (x < 0 || y < 0 || x > cells.length || y >= cells[x].length) {
            return 0;
        }

        if (!cells[x][y].isInfected || cells[x][y].visited) {
            return 0;
        }


        cells[x][y].visited = true;
        int size = 1;
        for (int i = x - 1; i <= x + 1; i++) {

            for (int c = y - 1; c <= y + 1; c++) {
                if (i == x || c == y) {
                    size += returnSize(cells, i, c);
                }
            }
        }

        return size;
    }


    public static boolean isOutbreak(Building[][] floor) {

        for (int x = 0; x < floor.length; x++) {
            for (int y = 0; y < floor[x].length; y++) {

                if (floor[x][y].isInfected && !floor[x][y].visited) {

                    int size = returnSize(floor, x, y);

                    if (size >= 5)
                        return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {


        Building[][] verticalTrue = new Building[][]{
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(true), new Building(false), new Building(true), new Building(true), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(true), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(true), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(true), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(true), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)}
        };


        Building[][] horizontalTrue = new Building[][]{
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(true), new Building(true), new Building(true), new Building(true), new Building(true), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)}
        };


        Building[][] noInfection = new Building[][]{
                {new Building(true), new Building(false), new Building(true), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(true), new Building(false), new Building(true), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(true), new Building(false), new Building(true), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(true), new Building(false), new Building(true), new Building(false), new Building(true), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(true), new Building(false), new Building(false), new Building(true), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(true), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(true), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)},
                {new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false), new Building(false)}
        };


        System.out.println("Horizontal = " + isOutbreak(verticalTrue));
        System.out.println("Vertical = " + isOutbreak(horizontalTrue));
        System.out.println("No Outbreak = " + isOutbreak(noInfection));
    }

}

