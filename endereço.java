public class Endereço {
    
    private int ceep;
    private String nomeBairro;
    private String nomeRua;
    private int numCasa;
    
    public Endereço(int ceep, String nomeBairro, String nomeRua, int numCasa) {
        this.ceep = ceep;
        this.nomeBairro = nomeBairro;
        this.nomeRua = nomeRua;
        this.numCasa = numCasa;
    }

    public int getCeep() {
        return ceep;
    }

    public void setCeep(int ceep) {
        this.ceep = ceep;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }
}
