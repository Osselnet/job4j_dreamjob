package ru.job4j.dreamjob.store;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.City;
import ru.job4j.dreamjob.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
@Repository
public class CityStore {
    @GuardedBy("this")
    private final Map<Integer, City> cities = new ConcurrentHashMap<>();

    public CityStore() {
        cities.put(1, new City(1, "Москва"));
        cities.put(2, new City(2, "СПб"));
        cities.put(3, new City(3, "Екб"));
    }

    public List<City> getAllCities() {
        return new ArrayList<>(cities.values());
    }

    public City findById(int id) {
        return cities.get(id);
    }
 }
