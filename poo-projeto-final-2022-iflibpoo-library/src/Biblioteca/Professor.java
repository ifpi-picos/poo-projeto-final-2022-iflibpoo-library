public class Professor extends Usuario implements UsuarioPadrao {
    
    private String NumeroUSP;
    private String Departamento;
    
     
    public Professor(){
        super((byte) 1);
        super.setMaxLivros(6);
        super.setMaxPrazo(60);
    }

    
    public String getNumeroUSP() {
        return NumeroUSP;
    }

    
    public void setNumeroUSP(String NumeroUSP) {
        this.NumeroUSP = NumeroUSP;
    }

    
    public String getDepartamento() {
        return Departamento;
    }

    
    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }
    
    public String toString(){
        return getNome() + "," + getRG() + "," + getNumeroUSP() + "," + getEmail()
                + "," + getDepartamento();
    }
    
  }