package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PostStore {

    private static final PostStore INST = new PostStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Разрабатывать платформу обслуживания автопарка.", "12.09.99"));
        posts.put(2, new Post(2, "Middle Java Job", "Создавать облачную платформу машинного обучения", "11.07.23"));
        posts.put(3, new Post(3, "Senior Java Job", "Разрабатывать интеграционные решения в рамках глобальной информационной инфраструктуры.", "23-03-12"));
    }

    public static PostStore instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }
}