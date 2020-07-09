package work.trons.library.weixin.core.http;

import lombok.SneakyThrows;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.SSLContext;
import java.io.IOException;

/**
 * @author liujiawei
 * @date 2020/7/9
 */
public class HttpClientFactory {

    private final static int DEFAULT_MAX_REQUEST = 64;
    private final static int DEFAULT_MAX_REQUESTS_PRE_HOST = 10;
    private final static long DEFAULT_KEEP_ALIVE_DURATION = 5000L;
    private final static int DEFAULT_CONNECTION_TIMEOUT = 15000;
    private final static int DEFAULT_SOCKET_TIMEOUT = 15000;
    private final static int DEFAULT_WRITE_TIMEOUT = 15000;

    @SneakyThrows
    public static CloseableHttpClient build() {
        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectTimeout(DEFAULT_CONNECTION_TIMEOUT)
                .setSocketTimeout(DEFAULT_SOCKET_TIMEOUT)
                .setConnectionRequestTimeout(DEFAULT_WRITE_TIMEOUT)
                .build();

        RegistryBuilder<ConnectionSocketFactory> socketFactoryRegistryBuilder = RegistryBuilder.create();
        socketFactoryRegistryBuilder.register("http", new PlainConnectionSocketFactory());
        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        socketFactoryRegistryBuilder.register("https", socketFactory);

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistryBuilder.build());
        connectionManager.setMaxTotal(DEFAULT_MAX_REQUEST);
        connectionManager.setDefaultMaxPerRoute(DEFAULT_MAX_REQUESTS_PRE_HOST);
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new ConnectionKeepAliveStrategy() {
                    @Override
                    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
                        long duration = DefaultConnectionKeepAliveStrategy.INSTANCE.getKeepAliveDuration(httpResponse, httpContext);

                        if (duration > 0 && duration < DEFAULT_KEEP_ALIVE_DURATION) {
                            return duration;
                        } else {
                            return DEFAULT_KEEP_ALIVE_DURATION;
                        }
                    }
                })
                .build();
    }
}
