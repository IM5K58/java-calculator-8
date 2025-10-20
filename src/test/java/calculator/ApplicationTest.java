package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 테스트2() {
        assertSimpleTest(() -> {
            run("3:");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 테스트3() {
        assertSimpleTest(() -> {
            run(":3");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1,2;4");
            assertThat(output()).contains("결과 : 7");
        });
    }
    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run("//;\\n1;2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }


    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n2;;22"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("#2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3:-2,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("423"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-423"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("#423"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트8() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트9() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;;3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
