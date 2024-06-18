import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        /*
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        */
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');

        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        Funcionario funcionario1 = new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador");
        Funcionario funcionario2 = new Funcionario("João", LocalDate.of(1990,5,12), new BigDecimal("2284.38"), "Operador");
        Funcionario funcionario3 = new Funcionario("Caio", LocalDate.of(1961,5,2), new BigDecimal("9836.14"), "Coordenador");
        Funcionario funcionario4 = new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"), "Diretor");
        Funcionario funcionario5 = new Funcionario("Alice", LocalDate.of(1995,1,5), new BigDecimal("2234.68"), "Recepcionista");
        Funcionario funcionario6 = new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"), "Operador");
        Funcionario funcionario7 = new Funcionario("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"), "Contador");
        Funcionario funcionario8 = new Funcionario("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"), "Gerente");
        Funcionario funcionario9 = new Funcionario("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("1606.85"), "Eletricista");
        Funcionario funcionario10 = new Funcionario("Helena", LocalDate.of(1996,9,2), new BigDecimal("2799.93"), "Gerente");

        ArrayList<Funcionario> funcionarios = new ArrayList();

        List<Funcionario> list = Arrays.asList(funcionario1,funcionario2,funcionario3, funcionario4, funcionario5, funcionario6, funcionario7, funcionario8, funcionario9, funcionario10);

        funcionarios.addAll(0, list);

        //3.2 – Remover o funcionário “João” da lista.
        funcionarios.remove(funcionario2);

        // 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
        //• informação de data deve ser exibido no formato dd/mm/aaaa;
        //• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
        System.out.println("Imprimindo lista com todas as informações: ");
        funcionarios.forEach(n -> {
            System.out.println("Nome: "+ n.nome + ", Salário: " + df.format(n.salario) + ", Função: " + n.funcao + ", Data de nascimento: " + n.data_nascimento.format(formatador));
        });

        //3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.

        funcionarios.forEach(n -> {
            n.salario = n.salario.add(n.salario.multiply(BigDecimal.valueOf(0.10)));
        });
        System.out.println("Imprimindo lista com o salário atualizado: ");
        funcionarios.forEach(n -> {

            System.out.println("Nome: "+ n.nome + ", Salário: " + df.format(n.salario) + ", Função: " + n.funcao + ", Data de nascimento: " + n.data_nascimento.format(formatador));
        });

        //3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.

        HashMap<String, ArrayList<Funcionario>> mapPorFuncao = new HashMap<>();

        for(Funcionario func : funcionarios){
            if(func.funcao.isEmpty()){
                return;
            }
            mapPorFuncao.computeIfAbsent(func.funcao, k -> new ArrayList<>()).add(func);
        }

        //3.6 – Imprimir os funcionários, agrupados por função.
        System.out.println("Imprimindo hashMap com os funcionários agrupados por função: ");
        mapPorFuncao.forEach((n,v) -> {
            v.forEach(func -> {
                System.out.println("Função: "+n + ", Funcionário: " +func.nome);
            });
        });

        //3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("Imprimindo lista dos aniversariantes do mes 10 e mes 12: ");
        funcionarios.forEach(n-> {
            switch (n.data_nascimento.getMonthValue()){
                case 10:
                    System.out.println("Aniversário de: " +"Nome: "+ n.nome + ", Salário: " + n.salario + ", Função: " + n.funcao + ", Data de nascimento: " + n.data_nascimento.format(formatador));
                    return;
                case 12:
                    System.out.println("Aniversário de: "+"Nome: "+ n.nome + ", Salário: " + n.salario + ", Função: " + n.funcao + ", Data de nascimento: " + n.data_nascimento.format(formatador));

            }
        });

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        Funcionario MaiorIdade = funcionarios.get(0);
        for(int i = 1; i< funcionarios.size(); i++){
            if(funcionarios.get(i).idade > MaiorIdade.idade){
                MaiorIdade = funcionarios.get(i);
            }
        }

        System.out.println("Funcionário mais velho: "+ MaiorIdade.nome + ", Idade: " +MaiorIdade.idade);


        // 3.10 – Imprimir a lista de funcionários por ordem alfabética.

        System.out.println("Imprimindo a lista de funcionários por ordem alfabética: ");
        funcionarios.stream().sorted().forEach(n -> {
            System.out.println("Nome: "+ n.nome + ", Salário: " + df.format(n.salario) + ", Função: " + n.funcao + ", Data de nascimento: " + n.data_nascimento.format(formatador));
        });

        // 3.11 – Imprimir o total dos salários dos funcionários.
        BigDecimal salarioTot = funcionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Salario total: " + salarioTot);

        // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        BigDecimal salMinimo = new BigDecimal("1212.00");

        funcionarios.forEach(n-> {
            System.out.println("Funcionário: "+ n.nome + ", recebe "+ n.salario.divide(salMinimo, 2).setScale(2, 2) + " salário(s) mínimo(s)");
        });

    }
}