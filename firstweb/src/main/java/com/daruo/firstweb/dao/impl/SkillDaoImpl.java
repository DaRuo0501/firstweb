package com.daruo.firstweb.dao.impl;

import com.daruo.firstweb.dao.SkillDao;
import com.daruo.firstweb.dto.TempSkill;
import com.daruo.firstweb.rowmapper.TempSkillListRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SkillDaoImpl implements SkillDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<TempSkill> getSkillByPokemonId(Integer pokemonId) {

        String sql = "SELECT p.pokemon_id, p.pokemon_name, s.skill_id, s.skill_name" +
                " FROM pokemon p" +
                " join pokemon_skill ps on p.pokemon_id = ps.pokemon_id" +
                " join skill s on ps.skill_id = s.skill_id" +
                " where p.pokemon_id = :pokemonId;";

        Map<String, Object> map = new HashMap<>();
        map.put("pokemonId", pokemonId);

        List<TempSkill> tempSkillList = namedParameterJdbcTemplate.query(sql, map, new TempSkillListRowMapper());

        return tempSkillList;
    }

    @Override
    public void remove(Integer userId, Integer bagId, Integer skillId) {

        String sql = "";
    }

    @Override
    public void createUserPokemonSkill(Integer myPkId, Integer userId, TempSkill tempSkill) {

        String sql = "INSERT INTO my_pokemon_skill(my_pk_id, user_id, pokemon_id, pokemon_name, skill_id, skill_name," +
                " created_date, last_modified_date)" +
                " VALUES (:myPkId, :userId, :pokemonId, :pokemonName, :skillId, :skillName, :createdDate, :lastModifiedDate);";

        Map<String, Object> map = new HashMap<>();
        map.put("myPkId", myPkId);
        map.put("userId", userId);
        map.put("pokemonId", tempSkill.getPokemonId());
        map.put("pokemonName", tempSkill.getPokemonName());
        map.put("skillId", tempSkill.getSkillId());
        map.put("skillName", tempSkill.getSkillName());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        namedParameterJdbcTemplate.update(sql, map);
    }
}
