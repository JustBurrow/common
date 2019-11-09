package kr.lul.common.util.parser;

import kr.lul.common.util.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 29.
 */
public class LocalDateParserTest {
  private static final Logger log = getLogger(LocalDateParserTest.class);

  private LocalDateParser parser;

  private ThreadLocalRandom random;

  @Before
  public void setUp() throws Exception {
    this.parser = new LocalDateParser();
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
        .hasCauseInstanceOf(DateTimeParseException.class);
  }

  @Test
  public void testParse() throws Exception {
    for (int i = 0; i < 100; i++) {
      // Given
      LocalDate localDate = null;
      do {
        try {
          localDate = LocalDate.of(this.random.nextInt(-999999999, 1000000000),
              this.random.nextInt(1, 13),
              this.random.nextInt(1, 31));
        } catch (Exception e) {
        }
      } while (null == localDate);
      String text = localDate.toString();
      log.debug("GIVEN - text={}", text);

      // When
      LocalDate actual = this.parser.parse(text);
      log.debug("WHEN - actual={}", actual);

      // Then
      assertThat(actual)
          .isEqualTo(localDate);
    }
  }
}
