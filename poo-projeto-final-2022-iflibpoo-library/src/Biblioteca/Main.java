import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Main {
    
    static List<UsuarioPadrao> Usuarios = new ArrayList<>();
    static List<LivroPadrao> Livros = new ArrayList<>();
    static List<Emprestimo> Emprestimos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    static Main main;
    Sistema sistemaDeData = new Sistema();
    static String Delimitador = ",";
    static String csvProfessor;
    static String csvAluno;
    static String csvComunidade;
    static String csvTexto;
    static String csvGeral;

    public static void main(String[] args) throws FileNotFoundException, IOException {
       
        main = new Main();
        try{
            csvProfessor = args[0];
            csvAluno     = args[1];
            csvComunidade= args[2];
            csvTexto     = args[3];
            csvGeral     = args[4];
        }catch(Exception e){
            csvProfessor = "Professor.csv";
            csvAluno     = "Aluno.csv";
            csvComunidade= "Comunidade.csv";
            csvTexto     = "Texto.csv";
            csvGeral     = "Geral.csv";
        }

        main.carregaCSV(csvProfessor, csvAluno, csvComunidade, csvTexto, csvGeral);
        main.menuPrincipal();
    }
    
    public void carregaCSV(String csvProfessores, String csvAlunos,
            String csvComunidade, String csvTexto, String csvGeral) throws IOException {
        BufferedReader in;
        String csv;
        
        try {
            in = new BufferedReader(new FileReader("Emprestimo.csv"));
            if (in != null)
                while((csv = in.readLine()) != null){
                    Emprestimo emprestimo  = new Emprestimo();
                    String[] values = csv.split(Delimitador);
                    emprestimo.setLivro(values[0]);
                    emprestimo.setUsuario(values[1]);
                    emprestimo.setDataEmprestimo(values[2]);
                    emprestimo.setDataDevolucao(values[3]);
                    Emprestimos.add(emprestimo);
                }
        } catch (FileNotFoundException ex){
            in = null;
        }
        
        try {
            in = new BufferedReader(new FileReader(csvProfessores));
        } catch (FileNotFoundException ex) {
            in = null;
        }
       
        if (in != null)
            while((csv = in.readLine()) != null){
                Professor professor  = new Professor();
                String[] values = csv.split(Delimitador);
                professor.setNome(values[0]);
                professor.setRG(values[1]);
                professor.setNumeroUSP(values[2]);
                professor.setEmail(values[3]);
                professor.setDepartamento(values[4]);
                Usuarios.add(professor);
            }
        
        try {
            in = new BufferedReader(new FileReader(csvAlunos));
        } catch (FileNotFoundException ex) {
            in = null;
        }
        if (in != null)
            while((csv = in.readLine()) != null){
                Aluno aluno  = new Aluno();
                String[] values = csv.split(Delimitador);
                aluno.setNome(values[0]);
                aluno.setRG(values[1]);
                aluno.setNumeroUSP(values[2]);
                aluno.setEmail(values[3]);
                aluno.setCurso(values[4]);
                aluno.setAnoDeIngresso(values[5]);
                Usuarios.add(aluno);
            }
        
        try {
            in = new BufferedReader(new FileReader(csvComunidade));
        } catch (FileNotFoundException ex) {
            in = null;
        }
        if (in != null)
            while((csv = in.readLine()) != null){
                Comunidade comunidade  = new Comunidade();
                String[] values = csv.split(Delimitador);
                comunidade.setNome(values[0]);
                comunidade.setRG(values[1]);
                comunidade.setEndereco(values[2]);
                comunidade.setEmail(values[3]);
                comunidade.setTelefone(values[4]);
                comunidade.setNascimento(values[5]);
                Usuarios.add(comunidade);
            }
        
        try {
            in = new BufferedReader(new FileReader(csvTexto));
        } catch (FileNotFoundException ex) {
            in = null;
        }
        if (in != null)
            while((csv = in.readLine()) != null){
                Texto texto  = new Texto();
                String[] values = csv.split(Delimitador);
                texto.setID(Integer.parseInt(values[0]));
                texto.setTitulo(values[1]);
                texto.setAutor(values[2]);
                texto.setAno(Short.parseShort(values[3]));
                texto.setArea(values[4]);
                texto.setInstituicao(values[5]);
                Livros.add(texto);
            }
        
        try {
            in = new BufferedReader(new FileReader(csvGeral));
        } catch (FileNotFoundException ex) {
            in = null;
        }
        if (in != null)
            while((csv = in.readLine()) != null){
                Geral geral  = new Geral();
                String[] values = csv.split(Delimitador);
                geral.setID(Integer.parseInt(values[0]));
                geral.setTitulo(values[1]);
                geral.setAutor(values[2]);
                geral.setAno(Short.parseShort(values[3]));
                geral.setEditora(values[4]);
                Livros.add(geral);
            }
        
    }
    
    public void menuPrincipal() throws IOException{
        String[] resposta = new String[]{" Cadastrar Usuario", "Cadastrar Livro", "Emprestimo", "Devolucao", " Suspensão", "Listar",  "Data",  "Sair"};
        int opcao = JOptionPane.showOptionDialog(null,"CADASTRO","BIBLIOTECA"
                ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,resposta,1);
        switch( opcao ){
            case 0:
main.menuCadastroUsuario(); break;
            case 1:
main.menuCadastroLivro(); break;
            case 2:
            main.menuEmprestimo(); break;
            case 3:
            main.menuDevolucao(); break;
            case 4:
            main.menuSuspensao(); break;
            case 5:
            main.menuListagem(); break;
            case 6:
            main.menuData(); break;
            case 7:
            main.sair(); break;
            
        }
    }

    private void menuCadastroUsuario() throws IOException {
        String[] resposta = new String[]{
                 "Professor" ,"Aluno" , "Comunidade"};
                int opcao = JOptionPane.showOptionDialog(null,"CADASTRO","BIBLIOTECA"
                ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,resposta,1);
        String Nome = JOptionPane.showInputDialog(null, "INFORME O NOME:");
        String RG =  JOptionPane.showInputDialog(null, "INFORME O RG:");
        String Email = JOptionPane.showInputDialog(null, "INFORME EMAIL");
        
        BufferedWriter fileWriter = null;
        switch (opcao){
            // Professor
            case 0: {
                String NumeroUSP = JOptionPane.showInputDialog(null, "NÚMERO USP");
                String Departamento =JOptionPane.showInputDialog(null, "DEPARTAMENTO:");
                Professor Usuario = new Professor();
                Usuario.setDepartamento(Departamento);
                Usuario.setEmail(Email);
                Usuario.setNome(Nome);
                Usuario.setNumeroUSP(NumeroUSP);
                Usuario.setRG(RG);
                Usuarios.add(Usuario);
                fileWriter = new BufferedWriter(new FileWriter(csvProfessor, true));
                break;
            }
            // ALUNO
            case 1: {
                String NumeroUSP = JOptionPane.showInputDialog(null, "INFORME O NÚMERO USP:");
                String Curso = JOptionPane.showInputDialog(null, "INFORME O CURSO:");
                String AnoDeIngresso = JOptionPane.showInputDialog(null, "INFORME O ANO DO INGRESSO:");
                Aluno Usuario = new Aluno();
                Usuario.setAnoDeIngresso(AnoDeIngresso);
                Usuario.setCurso(Curso);
                Usuario.setEmail(Email);
                Usuario.setNome(Nome);
                Usuario.setNumeroUSP(NumeroUSP);
                Usuario.setRG(RG);
                Usuarios.add(Usuario);
                fileWriter = new BufferedWriter(new FileWriter(csvAluno, true));
                break;
            } 
            // Comunidade
            case 2: {
                String Endereco = JOptionPane.showInputDialog(null, "INFORME O ENDEREÇO:");
                String Nascimento = JOptionPane.showInputDialog(null, "INFORME A DATA DE NASCIMENTO:");
                String Telefone   = JOptionPane.showInputDialog(null, "INFORME O TELEFONE");
                Comunidade Usuario = new Comunidade();
                Usuario.setEmail(Email);
                Usuario.setEndereco(Endereco);
                Usuario.setNascimento(Nascimento);
                Usuario.setNome(Nome);
                Usuario.setRG(RG);
                Usuario.setTelefone(Telefone);
                Usuarios.add(Usuario);
                fileWriter = new BufferedWriter(new FileWriter(csvComunidade, true));
                break;
            }
        }    
        clearConsole();
        JOptionPane.showMessageDialog(null,"Usuario cadastrado com sucesso!");
        fileWriter.append(Usuarios.get(Usuarios.size() - 1).toString() + "\n");
        fileWriter.flush();
        fileWriter.close();
        main.menuPrincipal();
    }
  private void menuCadastroLivro() throws IOException {
        String[] resposta = new String[]{ "Texto", "Geral"};

        int opcao = JOptionPane.showOptionDialog(null,"CADASTRO","BIBLIOTECA"
                ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,resposta,1);
        String Titulo;
        String Autor;
        short  Ano;
        int    ID;
        Titulo = JOptionPane.showInputDialog(null, "INFORME O TITÚLO:");
        Autor   = JOptionPane.showInputDialog(null, "INFORME O AUTOR:");
        Ano     =  Short.parseShort( JOptionPane.showInputDialog(null, "INFORME O ANO:"));
        ID  = Integer.parseInt(JOptionPane.showInputDialog(null, "INFORME O ID DE  INDENTIFICAÇÃO"));
        BufferedWriter fileWriter = null;
        switch (opcao){
            // Texto
            case 0: {
                System.out.print("Instituicao: ");
                String Instituicao = JOptionPane.showInputDialog(null, "INFORME A INSTITUIÇÃO:");
                String Area = JOptionPane.showInputDialog(null, "INFORME A ARÉA:");
                Texto Livro = new Texto();
                Livro.setAno(Ano);
                Livro.setArea(Area);
                Livro.setAutor(Autor);
                Livro.setInstituicao(Instituicao);
                Livro.setTitulo(Titulo);
                Livro.setID(ID);
                Livros.add(Livro);
                fileWriter = new BufferedWriter(new FileWriter(csvTexto, true));
                break;
            }
            // Geral
            case 1: {
                String Editora = JOptionPane.showInputDialog(null, "INFORME A EDITORA:");
                Geral Livro = new Geral();
                Livro.setAno(Ano);
                Livro.setEditora(Editora);
                Livro.setAutor(Autor);
                Livro.setTitulo(Titulo);
                Livro.setID(ID);
                Livros.add(Livro);
                fileWriter = new BufferedWriter(new FileWriter(csvGeral, true));
                break;
            } 
        }    
        clearConsole();
        JOptionPane.showMessageDialog(null,"livro cadastrado com sucesso");         
        fileWriter.append(Livros.get(Livros.size() - 1).toString() + "\n");
        fileWriter.flush();
        fileWriter.close();
        try {
            main.menuPrincipal();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void menuEmprestimo() throws IOException {
        String Nome = JOptionPane.showInputDialog(null, "INFORME O TITULO:");
        String RG = JOptionPane.showInputDialog(null, "INFORME O RG:");
        
        // Pesquisa Usuário
        List<UsuarioPadrao> Usuario =
                Usuarios
                    .stream()
                    .filter(s -> s.getRG().equals(RG))
                    .collect(Collectors.toList());
        
        if (Usuario.isEmpty()){
            clearConsole();
            JOptionPane.showMessageDialog(null,"Usuário não encontrado");
            main.menuPrincipal();
            return;
        }
        
        // Checa se o usuário não está suspenso
        if (Usuario.get(0).getEstado() > 0){
            clearConsole();
            JOptionPane.showMessageDialog(null,"Usuário esta suspenso");

            main.menuPrincipal();
            return;
        }
        
        // Pesquisa o Usuário em todos os empréstimos
        List<Emprestimo> emprestimos =
                Emprestimos
                    .stream()
                    .filter(s -> s.getUsuario().equals(Usuario.get(0).getRG()))
                    .collect(Collectors.toList());
        
        // Checa se o usuário não está com livros atrasados
        for (Emprestimo emprestimo : emprestimos) {
            if (sistemaDeData.compareDate(emprestimo.getDataDevolucao()) > 0){
                clearConsole();
                JOptionPane.showMessageDialog(null,"O usuário está com livros em atraso" + 
                        sistemaDeData.compareDate(emprestimo.getDataDevolucao()));
                main.menuPrincipal();
                return;
            }
        }
        
        if (emprestimos.size() == Usuario.get(0).getMaxLivros()){
            clearConsole();
            JOptionPane.showMessageDialog(null,"Usuário já pegou o limite de livros");
            main.menuPrincipal();
            return;
        }
        
        final String Nome_ = Nome;   
        List<LivroPadrao> Livro;
        // Pesquisa Livro pelo Título
        Livro = 
            Livros
                .stream()
                .filter(s -> s.getTitulo().equals(Nome_))
                .collect(Collectors.toList());

        
        // Se não encontrou o livro
        if (Livro.isEmpty()){
            clearConsole();
            JOptionPane.showMessageDialog(null,"Livro não encontrado\n");
            main.menuPrincipal();
            return;
        }
        
        // Verifica se o livro já não está emprestado
        List<Emprestimo> emprestimoss =
                Emprestimos
                    .stream()
                    .filter(s -> s.getLivro().equals(Livro.get(0).getTitulo()))
                    .collect(Collectors.toList());
        
        // Livro já está emprestado
        if (emprestimoss.isEmpty() != true){
            clearConsole();
            JOptionPane.showMessageDialog(null,"Livro já está emprestado\n");
            main.menuPrincipal();
            return;
        }
        
        // Cria empréstimo
        Emprestimo emp = new Emprestimo();
        emp.setLivro(Livro.get(0).getTitulo());
        emp.setUsuario(Usuario.get(0).getRG());
        emp.setDataEmprestimo(sistemaDeData.getDataString());
        sistemaDeData.incrementDays(Usuario.get(0).getMaxPrazo());
        emp.setDataDevolucao(sistemaDeData.getDataString());
        sistemaDeData.incrementDays(-1 * Usuario.get(0).getMaxPrazo());
        Emprestimos.add(emp);
        clearConsole();
        JOptionPane.showMessageDialog(null,"Emprestimo feito com sucesso!");
        main.writeEmprestimoCSV();
        main.menuPrincipal();
    }
    
    private void writeEmprestimoCSV() throws IOException{
        FileWriter fileWriter = new FileWriter("Emprestimo.csv");
        fileWriter.write("");
        for (Emprestimo emprestimo : Emprestimos)
            fileWriter.append(emprestimo.toString() + "\n");
        
        fileWriter.flush();
        fileWriter.close();
    }

    private void menuDevolucao() throws IOException {
      String Titulo =  JOptionPane.showInputDialog(null,"Titulo do Livro:");
        
        List<Emprestimo> emprestimos =
                Emprestimos
                    .stream()
                    .filter(s -> s.getLivro().equals(Titulo))
                    .collect(Collectors.toList());
        
        if (emprestimos.isEmpty()){
            clearConsole();
            JOptionPane.showMessageDialog(null,"Livro não foi emprestado!");
            main.menuPrincipal();
            return;
        }
        
        List<UsuarioPadrao> usuarios =
                Usuarios
                    .stream()
                    .filter(s -> s.getRG().equals(emprestimos.get(0).getUsuario()))
                    .collect(Collectors.toList());
        
        long atraso = sistemaDeData.compareDate(emprestimos.get(0).getDataDevolucao());
        
        if (atraso > 0)
            usuarios.get(0).setEstado((int) (usuarios.get(0).getEstado() + atraso));
        
        Emprestimos.remove(emprestimos.get(0));
        clearConsole();
        JOptionPane.showMessageDialog(null,"Devolução feita com sucesso!");
        main.writeEmprestimoCSV();
        main.menuPrincipal();
    }

    private void menuSuspensao() throws IOException {
      
        String RG = JOptionPane.showInputDialog(null, "INFORME O RG:");
        
        List<UsuarioPadrao> usuario =
                Usuarios
                    .stream()
                    .filter(s -> s.getRG().equals(RG))
                    .collect(Collectors.toList());
        
        if (usuario.isEmpty()){
            clearConsole();
            JOptionPane.showMessageDialog(null,"Usuário não encontrado!");
            main.menuPrincipal();
            return;
        }
        
        if (usuario.get(0).getEstado() > 0){
            clearConsole();
        JOptionPane.showMessageDialog(null,"Usuário suspenso por " + usuario.get(0).getEstado() +
                    " dias");
        }
        else{
            List<Emprestimo> emprestimos = Emprestimos
                        .stream()
                        .filter(s -> s.getUsuario().equals(usuario.get(0).getRG()))
                        .collect(Collectors.toList());

                        
            
            for (Emprestimo emprestimo : emprestimos)
                if (sistemaDeData.compareDate(emprestimo.getDataDevolucao()) > 0){
                    clearConsole();
                    JOptionPane.showMessageDialog(null,"Usuário esta com livros em atraso");
                    main.menuPrincipal();
                    return;
                }
                
            clearConsole();
            JOptionPane.showMessageDialog(null,"Usuário não está suspenso");
        }
        
        
        main.menuPrincipal();
    }

    private void menuListagem() throws IOException {
        int i;
        String[] resposta = new String[]{"Usuários",
                 "Livros","Empréstimos"};
       
        int opcao = JOptionPane.showOptionDialog(null,"CADASTRO","BIBLIOTECA"
                ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,resposta,1);
        
        switch (opcao){
            case 0: {
                if (Usuarios.size() == 0){
                    main.clearConsole();
                    JOptionPane.showMessageDialog(null,"SEM USUARIOS CADASTRADOS");

                }
                System.out.println("\n\n");
                for (i = 0; i < Usuarios.size(); i++)
                    JOptionPane.showMessageDialog(null,Usuarios.get(i).toString());
                break;
            }
            case 1: {
                if (Livros.isEmpty()){
                    main.clearConsole();
                    JOptionPane.showMessageDialog(null,"SEM LIVROS CADASTRADOS");

                }
                
                System.out.println("\n\n");
                for (i = 0; i < Livros.size(); i++)
                    JOptionPane.showMessageDialog(null,(Livros.get(i).toString()));
                break;
            }
            case 2: {
                if (Emprestimos.isEmpty()){
                    main.clearConsole();
                    JOptionPane.showMessageDialog(null,"SEM EMPRESTIMOS FEITOS");

                }
                for (i = 0; i < Emprestimos.size(); i++)
                    JOptionPane.showMessageDialog(null,(Emprestimos.get(i).toString()));
                break;
            }
        }
        main.menuPrincipal();
    }
    
    public final static void clearConsole(){
        char c = '\n';
        int length = 25;
        char[] chars = new char[length];
        Arrays.fill(chars, c);
        JOptionPane.showMessageDialog(null,String.valueOf(chars));
}

    private void sair() {

    }

    private void menuData() throws IOException {
        JOptionPane.showMessageDialog(null,"Data atual: " + sistemaDeData.getDataString());
        String[] resposta = new String[]{" Alterar", "Voltar"};

        int opcao = JOptionPane.showOptionDialog(null,"CADASTRO","BIBLIOTECA"
                ,JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,resposta,1);

        switch(opcao){
            case 0: {
                
                int Data = Integer.parseInt(JOptionPane.showInputDialog(null,"Dias a avançar:"));
                main.updateSuspensao(Data);
                sistemaDeData.incrementDays(Data);
                this.menuData();
                break;
            }
            case 1: {
                clearConsole();
                main.menuPrincipal();
                break;
            }
        }
    }

    private void updateSuspensao(long Diferenca) {
        // Só muda Estado se não há outros livros atrasados
        for (UsuarioPadrao usuario : Usuarios){
                List<Emprestimo> emprestimos =
                        Emprestimos
                            .stream()
                            .filter(s -> s.getUsuario().equals(usuario.getRG()))
                            .collect(Collectors.toList());
                boolean flag = true;
                for (Emprestimo emprestimo : emprestimos) {
                    if (sistemaDeData.compareDate(emprestimo.getDataDevolucao()) > 0){
                        flag = false;
                        return;
                    }
                }
                if (flag){
                    usuario.setEstado((int) (usuario.getEstado() - Diferenca));
                    if (usuario.getEstado() < 0)
                        usuario.setEstado(0);
                }
        }

    }
    
  }