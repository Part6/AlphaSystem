/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import persistencia.Endereco;

/**
 *
 * @author Desktop
 */
public class enderecodao {
    public void inserir(Endereco endereco) {
        String sql = "Insert into Endereco (Rua, Cidade, Estado, Numero, CEP) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getCidade());
            stmt.setString(3, endereco.getEstado());
            stmt.setInt(4, endereco.getNumero());
            stmt.setInt(5, endereco.getCep());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } 
   }

public Endereco search(int id){
    String sql = "Select from Endereco where Id = ? ";
          try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              
              stmt.setInt(1, id);
              ResultSet rs = stmt.executeQuery();
              
              Endereco c = new Endereco();
              c.setId(rs.getInt("Id"));
              c.setRua(rs.getString("Rua"));
              c.setCidade(rs.getString("Cidade"));
              c.setEstado(rs.getString("Estado"));
              c.setNumero(rs.getInt("Numero"));
              c.setCep(rs.getInt("CEP"));
              System.out.println("cadastrado endereço;");
              return c;
          
          } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
            return null;
        } 
}

public int searchId(String rua, String cidade, String estado, int n, int cep){
    String sql = "Select Id from Endereco where Rua = ? and Cidade = ? and Estado = ? and Numero = ? and CEP = ? ";
          try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
              
              stmt.setString(1, rua);
              stmt.setString(2, cidade);
              stmt.setString(3, estado);
              stmt.setInt(4, n);
              stmt.setInt(5, cep);
              ResultSet rs = stmt.executeQuery();
              rs.next();
              int id = rs.getInt("Id");
              System.out.println("id adquirido");
              return id;
          
          } catch (Exception e) {
            System.out.println("Erro ao procurar: " + e.getMessage());
            return -1;
        } 
}
}
