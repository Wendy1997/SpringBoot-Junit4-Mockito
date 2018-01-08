package springboot.http;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import springboot.configuration.Connection;

import java.util.concurrent.TimeUnit;

/**
 * Created by bakti.pratama on 1/18/2017.
 */
public class OkHttpFactory {

  public static OkHttpClient create(Connection connection) {
    return new OkHttpClient.Builder()
        .connectTimeout(connection.getConnectTimeout(), TimeUnit.MILLISECONDS)
        .writeTimeout(connection.getWriteTimeout(), TimeUnit.MILLISECONDS)
        .readTimeout(connection.getReadTimeout(), TimeUnit.MILLISECONDS)
        .connectionPool(new ConnectionPool(
            connection.getMaxIdleConnections(),
            connection.getKeepAliveDurationNs(), TimeUnit.MILLISECONDS
        ))
        .retryOnConnectionFailure(connection.getRetryOnConnectionFailure())
        .build();
  }

}
