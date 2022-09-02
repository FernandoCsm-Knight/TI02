package dao;

import model.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO extends DAO {	
	public ProdutoDAO() {
		super();
		conectar();
	}
	
	
	public void finalize() {
		close();
	}
	
	
	public boolean insert(Produto produto) {
		boolean status = false;
		try {
			String sql = "INSERT INTO produto (descricao, preco, quantidade, datafabricacao, datavalidade) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, produto.getDescricao());
			pst.setDouble(2, produto.getPreco());
			pst.setInt(3, produto.getQuantidade());
		    pst.setTimestamp(4, Timestamp.valueOf(produto.getDataFabricacao()));
			pst.setDate(5, Date.valueOf(produto.getDataValidade()));
			pst.executeUpdate();
			pst.close();
			status = true;
			Produto.increment();
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Produto get(int id) {
		Produto produto = null;
		
		try {
			String sql = "SELECT * FROM produto WHERE id = ?";
			PreparedStatement pst = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();	
	        if(rs.next()){            
	        	 produto = new Produto(rs.getInt("id"), rs.getString("descricao"), (float)rs.getDouble("preco"), 
	                				   rs.getInt("quantidade"), 
	        			               rs.getTimestamp("datafabricacao").toLocalDateTime(),
	        			               rs.getDate("datavalidade").toLocalDate());
	        }
	        pst.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produto;
	}
	
	
	public List<Produto> get() {
		return get("");
	}

	
	public List<Produto> getOrderByID() {
		return get("id");		
	}
	
	
	public List<Produto> getOrderByDescricao() {
		return get("descricao");		
	}
	
	
	public List<Produto> getOrderByPreco() {
		return get("preco");		
	}
	
	
	private List<Produto> get(String orderBy) {
		List<Produto> produtos = new ArrayList<Produto>();
		
		try {
			String sql;
			PreparedStatement pst; 
			if(orderBy.trim().length() == 0) {			
				sql = "SELECT * FROM produto";
				pst = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			} else {
				sql = "SELECT * FROM produto ORDER BY ?";
				pst = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				pst.setString(1, orderBy);
			}
			
			ResultSet rs = pst.executeQuery();	           
	        while(rs.next()) {	            	
	        	Produto p = new Produto(rs.getInt("id"), rs.getString("descricao"), (float)rs.getDouble("preco"), 
	        			                rs.getInt("quantidade"),
	        			                rs.getTimestamp("datafabricacao").toLocalDateTime(),
	        			                rs.getDate("datavalidade").toLocalDate());
	            produtos.add(p);
	        }
	        pst.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return produtos;
	}
	
	public int getLastCode() {
		int code = 0;
		try {
			String sql = "SELECT * FROM usuario ORDER BY codigo DESC LIMIT 1";
			PreparedStatement pst = conexao.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				code = rs.getInt("codigo");
			}
			pst.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return code;
	}
	
	public boolean update(Produto produto) {
		boolean status = false;
		try {  
			String sql = "UPDATE produto SET descricao = ?, preco = ?, quantidade = ?, datafabricacao = ?, datavalidade = ? WHERE id = ?";
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setString(1, produto.getDescricao());
			pst.setDouble(2, produto.getPreco());
			pst.setInt(3, produto.getQuantidade());
		    pst.setTimestamp(4, Timestamp.valueOf(produto.getDataFabricacao()));
			pst.setDate(5, Date.valueOf(produto.getDataValidade()));
			pst.setInt(6, produto.getID());
			pst.executeUpdate();
			pst.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			String sql = "DELETE FROM produto WHERE id = ?";
			PreparedStatement pst = conexao.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}