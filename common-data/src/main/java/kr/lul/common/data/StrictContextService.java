package kr.lul.common.data;

import static java.lang.String.format;

/**
 * @author justburrow
 * @since 2019/11/24
 */
public class StrictContextService implements ContextService {
  private final Object lock = new Object();

  private final ThreadLocal<Context> contextHolder;

  public StrictContextService() {
    this.contextHolder = new ThreadLocal<>();
  }

  /**
   * @return 신규 컨텍스트.
   *
   * @throws IllegalStateException 이미 컨텍스트가 있을 경우.
   */
  @Override
  public Context issue() throws IllegalStateException {
    synchronized (this.lock) {
      Context context = this.contextHolder.get();
      if (null != context)
        throw new IllegalStateException(format("context already exists : %s", context));

      context = new Context();
      this.contextHolder.set(context);
      return context;
    }
  }

  /**
   * @return 현재 컨텍스트.
   *
   * @throws IllegalStateException 현재 컨텍스트가 없을 때.
   */
  @Override
  public Context get() throws IllegalStateException {
    synchronized (this.lock) {
      Context context = this.contextHolder.get();

      if (null == context)
        throw new IllegalStateException("context does not exist.");

      return context;
    }
  }

  /**
   * @return {@code true}
   *
   * @throws IllegalStateException 현재 컨텍스트가 없을 때.
   */
  @Override
  public boolean clear() throws IllegalStateException {
    synchronized (this.lock) {
      Context context = this.contextHolder.get();
      if (null == context)
        throw new IllegalStateException("context does not exist.");

      this.contextHolder.remove();
      return true;
    }
  }
}
