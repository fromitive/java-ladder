package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Row> rows;

    private final Width width;

    Ladder(Height height, Width width, RowGenerator rowGenerator) {
        rows = IntStream.range(0, height.getLength())
                .mapToObj(value -> rowGenerator.generate(width.getLength() - 1))
                .toList();
        this.width = width;
    }

    public List<Row> getRows() {
        return rows;
    }

    public LadderPositions climbDown() {
        List<Integer> initPositions = IntStream.range(0, width.getLength()).boxed().toList();
        LadderPositions ladderPositions = new LadderPositions(initPositions);
        for (Row row : rows) {
            ladderPositions = ladderPositions.calculatePosition(row);
        }
        return ladderPositions;
    }
}
