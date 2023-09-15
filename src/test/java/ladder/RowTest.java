package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RowTest {

    @Test
    void 한_칸_사다리_이동() {
        //when
        int numberOfPerson = 1;
        Row row = new Row(numberOfPerson);

        //given
        int position = 0;

        //then
        assertEquals(0, row.nextPosition(position));
    }

    @Test
    void 두_칸_사다리_선_이동() {
        //when
        int numberOfPerson = 2;
        Row row = new Row(numberOfPerson);
        row.drawLine(0);

        //given
        int position = 0;

        //then
        assertEquals(1, row.nextPosition(position));

        //given
        position = 1;

        //then
        assertEquals(0, row.nextPosition(position));
    }

    @Test
    void 세_칸_사다리_선_이동() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        row.drawLine(0);

        //given
        int position = 0;

        //then
        assertEquals(1, row.nextPosition(position));

        //given
        position = 1;

        //then
        assertEquals(0, row.nextPosition(position));

        //given
        position = 2;

        //then
        assertEquals(2, row.nextPosition(position));
    }

    @Test
    void 사다리_사람수_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Row(0));
    }

    @Test
    void 사다리_최대_사람수_초과_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //given
        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }

    @Test
    void 사다리_최소_사람수_미만_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //given
        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }

    @Test
    void 사다리_그리기_위치_초과_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //given
        int position = 3;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(position));
    }

    @Test
    void 사다리_그리기_위치_미만_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);

        //given
        int position = -1;

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(position));
    }

    @Test
    void 사다리_그리기_좌측_선_중복_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        row.drawLine(0);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(1));
    }

    @Test
    void 사다리_그리기_우측_선_중복_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        row.drawLine(1);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(0));
    }

    @Test
    void 사다리_그리기_선_중복_예외() {
        //when
        int numberOfPerson = 3;
        Row row = new Row(numberOfPerson);
        row.drawLine(0);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(0));
    }
}