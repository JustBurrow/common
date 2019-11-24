package kr.lul.common.data;

import static java.lang.String.format;
import static java.util.UUID.randomUUID;

/**
 * @author justburrow
 * @since 2019/11/24
 */
public class UuidContextService implements ContextService<UuidContext> {
  private final Object lock = new Object();

  private ThreadLocal<UuidContext> threadLocal;

  public UuidContextService() {
    this.threadLocal = new ThreadLocal<>();
  }

  @Override
  public UuidContext issue() throws IllegalStateException {
    synchronized (this.lock) {
      UuidContext context = this.threadLocal.get();
      if (null == context) {
        context = new UuidContext(randomUUID());
      } else {
        throw new IllegalStateException(format("context already exists : id=%s", context.id()));
      }
      this.threadLocal.set(context);
      return context;
    }
  }

  @Override
  public UuidContext get() {
    synchronized (this.lock) {
      UuidContext context = this.threadLocal.get();
      if (null == context) {
        context = new UuidContext(randomUUID());
        this.threadLocal.set(context);
      }
      return context;
    }
  }

  @Override
  public boolean clear() {
    synchronized (this.lock) {
      UuidContext context = this.threadLocal.get();
      boolean rv = null != context;
      this.threadLocal.remove();
      return rv;
    }
  }
}
