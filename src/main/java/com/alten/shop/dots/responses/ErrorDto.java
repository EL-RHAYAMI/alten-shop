package com.alten.shop.dots.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {
    @JsonProperty(value = "Timestamp")
    private Date timestamp;
    @JsonProperty(value = "HTTP_CODE")
    private HttpStatus httpCode;
    @JsonProperty(value = "Message")
    private String message;
}