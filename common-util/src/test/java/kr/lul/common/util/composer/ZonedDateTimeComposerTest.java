package kr.lul.common.util.composer;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class ZonedDateTimeComposerTest {
  private static final Logger log = getLogger(ZonedDateTimeComposerTest.class);

  private ZonedDateTimeComposer composer;

  @Before
  public void setUp() throws Exception {
    this.composer = new ZonedDateTimeComposer();
  }

  @Test
  public void testConstructor() throws Exception {
    assertThat(this.composer)
        .isNotNull()
        .extracting(ZonedDateTimeComposer::getFormatter)
        .isEqualTo(DateTimeFormatter.ISO_ZONED_DATE_TIME);
  }

  @Test
  public void testComposeWithNull() throws Exception {
    assertThat(this.composer.compose(null))
        .isNull();
  }

  @Test
  public void testCompose() throws Exception {
    // Given
    ZonedDateTime expected = ZonedDateTime.now();
    log.debug("GIVEN - expected={}", expected);

    // When
    String actual = this.composer.compose(expected);
    log.debug("WHEN - actual={}", actual);

    // Then
    assertThat(actual)
        .isNotEmpty();
    assertThat(ZonedDateTime.parse(actual, this.composer.getFormatter()))
        .isEqualTo(expected);
  }
}
