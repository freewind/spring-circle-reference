package myweb;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

/**
 * Intercepts responses received by the restTemplate and, if they are gzipped, unzip them. Not that this intercepts incoming responses to the Resi Services
 * requests, not outgoing responses to client requests.
 */
public class GzipResponseInterceptor implements HttpResponseInterceptor {

    @Override
    public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {

    }
}
