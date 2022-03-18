package hw4_20001976_PhamBaThang.bai6.maze;

import hw4_20001976_PhamBaThang.bai2.LinkedListStack;

public class MazeSolver {

    public static void findPath(int[][] maze, LinkedListStack<Position> path, int startX,
                                int startY, int endX, int endY) {
        boolean done = false;
        path.push(new Position(startY, startX));
        while (!path.isEmpty() && !done) {
            Position current = path.top();
            Position.Movable newDir = current.getUnvisitedDir(maze);

            if (newDir == Position.Movable.no)
                path.pop();
            else {
                Position newPosition = current.move(newDir);
                maze[newPosition.getY()][newPosition.getX()] = 2;
                path.push(newPosition);
                if (newPosition.getY() == endY && newPosition.getX() == endX)
                    done = true;
            }
        }
    }
}

