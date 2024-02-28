package view;

import static domain.Name.MAX_NAME_LENGTH;

import domain.Bridges;
import domain.Ladder;
import domain.LadderGame;
import domain.LadderGameResult;
import domain.LadderResult;
import domain.LadderResults;
import domain.Name;
import domain.Names;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NAMES_INPUT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_RESULT_INPUT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String SEARCH_NAME_INPUT = "결과를 보고 싶은 사람은?";
    private static final String HEIGHT_INPUT = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_PREFIX = "\n사다리 결과\n";
    private static final String LADDER_RESULT_PREFIX = "\n실행 결과";
    private static final String VERTICAL_BRIDGE = "|";
    private static final String EXIST_BRIDGE = "-----";
    private static final String NONE_BRIDGE = "     ";
    private static final String NAME_LADDER_RESULT_FORMAT = "%s : %s";

    public void printNamesInput() {
        System.out.println(NAMES_INPUT);
    }

    public void printHeightInput() {
        System.out.println(HEIGHT_INPUT);
    }

    public void printLadderResultInput() {
        System.out.println(LADDER_RESULT_INPUT);
    }

    public void printLadderResult(LadderGame ladderGame) {
        Names names = ladderGame.getNames();
        Ladder ladder = ladderGame.getLadder();
        LadderResults ladderResults = ladderGame.getLadderResults();

        String namesString = makeNamesString(names);
        String ladderString = makeLadderString(ladder);
        String ladderResultString = makeLadderResultsString(ladderResults);

        System.out.println(String.join("\n", LADDER_PREFIX, namesString, ladderString, ladderResultString, "\n"));
    }

    public void printAllNameLadderResult(Names names, LadderGameResult ladderGameResult) {
        Map<Name, LadderResult> nameLadderResultMap = ladderGameResult.getLadderGameResult();
        String allNameLadderResult = names.getNames().stream()
                .map(name -> NAME_LADDER_RESULT_FORMAT
                        .formatted(name.getName(), nameLadderResultMap.get(name).getLadderResult()))
                .collect(Collectors.joining("\n"));
        System.out.println(String.join("\n", LADDER_RESULT_PREFIX, allNameLadderResult));
    }

    public void printSearchNameInput() {
        System.out.println(SEARCH_NAME_INPUT);
    }

    public void printSearchNameLadderResult(String searchName, LadderGameResult ladderGameResult) {
        Name searchForName = new Name(searchName);
        Map<Name, LadderResult> nameLadderResultMap = ladderGameResult.getLadderGameResult();
        if (nameLadderResultMap.containsKey(searchForName)) {
            System.out.println(
                    String.join("\n", LADDER_RESULT_PREFIX,
                            nameLadderResultMap.get(searchForName).getLadderResult() + "\n"));
        }
    }

    private String makeLadderString(Ladder ladder) {
        return ladder.getLadder().stream()
                .map(Bridges::getBridges)
                .map(this::makeBridgesString)
                .collect(Collectors.joining("\n"));
    }

    private String makeBridgesString(List<Boolean> bridges) {
        String rawBridgesString = bridges.stream()
                .map(this::makeBridge)
                .collect(Collectors.joining(VERTICAL_BRIDGE));
        return "    |%s|".formatted(rawBridgesString);
    }

    private String makeBridge(Boolean aBoolean) {
        if (aBoolean) {
            return EXIST_BRIDGE;
        }
        return NONE_BRIDGE;
    }

    private String makeNamesString(Names names) {
        return names.getNames().stream()
                .map(this::makeNameString)
                .collect(Collectors.joining(" "));
    }

    private String makeNameString(Name name) {
        String nameString = name.getName();
        if (nameString.length() < Name.MAX_NAME_LENGTH) {
            nameString = nameString + " ";
        }
        int nameStringLength = nameString.length();
        return " ".repeat(MAX_NAME_LENGTH - nameStringLength) + nameString;
    }

    private String makeLadderResultsString(LadderResults ladderResults) {
        return ladderResults.getLadderResults().stream()
                .map(this::makeLadderResultString)
                .collect(Collectors.joining(" "));
    }

    private String makeLadderResultString(LadderResult ladderResult) {
        String ladderResultString = ladderResult.getLadderResult();
        if (ladderResultString.length() < LadderResult.MAX_LADDER_RESULT_LENGTH) {
            ladderResultString = ladderResultString + " ";
        }
        int nameStringLength = ladderResultString.length();
        return " ".repeat(MAX_NAME_LENGTH - nameStringLength) + ladderResultString;
    }
}
