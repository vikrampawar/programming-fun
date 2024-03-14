package fun.d001records;

public record Range(int start, int end)
{
    public Range(int start, int end)
    {
        if (start > end) {
            throw new IllegalArgumentException("Start cannot be greater than end");
        }
        this.start = start;
        this.end = end;
    }
}
