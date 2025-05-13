package cafeteria;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    
    public Pedido(int id, Cliente cliente, Produto produto, int quantidade) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public int getId() {
        return id;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public Produto getProduto() {
        return produto;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
}

