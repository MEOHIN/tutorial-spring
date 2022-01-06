package validation.filter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@Component      // Spring 이 bean 으로 관리
public class GlobalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        전처리

        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest)request);        // 생성했을 땐 read 하지 않음. 길이만 초기화
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse)response);
        //      doFilter 이후에 처리가 필요
//        BufferedReader br = httpServletRequest.getReader();
//
//        br.lines().forEach(line -> {
//            log.info("url: {}, Line: {}", url, line);
//        });

        chain.doFilter(httpServletRequest, httpServletResponse);    // doFilter 를 통해서 실제로 내부 Spring 안으로 들어가야 그 메소드가 실행돼서 request 에 대한 내용이 ContentAsByteArray 담겨 있고, 그래야 읽을 수 있다.
        String url = httpServletRequest.getRequestURI();

//        후처리
//        전처리지만, 생성자가 생성했을때는 cachedContent 에는 길이만 지정하고 있고 실제 내용을 담고 있지 않음 -> doFilter 후에 request 에 대한 정보를 찍어야 한다
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url: {}, request body: {}", url, reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        log.info("response: {}, responseBody: {}", httpStatus, resContent);
    }
}
