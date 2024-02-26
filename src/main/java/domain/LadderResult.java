package domain;

public class LadderResult {
    private static final int MIN_LADDER_RESULT_LENGTH = 1;
    private static final int MAX_LADDER_RESULT_LENGTH = 5;

    private final String value;

    public LadderResult(String value) {
        validateLadderResultLength(value);
        this.value = value;
    }

    private void validateLadderResultLength(String ladderResult) {
        if (ladderResult.length() < MIN_LADDER_RESULT_LENGTH || ladderResult.length() > MAX_LADDER_RESULT_LENGTH) {
            throw new LadderGameException(ExceptionType.INVALID_LADDER_RESULT_RANGE);
        }
    }

    public String getValue() {
        return value;
    }
}