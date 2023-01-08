import java.time.LocalDate;
import Books.Livros;
import Users.Usuários;

public class Emprestimo {
    
    private LocalDate dataDeAdmissao;
    private Livros livro;
    private Usuários usuario;
    
    public Emprestimo(LocalDate dataDeAdmissao, Livros livro, Usuários usuario) {
        this.dataDeAdmissao = dataDeAdmissao;
        this.livro = livro;
        this.usuario = usuario;
    }

    public LocalDate getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(LocalDate dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public Usuários getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuários usuario) {
        this.usuario = usuario;
    }
  
}
