package org.jreynaud.katabankaccount;

public class App 
{
    public static void main( String[] args )
    {
    	Account account = new Account();
    	account.deposit(100);
    	account.withdraw(50);
    	
    	StatementPrinter sp = new StatementPrinter();
    	sp.printStatement(account.getStatements());
    }
}
