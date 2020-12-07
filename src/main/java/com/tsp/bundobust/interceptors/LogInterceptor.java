package com.tsp.bundobust.interceptors;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LogInterceptor extends OncePerRequestFilter {



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			MDC.clear();
			UUID requestId = UUID.randomUUID();
			MDC.put("requestId", String.valueOf(requestId));
			filterChain.doFilter(request, response);
		} finally {
			MDC.clear();
		}

	}

}