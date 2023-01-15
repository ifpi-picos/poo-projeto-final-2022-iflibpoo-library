public class Emprestimo {
    
    private String DataEmprestimo;
    private String DataDevolucao;
    private String Livro; 
    private String Usuario; 

    public String getDataEmprestimo() {
        return DataEmprestimo;
    }

    public void setDataEmprestimo(String DataEmprestimo) {
        this.DataEmprestimo = DataEmprestimo;
    }

   
    public String getDataDevolucao() {
        return DataDevolucao;
    }

    
    public void setDataDevolucao(String DataDevolucao) {
        this.DataDevolucao = DataDevolucao;
    }

    
    public String getLivro() {
        return Livro;
    }

    
    public void setLivro(String Livro) {
        this.Livro = Livro;
    }

   
    public String getUsuario() {
        return Usuario;
    }

    
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    public String toString(){
        return getLivro() + "," + getUsuario() + "," + getDataEmprestimo() +
                "," + getDataDevolucao();
    }
    
}