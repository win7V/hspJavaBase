package com.edu.dao_.test;

import com.edu.dao_.dao.ActorDAO.ActorDAO;
import com.edu.dao_.domain.Actor;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @date 3/12/2024 下午4:05
 * @explain:测试ActorDAO 对 actor表的crud操作
 */

public class TestDAO {
    @Test
    public void testActorDAO() {
        ActorDAO actorDAO = new ActorDAO();
        //1.查询
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("====查询结果====");
        for(Actor actor : actors) {
            System.out.println(actor);
        }

        //2.查询单行记录
        Actor actor = actorDAO.querySingle("select name from actor where id >= ?", Actor.class, 1);
        System.out.println("====查询结果====");
        System.out.println(actor);

        //3.查询单行单列
        Object o = actorDAO.queryScalar("select name from actor where id = ?", 1);
        System.out.println("====查询结果====");
        System.out.println(o);

        //4.dml操作 insert update delete
        int update = actorDAO.update("insert into actor values(null, ?, ?, ?, ?)","zzc", "男", "2000-11-11", "990");
        System.out.println(update > 0 ? "success" : "failed");

        
    }
}
