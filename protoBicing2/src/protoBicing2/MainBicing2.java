package protoBicing2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.h2.tools.DeleteDbFiles;
import java.util.Scanner;

public class MainBicing2 {

	public static void main(String[] args) throws Exception {
		Scanner reader = new Scanner(System.in);
		Menu2 menu = new Menu2(reader);

		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/protoBicing2", "javi", "a");
		Statement stat = conn.createStatement();

		ResultSet rs;
		rs = stat.executeQuery("select * from bike");

		System.out.println("** PROTO BICING DB SYSTEM **");
		String command = "";
		String query = "";
		int colNumber = 0;

		while (true) {
			System.out.println("\nInsert command:\n[addBike, printBike, addUser, printUsers, newTrip, writeSQL or end]\n");
			command = reader.nextLine();

			if (command.equalsIgnoreCase("end")) {
				break;
			} else {
				query = menu.options(command, reader);
				System.out.println(query);
				rs = stat. executeQuery(query);
			}

			if (rs != null) {
				System.out.println("Executing '" + query + "':\n");
				colNumber = rs.getMetaData().getColumnCount();

				for (int col = 1; col <= colNumber; col++) {
					if (col > 1)
						System.out.print("    ");
					System.out.print(rs.getMetaData().getColumnName(col));
				}
				System.out.println();

				while (rs.next()) {
					for (int col = 1; col <= colNumber; col++) {

						if (col > 1)
							System.out.print("      ");
						System.out.print(rs.getString(col));
					}
					System.out.println();
				}
			}
//%30s tabulate
		}

		System.out.print("\nEnd of the program");

		stat.close();
		conn.close();

	}

}