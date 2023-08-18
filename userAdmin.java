import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userAdmin {
    public Scanner scanner = new Scanner(System.in);
    private String name;
    private String password;
    private String role;
    private List<String> roles = new ArrayList<>();
    private List<String> acquintances = new ArrayList<>();

    public userAdmin(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;

        roles.add("Employee");
        roles.add("Admin");
        acquintances.add("Stationary");
        acquintances.add("Electronical");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void showActions() {
        System.out.println("Welcome Back Employee: " + getName());
        System.out.println("(1) View Report");
        System.out.println("(2) Register New User");
        System.out.println("(3) Exit");
        System.out.print("Enter Your Action:");
    }

    public void viewReport(String name) {
        ArrayList<String> stockList = new ArrayList<String>();

        userDatabase validation = new userDatabase();
        String stockType = validation.getStockTypePermission(name);

        if (stockType.equals("Electronical")) {
            try (BufferedReader reader = new BufferedReader(new FileReader("electronicalStock.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    stockList.add(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }

            System.out.println("\nElectronical Report");
            for (String aStock : stockList) {
                String[] stk = aStock.split(";");
                System.out.println("Stock Name:" + stk[0]);
                System.out.println("Stock Type:" + stk[1]);
                System.out.println("Stock Description:" + stk[2]);
                System.out.println("Stock Quantity:" + stk[3]);
                System.out.println("Stock Supplier:" + stk[4]);
                System.out.println("Restocker:" + stk[5]);
                System.out.println("Stock Warehouse Location:" + stk[6]);
                System.out.println("\n");
            }

        } else if (stockType.equals("Stationary")) {
            try (BufferedReader reader = new BufferedReader(new FileReader("stationaryStock.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    stockList.add(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }

            System.out.println("\nElectronical Report");
            for (String aStock : stockList) {
                String[] stk = aStock.split(";");
                System.out.println("Stock Name:" + stk[0]);
                System.out.println("Stock Type:" + stk[1]);
                System.out.println("Stock Description:" + stk[2]);
                System.out.println("Stock Quantity:" + stk[3]);
                System.out.println("Stock Supplier:" + stk[4]);
                System.out.println("Restocker:" + stk[5]);
                System.out.println("Stock Warehouse Location:" + stk[6]);
                System.out.println("\n");
            }
        } else {
            System.out.println("\nInvalid Acquitance");
        }

    }

    public void createStock() {
        userDatabase usd = new userDatabase();
        while (true) {
            String name = "";
            String password = "";
            String role = "";
            String acquintance = "";

            System.out.println("Please Make Sure All Information Is Correctly Inputted " + getName() + ":");
            System.out.println("New User Creation");
            System.out.print("Username:");
            name = scanner.nextLine();
            System.out.print("Password:");
            password = scanner.nextLine();

            System.out.println("Role:");
            int i = 1;
            for (String arole : roles) {
                System.out.println("(" + i + ") " + arole);
                i++;
            }
            System.out.print("Role Selection:");
            role = scanner.nextLine();

            System.out.println("Warehouse Acquinted:");
            i = 1;
            for (String aacquintance : acquintances) {
                System.out.println("(" + i + ") " + aacquintance);
                i++;
            }
            System.out.print("Acquitance Selection:");
            acquintance = scanner.nextLine();

            if (name == "" || password == "" || role == "" || acquintance == "") {
                System.out.println("Invalid Information!");
                break;
            } else {
                try {

                    int numericRole = Integer.parseInt(role);
                    int numericAcquintance = Integer.parseInt(acquintance);

                    if (numericRole > roles.size() || numericRole <= 0 || numericAcquintance > acquintances.size()
                            || numericAcquintance <= 0) {
                        System.out.println("Invalid Numeric Values");
                        break;
                    }

                    if (usd.validateUsername(name)) {
                        System.out.println("Username Already Exist, Please Pick Another One");
                    } else {

                        try {
                            String data = name + ";" + password + ";" + roles.get(numericRole - 1) + ";"
                                    + acquintances.get(numericAcquintance - 1);
                            File file = new File("user.txt");
                            FileWriter fw = new FileWriter(file, true);
                            fw.write(data + "\n");
                            fw.close();
                            System.out.println("Success");
                        } catch (Exception e) {
                            System.out.println("Failed");
                        }
                    }

                    break;
                } catch (Exception e) {
                    System.err.println("Invalid Inputs");
                    break;
                }

            }
        }
    }

}
