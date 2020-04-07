package com.ansh.repository;

import com.ansh.constant.RedisConstant;
import com.ansh.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ItemRepository implements RedisConstant {

    @Autowired
    private RedisTemplate<String, Item> redisTemplate;

    /*Getting all Items from tSable*/
    public Map<Integer, Item> getAllItems(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        return hashOperations.entries(KEY);
    }

    /*Getting a specific item by item id from table*/
    public Item getItem(int itemId){
        return (Item) redisTemplate.opsForHash().get(KEY, itemId);
    }

    /*Adding an item into redis database*/
    public void addItem(Item item){
        redisTemplate.opsForHash().put(KEY, item.getId(), item);
    }

    /*delete an item from database*/
    public void deleteItem(int id){
        redisTemplate.opsForHash().delete(KEY, id);
    }

    /*update an item from database*/
    public void updateItem(Item item){
        addItem(item);
    }
}