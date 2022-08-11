package com.example.SpringServer.controllers;


import com.example.SpringServer.ApiGatewayProperties;
import com.example.SpringServer.utils.ContentRequestTransformer;
import com.example.SpringServer.utils.HeadersRequestTransformer;
import com.example.SpringServer.utils.URLRequestTransformer;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.*;
@CrossOrigin("http://localhost:4200")
@RestController
public class GatewayController {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ApiGatewayProperties apiGatewayProperties;

  private HttpClient httpClient;

  @PostConstruct
  public void init() {
    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

    httpClient = HttpClients.custom()
            .setConnectionManager(cm)
            .build();
  }

  @RequestMapping(value = "/redirect/**", method = {GET, POST, DELETE,PUT})
  @ResponseBody
  public ResponseEntity<String> proxyRequest(HttpServletRequest request) throws IOException, URISyntaxException {
    HttpUriRequest proxiedRequest = createHttpUriRequest(request);
    logger.info("request: {}", proxiedRequest);
    HttpResponse proxiedResponse = httpClient.execute(proxiedRequest);
    logger.info("Response {}", proxiedResponse.getStatusLine().getStatusCode());
    return new ResponseEntity<>(read(proxiedResponse.getEntity().getContent()), makeResponseHeaders(proxiedResponse), HttpStatus.valueOf(proxiedResponse.getStatusLine().getStatusCode()));
  }

  private HttpHeaders makeResponseHeaders(HttpResponse response) {
    HttpHeaders result = new HttpHeaders();
    Header h = response.getFirstHeader("Content-Type");
    if(h != null) {
      result.set(h.getName(), h.getValue());
    }
    return result;
  }

  private HttpUriRequest createHttpUriRequest(HttpServletRequest request) throws URISyntaxException, IOException {
    URLRequestTransformer urlRequestTransformer = new URLRequestTransformer(apiGatewayProperties);
    ContentRequestTransformer contentRequestTransformer = new ContentRequestTransformer();
    HeadersRequestTransformer headersRequestTransformer = new HeadersRequestTransformer();
    headersRequestTransformer.setPredecessor(contentRequestTransformer);
    contentRequestTransformer.setPredecessor(urlRequestTransformer);

    return headersRequestTransformer.transform(request).build();
  }

  private String read(InputStream input) throws IOException {
    try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
      return buffer.lines().collect(Collectors.joining("\n"));
    }
  }
}
