package ru.job4j.dreamjob.store;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Repository
public class PostStore {
    @GuardedBy("this")
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private static final AtomicInteger POST_ID = new AtomicInteger(3);

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Разрабатывать платформу обслуживания автопарка."));
        posts.put(2, new Post(2, "Middle Java Job", "Создавать облачную платформу машинного обучения."));
        posts.put(3, new Post(3, "Senior Java Job", "Разрабатывать интеграционные решения в рамках глобальной информационной инфраструктуры."));
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        post.setId(POST_ID.incrementAndGet());
        posts.putIfAbsent(post.getId(), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void update(Post post) {
        posts.replace(post.getId(), post);
    }
}