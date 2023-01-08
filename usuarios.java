

public class usuarios{
    
    private String nome;
    private String email;
    private String dataDeNascimento;
    private endereço endereço;
    
    
    public usuarios(String nome, String email, String dataDeNascimento, endereço endereço) {
        this.nome = nome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
        this.endereço = endereço;
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


    public endereço getEndereço() {
        return endereço;
    }


    public void setEndereço(endereço endereço) {
        this.endereço = endereço;
    }

    

}