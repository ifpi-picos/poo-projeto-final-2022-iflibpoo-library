public class Aluno extends Usuario implements UsuarioPadrao {
    
    private String NumeroUSP;
    private String Curso;
    private String AnoDeIngresso;
   
     
    public Aluno(){
        super((byte) 2);
        super.setMaxLivros(4);
        super.setMaxPrazo(15);
    }

    
    public String getNumeroUSP() {
        return NumeroUSP;
    }

   
    public void setNumeroUSP(String NumeroUSP) {
        this.NumeroUSP = NumeroUSP;
    }

    
    public String getCurso() {
        return Curso;
    }

    
    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    
    public String getAnoDeIngresso() {
        return AnoDeIngresso;
    }

    
    public void setAnoDeIngresso(String AnoDeIngresso) {
        this.AnoDeIngresso = AnoDeIngresso;
    }
    
    public String toString(){
        return getNome() + "," + getRG() + "," + getNumeroUSP() + "," + getEmail()
                + "," + getCurso() + "," + getAnoDeIngresso();
    }
       
  }