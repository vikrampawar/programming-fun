package fun.d001records;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


@SpringBootTest
class D001RecordsApplicationTests
{

    @Test
    void testTraditionalRecord()
    {
        // Traditional record created as a class
        TraditionalRecord traditionalRecord = new TraditionalRecord(0, 0);
        assertThat(traditionalRecord).isNotEqualTo("TraditionalRecord{x=0, y=0}");
        // mutable
        traditionalRecord.x = 3;
        assertThat(traditionalRecord.x).isEqualTo(3);
        traditionalRecord.setX(4);
        assertThat(traditionalRecord.x).isEqualTo(4);
    }

    @Test
    void testCreateARecord()
    {
        // Creating a record : Canonical Constructor
        Record record = new Record(1, 1);
        assertThat(record.toString()).isEqualTo("Record[x=1, y=1]");

        // immutable
        // won't compile !!!
        //!!! record.x = 3;
        //!!! record.x() = 3;
    }

    @Test
    void testEqualsHashCodeToString()
    {
        Record record = new Record(1, 1);

        // equals
        var record2 = new Record(2, 2);
        assertThat(record2).isNotEqualTo(record);

        // hashCode
        assertThat(record.hashCode()).isEqualTo(32);

        // toString
        assertThat(record.toString()).isEqualTo("Record[x=1, y=1]");
    }

    @Test
    void testValueObject()
    {
        var record2 = new Record(2, 2);
        var record2b = new Record(2, 2);
        assertThat(record2).isEqualTo(record2b);
    }

    @Test
    void testAccessors()
    {
        Record record = new Record(1, 1);
        var x = record.x();
        var y = record.y();
        assertThat(x).isEqualTo(1);
        assertThat(y).isEqualTo(1);
    }

    @Test
    void testCompactConstructor()
    {
        Range range = new Range(1, 5);
        System.out.println(range);
    }

    @Test
    void testStartGreaterThanEnd()
    {
        var exception = assertThrows(IllegalArgumentException.class, () -> new Range(5, 1));
        assertThat(exception.getMessage()).isEqualTo("Start cannot be greater than end");
    }

    @Test
    void testReassignmentOfParameters()
    {
        var range = new Range(-10, -3);
        assertThat(range.start()).isEqualTo(0);
        assertThat(range.end()).isEqualTo(0);
    }
}
