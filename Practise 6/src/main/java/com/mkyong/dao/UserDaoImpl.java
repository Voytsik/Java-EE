package com.mkyong.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mkyong.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public User findByName(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
		String sql = "SELECT * FROM users WHERE firstName=:name";
        return namedParameterJdbcTemplate.queryForObject(
                    sql,
                    params,
                    new UserMapper());
	}

	@Override
	public List<User> findByLastName(String lastName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", lastName);
		String sql = "SELECT * FROM users WHERE lastName=:name";
		return namedParameterJdbcTemplate.query(sql, params, new UserMapper());
	}

	@Override
	public List<User> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "SELECT * FROM users";
        return namedParameterJdbcTemplate.query(sql, params, new UserMapper());
	}

	@Override
	public List<User> findLetterAll(String letter) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "%" + letter + "%");
		String sql = "SELECT * FROM users WHERE firstName LIKE :name OR lastName LIKE :name";
        return namedParameterJdbcTemplate.query(sql, params, new UserMapper());
	}

	private static final class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			return user;
		}

	}

}