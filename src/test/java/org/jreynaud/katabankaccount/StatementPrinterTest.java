package org.jreynaud.katabankaccount;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jreynaud.katabankaccount.Statement;
import org.jreynaud.katabankaccount.StatementPrinter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatementPrinterTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	public void restoreStream() {
		System.setOut(System.out);
	}

	@Test
	public void should_PrintCorrectFormattedStatements_when_PrintHistoryAfterOneDepositAndOneWithdraw() {
		List<Statement> statements = new ArrayList<>();

		String depositeDateString = "2019-12-08T10:15:30+01:00[Europe/Paris]";
		String withdrawDateString = "2019-12-09T10:15:30+01:00[Europe/Paris]";

		ZonedDateTime depositDate = ZonedDateTime.parse(depositeDateString);
		ZonedDateTime withdrawDate = ZonedDateTime.parse(withdrawDateString);

		statements.add(new Statement(1000, 1000, Statement.DEPOSIT, depositDate));
		statements.add(new Statement(500, 500, Statement.WITHDRAW, withdrawDate));

		StatementPrinter sp = new StatementPrinter();
		sp.printStatement(statements);

		StringBuilder sb = new StringBuilder();
		sb.append("OPERATION | DATE | AMOUNT | BALANCE |\n");
		sb.append("Deposit | 08/12/2019 - 10:15 | 1000 | 1000 |\n");
		sb.append("Withdraw | 09/12/2019 - 10:15 | -500 | 500 |\n");

		assertEquals(sb.toString(), outContent.toString());		
	}
}
