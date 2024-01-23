package edu.greenriver.dadjokes.controllers;

import edu.greenriver.dadjokes.domain.DadJoke;
import edu.greenriver.dadjokes.services.DadJokeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DadJokeController
{
    private DadJokeService service;

    public DadJokeController(DadJokeService service)
    {
        this.service = service;
    }

    @GetMapping("jokes")
    public List<DadJoke> getAll()
    {
        return service.getAll();
    }

    @GetMapping("jokes/random")
    public DadJoke getRandom()
    {
        return service.getRandomDadJoke();
    }

    @GetMapping("jokes/{id}")
    public DadJoke byId(@PathVariable int id)
    {
        return service.byId(id);
    }

    @PostMapping("jokes")
    public void addJoke(@RequestBody DadJoke newDadJoke)
    {
        service.add(newDadJoke);
    }

    @PutMapping("jokes/update/{id}")
    public DadJoke updateDadJoke(@PathVariable int id,
                                 @RequestBody DadJoke updatedDadJoke)
    {
        return service.update(id, updatedDadJoke);
    }

    @DeleteMapping("jokes/delete/{id}")
    public void deleteDadJoke(@PathVariable int id)
    {
        service.delete(id);
    }


}
