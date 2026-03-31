/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author Desktop
 */
import java.sql.Date;
import java.util.List;

public class Venda {
    private int idVenda;
    private Cliente cliente;
    private String observacoes;
    private Date data;
    private List<ProdutoHasVenda> itens;

    public int getIdVenda() { return idVenda; }
    public void setIdVenda(int idVenda) { this.idVenda = idVenda; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public List<ProdutoHasVenda> getItens() { return itens; }
    public void setItens(List<ProdutoHasVenda> itens) { this.itens = itens; }
}
