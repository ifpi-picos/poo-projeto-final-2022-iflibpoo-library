package Biblioteca;

public class Usuarios{
    
    private String nome;
    private String email;
    private String dataDeNascimento;
    private Endereco endereco;
    
    
    public Usuarios(String nome, String email, String dataDeNascimento, Endereco endereço) {
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getDataDeNascimento() {
        return dataDeNascimento;
    }


    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }


    public Endereco getEndereço() {
        return endereco;
    }


    public void setEndereço(Endereco endereço) {
        this.endereco = endereco;
    }

    
}
