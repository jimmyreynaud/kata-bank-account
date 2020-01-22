package org.jreynaud.katabankaccount;

public class App 
{
    public static void main( String[] args )
    {
    	Account account = new Account();
    	account.deposit(100);
    	account.withdraw(50);
    	account.deposit(100);
    	account.withdraw(50);
    	account.deposit(100);
    	account.withdraw(50);
    	account.deposit(350);
    	account.withdraw(150);
    	
    	StatementPrinter sp = new StatementPrinter();
    	sp.printStatement(account.getStatements());
    }
}
