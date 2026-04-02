/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import persistencia.Venda;

/**
 *
 * @author Desktop
 */
public class vendadao {
    public void inserir(Venda v) {
        String sql = "insert into Venda (IdCliente, Observacoes, Data) VALUES (?, ?, ?)";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, v.getCliente().getId());
            stmt.setString(2, v.getObservacoes());
            stmt.setDate(3, java.sql.Date.valueOf(v.getData()));


            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao inserir venda: " + e.getMessage());
        } 
   }
    
    public int searchId(Venda v){
    String sql = "Select IdVenda from Venda where IdCliente = ? and Observacoes = ? and Data = ? ";
          try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              
            stmt.setInt(1, v.getCliente().getId());
            stmt.setString(2, v.getObservacoes());
            stmt.setDate(3, java.sql.Date.valueOf(v.getData()));
              
             ResultSet rs = stmt.executeQuery();
               rs.next();
              return rs.getInt("IdVenda");
          
          } catch (Exception e) {
            System.out.println("Erro ao procurar vendaid: " + e.getMessage());
            return -1;
        } 
}
    
     public ArrayList<Object[]> getAllEProduto() {
    ArrayList<Object[]> lista = new ArrayList<>();

    String sql = """
        SELECT v.IdVenda, c.Nome AS ClienteNome, v.Observacoes, v.Data, p.Nome AS ProdutoNome
        FROM Venda v
        JOIN Cliente c ON v.IdCliente = c.Id
        JOIN ProdutoHasVenda pv ON v.IdVenda = pv.IdVenda
        JOIN Produtos p ON pv.IdProduto = p.Id
    """;

    try (Connection conn = coneccao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            lista.add(new Object[]{
               rs.getInt("IdVenda"),
                rs.getString("ClienteNome"),   
                rs.getString("Observacoes"),
                rs.getDate("Data"),
                rs.getString("ProdutoNome")          
            });
        }

    } catch (Exception e) {
        System.out.println("Erro ao fazer lista: " + e.getMessage());
    }

    return lista;
}
}
