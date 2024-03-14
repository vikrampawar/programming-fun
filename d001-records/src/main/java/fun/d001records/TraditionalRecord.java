package fun.d001records;

import java.util.Objects;

public class TraditionalRecord
{
    int x;
    int y;

    public TraditionalRecord(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TraditionalRecord that = (TraditionalRecord) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }

    @Override
    public String toString()
    {
        return "TraditionalRecord{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
