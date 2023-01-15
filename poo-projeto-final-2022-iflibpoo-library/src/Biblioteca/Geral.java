
public class Geral extends Livro implements LivroPadrao {
    
    private String Editora;
    
    public Geral(){
      
        super((byte) 2);
    }

    
    public String getEditora() {
        return Editora;
    }
    public void setEditora(String Editora) {
        this.Editora = Editora;
    }
    
    public String toString(){
        return getID() + "," + getTitulo() + "," + getAutor() + "," + getAno()
                + "," + Editora;
    }
    
}