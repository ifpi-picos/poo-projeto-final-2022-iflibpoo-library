package biblioteca;

public class Usuario implements UsuarioPadrao {
    
    private int MaxLivros;
    private int MaxPrazo;
    private String Nome;
    private String RG;
    private String Email;
    private byte   Tipo;
    private int Estado; 
    
    public Usuario(byte Tipo){
        this.Tipo = Tipo; 
        Estado = 0;
    }

   
    public String getNome() {
        return Nome;
    }

    
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    
    public String getRG() {
        return RG;
    }

    
    public void setRG(String RG) {
        this.RG = RG;
    }

    
    public String getEmail() {
        return Email;
    }

    
    public void setEmail(String Email) {
        this.Email = Email;
    }

    
    public byte getTipo() {
        return Tipo;
    }

    
    public void setTipo(byte Tipo) {
        this.Tipo = Tipo;
    }

    
    public int getEstado() {
        return Estado;
    }

    
    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    
    public int getMaxLivros() {
        return MaxLivros;
    }

    
    public void setMaxLivros(int MaxLivros) {
        this.MaxLivros = MaxLivros;
    }

    
    public int getMaxPrazo() {
        return MaxPrazo;
    }

    
    public void setMaxPrazo(int MaxPrazo) {
        this.MaxPrazo = MaxPrazo;
    }
    
    public String toString(){
        return getNome() + "," + getRG() + "," + getEmail();
    }

}