package dev.paie.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Grade;

public class GradeMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grade p = new Grade();
		p.setId(rs.getInt("id"));
		p.setCode(rs.getString("code"));
		p.setNbHeuresBase(rs.getBigDecimal("nbHeuresBase"));
		p.setTauxBase(rs.getBigDecimal("tauxBase"));
		return p;
	}
}