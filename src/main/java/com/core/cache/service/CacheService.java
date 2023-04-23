package com.core.cache.service;

import com.core.im.dto.AppUserProductDto;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CacheService<E> implements ICacheService<AppUserProductDto> {

    private final RestTemplate restTemplate;
    private final CacheManager cacheManager;

    public CacheService(RestTemplate restTemplate, CacheManager cacheManager) {
        this.restTemplate = restTemplate;
        this.cacheManager = cacheManager;
    }

    @Cacheable(key = "'allUser'", value = "allUserCache")
    public AppUserProductDto getAllUsersProducts(String url, Class<AppUserProductDto> type) {
        System.out.println("Getting All the users from DB! | Not Cached");
        AppUserProductDto appUserProductDto = restTemplate.getForObject(url, AppUserProductDto.class);
        return appUserProductDto;
    }

}
