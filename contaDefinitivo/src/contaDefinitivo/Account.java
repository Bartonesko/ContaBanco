package contaDefinitivo;

import java.util.ArrayList;

public class Account {
	private int number;
	private double balance;
	private AccountType AccountType;
	private double limit;
	private ArrayList<Move> movements;

	public Account(int number, AccountType accountType, double limite) {
		movements = new ArrayList<Move>();
		this.number = number;
		AccountType = accountType;
		this.limit = limite;
	}

	public String getMovements() {
		String results = "";
		for (Move i : movements) {
			results += "\n " + i.toString();
		}
		return results;
	}

	public void addStatement(Move movement) {
		this.movements.add(movement);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int numero) {
		this.number = numero;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double saldo) {
		this.balance = saldo;
	}

	public AccountType getAccountType() {
		return AccountType;
	}

	public void setAccountType(AccountType accountType) {
		AccountType = accountType;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limite) {
		this.limit = limite;
	}
}
