package hw4_20001976_PhamBaThang.bai6.maze;

public class Block {
    private final int y;
    private final int x;

    public Block(int y, int x) {
        this.y = y;
        this.x = x;
    }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Movable getUnvisitedBlock(int[][] maze) {
        if (x + 1 < maze[0].length) {
            if (maze[y][x + 1] == 0)
                return Movable.right;
        }

        if (x - 1 >= 0) {
            if (maze[y][x - 1] == 0)
                return Movable.left;
        }

        if (y - 1 >= 0) {
            if (maze[y - 1][x] == 0)
                return Movable.up;
        }

        if (y + 1 < maze.length) {
            if (maze[y + 1][x] == 0)
                return Movable.down;
        }

        return Movable.no;
    }

    public Block move(Movable newDir) {
        return switch (newDir) {
            case right -> new Block(y, x + 1);
            case left -> new Block(y, x - 1);
            case up -> new Block(y - 1, x);
            case down -> new Block(y + 1, x);
            default -> null;
        };
    }

    enum Movable {right, left, up, down, no}
}
