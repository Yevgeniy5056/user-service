package com.cydeo.client.interceptor;

import com.cydeo.service.KeycloakService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeignClientInterceptor implements RequestInterceptor {

    private final KeycloakService keycloakService;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", keycloakService.getAccessToken());
    }
}
