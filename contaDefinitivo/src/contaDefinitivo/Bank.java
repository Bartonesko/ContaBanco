package contaDefinitivo;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> accounts;

	public Bank() {
		accounts = new ArrayList<Account>();
	}

	public void addAccount(Account account) {
		if (accountExists(account.getNumber()) == true) {
			System.out.println("Uma conta com esse número já existe.");
		} else {
			accounts.add(account);
			System.out.println("Conta " + account.getAccountType() + " de número: " + account.getNumber() + " e limite de: R$" + account.getLimit()
					+ " cadastrada com sucesso.");
		}
	}

	public void removeAccount(int number) {
		for (Account i : accounts) {
			if (i.getNumber() == number) {
				accounts.remove(i);
				System.out.println("A conta " + number + " foi removida com sucesso.");
			} else
				System.out.println("Essa conta não existe.");
			break;
		}
	}

	public void withdraw(int number, double value) {
		if (accountExists(number) == false) {
			System.out.println("Essa conta não existe.");
		} else if (getAccount(number).getBalance() < value || getAccount(number).getLimit() < value
				|| 0 - getAccount(number).getLimit() > 0 - value) {
			System.out.println("Saldo ou limite ultrapassado!");
		} else {
			getAccount(number).setBalance(getAccount(number).getBalance() - value);
			getAccount(number).addStatement(new Move("Retirada de: R$", value, MoveType.SAIDA));
			System.out.println("Retirada de: R$" + value);
		}
	}

	public void deposit(int number, double value) {
		if (accountExists(number) == false) {
			System.out.println("Essa conta não existe.");
		} else {
			getAccount(number).setBalance(getAccount(number).getBalance() + value);
			getAccount(number).addStatement(new Move("Depósito de: R$", value, MoveType.ENTRADA));
			System.out.println("Depósito de: R$" + value);
		}
	}

	public void transfer(int from, int to, double value) {
		if (accountExists(from) == false) {
			System.out.println("Sua conta esta incorreta ou não existe.");
		} else if (accountExists(to) == false) {
			System.out.println("A conta para transferência esta incorreta ou não existe.");
		} else if (getAccount(from).getBalance() < value || getAccount(from).getLimit() < value
				|| 0 - getAccount(from).getLimit() > 0 - value) {
			System.out.println("Saldo ou limite ultrapassado!");
		} else {
			withdraw(from, value);
			deposit(to, value);
		}
	}

	public void getStatement(int number) {
		if (accountExists(number) == false) {
			System.out.println("Essa conta não existe.");
		} else
			System.out.println("\n.........:::::::::  EXTRATO  :::::::::.........\n" + getAccount(number).getMovements()
					+ "\n Saldo atual: R$" + getAccount(number).getBalance());
	}

	public boolean accountExists(int number) {
		for (Account i : accounts) {
			if (i.getNumber() == number) {
				return true;
			}
		}
		return false;
	}

	public Account getAccount(int number) {
		for (Account i : accounts) {
			if (i.getNumber() == number) {
				return i;
			}
		}
		return null;
	}
}
