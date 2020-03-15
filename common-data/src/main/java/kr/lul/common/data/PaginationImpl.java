package kr.lul.common.data;

import java.util.List;

import static java.lang.String.format;
import static java.util.Collections.unmodifiableList;
import static kr.lul.common.util.Arguments.*;

/**
 * 기본 구현.
 *
 * @param <T> 데이터 타입.
 *
 * @author justburrow
 * @since 2020/03/14
 */
public class PaginationImpl<T> implements Pagination<T> {
  private int page;
  private int limit;
  private long totalCount;
  private List<T> content;

  public PaginationImpl(final int page, final int limit, final long totalCount, final List<T> content) {
    notNegative(page, "page");
    positive(limit, "limit");
    notNegative(totalCount, "totalCount");
    notNull(content, "content");
    if (totalCount < content.size())
      throw new IllegalArgumentException(format("too many data : totalCount=%d, content.size=%d", totalCount, content.size()));

    this.page = page;
    this.limit = limit;
    this.totalCount = totalCount;
    this.content = unmodifiableList(content);
  }

  @Override
  public int getPage() {
    return this.page;
  }

  @Override
  public int getLimit() {
    return this.limit;
  }

  @Override
  public long getTotalCount() {
    return this.totalCount;
  }

  @Override
  public List<T> getContent() {
    return this.content;
  }

  @Override
  public String toString() {
    return new StringBuilder(PaginationImpl.class.getSimpleName())
               .append("{page=").append(this.page)
               .append(", limit=").append(this.limit)
               .append(", totalCount=").append(this.totalCount)
               .append(", content=").append(this.content)
               .append('}').toString();
  }
}
