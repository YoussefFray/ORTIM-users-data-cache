package com.redis.userCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final RedisTemplate<String, User> redisTemplate;

    @Autowired
    public UserService(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveUser(User user) {
        redisTemplate.opsForValue().set(user.getId(), user);
    }

    public User getUser(String id) {
        return redisTemplate.opsForValue().get(id);
    }

    public void deleteUser(String id) {
        redisTemplate.delete(id);
    }
}

