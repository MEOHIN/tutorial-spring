package validation.interceptor.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import validation.interceptor.interceptor.AuthInterceptor;

@Configuration
@RequiredArgsConstructor        // final 로 선언된 객체를 생성자에서 주입받을 수 있도록 해줌
public class MVCConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
    }
}
