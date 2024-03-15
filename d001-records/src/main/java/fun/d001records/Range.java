package fun.d001records;

public record Range(int start, int end)
{
    // block parameters are not declared
    public Range
    {
        // Can validate
        if (start > end) {
            throw new IllegalArgumentException("Start cannot be greater than end");
        }
        // cant access the record's fields
        // this.start = 13;
        // But can change the parameters
        if (start < 0)
            start = 0;
        if (end < 0)
            end = 0;
    }
}
