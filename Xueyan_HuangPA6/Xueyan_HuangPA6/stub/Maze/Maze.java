/**
 * Xueyan Huang
 * xueyanhuang@brandeis.edu
 * Dec 9, 2022
 * PA6
 * Explanation:Maze Class
 */

package Maze;

import java.awt.Color;
import java.util.*;

/**
 * Class that solves maze problems with backtracking.
 * 
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
        // this.findAllMazePaths(0, 0);
        // this.findMazePathMin(0, 0);
        return findMazePath(0, 0); // (0, 0) is the start point.
    }

    /**
     * Attempts to find a path through point (x, y).
     * 
     * @pre Possible path cells are in BACKGROUND color;
     *      barrier cells are in ABNORMAL color.
     * @post If a path is found, all cells on it are set to the
     *       PATH color; all cells that were visited but are
     *       not on the path are in the TEMPORARY color.
     * @param x The x-coordinate of current point
     * @param y The y-coordinate of current point
     * @return If a path through (x, y) is found, true;
     *         otherwise, false
     */
    public boolean findMazePath(int x, int y) {
        if (x > maze.getNCols() - 1 || y > maze.getNRows() - 1 || x < 0 || y < 0) {
            return false;
        }
        Color currentColor = maze.getColor(x, y);
        if (!currentColor.equals(NON_BACKGROUND) || currentColor.equals(TEMPORARY)) {
            return false;
        }
        maze.recolor(x, y, TEMPORARY);

        if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            maze.recolor(x, y, PATH);
            return true;
        }
        boolean isPath = findMazePath(x + 1, y) || findMazePath(x, y + 1) || findMazePath(x, y - 1)
                || findMazePath(x, y + 1);
        if (isPath) {
            maze.recolor(x, y, PATH);
        } else {
            maze.recolor(x, y, TEMPORARY);
        }
        return isPath;
    }

    // ADD METHOD FOR PROBLEM 2 HERE
    /**
     * @description: find all paths in the maze
     * @return all paths ArrayList
     */
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
        ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
        Stack<PairInt> trace = new Stack<>();
        findMazePathStackBased(0, 0, result, trace);
        if (result.size() == 0) {
            result.add(new ArrayList<PairInt>());
        }
        // System.out.println(result);
        return result;
    }

    /**
     * @description: The based function for the findMazePath
     * @param {int}                           x The x-coordinate of current point
     * @param {int}                           y The y-coordinate of current point
     * @param {ArrayList<ArrayList<PairInt>>} result The ArrayList of all paths
     * @param {Stack<PairInt>}                trace The Stack of tracing each path
     * @return void
     */
    public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
        if (x > maze.getNCols() - 1 || y > maze.getNRows() - 1 || x < 0 || y < 0) {
            return;
        }
        Color currentColor = maze.getColor(x, y);

        if (!currentColor.equals(NON_BACKGROUND)) {
            return;
        }
        PairInt current = new PairInt(x, y);
        trace.push(current);
        if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
            ArrayList<PairInt> currentPath = new ArrayList<PairInt>(trace);
            result.add(currentPath);
            trace.pop();
            return;
        }
        maze.recolor(x, y, PATH);
        findMazePathStackBased(x - 1, y, result, trace);
        findMazePathStackBased(x + 1, y, result, trace);
        findMazePathStackBased(x, y - 1, result, trace);
        findMazePathStackBased(x, y + 1, result, trace);

        trace.pop();
        maze.recolor(x, y, NON_BACKGROUND);
    }

    // ADD METHOD FOR PROBLEM 3 HERE
    /**
     * @description: Find the the smallest path
     * @return The ArrayList of the smallest path in PairInt type
     */
    public ArrayList<PairInt> findMazePathMin(int x, int y) {
        ArrayList<PairInt> result = new ArrayList<>();
        Stack<PairInt> path = new Stack<>();
        findMazePathMinBased(0, 0, path, result);
        // System.out.println(result);
        return result;
    }

    /**
     * @description: The based function for findMazePathMin
     * @param {int}                x The x-coordinate of current point
     * @param {int}                y The y-coordinate of current point
     * @param {Stack<PairInt>}     path The Stack of tracing each path
     * @param {ArrayList<PairInt>} result The ArrayList of the smallest path
     * @return {boolean}
     */
    public boolean findMazePathMinBased(int x, int y, Stack<PairInt> path, ArrayList<PairInt> result) {
        if (x > maze.getNCols() - 1 || y > maze.getNRows() - 1 || x < 0 || y < 0) {
            return false;
        }
        Color currentColor = maze.getColor(x, y);
        if (!currentColor.equals(NON_BACKGROUND)) {
            return false;
        }
        path.push(new PairInt(x, y));
        if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {

            if (path.size() < result.size() || result.size() == 0) {
                result.clear();
                result.addAll(path);
            }
            path.pop();
            return true;
        }
        maze.recolor(x, y, PATH);
        boolean left = findMazePathMinBased(x - 1, y, path, result);
        boolean right = findMazePathMinBased(x + 1, y, path, result);
        boolean down = findMazePathMinBased(x, y - 1, path, result);
        boolean up = findMazePathMinBased(x, y + 1, path, result);
        maze.recolor(x, y, NON_BACKGROUND);
        path.pop();
        if (left | right | down | up) {
            return true;
        }
        return false;
    }

    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }

    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
}
