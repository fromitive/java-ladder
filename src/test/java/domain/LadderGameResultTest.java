package domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameResultTest {
    private static final Names VALID_NAMES = new Names(List.of(new Name("name1"), new Name("name2")));
    private static final LadderResults VALID_LADDER_RESULTS = new LadderResults(
            List.of(new LadderResult("상품1"), new LadderResult("상품2")));
    private static final Ladder VALID_LADDER = new Ladder(new Height(5), new Width(2),
            new RowGenerator(() -> Bridge.EXIST));
    private static final LadderPositions VALID_LADDER_POSITIONS = new LadderPositions(2);
    private static final LadderGameResult VALID_LADDER_GAME_RESULT = new LadderGameResult(VALID_NAMES,
            VALID_LADDER_RESULTS, VALID_LADDER, VALID_LADDER_POSITIONS);

    @Test
    @DisplayName("이름들 개수가 불일치 할 경우 예외 발생")
    void validateNamesLength() {

        Names invalidNamesLength = new Names(List.of(new Name("name1"), new Name("name2"), new Name("name3")));
        Assertions.assertThatThrownBy(() -> new LadderGameResult(invalidNamesLength, VALID_LADDER_RESULTS, VALID_LADDER,
                        VALID_LADDER_POSITIONS))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH.getMessage());
    }

    @Test
    @DisplayName("사다리 결과들 개수가 불일치 할 경우 예외 발생")
    void validateLadderLength() {
        LadderResults invalidLadderResultsLength = new LadderResults(
                List.of(new LadderResult("상품1"), new LadderResult("상품2"), new LadderResult("상품3")));
        Assertions.assertThatThrownBy(() -> new LadderGameResult(VALID_NAMES, invalidLadderResultsLength, VALID_LADDER,
                        VALID_LADDER_POSITIONS))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH.getMessage());
    }

    @Test
    @DisplayName("사다리 위치들 개수가 불일치 할 경우 예외 발생")
    void validateLadderPositionsLength() {
        LadderPositions invalidLadderPositionLength = new LadderPositions(3);
        Assertions.assertThatThrownBy(() -> new LadderGameResult(VALID_NAMES, VALID_LADDER_RESULTS, VALID_LADDER,
                        invalidLadderPositionLength))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH.getMessage());
    }

    @Test
    @DisplayName("이름과 사다리 결과가 같으면 사다리 게임 결과 생성")
    void testCreateLadderGameResult() {
        Names names = new Names(List.of(new Name("name1"), new Name("name2")));
        LadderResults ladderResults = new LadderResults(List.of(new LadderResult("상품1"), new LadderResult("상품2")));
        Ladder ladder = new Ladder(new Height(5), new Width(2), new RowGenerator(new BridgeRandomGenerator()));
        LadderPositions ladderPositions = new LadderPositions(2);
        Assertions.assertThatCode(() -> new LadderGameResult(names, ladderResults, ladder, ladderPositions))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참여자들 반환 할 때, 생성 시 사용한 참여자들과 동일")
    void testGetNames() {
        Names actual = VALID_LADDER_GAME_RESULT.getNames();
        Names expected = VALID_NAMES;
        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    @DisplayName("참여자들 반환 할 때, 생성 시 사용한 참여자들과 동일")
    void testGetLadderResults() {
        LadderResults actual = VALID_LADDER_GAME_RESULT.getLadderResults();
        LadderResults expected = VALID_LADDER_RESULTS;
        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    @DisplayName("사다리 반환 할 때, 생성 시 사용한 사다리와 동일")
    void testGetLadder() {
        Ladder actual = VALID_LADDER_GAME_RESULT.getLadder();
        Ladder expected = VALID_LADDER;
        Assertions.assertThat(actual).isEqualTo(expected);
    }
    
    @Test
    @DisplayName("참여자 이름이 존재하지 않을 경우 예외 발생")
    void validateNameExist() {
        Name name = new Name("name3");
        Assertions.assertThatThrownBy(() -> VALID_LADDER_GAME_RESULT.getLadderResultFromName(name))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_SEARCH_NAME.getMessage());
    }

    @Test
    @DisplayName("전체 참여자 별 사다리 결과 반환")
    void testGetLadderGameResult() {
        Map<Name, LadderResult> ladderGameResult = VALID_LADDER_GAME_RESULT.getLadderGameResult();
        VALID_NAMES.getNames()
                .forEach(name -> Assertions.assertThat(ladderGameResult.get(name)).isNotNull());
    }
}