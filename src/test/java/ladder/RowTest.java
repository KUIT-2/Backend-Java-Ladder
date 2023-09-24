package ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RowTest {

    @Test
    void 한_칸_사다리_이동() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(1);
        Row row = new Row(numberOfPerson);

        //given
        Position position = Position.of(0);

        //then
        assertEquals(0, row.nextPosition(position).getValue());
    }

    @Test
    void 두_칸_사다리_선_이동() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(2);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //given
        Position position = Position.of(0);


        //then
        assertEquals(1, row.nextPosition(position).getValue());

        //given
        position = Position.of(1);

        //then
        assertEquals(0, row.nextPosition(position).getValue());
    }

    @Test
    void 세_칸_사다리_선_이동() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(0));

        //given
        Position position = Position.of(0);

        //then
        assertEquals(1, row.nextPosition(position).getValue());

        //given
        position = Position.of(1);


        //then
        assertEquals(0, row.nextPosition(position).getValue());

        //given
        position = Position.of(2);


        //then
        assertEquals(2, row.nextPosition(position).getValue());
    }

    @Test
    void 사다리_사람수_예외_처리() {
        assertThrows(IllegalArgumentException.class, () -> new Row(NaturalNumber.of(0)));
    }

    @Test
    void 사다리_최대_사람수_초과_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //given
        Position position = Position.of(3);


        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(position));
    }

    @Test
    void 사다리_최소_사람수_미만_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);


        //given
        //then
        assertThrows(IllegalArgumentException.class, () -> row.nextPosition(Position.of(-1)));
    }

    @Test
    void 사다리_그리기_위치_초과_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //given

        Position position = Position.of(3);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(position));
    }

    @Test
    void 사다리_그리기_위치_미만_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(-1)));
    }

    @Test
    void 사다리_그리기_좌측_선_중복_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);
        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(1)));
    }

    @Test
    void 사다리_그리기_우측_선_중복_예외() {
        //when
        NaturalNumber numberOfPerson = NaturalNumber.of(3);

        Row row = new Row(numberOfPerson);
        row.drawLine(Position.of(1));

        //then
        assertThrows(IllegalArgumentException.class, () -> row.drawLine(Position.of(0)));
    }

    @Test
    void 사다리_출력_한_칸(){
        NaturalNumber numberofPerson = NaturalNumber.of(3);
        Row row = new Row(numberofPerson);
        row.drawLine(Position.of(1));

//        row.printOneRow();

    }
}