package protoBicing2;

import java.util.Scanner;

public class Menu2 {

	
	public Menu2(Scanner reader) {

	}
	
	public String options(String command, Scanner reader) {

		String answer = "";
		if (command.equalsIgnoreCase("addBike")) {
			answer = addBike(reader);
		} else if (command.equalsIgnoreCase("printBike")) {
			answer = printBike();
		} else if (command.equalsIgnoreCase("printUsers")) {
			answer = printUsers();
		} else if (command.equalsIgnoreCase("addUser")) {
			answer = addUser(reader);
		} else if (command.equalsIgnoreCase("newTrip")) {
			answer = addTrip(reader);
		} else if (command.equalsIgnoreCase("writeSQL")) {
			answer = writeSQL(reader);
		}

		return answer;
	}

	
	public String writeSQL(Scanner reader) {

		System.out.println("Insert SQL code:");
		return reader.nextLine();

	}

	public String addUser(Scanner reader) {
		String name = "";
		System.out.println("Insert user name:");
		name = reader.nextLine();
		return "insert into users values (null, '" + name + "', 0)";
	}

	public String addBike(Scanner reader) {
		int station = 0;
		System.out.println("Insert initial station number:");
		station = Integer.parseInt(reader.nextLine());
		return "insert into bike values (null, " + station + ", 0)";
	}

	public String addTrip(Scanner reader) {
		int bike = 0;
		System.out.println("Insert bike ID number:");
		bike = Integer.parseInt(reader.nextLine());
		int user = 0;
		System.out.println("Insert user ID number:");
		user = Integer.parseInt(reader.nextLine());
		String time = java.time.LocalDate.now() + " " + java.time.LocalTime.now();
		
		return "insert into trips values (null, '" + bike + "', '" + user + "', " + time + " )";
	}
	
	public String printBike() {
		return "select * from bike";
	}
	
	public String printUsers() {
		return "select * from users";
	}
	
	
}
