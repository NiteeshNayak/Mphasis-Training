package com.test.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.test.model.MLATeam;

public class MLATeamDao1 {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public void createMLATeam(MLATeam obj) {
		String sql = "insert into mlateam values(:e_id, :e_name,:e_skill,:e_manager)";
		
		MapSqlParameterSource msp = new MapSqlParameterSource();
		
		msp.addValue("e_id", obj.getId());
		msp.addValue("e_name", obj.getName());
		msp.addValue("e_skill", obj.getSkill());
		msp.addValue("e_manager", obj.getManager());
		
		namedParameterJdbcTemplate.update(sql, msp);
	}
}
