package kr.lul.common.util.validator;

import kr.lul.common.util.ValidationException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.List;

import static kr.lul.common.util.validator.EmailValidator.LOCAL_PART_REGEX;
import static org.assertj.core.api.Assertions.*;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author justburrow
 * @since 2020/01/04
 */
public class EmailValidatorTest {
  private static final Logger log = getLogger(EmailValidatorTest.class);

  private EmailValidator validator;

  @Before
  public void setUp() throws Exception {
    this.validator = new EmailValidator();
    log.info("SETUP - regex={}", LOCAL_PART_REGEX);
  }

  @Test
  public void test_validate_with_null() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(null))
        .isInstanceOf(ValidationException.class)
        .hasMessage("email is null.");
  }

  @Test
  public void test_validate_with_empty() throws Exception {
    assertThatThrownBy(() -> this.validator.validate(""))
        .isInstanceOf(ValidationException.class)
        .hasMessage("email is empty.");
  }

  @Test
  public void test_validate_with_no_at_mark() throws Exception {
    // GIVEN
    final String email = "abc";
    log.info("GIVEN - email={}", email);

    // WHEN
    final ValidationException ex = catchThrowableOfType(() -> this.validator.validate(email),
        ValidationException.class);
    log.info("WHEN - ex=" + ex, ex);

    // THEN
    assertThat(ex)
        .hasMessageStartingWith("no '@' mark")
        .hasMessageContaining("email=" + email);
  }

  @Test
  public void test_validate_with_empty_local_part() throws Exception {
    // GIVEN
    final String email = "@bc";
    log.info("GIVEN - email={}", email);

    // WHEN
    final ValidationException ex = catchThrowableOfType(() -> this.validator.validate(email),
        ValidationException.class);
    log.info("WHEN - ex=" + ex, ex);

    // THEN
    assertThat(ex)
        .hasMessage("email.local is empty.");
  }

  @Test
  public void test_validate_with_empty_domain_part() throws Exception {
    // GIVEN
    final String email = "abcd@";
    log.info("GIVEN - email={}", email);

    // WHEN
    final ValidationException ex = catchThrowableOfType(() -> this.validator.validate(email),
        ValidationException.class);
    log.info("WHEN - ex=" + ex, ex);

    // THEN
    assertThat(ex)
        .isNotNull()
        .hasMessage("email.domain is empty.");
  }

  @Test
  public void test_validate_with_valid_emails() throws Exception {
    for (final String email : List.of(
        "emmanuel@hibernate.org",
        "emmanuel@hibernate",
        "emma-n_uel@hibernate",
        "emma+nuel@hibernate.org",
        "emma=nuel@hibernate.org",
        "emmanuel@[123.12.2.11]",
        "*@example.net",
        "fred&barny@example.com",
        "---@example.com",
        "foo-bar@example.net",
        "mailbox.sub1.sub2@this-domain",
        "prettyandsimple@example.com",
        "very.common@example.com",
        "disposable.style.email.with+symbol@example.com",
        "other.email-with-dash@example.com",
        "x@example.com",
        "\"much.more unusual\"@example.com",
        "\"very.unusual.@.unusual.com\"@example.com",

        // TODO 검증 실패하고 ValidationException 발생함. 왜?
        //"\"very.(),:;<>[]\\\".VERY.\\\"very@\\\\ \\\"very\\\".unusual\"@strange.example.com",

        "\"some \".\" strange \".\" part*:; \"@strange.example.com",
        "example-indeed@strange-example.com",
        "admin@mailserver1",
        "#!$%&'*+-/=?^_`{}|~@example.org",
        "\"()<>[]:,;@\\\"!#$%&'-/=?^_`{}| ~.a\"@example.org",
        "\" \"@example.org",
        "example@localhost",
        "example@s.solutions",
        "user@localserver",
        "user@tt",
        "user@[IPv6:2001:DB8::1]",
        "xn--80ahgue5b@xn--p-8sbkgc5ag7bhce.xn--ba-lmcq",
        "nothing@xn--fken-gra.no"
    )) {
      // GIVEN
      log.info("GIVEN - email={}", email);

      // WHEN
      final ValidationException ex = catchThrowableOfType(() -> this.validator.validate(email),
          ValidationException.class);
      log.info("WHEN - ex=" + ex, ex);

      // THEN
      assertThat(ex)
          .isNull();
      log.info("THEN - OK.\n\n\n");
    }
  }

  @Test
  public void test_validate_with_invalid_local_part_emails() throws Exception {
    for (final String email : List.of(
        "emma nuel@hibernate.org",
        "emma(nuel@hibernate.org",
        "emma\nnuel@hibernate.org",
        "emma@nuel@hibernate.org",
        "emma@nuel@.hibernate.org",
        "me.@example.com",
        ".me@example.com",
        "me\\@example.com",
        "A@b@c@example.com", // (only one @ is allowed outside quotation marks)

        // (none of the special characters in this local-part are allowed outside quotation marks)
        "a\"b(c)d,e:f;g<h>i[j\\k]l@example.com",

        // (quoted strings must be dot separated or the only element making up the local-part)
        "just\"not\"right@example.com",

        // (spaces, quotes, and backslashes may only exist when within quoted strings and preceded by a backslash)
        "this is\"not\\allowed@example.com",

        // (even if escaped (preceded by a backslash), spaces, quotes, and backslashes must still be contained by quotes)
        "this\\ still\\\"not\\\\allowed@example.com",

        // (double dot before @) with caveat: Gmail lets this through, Email address#Local-part the dots altogether
        "john..doe@example.com"
    )) {
      // GIVEN
      log.info("GIVEN - email={}", email);

      // WHEN
      final ValidationException ex = catchThrowableOfType(() -> this.validator.validate(email),
          ValidationException.class);
      log.info("WHEN - ex=" + ex, ex);

      // THEN
      assertThat(ex)
          .isNotNull()
          .hasMessageStartingWith("illegal email.local pattern");
      log.info("THEN - OK.\n\n\n");
    }
  }

  @Test
  public void test_validate_with_invalid_domain_part_emails() throws Exception {
    for (final String email : new String[]{
        "me@example..com",
        "john.doe@example..com",
        "abc@d..ef.ghi"
    }) {
      // GIVEN
      log.info("GIVEN - email={}", email);

      // WHEN
      final ValidationException ex = catchThrowableOfType(() -> this.validator.validate(email),
          ValidationException.class);
      log.info("WHEN - ex=" + ex, ex);

      // THEN
      assertThat(ex)
          .isNotNull()
          .hasMessageStartingWith("illegal email.domain pattern");
      log.info("THEN - OK.\n\n\n");
    }
  }

  @Test
  @Ignore
  public void test_validate_with_accent() throws Exception {
    // GIVEN
    final String email = "Test^Email@example.com";
    log.info("GIVEN - email={}", email);

    // WHEN
    this.validator.validate(email);

    // THEN
    log.info("THEN - OK");
  }
}
