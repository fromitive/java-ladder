package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NamesTest {
    @Test
    @DisplayName("사람 이름 중복 검사")
    void validateDuplicateName() {
        Assertions.assertThatThrownBy(() -> new Names("abcde,abcde,abc"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("이름은 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {",abc,ab", "abc,ab,", ",abc,ab,"})
    @DisplayName("구분자가 맨 앞이나 맨 뒤에 있는지 확인")
    void validate(String names) {
        Assertions.assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("구분자가 맨 앞이나 맨 뒤에 있으면 안됩니다.");
    }
}