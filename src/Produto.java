public class Produto implements IProduto {
    private String descricao;
    private double valor;
    private String marca;
    private String modelo;

    @Override
    public void exibir() {
        System.out.println("Descricao: " + getDescricao());
        System.out.println("Valor : " + getValor());
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if(valor<0) {
            throw new IllegalArgumentException("Preço não pode ser negativo!");
        } else {
            this.valor = valor;
        }
    }
}
