/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import persistencia.Produto;

public class produtodao {
   public void inserir(Produto p) {
        String sql = "Insert into Produtos(Nome,Categoria,Observacoes,Quantidade,Preco) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCategoria());
            stmt.setString(3, p.getObservacoes());
            stmt.setInt(4, p.getQuantidade());
            stmt.setDouble(5, p.getPreco());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } 
   }
   
   public void updateQuantidade(int id) {
       
           
        String sql = "Update Produtos Set Quantidade = Quantidade - 1 where Quantidade > 0 and Id = ?";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } 
       
       
   }
   
  public ArrayList<Produto> getAll(){
             String sql = "SELECT * FROM Produtos";  
            
             
              try(Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

                    ResultSet rs = stmt.executeQuery();   
                    
                    ArrayList<Produto> listaEmpresas = new ArrayList<>();
                    while (rs.next()) {
                         Produto p = new Produto();
                        
                        p.setId(rs.getInt("Id"));
                        p.setNome(rs.getString("Nome"));
                        p.setCategoria(rs.getString("Categoria"));
                        p.setObservacoes(rs.getString("Observacoes"));
                        p.setQuantidade(rs.getInt("Quantidade"));
                        p.setPreco(rs.getFloat("Preco"));
                        
                        listaEmpresas.add(p);    
                    }
                    return listaEmpresas;
                    
                } catch (Exception e) {
                    System.out.println("Erro na lista: " + e.getMessage());
                    return null;
                }
        } 
  
  public ArrayList<Object[]> getAllEFornecedor() {
    ArrayList<Object[]> lista = new ArrayList<>();

    String sql = """
        SELECT p.Id, p.Nome, p.Categoria, p.Observacoes, p.Quantidade, p.Preco,
        f.Nome AS Fornecedores, fp.Taxa AS Taxa
        FROM Produtos p
        LEFT JOIN FornecedorProduto fp ON p.Id = fp.IdProduto
        LEFT JOIN Fornecedor f ON fp.IdFornecedor = f.Id
        
    """;// GROUP BY p.Id

    try (Connection conn = coneccao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            lista.add(new Object[]{
                rs.getInt("Id"),
                rs.getString("Nome"),
                rs.getString("Categoria"),
                rs.getString("Observacoes"),
                rs.getInt("Quantidade"),
                rs.getFloat("Preco"),
                rs.getString("Fornecedores"),
                rs.getFloat("Taxa")
                    
            });
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}
  
  public int searchId(String nome, String cate, String obs, int qnt, Double preco){
    String sql = "Select Id from Produtos where Nome = ? and Categoria = ? and Observacoes = ? and Quantidade = ? and Preco = ? ";
          try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              
              stmt.setString(1, nome);
              stmt.setString(2, cate);
              stmt.setString(3, obs);
              stmt.setInt(4, qnt);
              stmt.setDouble(5, preco);
              ResultSet rs = stmt.executeQuery();
               
              return rs.getInt("Id");
          
          } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } 
}
  
  public int searchId(String nome){
    String sql = "Select Id from Produtos where Nome = ? ";
          try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              
              stmt.setString(1, nome);

              ResultSet rs = stmt.executeQuery();
               
              return rs.getInt("Id");
          
          } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } 
  }
}
