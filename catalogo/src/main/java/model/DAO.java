package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3307/dbfilme?userTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "@Fdsa86015";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Inserir filme.
	 *
	 * @param filme the filme
	 */
	public void inserirFilme(JavaBeans filme) {
		String create = "insert into filme(nome,ano,descricao) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, filme.getNome());
			pst.setString(2, filme.getAno());
			pst.setString(3, filme.getDescricao());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar filmes.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarFilmes() {
		ArrayList<JavaBeans> filmes = new ArrayList<>();
		String read = "select * from filme order by id";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String ano = rs.getString(3);
				String descricao = rs.getString(4);

				filmes.add(new JavaBeans(id, nome, ano, descricao));
			}
			con.close();
			return filmes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar filme.
	 *
	 * @param contato the contato
	 */
	public void selecionarFilme(JavaBeans contato) {
		String read2 = "select * from filme where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setId(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setAno(rs.getString(3));
				contato.setDescricao(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar filme.
	 *
	 * @param filme the filme
	 */
	public void alterarFilme(JavaBeans filme) {
		String update = "update filme set nome=?,ano=?,descricao=? where id =?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, filme.getNome());
			pst.setString(2, filme.getAno());
			pst.setString(3, filme.getDescricao());
			pst.setString(4, filme.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Deletar filme.
	 *
	 * @param filme the filme
	 */
	public void deletarFilme(JavaBeans filme) {
		String delete = "delete from filme where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, filme.getId());
			System.out.println(filme.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
