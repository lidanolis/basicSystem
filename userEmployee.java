import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class userEmployee {
    public Scanner scanner = new Scanner(System.in);
    private String name;
    private String password;
    private String role;
    private String stockType;

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public userEmployee(String name, String password, String role, String stockType) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.stockType = stockType;
    }

    public void showActions() {
        System.out.println("Welcome Back Employee: " + getName());
        System.out.println("Enter Your Action");
        System.out.println("(1) Add New Stock");
        System.out.println("(2) Edit Stock");
        System.out.println("(3) Exit");
        System.out.print("Your Action:");
    }

    public void createStock() {
        while (true) {
            warehouseLocation locationList = new warehouseLocation();
            // name, description, quantity, supplierName, employeeName, location
            String name = "";
            String description = "";
            String quantity = "";
            String supplierName = "";
            String employeeName = "";
            String location = "";
            String stocktype = "";
            System.out.println("Please Make Sure All Information Is Correctly Inputted " + getName() + ":");
            System.out.println("New Stock Creation");
            System.out.print("Stock Name:");
            name = scanner.nextLine();
            System.out.print("Stock Description:");
            description = scanner.nextLine();
            System.out.print("Stock Quantity:");
            quantity = scanner.nextLine();

            System.out.println("Type of Stock:");
            if (stockType.equals("Stationary")) {
                System.out.println("(1) Brush Set");
                System.out.println("(2) Crayon Set");
            } else if (stockType.equals("Electronical")) {
                System.out.println("(1) Microchip");
                System.out.println("(2) Motherboard");
            }
            System.out.print("Stock In Creation:");
            stocktype = scanner.nextLine();

            System.out.print("Stock Supplier Name:");
            supplierName = scanner.nextLine();
            locationList.showWarehouseLocations();
            System.out.print("WareHouse:");
            location = scanner.nextLine();

            if (name == "" || description == "" || quantity == "" || supplierName == "" || location == ""
                    || stocktype == "") {
                System.out.println("Invalid Information!");
                break;
            } else {
                try {
                    int numericQuantity = Integer.parseInt(quantity);
                    int numericLocation = Integer.parseInt(location);
                    int numericStocktype = Integer.parseInt(stocktype);

                    if (numericLocation > locationList.listSize() || numericLocation <= 0 || numericQuantity <= 0
                            || numericStocktype <= 0) {
                        System.out.println("Invalid Numeric Values");
                        break;
                    }

                    employeeName = getName();
                    location = locationList.getWarehosueLocation(numericLocation - 1);

                    if (stockType.equals("Stationary")) {
                        System.out.println("Generating Stock...");
                        if (numericStocktype == 1) {
                            String filePath = "stationaryStock.txt";
                            String STOCKTYPE = "BrushSet";
                            String data = name + ";" + STOCKTYPE + ";" + description + ";" + quantity + ";"
                                    + supplierName
                                    + ";"
                                    + employeeName + ";"
                                    + location;

                            try {
                                // Create a File instance for the specified file path
                                File file = new File(filePath);

                                // Check if the file exists
                                if (file.exists()) {
                                    // If the file exists, append the data
                                    FileWriter writer = new FileWriter(file, true); // true for append mode
                                    writer.write(data + "\n"); // Add a new line for the appended data
                                    writer.close();
                                } else {
                                    // If the file doesn't exist, create and write data
                                    FileWriter writer = new FileWriter(file);
                                    writer.write(data);
                                    writer.close();
                                }
                            } catch (IOException e) {
                                System.err.println("An error occurred: " + e.getMessage());
                            }
                        } else if (numericStocktype == 2) {
                            String filePath = "stationaryStock.txt";
                            String STOCKTYPE = "CrayonSet";
                            String data = name + ";" + STOCKTYPE + ";" + description + ";" + quantity + ";"
                                    + supplierName
                                    + ";"
                                    + employeeName + ";"
                                    + location;

                            try {
                                // Create a File instance for the specified file path
                                File file = new File(filePath);

                                // Check if the file exists
                                if (file.exists()) {
                                    // If the file exists, append the data
                                    FileWriter writer = new FileWriter(file, true); // true for append mode
                                    writer.write(data + "\n"); // Add a new line for the appended data
                                    writer.close();
                                } else {
                                    // If the file doesn't exist, create and write data
                                    FileWriter writer = new FileWriter(file);
                                    writer.write(data);
                                    writer.close();
                                }
                            } catch (IOException e) {
                                System.err.println("An error occurred: " + e.getMessage());
                            }
                        }

                    } else if (stockType.equals("Electronical")) {
                        System.out.println("Generating Stock...");

                        if (numericStocktype == 1) {
                            String filePath = "electronicalStock.txt";
                            String STOCKTYPE = "Microchip";
                            String data = name + ";" + STOCKTYPE + ";" + description + ";" + quantity + ";"
                                    + supplierName
                                    + ";"
                                    + employeeName + ";"
                                    + location;

                            try {
                                // Create a File instance for the specified file path
                                File file = new File(filePath);

                                // Check if the file exists
                                if (file.exists()) {
                                    // If the file exists, append the data
                                    FileWriter writer = new FileWriter(file, true); // true for append mode
                                    writer.write(data + "\n"); // Add a new line for the appended data
                                    writer.close();
                                } else {
                                    // If the file doesn't exist, create and write data
                                    FileWriter writer = new FileWriter(file);
                                    writer.write(data);
                                    writer.close();
                                }
                            } catch (IOException e) {
                                System.err.println("An error occurred: " + e.getMessage());
                            }
                        } else if (numericStocktype == 2) {
                            String filePath = "electronicalStock.txt";
                            String STOCKTYPE = "Motherboard";
                            String data = name + ";" + STOCKTYPE + ";" + description + ";" + quantity + ";"
                                    + supplierName
                                    + ";"
                                    + employeeName + ";"
                                    + location;

                            try {
                                // Create a File instance for the specified file path
                                File file = new File(filePath);

                                // Check if the file exists
                                if (file.exists()) {
                                    // If the file exists, append the data
                                    FileWriter writer = new FileWriter(file, true); // true for append mode
                                    writer.write(data + "\n"); // Add a new line for the appended data
                                    writer.close();
                                } else {
                                    // If the file doesn't exist, create and write data
                                    FileWriter writer = new FileWriter(file);
                                    writer.write(data);
                                    writer.close();
                                }
                            } catch (IOException e) {
                                System.err.println("An error occurred: " + e.getMessage());
                            }
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

    public void editStock() {
        ArrayList<String> stockList = new ArrayList<String>();
        ArrayList<String> filterStockList = new ArrayList<String>();
        ArrayList<Integer> filterStockListNumber = new ArrayList<Integer>();
        String stockType = getStockType();
        String filePath;

        if (stockType.equals("Electronical")) {
            filePath = "electronicalStock.txt";
        } else if (stockType.equals("Stationary")) {
            filePath = "stationaryStock.txt";
        } else {
            filePath = "Invalid";
        }

        if (!(filePath.equals("Invalid"))) {

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    stockList.add(line);

                    String[] addFilter = line.split(";");
                    if (addFilter[5].equals(getName())) {
                        filterStockList.add(line);
                        filterStockListNumber.add(stockList.size() - 1);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }

            if (filterStockList.isEmpty()) {
                System.out.println("\nNo Personally Added Stock");
            } else {
                for (int i = 0; i < filterStockList.size(); i++) {
                    String[] astk = filterStockList.get(i).split(";");
                    System.out.println("\n(" + (i + 1) + ") Stock:");
                    System.out.println("Stock Name:" + astk[0]);
                    System.out.println("Stock Type:" + astk[1]);
                    System.out.println("Stock Description:" + astk[2]);
                    System.out.println("Stock Quantity:" + astk[3]);
                    System.out.println("Stock Supplier:" + astk[4]);
                    System.out.println("Restocker:" + astk[5]);
                    System.out.println("Stock Warehouse Location:" + astk[6]);
                    System.out.println("\n");
                }

                while (true) {
                    String selection;

                    System.out.print("\nInput 0 to Exit");
                    System.out.print("Stock To Edit:");
                    selection = scanner.nextLine();

                    if (selection == "") {
                        System.out.println("Invalid Information!");
                        break;
                    } else {
                        try {
                            int numericSelection = Integer.parseInt(selection);

                            if (numericSelection == 0) {
                                break;
                            }
                            if (numericSelection > filterStockList.size() || numericSelection < 0) {
                                System.out.println("Invalid Numeric Values");
                                break;
                            }

                            String[] editStock = filterStockList.get(numericSelection - 1).split(";");
                            while (true) {
                                String action = "";
                                System.out.println("(1) Stock Name:" + editStock[0]);
                                System.out.println("(2) Stock Type:" + editStock[1]);
                                System.out.println("(3) Stock Description:" + editStock[2]);
                                System.out.println("(4) Stock Quantity:" + editStock[3]);
                                System.out.println("(5) Stock Supplier:" + editStock[4]);
                                System.out.println("(6) Restocker:" + editStock[5]);
                                System.out.println("(7) Stock Warehouse Location:" + editStock[6]);
                                System.out.println("(8) Cancel Action");
                                System.out.println("(9) Confirm Modification");
                                System.out.println("\n");
                                System.out.print("Modification Section:");
                                action = scanner.nextLine();

                                try {
                                    int numericAction = Integer.parseInt(action);

                                    if (numericAction > 9 || numericAction <= 0) {
                                        System.out.println("Invalid Numeric Values");
                                        continue;
                                    }

                                    if (numericAction == 8) {
                                        break;
                                    } else if (numericAction == 9) {
                                        String combined = editStock[0] + ";" + editStock[1] + ";" + editStock[2]
                                                + ";" + editStock[3] + ";" + editStock[4] + ";" + editStock[5]
                                                + ";" + editStock[6];
                                        filterStockList.set(numericSelection - 1, combined);

                                        int j = 0;
                                        for (int i : filterStockListNumber) {
                                            stockList.set(i, filterStockList.get(j));
                                            j++;
                                        }

                                        try {
                                            String data = "";
                                            for (String newstk : stockList) {
                                                data = data + newstk + "\n";
                                            }

                                            BufferedWriter writer = new BufferedWriter(
                                                    new FileWriter(filePath));

                                            writer.write(data);
                                            writer.close();

                                            System.out.println("Stock Has Been Updated");
                                            break;
                                        } catch (IOException e) {
                                            System.err.println("An error occurred: " + e.getMessage());
                                            break;
                                        }
                                    }

                                    String modifyString = "";
                                    System.out.print("Modify To:");
                                    modifyString = scanner.nextLine();

                                    if (!(modifyString.equals(""))) {
                                        editStock[numericAction - 1] = modifyString;
                                    } else {
                                        System.out.print("New Value Cannot Be Empty!\n");
                                        continue;
                                    }

                                } catch (Exception e) {
                                    System.err.println("Invalid Inputs");
                                    continue;
                                }
                            }
                        } catch (Exception e) {
                            System.err.println("Invalid Inputs");
                            break;
                        }

                    }
                }
            }

        }

    }

}
