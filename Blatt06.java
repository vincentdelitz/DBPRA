import java.math.BigDecimal;
import java.sql.*;
// package to read input from the user
import java.util.Scanner;

public class Blatt06 extends Basis06 {
	private static String server = "jdbc:postgresql:"; // DO NOT CHANGE
	private static String database = "postgres"; // place the name of your
													// Database here
	private static String user = "postgres"; // place your db-username here
	private static String password = "123456"; // place your password here

	/*
	 * readString
	 * 
	 * this is just a very simple Method to get a String from the User
	 */
	private static String readString(String msg) {
		System.out.println(msg);
		return readString();
	}

	private static String readString() {
		return (new Scanner(System.in)).next();
	}

	public static void main(String[] args) throws SQLException,
			LabCourseException {
		/*
		 * System.out.println("Please give a name for the customer:"); String
		 * name = readString(); Blatt06 test = new Blatt06(); int result =
		 * test.aufg_1_2(name);
		 */

		/*System.out.println("Please give a name for the supplier:");
		String supplier = readString();
		System.out.println("Please give a name for the part:");
		String part = readString();
		Scanner s = new Scanner(System.in);
		System.out.println("Please give the available quantity as integer:");
		Integer availqty = new Integer(s.nextInt());
		System.out.println("Please give the supplying costs as BigDecimal:");
		BigDecimal supplycost = s.nextBigDecimal();

		Blatt06 test = new Blatt06();
		boolean result = test.aufg_1_1(supplier, part, availqty, supplycost);

		// Testwerte: 4, 10, 69, 4.20
		// SWIRL, S87904
		 
		 */
		
		
		 
		 String name = readString("Please give a name for the customer:"); 
		 Blatt06 test = new Blatt06(); 
		 boolean result = test.aufg_1_4(name);
		 

	}

