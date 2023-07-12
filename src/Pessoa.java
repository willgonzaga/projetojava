import java.security.InvalidParameterException;

public abstract class Pessoa {
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade<0) {
            throw new IllegalArgumentException("Idade não pode ser negativa!");
        } else {
            this.idade = idade;
        }
    }
}
