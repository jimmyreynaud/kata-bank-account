package org.jreynaud.katabankaccount;

import java.time.format.DateTimeFormatter;
import java.util.List;

/*
 *  This class could have implemented a Printer Interface
 */

public class StatementPrinter {

	private static final String STATEMENT_HISTORY_HEADER = "OPERATION | DATE | AMOUNT | BALANCE |\n";
	private static final String ITEM_STATEMENT_SEPARATOR = " | ";
	private static final String ENDLINE_STATEMENT_SEPARATOR = " |\n";

	public void printStatement(List<Statement> statements) {
		if (statements != null && !statements.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append(STATEMENT_HISTORY_HEADER);
			for (Statement statement : statements) {
				appendStatementFormatted(sb, statement);
			}
			System.out.print(sb);
		}
	}

	private void appendStatementFormatted(StringBuilder sb, Statement statement) {
		sb.append(statement.getOperationType()).append(ITEM_STATEMENT_SEPARATOR)
		.append(DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm").format(statement.getDate())).append(ITEM_STATEMENT_SEPARATOR)
		.append(statement.getOperationType().equals(Statement.DEPOSIT) ? "" : "-").append(statement.getAmount()).append(ITEM_STATEMENT_SEPARATOR)
		.append(statement.getBalance()).append(ENDLINE_STATEMENT_SEPARATOR);
	}

}
