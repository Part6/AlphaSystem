/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;

/**
 *
 * @author Desktop
 */
public class FornecedorProdutoDao {
    public void inserir(int IdF, int IdP, float Taxa) {
        String sql = "Insert into FornecedorProduto(IdProduto,IdFornecedor,Taxa) VALUES (?, ?, ?)";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, IdP);
            stmt.setInt(2, IdF);
            stmt.setFloat(3, Taxa);
            
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } 
   }
    
    public int getProdutoId(int idv){
             String sql = "SELECT IdProduto FROM FornecedorProduto where IdFornecedor = ?";  
             
              try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              
              stmt.setInt(1, idv);
              ResultSet rs = stmt.executeQuery();

              return rs.getInt("IdProduto");
          
          } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } 
        } 
    
    public int getFornecedorId(int idp){
             String sql = "SELECT IdFornecedor FROM FornecedorProduto where IdProduto = ?";  
             
              try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              
              stmt.setInt(1, idp);
              ResultSet rs = stmt.executeQuery();

              return rs.getInt("IdFornecedor");
          
          } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } 
        } 
    
}
