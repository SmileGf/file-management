package com.fia.file.common;

import java.util.Date;
import java.util.Objects;

/**
 * response entity
 * @author 10268
 * @date 2021/1/13 17:29
 */
public class ResponseEntity {

    /**
     *  返回值code
     */
    private String code;

    /**
     * 返回值 message
     */
    private String message;

    /**
     * 时间
     */
    private String responseDate;

    /**
     * 返回值 返回对象
     */
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(String responseDate) {
        this.responseDate = responseDate;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseEntity that = (ResponseEntity) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(message, that.message) &&
                Objects.equals(responseDate, that.responseDate) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, responseDate, data);
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", responseDate=" + responseDate +
                ", data=" + data +
                '}';
    }
}
