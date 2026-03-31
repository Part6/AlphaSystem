/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author Desktop
 */
public class FornecedorProduto {
    private Produto produto;
    private Fornecedor fornecedor;
    private float taxa;

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }

    public Fornecedor getFornecedor() { return fornecedor; }
    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }

    public float getTaxa() { return taxa; }
    public void setTaxa(float taxa) { this.taxa = taxa; }
}