package fun.d001records;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class D001RecordsApplicationTests
{

    @Test
    void testCreateARecord()
    {
        // Traditional record created as a class
        TraditionalRecord traditionalRecord = new TraditionalRecord(0, 0);
        assertThat(traditionalRecord).isNotEqualTo("TraditionalRecord{x=0, y=0}");

        // Creating a record : Canonical Constructor
        Record record = new Record(1, 1);
        assertThat(record.toString()).isEqualTo("Record[x=1, y=1]");

        // immutable
        traditionalRecord.x = 3;
        traditionalRecord.setX(3);
        assertThat(traditionalRecord.getX()).isEqualTo(3);
        // won't compile !!!
        //!!! record.x = 3;
        //!!! record.x() = 3;
    }

    @Test
    void testEqualsHashCodeToString(){
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
    void testValueObject() {
        var record2 = new Record(2, 2);
        var record2b = new Record(2, 2);
        assertThat(record2).isEqualTo(record2b);
    }

    @Test
    void testAccessors() {
        Record record = new Record(1, 1);
        var x = record.x();
        var y = record.y();
        assertThat(x).isEqualTo(1);
        assertThat(y).isEqualTo(1);

    }

}
