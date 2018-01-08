package springboot.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by bakti.pratama on 1/18/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseWrapper<T> {
  private Integer code;
  private String message;
  private T value;

  public ResponseWrapper() {
    this.code = 200;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }
}
