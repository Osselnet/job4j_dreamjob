package ru.job4j.dreamjob.store;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Repository
public class CandidateStore {
    @GuardedBy("this")
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();
    private static final AtomicInteger CANDIDATE_ID = new AtomicInteger(3);

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Junior Developer", "Сan dig."));
        candidates.put(2, new Candidate(2, "Middle Developer", "I can't dig."));
        candidates.put(3, new Candidate(3, "Senior Developer", "I can sleep sitting all day."));
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void add(Candidate candidate) {
        candidate.setId(CANDIDATE_ID.incrementAndGet());
        candidates.put(candidate.getId(), candidate);
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }

    public void update(Candidate candidate) {
        candidates.replace(candidate.getId(), candidate);
    }

}
