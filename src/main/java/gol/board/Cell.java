package gol.board;

import java.util.HashSet;
import java.util.Set;

import gol.rule.CellState;

/**
 * @author Klaus Bayrhammer
 */
public class Cell
{
    private final Point coordinates;
    private CellState currentState = CellState.DEAD;
    private Set<Cell> neighbors = new HashSet<Cell>();

    public Cell(int x, int y)
    {
        coordinates = new Point(x, y);
    }

    public CellState getCurrentState()
    {
        return currentState;
    }

    public void setCurrentState(CellState currentState)
    {
        this.currentState = currentState;
    }

    public boolean isAt(int x, int y)
    {
        return coordinates.equals(new Point(x, y));
    }

    public void addRelevantNeighbors(Set<Cell> possibleNeighbors)
    {
        for (Cell possibleNeighbor : possibleNeighbors)
        {
            if (possibleNeighbor.isRelevantNeighbor(coordinates))
            {
                neighbors.add(possibleNeighbor);
            }
        }
    }

    private boolean isRelevantNeighbor(Point p)
    {
        int distance = p.getDistanceFrom(coordinates);
        return distance == 1;
    }

    public int getNumberOfAliveNeighbors()
    {
        int aliveNeighbors = 0;
        for (Cell neighbor : neighbors)
        {
            if (neighbor.getCurrentState() == CellState.ALIVE)
            {
                aliveNeighbors++;
            }
        }
        return aliveNeighbors;
    }
}
