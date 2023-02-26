package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import static ladder.model.ErrorMessage.EXCEPTION_HEIGHT_INVALID_TYPE;
import static ladder.model.ErrorMessage.EXCEPTION_PLAYER_NAME_DUPLICATE;

public class InputView {

    private static final InputView INSTANCE = new InputView();
    private static final Pattern NUMBER_REGEX = Pattern.compile("^-?[0-9]+$");

    private InputView() {}

    public static InputView getInstance() {
        return INSTANCE;
    }

    public List<String> readNames() {
        System.out.println(InputMessage.INPUT_NAMES.getMessage());

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> names = new ArrayList<>(List.of(splitInput(input)));
        validateDuplicatedNames(names);
        return names;
    }

    private String[] splitInput(String input) {
        return input.split(",");
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(EXCEPTION_PLAYER_NAME_DUPLICATE.getMessage());
        }
    }

    public List<String> readRewards() {
        System.out.println(InputMessage.INPUT_REWARDS.getMessage());

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> rewards = new ArrayList<>(List.of(splitInput(input)));
        return rewards;
    }

    public int readHeight() {
        System.out.println(InputMessage.INPUT_HEIGHT.getMessage());

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        validateHeight(input);
        return Integer.parseInt(input);
    }

    private void validateHeight(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(EXCEPTION_HEIGHT_INVALID_TYPE.getMessage());
        }
    }

    public String readAskingResult(){
        System.out.println(InputMessage.INPUT_ASKING_RESULT.getMessage());

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    private enum InputMessage {

        INPUT_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
        INPUT_REWARDS("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
        INPUT_HEIGHT("최대 사다리 높이는 몇 개인가요?"),
        INPUT_ASKING_RESULT("\n결과를 보고 싶은 사람은?");
        private final String message;

        InputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

    }

}
