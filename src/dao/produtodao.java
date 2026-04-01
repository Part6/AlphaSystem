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
   
  public ArrayList<Produto> getAll(){
             String sql = "SELECT * FROM Produtos";  
             //LIKE nos permite pesquisar por partes de um nome, ao invés de pesquisarmos por todo nome
             
              try(Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

                    //Conforme for a palavra ou letra digitada para pesquisa, será buscada antes, no meio e no fim
                    
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
}
