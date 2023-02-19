package ladder.domain;

import ladder.utils.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final Height maxHeight;

    public Ladder(final int columnCount, final int height, final LineStrategy lineStrategy) {
        this.maxHeight = new Height(height);
        this.lines = assignLines(columnCount, lineStrategy);
    }

    private List<Line> assignLines(final int columnCount, final LineStrategy lineStrategy) {
        List<Line> lines = new ArrayList<>();

        IntStream.range(0, maxHeight.getHeight())
                .forEach(i -> lines.add(new Line(lineStrategy, columnCount - 1)));
        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}