package kr.lul.common.util.composer;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class DurationComposerTest {
  private static final Logger log = getLogger(DurationComposerTest.class);
  public static final int LOOP_COUNT = 100;

  public static Duration[] durations(int length) {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    Duration[] array = new Duration[length];
    for (int i = 0; i < length; i++) {
      array[i] = Duration.ofSeconds(random.nextLong(), random.nextLong());
    }
    return array;
  }

  private DurationComposer composer;

  private ThreadLocalRandom random;

  @Before
  public void setUp() throws Exception {
    this.composer = new DurationComposer();

    if (null == this.random) {
      this.random = ThreadLocalRandom.current();
    } else {
      this.random.setSeed(this.random.nextLong());
    }
  }

  @Test
  public void testComposeWithNull() throws Exception {
    assertThat(this.composer.compose(null))
        .isNull();
  }

  @Test
  public void testCompose() throws Exception {
    asList(durations(this.random.nextInt(1, LOOP_COUNT))).forEach(expected -> {
      log.debug("GIVEN - expected={}", expected);

      // When
      String actual = this.composer.compose(expected);
      log.debug("WHEN - actual={}", actual);

      // Then
      assertThat(actual)
          .isNotEmpty();
      assertThat(Duration.parse(actual))
          .isEqualTo(expected);
    });
  }
}
