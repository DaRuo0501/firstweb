package com.daruo.firstweb.controller;

import com.daruo.firstweb.constant.PokemonCategory;
import com.daruo.firstweb.dto.PokemonQueryParams;
import com.daruo.firstweb.model.Pokemon;
import com.daruo.firstweb.model.User;
import com.daruo.firstweb.service.PokemonService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

}
