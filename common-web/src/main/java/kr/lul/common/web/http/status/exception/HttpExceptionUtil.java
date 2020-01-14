package kr.lul.common.web.http.status.exception;

import kr.lul.common.web.http.status.exception.client.*;
import kr.lul.common.web.http.status.exception.informationalresponse.Continue;
import kr.lul.common.web.http.status.exception.informationalresponse.EarlyHints;
import kr.lul.common.web.http.status.exception.informationalresponse.Processing;
import kr.lul.common.web.http.status.exception.informationalresponse.SwitchingProtocols;
import kr.lul.common.web.http.status.exception.success.OK;
import kr.lul.common.web.http.status.exception.success.*;

import static kr.lul.common.util.Arguments.range;
import static kr.lul.common.web.http.status.HttpStatusCodes.*;

/**
 * @author justburrow
 * @since 2020/01/14
 */
public abstract class HttpExceptionUtil {
  /**
   * HTTP 조건부 응답용 예외 생성.
   *
   * @param status 상태 코드.
   * @param <E>    상세 예외.
   *
   * @return 조건부 응답 예외.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http1xxException> E informationalResponse(final int status) {
    range(status, 100, 199, "status");

    final E ex;
    switch (status) {
      case CONTINUE:
        ex = (E) new Continue();
        break;
      case SWITCHING_PROTOCOLS:
        ex = (E) new SwitchingProtocols();
        break;
      case PROCESSING:
        ex = (E) new Processing();
        break;
      case EARLY_HINTS:
        ex = (E) new EarlyHints();
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  /**
   * HTTP 조건부 응답용 예외 생성.
   *
   * @param status  상태 코드.
   * @param message 예외 메시지.
   * @param <E>     상세 예외.
   *
   * @return 조건부 응답 예외.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http1xxException> E informationalResponse(final int status, final String message) {
    range(status, 100, 199, "status");

    final E ex;
    switch (status) {
      case CONTINUE:
        ex = (E) new Continue(message);
        break;
      case SWITCHING_PROTOCOLS:
        ex = (E) new SwitchingProtocols(message);
        break;
      case PROCESSING:
        ex = (E) new Processing(message);
        break;
      case EARLY_HINTS:
        ex = (E) new EarlyHints(message);
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  /**
   * HTTP 조건부 응답용 예외 생성.
   *
   * @param status 상태 코드.
   * @param cause  에러 원인.
   * @param <E>    상세 예외.
   *
   * @return 조건부 응답 예외.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http1xxException> E informationalResponse(final int status, final Throwable cause) {
    range(status, 100, 199, "status");

    final E ex;
    switch (status) {
      case CONTINUE:
        ex = (E) new Continue(cause);
        break;
      case SWITCHING_PROTOCOLS:
        ex = (E) new SwitchingProtocols(cause);
        break;
      case PROCESSING:
        ex = (E) new Processing(cause);
        break;
      case EARLY_HINTS:
        ex = (E) new EarlyHints(cause);
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  /**
   * HTTP 조건부 응답용 예외 생성.
   *
   * @param status  상태 코드.
   * @param message 예외 메시지.
   * @param cause   예외 원인.
   * @param <E>     상세 예외.
   *
   * @return 조건부 응답 예외.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http1xxException> E informationalResponse(final int status, final String message,
      final Throwable cause) {
    range(status, 100, 199, "status");

    final E ex;
    switch (status) {
      case CONTINUE:
        ex = (E) new Continue(message, cause);
        break;
      case SWITCHING_PROTOCOLS:
        ex = (E) new SwitchingProtocols(message, cause);
        break;
      case PROCESSING:
        ex = (E) new Processing(message, cause);
        break;
      case EARLY_HINTS:
        ex = (E) new EarlyHints(message, cause);
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  /**
   * HTTP 요청 성공 예외.
   *
   * @param status 상태 코드.
   * @param <E>    상세 예외.
   *
   * @return 성공 예외.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http2xxException> E success(final int status) {
    range(status, 200, 299, "status");

    final E ex;
    switch (status) {
      case OK:
        ex = (E) new OK();
        break;
      case CREATED:
        ex = (E) new Created();
        break;
      case ACCEPTED:
        ex = (E) new Accepted();
        break;
      case NON_AUTHORITATIVE_INFORMATION:
        ex = (E) new NonAuthoritativeInformation();
        break;
      case NO_CONTENT:
        ex = (E) new NoContent();
        break;
      case RESET_CONTENT:
        ex = (E) new ResetContent();
        break;
      case PARTIAL_CONTENT:
        ex = (E) new PartialContent();
        break;
      case MULTI_STATUS:
        ex = (E) new MultiStatus();
        break;
      case ALREADY_REPORTED:
        ex = (E) new AlreadyReported();
        break;
      case IM_USED:
        ex = (E) new ImUsed();
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  /**
   * HTTP 요청 성공 예외.
   *
   * @param status  상태 코드.
   * @param message 예외 메시지.
   * @param <E>     상세 예외.
   *
   * @return 성공 예외.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http2xxException> E success(final int status, final String message) {
    range(status, 200, 299, "status");

    final E ex;
    switch (status) {
      case OK:
        ex = (E) new OK(message);
        break;
      case CREATED:
        ex = (E) new Created(message);
        break;
      case ACCEPTED:
        ex = (E) new Accepted(message);
        break;
      case NON_AUTHORITATIVE_INFORMATION:
        ex = (E) new NonAuthoritativeInformation(message);
        break;
      case NO_CONTENT:
        ex = (E) new NoContent(message);
        break;
      case RESET_CONTENT:
        ex = (E) new ResetContent(message);
        break;
      case PARTIAL_CONTENT:
        ex = (E) new PartialContent(message);
        break;
      case MULTI_STATUS:
        ex = (E) new MultiStatus(message);
        break;
      case ALREADY_REPORTED:
        ex = (E) new AlreadyReported(message);
        break;
      case IM_USED:
        ex = (E) new ImUsed(message);
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  /**
   * HTTP 요청 성공 예외.
   *
   * @param status 상태 코드.
   * @param cause  예외 원인.
   * @param <E>    상세 예외.
   *
   * @return 성공 예외.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http2xxException> E success(final int status, final Throwable cause) {
    range(status, 200, 299, "status");

    final E ex;
    switch (status) {
      case OK:
        ex = (E) new OK(cause);
        break;
      case CREATED:
        ex = (E) new Created(cause);
        break;
      case ACCEPTED:
        ex = (E) new Accepted(cause);
        break;
      case NON_AUTHORITATIVE_INFORMATION:
        ex = (E) new NonAuthoritativeInformation(cause);
        break;
      case NO_CONTENT:
        ex = (E) new NoContent(cause);
        break;
      case RESET_CONTENT:
        ex = (E) new ResetContent(cause);
        break;
      case PARTIAL_CONTENT:
        ex = (E) new PartialContent(cause);
        break;
      case MULTI_STATUS:
        ex = (E) new MultiStatus(cause);
        break;
      case ALREADY_REPORTED:
        ex = (E) new AlreadyReported(cause);
        break;
      case IM_USED:
        ex = (E) new ImUsed(cause);
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  /**
   * HTTP 요청 성공 예외.
   *
   * @param status  상태 코드.
   * @param message 예외 메시지.
   * @param cause   예외 원인.
   * @param <E>     상세 예외.
   *
   * @return 성공 예외.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http2xxException> E success(final int status, final String message, final Throwable cause) {
    range(status, 200, 299, "status");

    final E ex;
    switch (status) {
      case OK:
        ex = (E) new OK(message, cause);
        break;
      case CREATED:
        ex = (E) new Created(message, cause);
        break;
      case ACCEPTED:
        ex = (E) new Accepted(message, cause);
        break;
      case NON_AUTHORITATIVE_INFORMATION:
        ex = (E) new NonAuthoritativeInformation(message, cause);
        break;
      case NO_CONTENT:
        ex = (E) new NoContent(message, cause);
        break;
      case RESET_CONTENT:
        ex = (E) new ResetContent(message, cause);
        break;
      case PARTIAL_CONTENT:
        ex = (E) new PartialContent(message, cause);
        break;
      case MULTI_STATUS:
        ex = (E) new MultiStatus(message, cause);
        break;
      case ALREADY_REPORTED:
        ex = (E) new AlreadyReported(message, cause);
        break;
      case IM_USED:
        ex = (E) new ImUsed(message, cause);
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  /**
   * HTTP 클라이언트 에러 생성.
   *
   * @param status HTTP 상태 코드.
   * @param <E>    상세 에러 타입.
   *
   * @return 클라이언트 에러.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http4xxException> E client(final int status) {
    range(status, 400, 499, "status");

    final E ex;
    switch (status) {
      case BAD_REQUEST:
        ex = (E) new BadRequest();
        break;
      case UNAUTHORIZED:
        ex = (E) new Unauthorized();
        break;
      case PAYMENT_REQUIRED:
        ex = (E) new PaymentRequired();
        break;
      case FORBIDDEN:
        ex = (E) new Forbidden();
        break;
      case NOT_FOUND:
        ex = (E) new NotFound();
        break;
      case METHOD_NOT_ALLOWED:
        ex = (E) new MethodNotAllowed();
        break;
      case NOT_ACCEPTABLE:
        ex = (E) new NotAcceptable();
        break;
      case PROXY_AUTHENTICATION_REQUIRED:
        ex = (E) new ProxyAuthenticationRequired();
        break;
      case REQUEST_TIMEOUT:
        ex = (E) new RequestTimeout();
        break;
      case CONFLICT:
        ex = (E) new Conflict();
        break;
      case GONE:
        ex = (E) new Gone();
        break;
      case LENGTH_REQUIRED:
        ex = (E) new LengthRequired();
        break;
      case PRECONDITION_FAILED:
        ex = (E) new PreconditionFailed();
        break;
      case PAYLOAD_TOO_LARGE:
        ex = (E) new PayloadTooLarge();
        break;
      case URI_TOO_LONG:
        ex = (E) new UriTooLong();
        break;
      case UNSUPPORTED_MEDIA_TYPE:
        ex = (E) new UnsupportedMediaType();
        break;
      case RANGE_NOT_SATISFIABLE:
        ex = (E) new RangeNotSatisfiable();
        break;
      case EXPECTATION_FAILED:
        ex = (E) new ExpectationFailed();
        break;
      case MISDIRECTED_REQUEST:
        ex = (E) new MisdirectedRequest();
        break;
      case UNPROCESSABLE_ENTITY:
        ex = (E) new UnprocessableEntity();
        break;
      case LOCKED:
        ex = (E) new Locked();
        break;
      case FAILED_DEPENDENCY:
        ex = (E) new FailedDependency();
        break;
      case TOO_EARLY:
        ex = (E) new TooEarly();
        break;
      case UPGRADE_REQUIRED:
        ex = (E) new UpgradeRequired();
        break;
      case PRECONDITION_REQUIRED:
        ex = (E) new PreconditionRequired();
        break;
      case TOO_MANY_REQUESTS:
        ex = (E) new TooManyRequests();
        break;
      case REQUEST_HEADER_FIELDS_TOO_LARGE:
        ex = (E) new RequestHeaderFieldsTooLarge();
        break;
      case UNAVAILABLE_FOR_LEGAL_REASONS:
        ex = (E) new UnavailableForLegalReasons();
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  /**
   * HTTP 클라이언트 에러 생성.
   *
   * @param status  HTTP 상태 코드.
   * @param message 에러 메시지.
   * @param <E>     상세 에러 타입.
   *
   * @return 클라이언트 에러.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http4xxException> E client(final int status, final String message) {
    range(status, 400, 499, "status");

    final E ex;
    switch (status) {
      case BAD_REQUEST:
        ex = (E) new BadRequest(message);
        break;
      case UNAUTHORIZED:
        ex = (E) new Unauthorized(message);
        break;
      case PAYMENT_REQUIRED:
        ex = (E) new PaymentRequired(message);
        break;
      case FORBIDDEN:
        ex = (E) new Forbidden(message);
        break;
      case NOT_FOUND:
        ex = (E) new NotFound(message);
        break;
      case METHOD_NOT_ALLOWED:
        ex = (E) new MethodNotAllowed(message);
        break;
      case NOT_ACCEPTABLE:
        ex = (E) new NotAcceptable(message);
        break;
      case PROXY_AUTHENTICATION_REQUIRED:
        ex = (E) new ProxyAuthenticationRequired(message);
        break;
      case REQUEST_TIMEOUT:
        ex = (E) new RequestTimeout(message);
        break;
      case CONFLICT:
        ex = (E) new Conflict(message);
        break;
      case GONE:
        ex = (E) new Gone(message);
        break;
      case LENGTH_REQUIRED:
        ex = (E) new LengthRequired(message);
        break;
      case PRECONDITION_FAILED:
        ex = (E) new PreconditionFailed(message);
        break;
      case PAYLOAD_TOO_LARGE:
        ex = (E) new PayloadTooLarge(message);
        break;
      case URI_TOO_LONG:
        ex = (E) new UriTooLong(message);
        break;
      case UNSUPPORTED_MEDIA_TYPE:
        ex = (E) new UnsupportedMediaType(message);
        break;
      case RANGE_NOT_SATISFIABLE:
        ex = (E) new RangeNotSatisfiable(message);
        break;
      case EXPECTATION_FAILED:
        ex = (E) new ExpectationFailed(message);
        break;
      case MISDIRECTED_REQUEST:
        ex = (E) new MisdirectedRequest(message);
        break;
      case UNPROCESSABLE_ENTITY:
        ex = (E) new UnprocessableEntity(message);
        break;
      case LOCKED:
        ex = (E) new Locked(message);
        break;
      case FAILED_DEPENDENCY:
        ex = (E) new FailedDependency(message);
        break;
      case TOO_EARLY:
        ex = (E) new TooEarly(message);
        break;
      case UPGRADE_REQUIRED:
        ex = (E) new UpgradeRequired(message);
        break;
      case PRECONDITION_REQUIRED:
        ex = (E) new PreconditionRequired(message);
        break;
      case TOO_MANY_REQUESTS:
        ex = (E) new TooManyRequests(message);
        break;
      case REQUEST_HEADER_FIELDS_TOO_LARGE:
        ex = (E) new RequestHeaderFieldsTooLarge(message);
        break;
      case UNAVAILABLE_FOR_LEGAL_REASONS:
        ex = (E) new UnavailableForLegalReasons(message);
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  /**
   * HTTP 클라이언트 에러 생성.
   *
   * @param status HTTP 상태 코드.
   * @param cause  에러 원인.
   * @param <E>    상세 에러 타입.
   *
   * @return 클라이언트 에러.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http4xxException> E client(final int status, final Throwable cause) {
    range(status, 400, 499, "status");

    final E ex;
    switch (status) {
      case BAD_REQUEST:
        ex = (E) new BadRequest(cause);
        break;
      case UNAUTHORIZED:
        ex = (E) new Unauthorized(cause);
        break;
      case PAYMENT_REQUIRED:
        ex = (E) new PaymentRequired(cause);
        break;
      case FORBIDDEN:
        ex = (E) new Forbidden(cause);
        break;
      case NOT_FOUND:
        ex = (E) new NotFound(cause);
        break;
      case METHOD_NOT_ALLOWED:
        ex = (E) new MethodNotAllowed(cause);
        break;
      case NOT_ACCEPTABLE:
        ex = (E) new NotAcceptable(cause);
        break;
      case PROXY_AUTHENTICATION_REQUIRED:
        ex = (E) new ProxyAuthenticationRequired(cause);
        break;
      case REQUEST_TIMEOUT:
        ex = (E) new RequestTimeout(cause);
        break;
      case CONFLICT:
        ex = (E) new Conflict(cause);
        break;
      case GONE:
        ex = (E) new Gone(cause);
        break;
      case LENGTH_REQUIRED:
        ex = (E) new LengthRequired(cause);
        break;
      case PRECONDITION_FAILED:
        ex = (E) new PreconditionFailed(cause);
        break;
      case PAYLOAD_TOO_LARGE:
        ex = (E) new PayloadTooLarge(cause);
        break;
      case URI_TOO_LONG:
        ex = (E) new UriTooLong(cause);
        break;
      case UNSUPPORTED_MEDIA_TYPE:
        ex = (E) new UnsupportedMediaType(cause);
        break;
      case RANGE_NOT_SATISFIABLE:
        ex = (E) new RangeNotSatisfiable(cause);
        break;
      case EXPECTATION_FAILED:
        ex = (E) new ExpectationFailed(cause);
        break;
      case MISDIRECTED_REQUEST:
        ex = (E) new MisdirectedRequest(cause);
        break;
      case UNPROCESSABLE_ENTITY:
        ex = (E) new UnprocessableEntity(cause);
        break;
      case LOCKED:
        ex = (E) new Locked(cause);
        break;
      case FAILED_DEPENDENCY:
        ex = (E) new FailedDependency(cause);
        break;
      case TOO_EARLY:
        ex = (E) new TooEarly(cause);
        break;
      case UPGRADE_REQUIRED:
        ex = (E) new UpgradeRequired(cause);
        break;
      case PRECONDITION_REQUIRED:
        ex = (E) new PreconditionRequired(cause);
        break;
      case TOO_MANY_REQUESTS:
        ex = (E) new TooManyRequests(cause);
        break;
      case REQUEST_HEADER_FIELDS_TOO_LARGE:
        ex = (E) new RequestHeaderFieldsTooLarge(cause);
        break;
      case UNAVAILABLE_FOR_LEGAL_REASONS:
        ex = (E) new UnavailableForLegalReasons(cause);
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  /**
   * HTTP 클라이언트 에러 생성.
   *
   * @param status  HTTP 상태 코드.
   * @param message 에러 메시지.
   * @param cause   에러 원인.
   * @param <E>     상세 에러 타입.
   *
   * @return 클라이언트 에러.
   */
  @SuppressWarnings("unchecked")
  public static <E extends Http4xxException> E client(final int status, final String message, final Throwable cause) {
    range(status, 400, 499, "status");

    final E ex;
    switch (status) {
      case BAD_REQUEST:
        ex = (E) new BadRequest(message, cause);
        break;
      case UNAUTHORIZED:
        ex = (E) new Unauthorized(message, cause);
        break;
      case PAYMENT_REQUIRED:
        ex = (E) new PaymentRequired(message, cause);
        break;
      case FORBIDDEN:
        ex = (E) new Forbidden(message, cause);
        break;
      case NOT_FOUND:
        ex = (E) new NotFound(message, cause);
        break;
      case METHOD_NOT_ALLOWED:
        ex = (E) new MethodNotAllowed(message, cause);
        break;
      case NOT_ACCEPTABLE:
        ex = (E) new NotAcceptable(message, cause);
        break;
      case PROXY_AUTHENTICATION_REQUIRED:
        ex = (E) new ProxyAuthenticationRequired(message, cause);
        break;
      case REQUEST_TIMEOUT:
        ex = (E) new RequestTimeout(message, cause);
        break;
      case CONFLICT:
        ex = (E) new Conflict(message, cause);
        break;
      case GONE:
        ex = (E) new Gone(message, cause);
        break;
      case LENGTH_REQUIRED:
        ex = (E) new LengthRequired(message, cause);
        break;
      case PRECONDITION_FAILED:
        ex = (E) new PreconditionFailed(message, cause);
        break;
      case PAYLOAD_TOO_LARGE:
        ex = (E) new PayloadTooLarge(message, cause);
        break;
      case URI_TOO_LONG:
        ex = (E) new UriTooLong(message, cause);
        break;
      case UNSUPPORTED_MEDIA_TYPE:
        ex = (E) new UnsupportedMediaType(message, cause);
        break;
      case RANGE_NOT_SATISFIABLE:
        ex = (E) new RangeNotSatisfiable(message, cause);
        break;
      case EXPECTATION_FAILED:
        ex = (E) new ExpectationFailed(message, cause);
        break;
      case MISDIRECTED_REQUEST:
        ex = (E) new MisdirectedRequest(message, cause);
        break;
      case UNPROCESSABLE_ENTITY:
        ex = (E) new UnprocessableEntity(message, cause);
        break;
      case LOCKED:
        ex = (E) new Locked(message, cause);
        break;
      case FAILED_DEPENDENCY:
        ex = (E) new FailedDependency(message, cause);
        break;
      case TOO_EARLY:
        ex = (E) new TooEarly(message, cause);
        break;
      case UPGRADE_REQUIRED:
        ex = (E) new UpgradeRequired(message, cause);
        break;
      case PRECONDITION_REQUIRED:
        ex = (E) new PreconditionRequired(message, cause);
        break;
      case TOO_MANY_REQUESTS:
        ex = (E) new TooManyRequests(message, cause);
        break;
      case REQUEST_HEADER_FIELDS_TOO_LARGE:
        ex = (E) new RequestHeaderFieldsTooLarge(message, cause);
        break;
      case UNAVAILABLE_FOR_LEGAL_REASONS:
        ex = (E) new UnavailableForLegalReasons(message, cause);
        break;
      default:
        throw new IllegalArgumentException("unsupported status code : " + status);
    }

    return ex;
  }

  protected HttpExceptionUtil() {
    throw new UnsupportedOperationException();
  }
}
