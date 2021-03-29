package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class BigIntegerParserTest {
  private static final Logger log = getLogger(BigIntegerParserTest.class);

  private BigIntegerParser parser;

  private ThreadLocalRandom random;

  @BeforeEach
  public void setUp() throws Exception {
    this.parser = new BigIntegerParser();

    this.random = ThreadLocalRandom.current();
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
  public void testParseWithFloatingPointNumber() throws Exception {
    assertThatThrownBy(() -> this.parser.parse(Double.toString(this.random.nextDouble() * this.random.nextLong())))
        .isInstanceOf(ParseException.class)
        .hasCauseInstanceOf(NumberFormatException.class);
  }

  @Test
  public void testParse() throws Exception {
    for (int i = 0; i < 100; i++) {
      // Given
      long l = this.random.nextLong();
      String input = Long.toString(l);
      log.debug("GIVEN - l={}, input={}", l, input);

      // When
      BigInteger actual = this.parser.parse(input);
      log.debug("WHEN - actual={}", actual);

      // Then
      assertThat(actual)
          .isNotNull()
          .isEqualTo(l);
    }
  }
}
