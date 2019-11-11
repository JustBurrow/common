package kr.lul.common.web;

import org.junit.Test;
import org.slf4j.Logger;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2019/11/09
 */
public class ApiTest {
  private static final Logger log = getLogger(ApiTest.class);

  @Test
  public void test_constructor_with_null_namespace_and_null_name() throws Exception {
    assertThatThrownBy(() -> new Api(null, null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void test_constructor_with_empty_namespace_and_null_name() throws Exception {
    assertThatThrownBy(() -> new Api("", null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void test_constructor_with_null_namespace_and_empty_name() throws Exception {
    assertThatThrownBy(() -> new Api(null, ""))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void test_constructor_with_empty_namespace_and_empty_namespace() throws Exception {
    // WHEN
    Api api = new Api("", "");
    log.info("WHEN - api={}", api);

    // THEN
    assertThat(api)
        .extracting(Api::getNamespace, Api::getName, Api::toString)
        .containsSequence("", "", "");
  }

  @Test
  public void test_constructor_with_random_namespace_and_random_name() throws Exception {
    // GIVEN
    String namespace = "/" + randomAlphabetic(1, 10);
    String name = "/" + randomAlphanumeric(1, 10);
    log.info("GIVEN - namespace={}, name={}", namespace, name);

    // WHEN
    Api api = new Api(namespace, name);
    log.info("WHEN - api={}", api);

    // THEN
    assertThat(api)
        .extracting(Api::getNamespace, Api::getName, Api::toString)
        .containsSequence(namespace, name, namespace + name);
  }
}
