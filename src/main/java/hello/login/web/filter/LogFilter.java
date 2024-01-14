package hello.login.web.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("***** log filter init *****");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("***** log filter doFilter *****");

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpRequest.getRequestURI();// 모든 사용자의 요청 URI

        String uuid = UUID.randomUUID().toString();

        try {
            log.info("********** REQUEST [{}][{}]", uuid, requestURI);
            filterChain.doFilter(servletRequest, servletResponse); // 다음 필터가 있으면 다음 필터를 호출, 없으면 servlet 호출
        } catch (Exception e) {
            throw e;
        } finally {
            log.info("********** RESPONSE [{}][{}]", uuid, requestURI);
        }
    }

    @Override
    public void destroy() {
        log.info("***** log filter destroy *****");
    }
}
