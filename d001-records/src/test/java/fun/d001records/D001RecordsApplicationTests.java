package fun.d001records;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class D001RecordsApplicationTests {

	@Test
	void testInitial() {
		// Traditional record created as a class
		TraditionalRecord traditionalRecord = new TraditionalRecord(0,0);
		assertThat(traditionalRecord).isNotEqualTo("TraditionalRecord{x=0, y=0}");

		// Creating a record : Canonical Constructor
		Record record = new Record(1, 1);
		assertThat(record.toString()).isEqualTo("Record[x=1, y=1]");

		// immutable
		traditionalRecord.x = 3;
		traditionalRecord.setX(3);
		assertThat(traditionalRecord.getX()).isEqualTo(3);
		// record.x = 3;
		// record.x() = 3;

		// equals
		var record2 = new Record(2,2);
		assertThat(record2).isNotEqualTo(record);

		// hashCode
		assertThat(record.hashCode()).isEqualTo(32);

		// value object
		var record2b = new Record(2, 2);
		assertThat(record2).isEqualTo(record2b);
	}

}
