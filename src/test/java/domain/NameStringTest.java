package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NameStringTest {
    @ParameterizedTest
    @CsvSource(value = {
            "a,'   a '",
            "aa,'  aa '",
            "aaa,' aaa '",
            "aaaa,'aaaa '",
            "aaaaa,aaaaa"})
    @DisplayName("이름이 5자 미만이면 규칙에 따라 공백을 추가")
    void testNameStringPadding(String name, String expected) {
        String actual = NameString.from(new Name(name));
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}