package kr.lul.common.util.composer;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2018. 9. 24.
 */
public class ZoneIdComposerTest {
  private static final Logger log = getLogger(ZoneIdComposerTest.class);
  private static final int LOOP_COUNT = 100;

  /**
   * TODO 공용 클래스로 이동.
   */
  public static ZoneId[] zoneIds(int length) {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    List<String> zoneIds = ZoneId.SHORT_IDS.values().stream().collect(toList());

    ZoneId[] array = new ZoneId[length];
    for (int i = 0; i < length; i++) {
      array[i] = ZoneId.of(zoneIds.get(random.nextInt(zoneIds.size())));
    }
    return array;
  }

  private ZoneIdComposer composer;

  private ThreadLocalRandom random;

  @Before
  public void setUp() throws Exception {
    this.composer = new ZoneIdComposer();

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
    asList(zoneIds(this.random.nextInt(1, LOOP_COUNT))).forEach(expected -> {
      log.debug("GIVEN - expected={}", expected);

      // When
      String actual = this.composer.compose(expected);
      log.debug("WHEN - actual={}", actual);

      // Then
      assertThat(actual)
          .isNotEmpty();
      assertThat(ZoneId.of(actual))
          .isEqualTo(expected);
    });
  }
}
