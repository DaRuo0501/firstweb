package com.daruo.firstweb.service.impl;

import com.daruo.firstweb.dao.PokemonDao;
import com.daruo.firstweb.dto.PokemonQueryParams;
import com.daruo.firstweb.dto.UserQueryParams;
import com.daruo.firstweb.model.Pokemon;
import com.daruo.firstweb.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private PokemonDao pokemonDao;

    @Override
    public List<Pokemon> getPokemons(PokemonQueryParams pokemonQueryParams) {

        return pokemonDao.getPokemons(pokemonQueryParams);
    }

    @Override
    public List<Pokemon> getCategory() {
        return pokemonDao.getCategory();
    }

    @Override
    public List<Integer> getPokemonsCount(PokemonQueryParams pokemonQueryParams) {

        // 取得 資料庫中，寶可夢的總數
        Integer total = pokemonDao.getPokemonsCount(pokemonQueryParams);

        // 每頁要顯示的數量: 12個
        Integer count = 12;

        // 總共會產生多少頁數，初始值為: 0
        Integer page = 0;

        // 將迴圈取得的頁數，存放於 List 裡面
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < total; i++) {

            total += -count;
            page++;
            integerList.add(page);
        }

        if (total > 0) {

            page++;
            integerList.add(page);
        }

        return integerList;
    }
}