	public boolean aufg_1_1(String supplier, String name, Integer availqty,
			BigDecimal supplycost) throws SQLException, LabCourseException {

		String query = "INSERT INTO partsupp(partkey,suppkey,availqty,supplycost) "
				+ "VALUES(?,?,?,?)";

		try {
			// Load vendor-specific driver
			Class.forName("org.postgresql.Driver");

			// Open Connection
			// Connection con = DriverManager.getConnection(server + database,
			// user, password);

			Connection con = DriverManager.getConnection(server + database,
					user, password);

			// start transaction
			con.setAutoCommit(false);

			// prepare stmt
			PreparedStatement ps = con.prepareStatement(query);

			/*
			 * The rough structure of the method and the following LoCs is: 1.
			 * Search for the supplier by the given name 2. Let the user take an
			 * existing part or create a new one 4. Store information for
			 * available quantity and supply costs
			 */

			/*
			 * At first, the suppkey of the existing supplier is being searched
			 * and stored in the variable suppkey.
			 */
			String query_suppkey = "SELECT suppkey FROM supplier "
					+ "WHERE name = ?";
			PreparedStatement ps_suppkey = con.prepareStatement(query_suppkey);
			ps_suppkey.setString(1, supplier);
			ResultSet rs_suppkey = ps_suppkey.executeQuery();
			rs_suppkey.next();
			int suppkey = rs_suppkey.getInt(1);

			con.commit();

			// close statement
			ps_suppkey.close();

			System.out.println("Suppkey for " + supplier + " is: " + suppkey);

			
			/*
			 * Afterwards, the user is asked if he wants to create a new part or
			 * if he wants to use an existing one. Therefore, only the letters E
			 * and N are valid for the selection.
			 */
			System.out
					.println("Do you want to add a new (N) or existing (E) product? Enter the letter:");
			String decision = readString();
			boolean neu;

			// Evaluate the user input
			if (decision.contentEquals("E")) {
				neu = false;
				System.out
						.println("You decided to enter an existing product to the offer");
			} else if (decision.contentEquals("N")) {
				neu = true;
				System.out
						.println("You decided to enter a new product to the offer");
			} else {
				System.out.println("You didn't enter 'E' or 'N'!");
				return false;
			}

			/*
			 * Now we want to find/create the partkey for the product. In order
			 * to this we have to first distinguish if the product is already
			 * avaible and thus we only need to retrieve the partkey. Or if we
			 * need to create a new product (incl. the partkey) and take this
			 * new product and its partkey for further processing.
			 */
			int partkey;

			if (!neu) {
				/*
				 * Our assumption here is that the part name is unique and
				 * correctly written.
				 */
				String query_partkey = "SELECT partkey FROM Part "
						+ "WHERE name = ?";
				PreparedStatement ps_partkey = con
						.prepareStatement(query_partkey);
				ps_partkey.setString(1, name);
				ResultSet rs_partkey = ps_partkey.executeQuery();
				rs_partkey.next();
				partkey = rs_partkey.getInt(1);

				System.out.println("Partkey for " + name + " is: " + partkey);
				con.commit();

				// close statement
				ps_partkey.close();
			} else {
				/*
				 * If we need to create the product, we need at first some more
				 * information from the user like, type, or retailprice. The
				 * name for the product is already in the parameter name and the
				 * partkey will be generated automatically and return by partkey
				 * = ps_partkey.executeUpdate(); Moreover, we assume that the
				 * name for the product is less than 55 characters long.
				 */
				System.out.println("Enter the type (maximum 25 characters):");
				String type = readString();
				// According to our definition, we are solely allowed to use
				// maximum 25 chars for the type.
				if (type.length() > 25) {
					System.out.println("too long");
					// Exception
					return false;
				}

				// Wie herausfinden, ob Partkey schon vergeben ist?

				System.out
						.println("Enter the retailprice as a double with 2 digits after the point:");
				Scanner s = new Scanner(System.in);
				BigDecimal retailprice = s.nextBigDecimal();

				// Actually, we need to check the format of the double here as
				// well.
				
				/*
				 * In the following we retrieve the highest existing partkey.
				 */
				
				String query_highest = "SELECT Max(Partkey) FROM Part";
				PreparedStatement ps_highest = con.prepareStatement(query_highest);
				ResultSet current_highest_partkey_rs = ps_highest.executeQuery();
				current_highest_partkey_rs.next();
				partkey = current_highest_partkey_rs.getInt(1);
				partkey++;
				con.commit();
				ps_highest.close();

				// Insertion of a new product into the table Part
				String query_partkey = "INSERT INTO Part(Partkey,Name,Type,Retailprice) VALUES (?,?,?,?)"; 
				PreparedStatement ps_partkey = con.prepareStatement(
						query_partkey);
				ps_partkey.setInt(1,partkey);
				ps_partkey.setString(2, name);
				ps_partkey.setString(3, type);
				ps_partkey.setBigDecimal(4, retailprice);

				partkey = ps_partkey.executeUpdate();
				System.out.println("Partkey for part " + name + " is: "
						+ partkey);
				con.commit();

				// close statement
				ps_partkey.close();

			}

			// Finally, we retrieved and/or generated the foreign keys and can
			// set up our actual values for the query
			ps.setInt(1, partkey);
			ps.setInt(2, suppkey);
			ps.setInt(3, availqty.intValue());
			ps.setBigDecimal(4, supplycost);

			// Execute query
			int id_new_row = ps.executeUpdate();

			// end transaction

			con.commit();

			// close statement
			ps.close();
			// close connection
			con.close();

			System.out.println("New offer with " + partkey + ", " + suppkey
					+ ", " + availqty + ", " + supplycost
					+ " has been added successfully.");

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}
		return true;
	}

