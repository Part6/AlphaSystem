/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import persistencia.Produto;
import persistencia.Venda;

/**
 *
 * @author Desktop
 */
public class ProdutoHasVendaDao {
    
    public void inserir(int IdV, int IdP) {
        String sql = "Insert into ProdutoHasVenda(IdProduto,IdVenda) VALUES (?, ?)";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, IdP);
            stmt.setInt(2, IdV);
            
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } 
   }
    
    public int getProdutoId(int idv){
             String sql = "SELECT IdProduto FROM ProdutoHasVenda where IdVenda = ?";  
             
              try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              
              stmt.setInt(1, idv);
              
              ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    return rs.getInt("IdProduto");
                }
          
          } catch (Exception e) {
            e.printStackTrace();
            
        } 
              return -1;
        } 
    
    public int getVendaId(int idp){
             String sql = "SELECT IdVenda FROM ProdutoHasVenda where IdProduto = ?";  
             
              try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              
              stmt.setInt(1, idp);
              ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
              return rs.getInt("IdVenda");
                }
          
          } catch (Exception e) {
            e.printStackTrace();
           
        } 
              return -1;
        } 
    
    
}
