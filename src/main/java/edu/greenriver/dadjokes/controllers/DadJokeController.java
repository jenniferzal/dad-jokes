package edu.greenriver.dadjokes.controllers;

import edu.greenriver.dadjokes.services.DadJokeService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadJokeController
{
    private DadJokeService service;

    public DadJokeController(DadJokeService service)
    {
        this.service = service;
    }
}
