
/**
 * Xueyan Huang
 * xueyanhuang@brandeis.edu
 * Dec 9, 2022
 * PA6
 * Explanation:PairInt Class
 */
package Maze;


public class PairInt {
    private int x;
    private int y;

    public PairInt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Object p) {
        if (p instanceof PairInt) {
            PairInt other = (PairInt) p;
            return other.getX() == this.x && other.getY() == this.y;
        }
        return false;
    }

    public PairInt copy() {
        return new PairInt(this.x, this.y);
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
