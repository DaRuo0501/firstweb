package com.daruo.firstweb.dao;

import com.daruo.firstweb.dto.TempBag;
import com.daruo.firstweb.dto.TempSkill;

import java.util.List;

public interface SkillDao {

    List<TempSkill> getSkillByPokemonId(Integer pokemonId);

    void remove(Integer userId, Integer myPkId, Integer skillId);

    void createUserPokemonSkill(Integer myPkId, Integer userId, TempSkill tempSkill);

    void deleteById(Integer userId, Integer myPkId);

    List<TempSkill> getSkillByMyPkId(Integer myPkId, Integer userId);

    List<TempSkill> getPokemonNewSkill(TempBag tempBag);

    void add(TempBag tempBag, TempSkill tempSkill);

    TempSkill getSkillName(Integer skillId);

    Integer getCountSkill(Integer myPkId, Integer userId);

    TempSkill getSkillNameByMyPkId(Integer myPkId, Integer skillId);
}
