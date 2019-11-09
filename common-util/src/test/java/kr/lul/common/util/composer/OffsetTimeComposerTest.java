package kr.lul.common.util.composer;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.OffsetTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 28.
 */
public class OffsetTimeComposerTest {
  private static final Logger log = getLogger(OffsetTimeComposerTest.class);
  public static final int LOOP_COUNT = 100;

  private OffsetTimeComposer composer;

  @Before
  public void setUp() throws Exception {
    this.composer = new OffsetTimeComposer();
  }

  @Test
  public void testComposeWithNull() throws Exception {
    assertThat(this.composer.compose(null))
        .isNull();
  }

  @Test
  public void testCompose() throws Exception {
    // Given
    OffsetTime offsetTime = OffsetTime.now();
    log.debug("GIVEN - offsetTime={}", offsetTime);

    // When
    String actual = this.composer.compose(offsetTime);
    log.debug("WHEN - actual={}", actual);

    // Then
    assertThat(actual)
        .isNotEmpty()
        .isEqualTo("" + offsetTime);
  }
}
