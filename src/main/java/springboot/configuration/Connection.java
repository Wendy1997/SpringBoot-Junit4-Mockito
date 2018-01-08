package springboot.configuration;

/**
 * Created by bakti.pratama on 1/18/2017.
 */
public class Connection {
  private Long connectTimeout = 10 * 1000L;

  private Long readTimeout = 10 * 1000L;

  private Long writeTimeout = 10 * 1000L;

  private Integer maxIdleConnections = 5;

  private Long keepAliveDurationNs = 5 * 60 * 1000L;

  private Boolean retryOnConnectionFailure = true;

  public Long getConnectTimeout() {
    return connectTimeout;
  }

  public void setConnectTimeout(Long connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public Long getReadTimeout() {
    return readTimeout;
  }

  public void setReadTimeout(Long readTimeout) {
    this.readTimeout = readTimeout;
  }

  public Long getWriteTimeout() {
    return writeTimeout;
  }

  public void setWriteTimeout(Long writeTimeout) {
    this.writeTimeout = writeTimeout;
  }

  public Integer getMaxIdleConnections() {
    return maxIdleConnections;
  }

  public void setMaxIdleConnections(Integer maxIdleConnections) {
    this.maxIdleConnections = maxIdleConnections;
  }

  public Long getKeepAliveDurationNs() {
    return keepAliveDurationNs;
  }

  public void setKeepAliveDurationNs(Long keepAliveDurationNs) {
    this.keepAliveDurationNs = keepAliveDurationNs;
  }

  public Boolean getRetryOnConnectionFailure() {
    return retryOnConnectionFailure;
  }

  public void setRetryOnConnectionFailure(Boolean retryOnConnectionFailure) {
    this.retryOnConnectionFailure = retryOnConnectionFailure;
  }
}
