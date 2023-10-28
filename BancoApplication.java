
package gerenciamentobanco;
import java.util.InputMismatchException;
import java.util.Scanner;
public class BancoApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo à aplicação de gerenciamento de banco!");

        System.out.print("Informe seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe seu sobrenome: ");
        String sobrenome = scanner.nextLine();

        System.out.print("Informe seu CPF: ");
        String cpf = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf);

    while (true) {
            try {
                System.out.println("\nOpções:");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Depositar");
                System.out.println("3. Retirar");
                System.out.println("4. Interromper execução");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1 -> conta.consultarSaldo();
                    case 2 -> {
                        System.out.print("Informe o valor a depositar: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                    }
                    case 3 -> {
                        System.out.print("Informe o valor a retirar: ");
                        double valorRetirada = scanner.nextDouble();
                        conta.retirar(valorRetirada);
                    }
                    case 4 -> conta.interromperExecucao();
                    default -> System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Certifique-se de fornecer um valor válido.");
                scanner.nextLine(); // Limpa a entrada inválida
            }
        }
    }
}