	public int aufg_1_2(String name) throws SQLException, LabCourseException {

		int rs_counter = 0;

		String query = "SELECT * " + "FROM customer " + "WHERE name LIKE ?;";

		try {
			// Load vendor-specific driver
			Class.forName("org.postgresql.Driver");

			// Open Connection
			// Connection con = DriverManager.getConnection(server + database,
			// user, password);

			Connection con = DriverManager.getConnection(server + database,
					user, password);

			// start transaction
			con.setAutoCommit(false);

			// prepare stmt
			PreparedStatement ps = con.prepareStatement(query);

			// Ask User
			String customer = name;
			// Provide values
			ps.setString(1, "%" + customer + "%");

			// Execute query
			ResultSet rs = ps.executeQuery();

			// Fetch values
			while (rs.next()) {
				// First Index is 1
				for (int i = 1; i <= 7; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
				rs_counter++;

			}

			// end transaction
			// con.rollback();
			con.commit();

			// close resultset
			rs.close();
			// close statement
			ps.close();
			// close connection
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return rs_counter;
	}

	public int aufg_1_3(String table) throws SQLException, LabCourseException {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean aufg_1_4(String name) throws SQLException,
			LabCourseException {

		

		String query = "SELECT * " + "FROM customer " + "WHERE name LIKE ?;";

		try {
			// Load vendor-specific driver
			Class.forName("org.postgresql.Driver");

			// Open Connection
			// Connection con = DriverManager.getConnection(server + database,
			// user, password);

			Connection con = DriverManager.getConnection(server + database,
					user, password);

			// start transaction
			con.setAutoCommit(false);

			// prepare stmt
			PreparedStatement ps = con.prepareStatement(query);

			// Ask User
			String customer = name;
			// Provide values
			ps.setString(1, "%" + customer + "%");

			// Execute query
			ResultSet rs = ps.executeQuery();

			// Fetch values
			while (rs.next()) {
				// First Index is 1
				for (int i = 1; i <= 2; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
				
			}
			
			
			
			System.out.println("Please enter the custkey of the customer that you want to delete:");
			Scanner s = new Scanner(System.in);
			int custkey = s.nextInt();
			
			System.out.println("You decided to delete the customer with custkey = " + custkey);
			
			/*
			 * In the following we will test if the record can be deleted:
			 * - is acctbal positive?
			 * - is there an order for the custkey that is no
			 */
			double accountBalance=0;
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)==custkey){
					accountBalance=rs.getDouble(7);
				}
			}
			
			if(accountBalance<0.00){
				System.out.println("Account Balance is negative");
				//Exception
				return false;
			}
			
			// end transaction
			con.commit();

			// close resultset
			rs.close();
			// close statement
			ps.close();
			
			
			//Check if there is an order that is not ok
			String query_orders = "SELECT orderstatus FROM orders WHERE custkey = ?;";
			
			PreparedStatement ps_orders = con.prepareStatement(query_orders);
			ps_orders.setInt(1, custkey);
			ResultSet rs_orders = ps_orders.executeQuery();

			while (rs_orders.next()) {

				if (rs_orders.getString(1).equals("no")) {
						System.out.println("There is one order for the custkey that is not ok.");
						//Exception
						return false;
				}
			}
			con.commit();

			// close resultset
			rs_orders.close();
			// close statement
			ps_orders.close();
			
			/*
			 * if the user is allowed to delete the correpsonding record,
			 * the query is executed.
			 */
			
			String query_delete = "DELETE FROM customer WHERE custkey = ?;";
			PreparedStatement ps_delete = con.prepareStatement(query_delete);
			ps_delete.setInt(1, custkey);
			
			int deletedrow = ps_delete.executeUpdate();
			con.commit();
			ps_delete.close();
			System.out.println("You successfully deleted customer " + name + " with custkey " + custkey);

			// close connection
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
		}
		return true;
	}

	public BigDecimal aufg_1_5(String name, BigDecimal payment)
			throws SQLException, LabCourseException {
		// TODO Auto-generated method stub
		return null;
	}



}