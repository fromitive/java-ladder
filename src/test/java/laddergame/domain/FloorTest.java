package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FloorTest {

    @Nested
    static class FloorStatusTest {

        @ParameterizedTest
        @DisplayName("Players가 두 명 이상이면 Line이 생성된다.")
        @ValueSource(ints = {2, 5, 10})
        void givenTwoMorePlayers_thenCreateLine(final int numberOfPlayers) {
            assertThatCode(() -> Floor.from(numberOfPlayers))
                    .doesNotThrowAnyException();
        }

        @Test
        @DisplayName("Line의 길이가 1보다 작으면 예외가 발생한다.")
        void givenTwoLessPlayers_thenFail() {

            final int minNumberOfExistences = 1;

            assertThatThrownBy(() -> Floor.from(minNumberOfExistences))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage(String.format("Floor의 길이는 %d보다 작을 수 없습니다.", minNumberOfExistences));
        }

        @Test
        @DisplayName("라인이 생성되면 List<Boolean>이 생성된다.")
        void givenLine_thenCreateBooleanList() {
            //given
            final List<Boolean> statuses = List.of(true, false, false);

            //when
            final Floor line = Floor.of(statuses.size(), new TestLinkPicker(statuses));

            //then
            assertThat(line)
                    .extracting(Floor::getFloor)
                    .isEqualTo(List.of(Link.CONNECTION, Link.DISCONNECTION));
        }
    }

    @Test
    @DisplayName("라인이 겹치지 않는다.")
    void givenLine_thenNotOverLap() {
        //given
        final List<Boolean> statuses = List.of(true, true, false);
        final Floor line = Floor.of(statuses.size(), new TestLinkPicker(statuses));

        //then
        assertThat(line)
                .extracting(Floor::getFloor)
                .isEqualTo(List.of(Link.CONNECTION, Link.DISCONNECTION));
    }

    @Test
    @DisplayName("라인이 두 칸 이상인 경우, 적어도 한 칸 이상의 발판이 발생한다.")
    void givenTwoMoreSizeLine_thenSetLineSizeTwo() {
        //given
        final Floor line = Floor.from(3);

        //when
        final int size = new HashSet<>(line.getFloor()).size();

        //then
        assertThat(size)
                .isEqualTo(2);
    }
}