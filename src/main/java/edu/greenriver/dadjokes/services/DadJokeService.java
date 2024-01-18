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

    public DadJoke update(int id, String newDadJokeText)
    {
        return null;
    }

    public void delete(int id)
    {

    }

}
