public class Comunidade extends Usuario implements UsuarioPadrao {
    
    private String Endereco;
    private String Nascimento;
    private String Telefone;
    
    public Comunidade(){
        super((byte) 3);
        super.setMaxLivros(2);
        super.setMaxPrazo(15);
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getNascimento() {
        return Nascimento;
    }

    
    public void setNascimento(String Nascimento) {
        this.Nascimento = Nascimento;
    }

    public String getTelefone() {
        return Telefone;
    }

    
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
    
    public String toString(){
        return getNome() + "," + getRG() + "," + getEndereco() + "," + getEmail()
                + "," + getTelefone() + "," + getNascimento();         
    }
    
}