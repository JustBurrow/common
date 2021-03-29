package kr.lul.common.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/04
 */
public class CommonUtilAnchorTest {
  private static final Logger log = getLogger(CommonUtilAnchorTest.class);

  @Test
  public void test_constructor() throws Exception {
    Assertions.assertThatThrownBy(CommonUtilAnchor::new)
        .isInstanceOf(UnsupportedOperationException.class)
        .hasMessage("does not support instance.");
  }
}
