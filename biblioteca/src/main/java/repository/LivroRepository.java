package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import models.Livro;
import models.Livro.Status;

public class LivroRepository implements ILivroRepository {
	
	private Connection conn;
	
	public LivroRepository() {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public Boolean insert(Livro livro) {
		
		PreparedStatement statement = null;
		LocalDate date = livro.getDataLancamento();
		Date dateFinal = Date.valueOf(date);
		try {
			
			String sql = "INSERT INTO livros (name, datalancamento, description, autor, status) VALUES(?, ?, ?, ?, ?)";
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, livro.getName());
			statement.setString(3, livro.getDescription());
			statement.setString(4, livro.getAutor());
			statement.setDate(2, dateFinal);
			statement.setString(5, livro.getStatus().toString());

			
			int rowsAffected = statement.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet ids = statement.getGeneratedKeys();
				
				while (ids.next()) {
					livro.setId(ids.getInt(1));
				}
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public Boolean update(Livro livro) {
		
		PreparedStatement statement = null;
				
		try {
			Date dateFinal = Date.valueOf(livro.getDataLancamento());
			
			String sql = "UPDATE livros "
					+ "SET name = ?, datalancamento = ?, description = ?, autor = ? , status = ?"
					+ "WHERE id = ?";
			
			statement = conn.prepareStatement(sql);
			
			statement.setString(1, livro.getName());
			statement.setDate(2, dateFinal);
			statement.setString(3, livro.getDescription());
			statement.setString(4, livro.getAutor());
			statement.setString(5, livro.getStatus().getLabel());
			statement.setInt(6, livro.getId());
			
			statement.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public Integer deleteById(Integer id) {
		
		PreparedStatement statement = null;
		
		try {
			
			String sql = "DELETE FROM livros WHERE (id = ?)";
			statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			int rowsAffected = statement.executeUpdate();
			
			System.out.println("Rows affected: " + rowsAffected);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return id;
	}

	@Override
	public List<Livro> findAll() {
		
		List<Livro> livros = new ArrayList<Livro>();
		
		PreparedStatement stmt = null;
		ResultSet result = null;
	
		try {
			
			stmt = conn.prepareStatement("SELECT * FROM livros");
			result = stmt.executeQuery();
			
			while(result.next()) {
				
				Integer id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				String autor = result.getString("autor");
				String date = result.getDate("datalancamento").toString();
				Status status = Status.valueOf(result.getString("status"));
				
				Livro p = new Livro(id, name, description, autor, date, status);
				
				livros.add(p);
			}
			
			
		} catch (SQLException e) {
		
			throw new RuntimeException(e.getMessage());
		
		} finally {
						
			try {
				stmt.close();
				result.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return livros;
	
	}

	@Override
	public Livro findById(Integer id) {
		
		Livro livro = null;
		
		PreparedStatement statement = null;
		ResultSet result = null;
	
		try {
			
			statement = conn.prepareStatement("SELECT * FROM livros WHERE id = ?");
			statement.setInt(1, id);

			result = statement.executeQuery();
			
			while(result.next()) {
				
				String name = result.getString("name");
				String description = result.getString("description");
				String autor = result.getString("autor");
				String date = result.getDate("datalancamento").toString();
				Status status = Status.valueOf(result.getString("status"));
				
				livro = new Livro(id, name, description, autor, date, status);
				
			}
			
		} catch (SQLException e) {
		
			throw new RuntimeException(e.getMessage());
		
		} finally {
						
			try {
				statement.close();
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return livro;

	}

	@Override
	public Livro findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
