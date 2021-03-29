package kr.lul.common.util.composer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class OffsetDateTimeComposerTest {
  private static final Logger log = getLogger(OffsetDateTimeComposerTest.class);

  private OffsetDateTimeComposer composer;

  @BeforeEach
  public void setUp() throws Exception {
    this.composer = new OffsetDateTimeComposer();
  }

  @Test
  public void testConstructor() throws Exception {
    assertThat(this.composer)
        .isNotNull()
        .extracting(OffsetDateTimeComposer::getConfig)
        .isEqualTo(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }

  @Test
  public void testComposeWithNull() throws Exception {
    assertThat(this.composer.compose(null))
        .isNull();
  }

  @Test
  public void testCompose() throws Exception {
    // Given
    OffsetDateTime expected = OffsetDateTime.now();
    log.debug("GIVEN - expected={}", expected);

    // When
    String actual = this.composer.compose(expected);
    log.debug("WHEN - actual={}", actual);

    // Then
    assertThat(actual)
        .isNotEmpty();
    assertThat(OffsetDateTime.parse(actual, this.composer.getConfig()))
        .isEqualTo(expected);
  }
}
