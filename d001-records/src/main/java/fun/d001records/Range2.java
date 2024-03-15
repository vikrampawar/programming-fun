package fun.d001records;

public record Range2(int start, int end)
{
    public Range2(int start, int end)
    {
        if (start < 0) {
            this.start = 0;
        } else {
            this.start = start;
        }

        if (end < 0) {
            this.end = 0;
        } else {
            this.end = end;
        }
    }

}

