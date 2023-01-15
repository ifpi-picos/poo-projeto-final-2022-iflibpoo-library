package biblioteca;


public interface UsuarioPadrao {
    void setNome(String Nome);
    String getNome();
    void setRG(String RG);
    String getRG();
    public void setTipo(byte Tipo);
    public byte getTipo();
    public void setEmail(String Email);
    public String getEmail();
    public int getMaxLivros();
    public int getMaxPrazo();
    public int getEstado();
    public void setEstado(int Estado);
}