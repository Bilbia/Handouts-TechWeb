package br.edu.insper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	private Connection connection = null;
	
	public DAO () throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost/meus_dados", "root", "alexehulk");
	}
	
	public List<Pessoa> getLista() throws SQLException {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Pessoa");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getNString("nome"));
			pessoa.setIdade(rs.getInt("idade"));
			pessoas.add(pessoa);
		}
		
		rs.close();
		stmt.close();
		return pessoas;
	}
	
	public void adiciona (Pessoa pessoa) throws SQLException {
		
		String sql = "INSERT INTO Pessoa (nome, idade) VALUES (?,?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setNString(1, pessoa.getNome());
		stmt.setInt(2, pessoa.getIdade());
		stmt.execute();
		stmt.close();
				
	}
	
	public void close() throws SQLException {
		connection.close();
	}

}
