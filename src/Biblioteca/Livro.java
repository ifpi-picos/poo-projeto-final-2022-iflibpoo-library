public class Livro implements LivroPadrao {

    private int ID;
    private String Titulo;
    private String Autor;
    private byte  Tipo;
    private short  Ano;
    
    public Livro(byte Tipo){
        this.Tipo = Tipo;
    }

    
    public String getTitulo() {
        return Titulo;
    }

    
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

   
    public String getAutor() {
        return Autor;
    }

    
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    
    public byte getTipo() {
        return Tipo;
    }

    
    public void setTipo(byte Tipo) {
        this.Tipo = Tipo;
    }

    
    public short getAno() {
        return Ano;
    }

    
    public void setAno(short Ano) {
        this.Ano = Ano;
    }

    
    public int getID() {
        return ID;
    }

    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String toString(){
        return getID() + "," + getTitulo() + "," + getAutor() + "," + getAno();
    }
    
}