package com.core.cache.rest;

import com.core.cache.service.ICacheService;
import com.core.im.dto.AppUserProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Value("${com.tds.url}")
    private String tdsUrl;
    private final ICacheService<AppUserProductDto> cacheService;

    public CacheController(ICacheService<AppUserProductDto> cacheService) {
        this.cacheService = cacheService;
    }

    @RequestMapping(value = "/v2/appUsersAndProducts", method = RequestMethod.GET)
    public ResponseEntity<AppUserProductDto> getAppUsersAndProducts() {
        long startTime = System.currentTimeMillis();
        AppUserProductDto appUserProductDto = cacheService.getAllUsersProducts(tdsUrl, AppUserProductDto.class);
        System.out.println(System.currentTimeMillis() - startTime);
        return new ResponseEntity<>(appUserProductDto, HttpStatus.OK);
    }
}
