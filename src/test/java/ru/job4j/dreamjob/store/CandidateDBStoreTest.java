package ru.job4j.dreamjob.store;

import org.junit.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.model.Candidate;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CandidateDBStoreTest {

    @Test
    public void whenCreatePost() {
        CandidateDBStore store = new CandidateDBStore(new Main().loadPool());
        Candidate candidate = new Candidate(0, "Junior Developer", "Сan dig.", LocalDateTime.now(), new byte[]{1, 2, 3});
        store.add(candidate);
        Candidate postInDb = store.findById(candidate.getId());
        assertThat(postInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void whenUpdatePost() {
        CandidateDBStore store = new CandidateDBStore(new Main().loadPool());
        Candidate candidate = new Candidate(0, "Junior Developer", "Сan dig.", LocalDateTime.now(), new byte[]{1, 2, 3});
        store.add(candidate);
        candidate.setName("Senior Developer");
        candidate.setDescription("I can sleep sitting all day.");
        store.update(candidate);
        Candidate postInDb = store.findById(candidate.getId());
        assertThat(postInDb.getName(), is(candidate.getName()));
    }
}