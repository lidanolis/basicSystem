import java.util.Scanner;

class Basicdesign {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        userDatabase usd = new userDatabase();
        while (true) {
            String action = "";
            System.out.println("Welcome");
            System.out.println("(1) Login");
            System.out.println("(2) Exit");
            System.out.print("Your Action:");
            action = scanner.nextLine();

            if (action.equals("1")) {
                while (true) {
                    String name = "";
                    String password = "";
                    String role = "";

                    System.out.print("Enter your username: ");
                    name = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    password = scanner.nextLine();

                    System.out.println("Role:");
                    System.out.println("(1) Employee");
                    System.out.println("(2) Admin");
                    System.out.print("Enter your role: ");
                    role = scanner.nextLine();

                    if (role.equals("1")) {
                        role = "Employee";
                    } else if (role.equals("2")) {
                        role = "Admin";
                    } else {
                        System.out.println("Invalid Input");
                        continue;
                    }

                    if (usd.validateUsername(name)) {
                        if (usd.validatePassword(name, password)) {
                            if (usd.validateRole(name, password, role)) {
                                while (true) {
                                    if (role.equals("Admin")) {
                                        userAdmin usa = new userAdmin(name, password, role);
                                        usa.showActions();
                                        action = scanner.nextLine();
                                        if (action.equals("1")) {
                                            usa.viewReport(usa.getName());
                                            continue;
                                        } else if (action.equals("2")) {
                                            usa.createStock();
                                            continue;
                                        } else if (action.equals("3")) {
                                            break;
                                        } else {
                                            System.out.println("Invalid Action");
                                        }
                                    } else if (role.equals("Employee")) {
                                        String stockType = usd.getStockTypePermission(name);
                                        userEmployee usc = new userEmployee(name, password, role, stockType);
                                        usc.showActions();
                                        action = scanner.nextLine();
                                        if (action.equals("1")) {
                                            usc.createStock();
                                            continue;
                                        } else if (action.equals("2")) {
                                            usc.editStock();
                                            continue;
                                        } else if (action.equals("3")) {
                                            break;
                                        } else {
                                            System.out.println("Invalid Action");
                                        }
                                    } else {
                                        System.out.println("Invalid");
                                        break;
                                    }

                                }
                                break;
                            } else {
                                System.out.println("Invalid Role");
                            }
                        } else {
                            System.out.println("Invalid Password");
                        }
                    } else {
                        System.out.println("Invalid Name");
                    }
                }
            } else if (action.equals("2")) {
                break;
            } else {
                System.out.println("Invalid Input");
            }

        }
        scanner.close();
    }
}