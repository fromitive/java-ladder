package domain;

import java.util.List;
import java.util.stream.Collectors;

class RowString {
    static String from(Row row) {
        List<Boolean> bridges = row.getBridges();
        String rawRowString = bridges.stream()
                .map(RowString::makeBridge)
                .collect(Collectors.joining("|"));
        return "    |%s|".formatted(rawRowString);
    }

    private static String makeBridge(Boolean aBoolean) {
        if (aBoolean) {
            return "-----";
        }
        return "     ";
    }
}
