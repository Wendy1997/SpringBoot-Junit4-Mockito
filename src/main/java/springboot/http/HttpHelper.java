package springboot.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import springboot.model.response.ResponseWrapper;

import java.io.IOException;

/**
 * Created by bakti.pratama on 1/18/2017.
 */
public class HttpHelper {

  ObjectMapper mapper;
  OkHttpClient client;

  public HttpHelper(OkHttpClient client) {
    this.client = client;
    this.mapper = new ObjectMapper();
  }

  public String createURL(String baseUrl) {
    return "http://localhost:8080" + baseUrl;
  }

  private <T> ResponseWrapper<T> callApi(Request httpRequest, TypeReference<ResponseWrapper<T>> typeRef)
      throws IOException {
    Response response = client.newCall(httpRequest).execute();
    ResponseWrapper<T> result = new ResponseWrapper<T>();
    result = mapper.readValue(response.body().string(), typeRef);
    response.close();
    return result;
  }


  public <T> ResponseWrapper<T> callGetApi(String url, TypeReference<ResponseWrapper<T>> typeRef) {
    try {
      Request httpRequest = new Request.Builder().get().url(createURL(url)).build();
      return this.callApi(httpRequest, typeRef);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public <T, R> ResponseWrapper<T> callPostApi(String url, R request, TypeReference<ResponseWrapper<T>> typeRef) {
    try {
      String json = mapper.writeValueAsString(request);
      Request httpRequest =
          new Request.Builder().post(RequestBody.create(MediaType.parse("application/json"), json)).url(createURL(url))
              .build();
      return this.callApi(httpRequest, typeRef);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
