package kr.lul.common.data;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import static org.assertj.core.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/12/07
 */
public class StrictContextServiceTest {
  private static final Logger log = getLogger(StrictContextServiceTest.class);

  private StrictContextService service;

  @Before
  public void setUp() throws Exception {
    this.service = new StrictContextService();
  }

  @Test
  public void test_issue() throws Exception {
    // WHEN
    Context context = this.service.issue();
    log.info("WHEN - context={}", context);

    // THEN
    assertThat(context)
        .isNotNull();
  }

  @Test
  public void test_get_before_issue() throws Exception {
    assertThatThrownBy(() -> this.service.get())
        .isInstanceOf(IllegalStateException.class)
        .hasMessage("context does not exist.");
  }

  @Test
  public void test_get() throws Exception {
    // GIVEN
    Context expected = this.service.issue();
    log.info("GIVEN - expected={}", expected);

    // WHEN
    Context actual = this.service.get();
    log.info("WHEN - actual={}", actual);

    // THEN
    assertThat(actual)
        .isNotNull()
        .isEqualTo(expected);
  }

  @Test
  public void test_clear_before_issue() throws Exception {
    assertThatThrownBy(() -> this.service.clear())
        .isInstanceOf(IllegalStateException.class)
        .hasMessage("context does not exist.");
  }

  @Test
  public void test_clear() throws Exception {
    // GIVEN
    Context context = this.service.issue();
    log.info("GIVEN - context={}", context);

    // WHEN
    boolean clear = this.service.clear();
    log.info("WHEN - clear={}", clear);

    // THEN
    assertThat(clear)
        .isTrue();
    assertThatThrownBy(() -> this.service.get())
        .isInstanceOf(IllegalStateException.class)
        .hasMessage("context does not exist.");
    assertThat(this.service.issue())
        .isNotNull()
        .isNotEqualTo(context);
  }

  @Test
  public void test_multi_thread() throws Exception {
    fail("not yet");
  }
}
