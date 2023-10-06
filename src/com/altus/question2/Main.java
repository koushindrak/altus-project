package com.altus.question2;

public class Main {
    /**
     * The entry point of the program.
     */
    public static void main(String[] args) {
        Robot rob = new Robot();
        solveMaze(rob);
    }

    /**
     * Recursively attempts to solve the maze by moving forward and trying different directions upon encountering a wall.
     * The function recurses by trying to move in a direction, then calling itself.
     * 
     * @param rob The Robot object.
     * @return true if the maze is solved, false otherwise.
     */
    public static boolean solveMaze(Robot rob) {
        if (rob.hasExited()) {
            return true;
        }

        if (rob.isPathClear() && tryToMove(rob) && solveMaze(rob)) {
            return true;
        }

        rob.turnLeft(); rob.turnLeft(); rob.turnLeft(); 
        if (rob.isPathClear() && tryToMove(rob) && solveMaze(rob)) {
            return true;
        }

        rob.turnLeft(); rob.turnLeft();
        if (rob.isPathClear() && tryToMove(rob) && solveMaze(rob)) {
            return true;
        }

        rob.turnLeft();
        return false;
    }

    /**
     * Tries to move the robot forward and handles any exceptions that occur when hitting a wall.
     * 
     * @param rob The Robot object.
     * @return true if move forward is successful, false otherwise.
     */
    public static boolean tryToMove(Robot rob) {
        try {
            rob.moveForward();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

/*

Time Complexity (TC):
O(3^(m*n)) - where m and n represent the dimensions of the maze. This complexity is derived from the possibility of exploring almost all viable paths, making up to 3 decisions at most maze cells.

Space Complexity (SC):
O(m*n) - primarily due to the maximum depth of the recursion stack in the worst-case scenario, potentially exploring every cell of the maze.

 */