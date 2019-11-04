package kr.lul.common.util;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import java.time.Instant;

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
    // WHEN
    Instant now = this.provider.now();
    log.info("WHEN - now={}", now);

    // THEN
    assertThat(now.getNano() % 1000000)
        .isEqualTo(0);
  }
}
