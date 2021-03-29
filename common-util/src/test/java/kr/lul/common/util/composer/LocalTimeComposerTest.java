package kr.lul.common.util.composer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class LocalTimeComposerTest {
  private static final Logger log = getLogger(LocalTimeComposerTest.class);

  private LocalTimeComposer composer;

  @BeforeEach
  public void setUp() throws Exception {
    this.composer = new LocalTimeComposer();
  }

  @Test
  public void testConstructor() throws Exception {
    assertThat(this.composer)
        .isNotNull()
        .extracting(LocalTimeComposer::getFormatter)
        .isEqualTo(DateTimeFormatter.ISO_LOCAL_TIME);
  }

  @Test
  public void testComposeWithNull() throws Exception {
    assertThat(this.composer.compose(null))
        .isNull();
  }

  @Test
  public void testCompose() throws Exception {
    // Given
    LocalTime expected = LocalTime.now();
    log.debug("GIVEN - expected={}", expected);

    // When
    String actual = this.composer.compose(expected);
    log.debug("WHEN - actual={}", actual);

    // Then
    assertThat(actual)
        .isNotEmpty();
    assertThat(LocalTime.parse(actual, this.composer.getFormatter()))
        .isEqualTo(expected);
  }
}
