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
        String[] resposta = new String[]{" Cadastrar Usuario", "Cadastrar Livro",
                 "Emprestimo\n", "Devolucao\n", " Suspensão",
                 "Listar",  "Data",  "Sair"};
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
            case 3: {
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