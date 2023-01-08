public class Livros {
    
    private String titulo;
    private String autor;
    private AreaDeConhecimento areaDeConhecimento;
    private String dataDePublicacao;
    private int quantidadeNoAcervo;
    
    public Livros(String titulo, String autor, AreaDeConhecimento areaDeConhecimento, String dataDePublicacao,
            int quantidadeNoAcervo) {
        this.titulo = titulo;
        this.autor = autor;
        this.areaDeConhecimento = areaDeConhecimento;
        this.dataDePublicacao = dataDePublicacao;
        this.quantidadeNoAcervo = quantidadeNoAcervo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(String dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public int getQuantidadeNoAcervo() {
        return quantidadeNoAcervo;
    }

    public void setQuantidadeNoAcervo(int quantidadeNoAcervo) {
        this.quantidadeNoAcervo = quantidadeNoAcervo;
    }

    public AreaDeConhecimento getAreaDeConhecimento() {
        return areaDeConhecimento;
    }

    public void setAreaDeConhecimento(AreaDeConhecimento areaDeConhecimento) {
        this.areaDeConhecimento = areaDeConhecimento;
    }

    
}
