package com.jojo.boot.springbootmdc.filter;

import io.micrometer.common.lang.NonNullApi;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@NonNullApi
public class HttpRequestFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    public static final String TRACE_KEY = "traceId" ;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)  throws IOException, ServletException {
        String traceId = request.getHeader("x-trace-id") ;
        // 呼び出し元が traceId を渡さなかった場合、自動生成する
        if (!StringUtils.hasLength(traceId)) {
            traceId =  RandomStringUtils.secure().nextAlphanumeric(32).replace("-", "").toUpperCase() ;
        }
        // 現在のリクエストの traceId を MDC に保存する
        MDC.put(TRACE_KEY,traceId);
        logger.info("リクエスト: {}", request.getServletPath());
        try {
            chain.doFilter(request, response);
        } finally {
            // 処理終了後に MDC から traceId を削除する
            MDC.remove(TRACE_KEY);
        }
    }

}
