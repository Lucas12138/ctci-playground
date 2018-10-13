import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns. The robot an only move in two directions, right and down, but certain cells are "off limits" such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.
 * http://www.lucas-liu.com
 *
 * @author lucas
 * @create 2018-10-13 4:00 PM
 */
public class RobotInAGrid {

    class Point {
        int rowIndex;
        int colIndex;

        public Point(int rowIndex, int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return rowIndex == point.rowIndex &&
                    colIndex == point.colIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rowIndex, colIndex);
        }
    }

    public boolean searchPath(boolean[][] maze, List<Point> path, int row, int col, Set<Point> failedPoints) {
        if (row < 0 || col < 0 || !maze[row][col]) {
            return false;
        }

        Point point = new Point(row, col);
        if (failedPoints.contains(point)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);
        if (isAtOrigin || searchPath(maze, path, row - 1, col, failedPoints) || searchPath(maze, path, row, col - 1, failedPoints)) {
            path.add(point);
            return true;
        }

        failedPoints.add(point);
        return false;
    }

    public List<Point> getPath(boolean[][] maze) {
        List<Point> path = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();

        boolean isPathFound = searchPath(maze, path, maze.length - 1, maze[0].length - 1, failedPoints);
        if (isPathFound) {
            return path;
        }
        return null;
    }


    @Test
    public void test() {
        boolean[][] maze = {{true, true, false, false, false},
                            {false, true, true, false, false},
                            {false, false, true, false, false},
                            {false, false, true, false, false},
                            {false, false, true, true, true}};

        List<Point> path = getPath(maze);

        List<Point> expectedPath = new ArrayList<>();
        expectedPath.add(new Point(0,0));
        expectedPath.add(new Point(0,1));
        expectedPath.add(new Point(1,1));
        expectedPath.add(new Point(1,2));
        expectedPath.add(new Point(2,2));
        expectedPath.add(new Point(3,2));
        expectedPath.add(new Point(4,2));
        expectedPath.add(new Point(4,3));
        expectedPath.add(new Point(4,4));

        assertEquals(expectedPath, path);
    }
}
