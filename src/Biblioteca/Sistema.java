import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Sistema {
    
    private final Calendar Data;
    
    
    public Sistema(){
        Data = Calendar.getInstance();
    }

    
    public String getDataString() {
        return "" + Data.get(Calendar.DAY_OF_MONTH) + "/" +
                    (Data.get(Calendar.MONTH) + 1)  + "/" +
                    Data.get(Calendar.YEAR);
    }
    public Date getData(){
        return Data.getTime();
    }

    public void setData(int dia, int mes, int ano) {
        this.Data.set(Calendar.YEAR, ano);
        this.Data.set(Calendar.MONTH, mes);
        this.Data.set(Calendar.DAY_OF_MONTH, dia);
    }
    
    public void incrementDays(int dias){
        Data.add(Calendar.DATE, dias);
    }
    
    
    @SuppressWarnings("null")
    public long compareDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date e = null;
        
        try {
            e = format.parse(getDataString());
        } catch (ParseException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date f = null;
        try {
            f = format.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return ( (e.getTime() - f.getTime()) / 60 / 60 / 24 / 1000 );
    }
    
   public void updateSuspensao(List<Emprestimo> Emprestimos,
           List<UsuarioPadrao> Usuarios){
       int i;
       for (i = 0; i < Emprestimos.size(); i++){
           String RG = Emprestimos.get(i).getUsuario();
           List<UsuarioPadrao> usuarios =
                   Usuarios
                        .stream()
                        .filter(s -> s.getRG().equals(RG))
                        .collect(Collectors.toList());
           long date = compareDate(Emprestimos.get(i).getDataDevolucao());
           
       }
   }
}