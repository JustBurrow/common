package kr.lul.common.util.composer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO 포맷을 변경할 경우.
 *
 * @author justburrow
 * @since 2018. 9. 23.
 */
public class InstantComposerTest {
  private static final Logger log = getLogger(InstantComposerTest.class);

  private InstantComposer composer;

  @BeforeEach
  public void setUp() throws Exception {
    this.composer = new InstantComposer();
  }

  @Test
  public void testConstructor() throws Exception {
    assertThat(this.composer)
        .isNotNull()
        .extracting(InstantComposer::getFormatter)
        .isEqualTo(DateTimeFormatter.ISO_INSTANT);
  }

  @Test
  public void testComposeWithNull() throws Exception {
    assertThat(this.composer.compose(null))
        .isNull();
  }

  @Test
  public void testGetConfig() throws Exception {
    assertThat(this.composer.getFormatter())
        .isEqualTo(DateTimeFormatter.ISO_INSTANT);
  }

  @Test
  public void testCompose() throws Exception {
    // Given
    Instant expected = Instant.now();
    log.debug("GIVEN - expected={}", expected);

    // When
    String actual = this.composer.compose(expected);
    log.debug("WHEN - actual={}", actual);

    // Then
    assertThat(actual)
        .isNotNull()
        .isEqualTo(expected.toString());
    assertThat(Instant.parse(actual))
        .isEqualTo(expected);
  }
}
