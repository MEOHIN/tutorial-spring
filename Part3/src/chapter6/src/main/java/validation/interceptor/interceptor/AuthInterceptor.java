package validation.interceptor.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import validation.interceptor.annotation.Auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
//    이 때 HttpServletRequest 가 response body 를 읽으면, 손실됨
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();

        log.info("request url: {}", url);
//        권한 체크
        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation: {}", hasAnnotation);


        return true;       // true 일때만 Interceptor 넘어서서 logic 을 타게 된다.
    }

//    annotation 유무 확인
   private boolean checkAnnotation(Object handler, Class clazz) {

//        resource 에 대한 요청일 땐, 권한 확인없이 무조건 통과: 예를들면, javascript, html
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

//        annotation check
       HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {
//            Auth annotation 이 있을 때 true;
            return true;
        }

        return false;
    }
}
