package com.one.experiment1;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
@Component
public class MdcInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String CID = getCorrelationId();
    log.info("Generated CID : " + CID + " | Request start: " + request.getRequestURI());
    MDC.put("CorrelationId", CID);
    return true;
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    log.info("Request end : " + request.getRequestURI() + " | Removing CID : " + MDC.get("CorrelationId"));
    MDC.remove("CorrelationId");
  }

  private String getCorrelationId() {
    return UUID.randomUUID().toString();
  }
}
