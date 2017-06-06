package dev.paie.util;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Grade;

public class GradeMapper implements RowMapper<Grade> {

	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grade g = new Grade();
		g.setId(rs.getInt("ID"));
		g.setCode(rs.getString("CODE"));
		g.setNbHeuresBase(rs.getBigDecimal("nbHeuresBase"));
		g.setTauxBase(rs.getBigDecimal("TAUXBASE"));
		return g;
	}
}