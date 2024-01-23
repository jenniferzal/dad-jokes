package edu.greenriver.dadjokes.services;

import edu.greenriver.dadjokes.db.DadJokeRepository;
import edu.greenriver.dadjokes.domain.DadJoke;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DadJokeService
{
    private DadJokeRepository repository;

    public DadJokeService(DadJokeRepository repository)
    {
        this.repository = repository;
    }

    public List<DadJoke> getAll()
    {
        //convert to read-only list
        List<DadJoke> jokes = repository.findAll();
        return Collections.unmodifiableList(jokes);
    }

    public void add(DadJoke joke)
    {
        repository.save(joke);
    }

    public DadJoke update(int id, DadJoke newDadJokeText)
    {
        DadJoke currentJoke = repository.findById(id).orElseThrow();
        currentJoke.setJokeText(newDadJokeText.getJokeText());

        return repository.save(currentJoke);
    }

    public void delete(int id)
    {
        repository.deleteById(id);
    }

    public DadJoke byId(int id)
    {
        return repository.findById(id).orElseThrow();
    }

}
