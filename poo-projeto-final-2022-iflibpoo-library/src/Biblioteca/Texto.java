public class Texto extends Livro {
    
    private String Instituicao;
    private String Area;
        
    public Texto(){
        super((byte) 1);
    }

    public String getInstituicao() {
        return Instituicao;
    }

    
    public void setInstituicao(String Instituicao) {
        this.Instituicao = Instituicao;
    }

    
    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
    
    public String toString(){
        return getID() + "," + getTitulo() + "," + getAutor() + "," + getAno()
                + "," + getArea() + "," + getInstituicao();
    }
}