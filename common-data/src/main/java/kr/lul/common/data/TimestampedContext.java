package kr.lul.common.data;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import static java.time.Instant.now;
import static java.util.UUID.randomUUID;
import static kr.lul.common.util.Arguments.notNull;

/**
 * @author justburrow
 * @since 2020/04/26
 */
public class TimestampedContext extends Context {
  protected final Instant timestamp;

  public TimestampedContext() {
    this(randomUUID(), now());
  }

  public TimestampedContext(final UUID id, final Instant timestamp) {
    super(id);
    notNull(timestamp, "timestamp");

    this.timestamp = timestamp;
  }

  public TimestampedContext(final TimestampedContext context) {
    this(context.id, context.timestamp);
  }

  public Instant getTimestamp() {
    return this.timestamp;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    final TimestampedContext that = (TimestampedContext) o;
    return this.id.equals(that.id) &&
               this.timestamp.equals(that.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.timestamp);
  }
}
