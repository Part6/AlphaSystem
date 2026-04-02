/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import persistencia.Cliente;
import persistencia.Cliente;
/**
 *
 * @author Desktop
 */
public class clientedao {
public void inserir(Cliente cliente) {
        String sql = "Insert into Cliente(Nome, Cpf, Email, EnderecoID) VALUES (?, ?, ?, ?)";

        try (Connection conn = coneccao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setInt(4, cliente.getEnderecoId());

            stmt.executeUpdate();
            System.out.println("cadastrado cliente");

        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        } 
   }

public Cliente search(String nome) {
    String sql = "SELECT * FROM Cliente WHERE Nome = ?";

    try (Connection conn = coneccao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) { 
            Cliente c = new Cliente();
            c.setId(rs.getInt("Id"));
            c.setNome(rs.getString("Nome"));
            c.setCpf(rs.getString("CPF"));
            c.setEmail(rs.getString("Email"));

            c.setEnderecoId(rs.getInt("EnderecoID"));
            return c;
        }

    } catch (Exception e) {
        System.out.println("Erro ao procurar id cliente: " + e.getMessage());
    }

    return null;
}


    public ArrayList<Object[]> getAllEEndereco() {
    ArrayList<Object[]> lista = new ArrayList<>();

    String sql = """
        SELECT c.Id, c.Nome, c.Cpf, c.Email, en.Rua AS Rua, en.Cidade AS Cidade,
        en.Estado AS Estado, en.Numero AS Numero, en.CEP AS CEP
        FROM Cliente c
        LEFT JOIN Endereco en ON c.EnderecoID = en.Id   
    """;// GROUP BY p.Id

    try (Connection conn = coneccao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            lista.add(new Object[]{
                rs.getInt("Id"),
                rs.getString("Nome"),
                rs.getString("Cpf"),
                rs.getString("Email"),
                rs.getString("Rua"),
                rs.getString("Cidade"),
                rs.getString("Estado"),
                rs.getInt("Numero"),
                rs.getInt("CEP")
                    
            });
        }

    } catch (Exception e) {
        System.out.println("Erro na lista: " + e.getMessage());
    }

    return lista;
}
}
