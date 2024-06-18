import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Funcionario extends Pessoa implements Comparable<Funcionario>{
    public BigDecimal salario;

    public String funcao;

    public int idade;

    public Funcionario(String nome, LocalDate data_nascimento, BigDecimal salario, String funcao ){
        this.nome= nome;
        this.data_nascimento = data_nascimento;
        this.salario = salario;
        this.funcao = funcao;


        this.idade = calcularIdade(data_nascimento);
    }
    public String getNome(){
        return this.nome;
    }

    @Override
    public int compareTo(Funcionario outroFuncionario) {
        return this.nome.compareTo(outroFuncionario.nome);
    }
    public static int calcularIdade(LocalDate nascimento){

        return LocalDate.now().getYear() - nascimento.getYear();
    }

    public BigDecimal getSalario(){
        return this.salario;
    }
}
