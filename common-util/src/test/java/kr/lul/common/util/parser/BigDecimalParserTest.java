package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class BigDecimalParserTest {
  private static final Logger log = getLogger(BigDecimalParserTest.class);

  public static final int LOOP_COUNT = 100;

  private BigDecimalParser parser;

  private final ThreadLocalRandom random = ThreadLocalRandom.current();

  @BeforeEach
  public void setUp() throws Exception {
    this.parser = new BigDecimalParser();
  }

  @Test
  public void testParseWithNull() throws Exception {
    assertThat(this.parser.parse(null))
        .isNull();
  }

  @Test
  public void testParseWithEmpty() throws Exception {
    assertThatThrownBy(() -> this.parser.parse(""))
        .isInstanceOf(ParseException.class)
        .hasCauseInstanceOf(NumberFormatException.class);
  }

  @Test
  public void testParseWithDoubleString() throws Exception {
    for (int i = 0; i < LOOP_COUNT; i++) {
      // Given
      double d = this.random.nextDouble() * this.random.nextLong();
      String text = Double.toString(d);
      log.debug("GIVEN - d={}, text={}", d, text);

      // When
      BigDecimal actual = this.parser.parse(text);
      log.debug("WHEN - actual={}", actual);

      // Then
      assertThat(actual)
          .isNotNull();
    }
  }
}
