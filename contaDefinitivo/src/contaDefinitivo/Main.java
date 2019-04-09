package contaDefinitivo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Bank bank1 = new Bank();
		int option = 0;

		do {
			System.out.println(".........::::::::: Bart Bank :::::::::.........\n"
					+ "(1)Sacar\t \n(2)Depositar\t \n(3)Transferência\t \n(4)Extrato\t"
					+ " \n(5)Cadastrar-se\t \n(6)Remover Conta\t \n(7)Sair");

			int number;
			double value;
			Scanner options = new Scanner(System.in);
			Scanner numberInput = new Scanner(System.in);
			Scanner valueInput = new Scanner(System.in);
			option = options.nextInt();

			switch (option) {
			case 1:
				System.out.println("Digite o número da conta: ");
				number = numberInput.nextInt();
				System.out.println("Digite o valor a ser sacado: ");
				value = valueInput.nextDouble();
				bank1.withdraw(number, value);
				break;
			case 2:
				System.out.println("Digite o número da conta: ");
				number = numberInput.nextInt();
				System.out.println("Digite o valor a ser depositado: ");
				value = valueInput.nextDouble();
				bank1.deposit(number, value);
				break;
			case 3:
				Scanner toInput = new Scanner(System.in);
				System.out.println("Digite o número da sua conta: ");
				number = numberInput.nextInt();
				System.out.println("Digite o numero da conta para que deseja transferir: ");
				int to = toInput.nextInt();
				System.out.println("Digite o valor que deseja transferir: ");
				value = valueInput.nextDouble();
				bank1.transfer(number, to, value);
				break;
			case 4:
				System.out.println("Digite o número da sua conta: ");
				bank1.getStatement(numberInput.nextInt());
				break;
			case 5:
				Scanner entrada = new Scanner(System.in);
				char type;

				do {
					System.out.println("Qual tipo de conta deseja criar: \n(n)Normal \n(e)Especial");
					type = entrada.next().charAt(0);
					if (type == 'n') {
						System.out.println("Digite um número para sua nova conta: ");
						number = numberInput.nextInt();
						System.out.println("Digite o limite: ");
						value = valueInput.nextDouble();
						bank1.addAccount(new Account(number, AccountType.NORMAL, value));
						break;
					} else if (type == 'e') {
						System.out.println("Digite um número para sua nova conta: ");
						number = numberInput.nextInt();
						System.out.println("Digite o limite: ");
						value = valueInput.nextDouble();
						bank1.addAccount(new Account(number, AccountType.ESPECIAL, value));
						break;
					} else
						break;
				} while (type != 'n' || type != 'e');
				break; // Precisa ter esse break senão vai direto pro case 6.
			case 6:
				System.out.println("Digite o número da conta a ser removida: ");
				bank1.removeAccount(numberInput.nextInt());
				break;
			default:
				break;
			}
		} while (option != 7);
		System.exit(0);
	}
}
