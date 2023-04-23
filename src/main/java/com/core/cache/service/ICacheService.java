package com.core.cache.service;

public interface ICacheService<E> {
    E getAllUsersProducts(String url, Class<E> type);
}
