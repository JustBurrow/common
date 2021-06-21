package kr.lul.common.util.validator;

import kr.lul.common.util.ValidationException;
import kr.lul.common.util.Validator;

import java.net.IDN;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static java.util.regex.Pattern.CASE_INSENSITIVE;
import static kr.lul.common.util.Arguments.positive;

/**
 * Hibernate의 {@code AbstractEmailValidator}를 기반으로 작성.
 *
 * @author justburrow
 * @see <a href="https://github.com/hibernate/hibernate-validator/blob/master/engine/src/main/java/org/hibernate/validator/internal/constraintvalidators/AbstractEmailValidator.java">AbstractEmailValidator</a> Hibernate 코드를 사용.
 * @see <a href="https://github.com/hibernate/hibernate-validator/blob/master/engine/src/main/java/org/hibernate/validator/internal/util/DomainNameUtil.java">DomainNameUtil</a> 메일 주소의 도메인 영역 검증.
 * @since 2020/01/04
 */
public class EmailValidator implements Validator<CharSequence> {
  public static final int DEFAULT_LOCAL_MAX_LENGTH = 64;
  public static final int DEFAULT_DOMAIN_MAX_LENGTH = 255;

  public static final String DEFAULT_LOCAL_PART_ATOM = "[a-z0-9!#$%&'*+/=?^_`{|}~\u0080-\uFFFF-]";
  public static final String DEFAULT_LOCAL_PART_INSIDE_QUOTES_ATOM = "([a-z0-9!#$%&'*.(),<>\\[\\]:;  @+/=?^_`{|}~\u0080-\uFFFF-]|\\\\\\\\|\\\\\\\")";

  public static final String LOCAL_PART_REGEX = format("(%s+|\"%s+\")(\\.(%s+|\"%s+\"))*",
      DEFAULT_LOCAL_PART_ATOM, DEFAULT_LOCAL_PART_INSIDE_QUOTES_ATOM,
      DEFAULT_LOCAL_PART_ATOM, DEFAULT_LOCAL_PART_INSIDE_QUOTES_ATOM);
  /**
   * Regular expression for the local part of an email address (everything before '@')
   */
  public static final Pattern LOCAL_PART_PATTERN = Pattern.compile(LOCAL_PART_REGEX, CASE_INSENSITIVE);

  public static final String DOMAIN_CHARS_WITHOUT_DASH = "[a-z\u0080-\uFFFF0-9!#$%&'*+/=?^_`{|}~]";
  public static final String DOMAIN_LABEL = "(" + DOMAIN_CHARS_WITHOUT_DASH + "-*)*" + DOMAIN_CHARS_WITHOUT_DASH + "+";
  public static final String DOMAIN = DOMAIN_LABEL + "+(\\." + DOMAIN_LABEL + "+)*";

  public static final String IP_DOMAIN = "[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}";
  //IP v6 regex taken from http://stackoverflow.com/questions/53497/regular-expression-that-matches-valid-ipv6-addresses
  public static final String IP_V6_DOMAIN = "(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))";

  public static final String DOMAIN_REGEX = format("%s|\\[%s\\]", DOMAIN, IP_V6_DOMAIN);
  public static final String EMAIL_DOMAIN_REGEX = format("%s|\\[%s\\]|\\[IPv6:%s\\]", DOMAIN, IP_DOMAIN, IP_V6_DOMAIN);

  /**
   * Regular expression for the domain part of an URL
   * <p>
   * A host string must be a domain string, an IPv4 address string, or "[", followed by an IPv6 address string,
   * followed by "]".
   */
  public static final Pattern DOMAIN_PATTERN = Pattern.compile(DOMAIN_REGEX, CASE_INSENSITIVE);

  /**
   * Regular expression for the domain part of an email address (everything after '@')
   */
  public static final Pattern EMAIL_DOMAIN_PATTERN = Pattern.compile(EMAIL_DOMAIN_REGEX, CASE_INSENSITIVE);

  private final int localMaxLength;
  private final int domainMaxLength;

  public EmailValidator() {
    this(DEFAULT_LOCAL_MAX_LENGTH, DEFAULT_DOMAIN_MAX_LENGTH);
  }

  public EmailValidator(final int localMaxLength, final int domainMaxLength) {
    positive(localMaxLength, "localMaxLength");
    positive(domainMaxLength, "domainMaxLength");

    this.localMaxLength = localMaxLength;
    this.domainMaxLength = domainMaxLength;
  }

  private void validateLocal(final String local) {
    if (local.isEmpty())
      throw new ValidationException("email.local", local, "email.local is empty.");
    else if (this.localMaxLength < local.length())
      throw new ValidationException("email.local", local,
          format("too long email.local : length=%d, max=%d", local.length(), this.localMaxLength));

    final Matcher matcher = LOCAL_PART_PATTERN.matcher(local);
    if (!matcher.matches())
      throw new ValidationException("email.local", local,
          format("illegal email.local pattern : email.local=%s, pattern=%s", local, LOCAL_PART_REGEX));
  }

  private void validateDomain(final String domain) {
    if (domain.isEmpty())
      throw new ValidationException("email.domain", domain, "email.domain is empty.");
    else if (this.domainMaxLength < domain.length())
      throw new ValidationException("email.domain", domain,
          format("too long email.domain : length=%d, max=%d, email.domain=%s",
              domain.length(), this.domainMaxLength, domain));
    else if (domain.endsWith("."))
      throw new ValidationException("email.domain", domain,
          "email.domain ends with '.' : email.domain=%s" + domain);

    final Matcher matcher = EMAIL_DOMAIN_PATTERN.matcher(domain);
    if (!matcher.matches())
      throw new ValidationException("email.domain", domain,
          format("illegal email.domain pattern : email.domain=%s, pattern=%s", domain, DOMAIN_REGEX));

    if (!domain.matches("^\\p{ASCII}*$")) {
      final String ascii;
      try {
        ascii = IDN.toASCII(domain);
      } catch (final IllegalArgumentException e) {
        throw new ValidationException("email.domain", domain,
            "fail to ascii translate email.domain : email.domain=" + domain, e);
      }

      if (this.domainMaxLength < ascii.length())
        throw new ValidationException("email.domain", domain,
            format("too long ascii email.domain : ascii.length=%d, max=%d, ascii=%s",
                ascii.length(), this.domainMaxLength, ascii));
    }
  }

  public int getLocalMaxLength() {
    return this.localMaxLength;
  }

  public int getDomainMaxLength() {
    return this.domainMaxLength;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // kr.lul.common.util.Validator
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public CharSequence validate(final CharSequence email) throws ValidationException {
    if (null == email)
      throw new ValidationException("email", null, "email is null.");
    else if (0 == email.length())
      throw new ValidationException("email", email, "email is empty.");

    final String mail = email.toString();
    final int splitPosition = mail.lastIndexOf('@');
    if (0 > splitPosition)
      throw new ValidationException("email", mail, "no '@' mark : email=" + mail);

    final String localPart = mail.substring(0, splitPosition);
    final String domainPart = mail.substring(splitPosition + 1);

    validateLocal(localPart);
    validateDomain(domainPart);

    return email;
  }
}
