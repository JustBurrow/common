package kr.lul.common.util;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.Instant;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/04
 */
public class MillisSystemTimeProviderTest {
  private static final Logger log = getLogger(MillisSystemTimeProviderTest.class);

  private TimeProvider provider;

  @Before
  public void setUp() throws Exception {
    this.provider = new MillisSystemTimeProvider();
  }

  @Test
  public void test_now() throws Exception {
    // GIVEN
    Instant before = Instant.now();
    log.info("GIVEN - before={}", before);

    int sleep = (1_000_000_000 - before.getNano()) / 1000;
    log.info("GIVEN - sleep={}", sleep);

    sleep(sleep);

    // WHEN
    Instant now = this.provider.now();
    log.info("WHEN - now={}", now);

    // THEN
    assertThat(now)
        .isNotNull()
        .isAfter(before);
    assertThat(now.getNano() % 1000000)
        .isEqualTo(0);
  }
}
