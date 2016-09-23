package com.thomas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.thomas.domaine.Employe;

public class EmployeDao implements IEmployeDao {

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public EmployeDao() {
		super();
	}

	@Override
	public void saveEmploye(Employe employe) {
		final String EMPLOYE_INSERT = "insert into employe (id,login, password, prenom, nom, email, role) "
				+ "values (?,?,?,?,?,?,?)";

		jdbcTemplate.update(EMPLOYE_INSERT, new Object[] { employe.getId(), employe.getLogin(), employe.getPassword(),
				employe.getPrenom(), employe.getNom(), employe.getEmail(), employe.getRole() });
	}

	@Override
	public Employe getEmployeById(int id) {
		String EMPLOYE_READ = "SELECT * FROM employe WHERE id = ?";

		RowMapper mapper = new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employe employe = new Employe();
				employe.setId((int) rs.getLong("id"));
				employe.setPrenom(rs.getString("prenom"));
				employe.setNom(rs.getString("nom"));
				employe.setEmail(rs.getString("email"));
				employe.setLogin(rs.getString("login"));
				employe.setPassword(rs.getString("password"));
				employe.setRole(rs.getString("role"));
				
				return employe;
			}
		};
		Employe employe = (Employe) jdbcTemplate.queryForObject(EMPLOYE_READ, new Object[] { Long.valueOf(id) },
				mapper);

		return employe;
	}

	@Override
	public Employe getEmployeByLogin(String login) {
		String EMPLOYE_READ = "SELECT * FROM employe WHERE login = ?";

		RowMapper mapper = new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employe employe = new Employe();
				employe.setId((int) rs.getLong("id"));
				employe.setPrenom(rs.getString("prenom"));
				employe.setNom(rs.getString("nom"));
				employe.setEmail(rs.getString("email"));
				employe.setLogin(rs.getString("login"));
				employe.setPassword(rs.getString("password"));
				employe.setRole(rs.getString("role"));
				
				return employe;
			}
		};
		Employe employe = (Employe) jdbcTemplate.queryForObject(EMPLOYE_READ, new Object[] { login },
				mapper);

		return employe;
	}

	@Override
	public int getEmployeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employe> getAllEmploye() {

		final String sql = "select * from employe";

		RowMapper mapper = new RowMapper() {

			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

				Employe employe = new Employe();
				employe.setId((int) rs.getLong("id"));
				employe.setPrenom(rs.getString("prenom"));
				employe.setNom(rs.getString("nom"));
				employe.setEmail(rs.getString("email"));
				employe.setLogin(rs.getString("login"));
				employe.setPassword(rs.getString("password"));
				employe.setRole(rs.getString("role"));
				return employe;

			}
		};

		List<Employe> listeDesClients = (List<Employe>) jdbcTemplate.query(sql, mapper);

		return listeDesClients;
	}

}
