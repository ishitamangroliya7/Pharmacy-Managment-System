import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Customer {
    private String name;
    private String id;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;

    public Customer(String name, String id, String address, String phoneNumber, String email, String password) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Address: " + address + ", Phone Number: " + phoneNumber +
                ", Email: " + email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}

class Distributor {
    private String name;
    private String id;
    private String address;
    private String joiningDate;
    private double salary;
    private String phoneNumber;
    private String email;
    private String password;

    public Distributor(String name, String id, String address, String joiningDate, double salary,
                       String phoneNumber, String email, String password) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.joiningDate = joiningDate;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Address: " + address + ", Joining Date: " + joiningDate +
                ", Salary: " + salary + ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
}

class Order {
    private String orderId;
    private String customerId;
    private String productName;
    private double amount;
    private int quantity;

    public Order(String orderId, String customerId, String productName, double amount, int quantity) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productName = productName;
        this.amount = amount;
        this.quantity = quantity;
    }

    public String toString() {
        return "Order ID: " + orderId + ", Product Name: " + productName +
                ", Amount: " + amount + ", Quantity: " + quantity;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductName() {
        return productName;
    }

    public double getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }

    
}

class CustomerManager {
    private ArrayList<Customer> customers;
    private ArrayList<Distributor> distributors;
    private ArrayList<Order> orders;
    private static int orderIdCounter = 1000;
    private HashMap<String, Double> productPrices; // Hashtable to store product name and prices

    public CustomerManager() {
        this.customers = new ArrayList<>();
        this.distributors = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.productPrices = new HashMap<>();

        // available products
        productPrices.put("aspirin", 5.0);
        productPrices.put("paracetamol", 3.0);
        productPrices.put("ibuprofen", 7.0);
        productPrices.put("soliris",25.0);
        productPrices.put("cinryze", 115.0);
        productPrices.put("elaprase", 30.0);
        productPrices.put("cipro", 10.0);

        Customer Customer1=new Customer("ishita","1","junagadh","9023117139","iahu123@gmail.com","1234");
        Customer Customer2=new Customer("shrey","2","una","8140962271","shrey234@gmail.com","56789");
        customers.add(Customer1);
        customers.add(Customer2);

        Distributor distributor1 = new Distributor("kp", "1", "botad", "1st jan 2023", 25000,"9737594985", "kp@gmail.com", "9810");
        distributors.add(distributor1);
    }

    // Validate email
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Validate phone number
    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10}");
    }

    // Register For Customer & Store ArrayList
    public void registerCustomer(String name, String id, String address, String phoneNumber, String email, String password) {
        Scanner scanner = new Scanner(System.in);
        while (!isValidEmail(email)) {
            System.out.print("Enter a valid email: ");
            email = scanner.nextLine();
        }
        while (!isValidPhoneNumber(phoneNumber)) {
            System.out.print("Enter a valid phone number: ");
            phoneNumber = scanner.nextLine();
        }
        customers.add(new Customer(name, id, address, phoneNumber, email, password));
        System.out.println("-> Registration successful for customer: " + name);
        System.out.println();
    }

    // Register For Distributor & Store ArrayList
    public void registerDistributor(String name, String id, String address, String joiningDate, double salary,
                                    String phoneNumber, String email, String password) 
    {
        Scanner scanner = new Scanner(System.in);
        while (!isValidEmail(email)) {
            System.out.print("Enter a valid email: ");
            email = scanner.nextLine();
        }
        while (!isValidPhoneNumber(phoneNumber)) {
            System.out.print("Enter a valid phone number: ");
            phoneNumber = scanner.nextLine();
        }
        distributors.add(new Distributor(name, id, address, joiningDate, salary, phoneNumber, email, password));
        System.out.println("-> Registration successful for distributor: " + name);
        System.out.println();
    }

    // Login For Customer
    public Customer loginCustomer(String name, String password) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name) && customer.getPassword().equals(password)) {
                System.out.println("-> Customer login successful for: " + name);
                return customer;
            }
        }
        System.out.println("Invalid customer username or password");
        System.out.println();
        return null;
    }

    // Login For Distributor
    public Distributor loginDistributor(String name, String password) {
        for (Distributor distributor : distributors) {
            if (distributor.getName().equals(name) && distributor.getPassword().equals(password)) {
                System.out.println("-> Distributor login successful for: " + name);
                return distributor;
            }
        }
        System.out.println("Invalid distributor username or password");
        System.out.println();
        return null;
    }

    // Method to check if a product exists in the productPrices hashtable
    private boolean isProductAvailable(String productName) {
        return productPrices.containsKey(productName);
    }

    // Method to place an order for a customer
    public void placeOrder(Customer customer, String productName, int quantity) {
        if (!isProductAvailable(productName)) {
            System.out.println("Sorry, " + productName + " is not available.");
            return;
        }

        double productPrice = productPrices.get(productName);
        double amount = productPrice * quantity;
        String orderId = "ORD" + orderIdCounter++;

        orders.add(new Order(orderId, customer.getId(), productName, amount, quantity));
        System.out.println("Order placed successfully with ID: " + orderId);
    }

    // Method to display all available products
    public void displayAvailableProducts() {
        System.out.println();
        System.out.println("Available Products:");
        for (String productName : productPrices.keySet()) {
            System.out.println(productName + " - Price: " + productPrices.get(productName));
        }
    }

    // Display All Customer in Stored ArrayList 'customers'
    public void printAllCustomers() {
        System.out.println("All Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    // Edit customer Details Through the customerId
    public void editCustomerDetails(String customerId) {
        Customer foundCustomer = null;
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                foundCustomer = customer;
                break;
            }
        }
        
        // If customer with the provided ID is found, allow editing
        if (foundCustomer != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Editing details for customer with ID: " + customerId);
            System.out.println("Current details: " + foundCustomer);
    
            // Ask user for new details
            System.out.print("Enter new name (press Enter to skip): ");
            String newName = scanner.nextLine().trim();
            if (!newName.isEmpty()) {
                foundCustomer.setName(newName);
            }
    
            System.out.print("Enter new address (press Enter to skip): ");
            String newAddress = scanner.nextLine().trim();
            if (!newAddress.isEmpty()) {
                foundCustomer.setAddress(newAddress);
            }
    
            System.out.print("Enter new phone number (press Enter to skip): ");
            String newPhoneNumber = scanner.nextLine().trim();
            if (!newPhoneNumber.isEmpty()) {
                foundCustomer.setPhoneNumber(newPhoneNumber);
            }
    
            System.out.print("Enter new email (press Enter to skip): ");
            String newEmail = scanner.nextLine().trim();
            if (!newEmail.isEmpty()) {
                foundCustomer.setEmail(newEmail);
            }

            System.out.print("Enter new Password (press Enter to skip): ");
            String newPassword = scanner.nextLine().trim();
            if (!newPassword.isEmpty()) {
                foundCustomer.setPassword(newPassword);
            }
    
            System.out.println("Customer details updated successfully.");
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }
    
    // Delete customer thorugh the customerId 
    public void deleteCustomer(String customerId) {
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(customerId)) {
                index = i;
                break;
            }
        }
    
        // If customer with the provided ID is found, remove it
        if (index != -1) {
            customers.remove(index);
            System.out.println("Customer with ID " + customerId + " deleted successfully.");
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }
    
    // Place Ordered For Customer Throgh the Distributor
    public void placeOrderForCustomer(String customerId) {
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getId().equals(customerId)) {
                customer = c;
                break;
            }
        }
    
        if (customer == null) {
            System.out.println("Customer with ID " + customerId + " not found.");
            return;
        }
    
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. See order details for customer " + customerId);
            System.out.println("2. Edit order details for customer " + customerId);
            System.out.println("3. Entered Ordered for customer " + customerId);
            System.out.println("4. Back");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            System.out.println();
            scanner.nextLine();
    
            switch (option) {
                case 1:
                    System.out.println("Order details for customer " + customerId + ":");
                    boolean foundOrders = false;
                    for (Order order : orders) {
                        if (order.getCustomerId().equals(customerId)) {
                            System.out.println(order);
                            System.out.println();
                            foundOrders = true;
                        }
                    }
                    if (!foundOrders) {
                        System.out.println("No orders found for customer " + customerId);
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Editing order details for customer " + customerId + ":");
                    System.out.print("Enter order ID to edit: ");
                    String orderId = scanner.nextLine();
                    boolean foundOrder = false;
                    for (Order order : orders) {
                        if (order.getCustomerId().equals(customerId) && order.getOrderId().equals(orderId)) {
                            // Update order details
                            System.out.print("Enter new Product Name (press Enter to skip): ");
                            String newProductName = scanner.nextLine().trim().toLowerCase();
                            if (!newProductName.isEmpty()) {
                                // Check if the new product available in the productPrices hashtable
                                if (isProductAvailable(newProductName)) {
                                    order.setProductName(newProductName);
                                    // Update the amount based on the new product price
                                    double productPrice = productPrices.get(newProductName);
                                    order.setAmount(productPrice * order.getQuantity());
                                    System.out.println("Product name updated successfully.");
                                } else {
                                    System.out.println("Product name not found in the available products.");
                                }
                            }
    
                            System.out.print("Enter new Product Quantity (press Enter to skip): ");
                            String quantityInput = scanner.nextLine().trim();
                            if (!quantityInput.isEmpty()) {
                                try {
                                    int newQuantity = Integer.parseInt(quantityInput);
                                    order.setQuantity(newQuantity);
                                    order.setAmount(productPrices.get(order.getProductName()) * newQuantity);
                                    System.out.println("Quantity updated successfully.");
                                    System.out.println();
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid quantity input.");
                                    System.out.println();
                                }
                            }
                            foundOrder = true;
                            break;
                        }
                    }
                    if (!foundOrder) {
                        System.out.println("Order with ID " + orderId + " not found for customer " + customerId);
                    }
                    break; 
                case 3:
                    System.out.println("Adding order for customer " + customerId + ":");
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine().toLowerCase();
                    if (!isProductAvailable(productName)) {
                        System.out.println("Product not found in the available products.");
                        System.out.println();
                        break;
                    }
                
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); 
                
                    double productPrice = productPrices.get(productName);
                    double amount = productPrice * quantity;
                    String orderId1 = "ORD" + orderIdCounter++;
                    orders.add(new Order(orderId1, customerId, productName, amount, quantity));
                    System.out.println("Order placed successfully with ID: " + orderId1);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.out.println();
                    return;
                default:
                    System.out.println("Invalid option");
                    System.out.println();
            }
        }
    }
    


}

class PharmacySystem {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("******* Home Page ******");
            System.out.println("1 -> Register");
            System.out.println("2 -> Login");
            System.out.println("3 -> Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            System.out.println();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("********* Registertion Page *********");
                    System.out.println("1 -> Register Customer");
                    System.out.println("2 -> Register Distributor");
                    System.out.print("Choose an option: ");
                    int registerOption = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (registerOption) {
                        case 1:
                            System.out.println();
                            System.out.print("Enter customer name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter customer ID: ");
                            String id = scanner.nextLine();
                            System.out.print("Enter address: ");
                            String address = scanner.nextLine();
                            System.out.print("Enter phone number: ");
                            String phoneNumber = scanner.nextLine();
                            System.out.print("Enter email: ");
                            String email = scanner.nextLine();
                            System.out.print("Enter password: ");
                            String regPassword = scanner.nextLine();
                            System.out.print("Confirm password: ");
                            String confirmPassword = scanner.nextLine();

                            if (!regPassword.equals(confirmPassword)) {
                                System.out.println("Passwords do not match. Registration failed.");
                                break;
                            }

                            customerManager.registerCustomer(name, id, address, phoneNumber, email, regPassword);
                            break;
                        case 2:
                            System.out.println();
                            System.out.print("Enter distributor name: ");
                            String distName = scanner.nextLine();
                            System.out.print("Enter distributor ID: ");
                            String distId = scanner.nextLine();
                            System.out.print("Enter address: ");
                            String distAddress = scanner.nextLine();
                            System.out.print("Enter joining date: ");
                            String joiningDate = scanner.nextLine();
                            System.out.print("Enter salary: ");
                            double salary = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Enter phone number: ");
                            String distPhoneNumber = scanner.nextLine();
                            System.out.print("Enter email: ");
                            String distEmail = scanner.nextLine();
                            System.out.print("Enter password: ");
                            String distPassword = scanner.nextLine();
                            System.out.print("Confirm password: ");
                            String distConfirmPassword = scanner.nextLine();

                            if (!distPassword.equals(distConfirmPassword)) {
                                System.out.println("Passwords do not match. Registration failed.");
                                break;
                            }

                            customerManager.registerDistributor(distName, distId, distAddress, joiningDate,
                                    salary, distPhoneNumber, distEmail, distPassword);
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                    break;
                case 2:
                    System.out.println("****** Login Page ******");
                    System.out.println("1 -> Login as Customer");
                    System.out.println("2 -> Login as Distributor");
                    System.out.print("Choose an option: ");
                    int loginOption = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (loginOption) {
                        case 1:
                            System.out.println();
                            System.out.println("****** Login Customer Page ******");
                            System.out.print("Enter customer name: ");
                            String loginName = scanner.nextLine();
                            System.out.print("Enter password: ");
                            String loginPassword = scanner.nextLine();
                            Customer loggedInCustomer = customerManager.loginCustomer(loginName, loginPassword);
                            if (loggedInCustomer != null) {
                                while (true) {
                                    System.out.println();
                                    System.out.println("****** Customer Home Page ******");
                                    System.out.println("1. Add Order");
                                    System.out.println("2. About Us");
                                    System.out.println("3. Contact Us");
                                    System.out.println("4. Display All Product");
                                    System.out.println("5. Logout");
                                    System.out.print("Choose an option: ");
                                    int userOption = scanner.nextInt();
                                    scanner.nextLine(); 

                                    switch (userOption) {
                                        case 1:
                                            System.out.println();
                                            System.out.println("****** Customer Add Order Page ******");
                                            System.out.print("Enter Product Name: ");
                                            String productName = scanner.nextLine().toLowerCase();
                                            System.out.print("Enter Quantity: ");
                                            int quantity = scanner.nextInt();
                                            customerManager.placeOrder(loggedInCustomer,productName, quantity);
                                            break;
                                        case 2:
                                            System.out.println();
                                            System.out.println("****** About Us ******");
                                            System.out.println("About Us: Welcome to our pharmacy! We provide a wide range of medications and healthcare products.");
                                            break;
                                        case 3:
                                            System.out.println();
                                            System.out.println("****** Contact Us ******");
                                            System.out.println("For any inquiries, please contact us at: ");
                                            System.out.println("Phone: 123-456-7890");
                                            System.out.println("Address: 123 Pharmacy Street, Ahmedabad, India");
                                            break;
                                        case 4:
                                            customerManager.displayAvailableProducts();
                                            break;
                                        case 5:
                                            System.out.println();
                                            System.out.println("Logged out.");
                                            System.out.println();
                                            break;
                                        default:
                                            System.out.println();
                                            System.out.println("Invalid option");
                                    }

                                    if (userOption == 5) {
                                        break;
                                    }
                                }
                            }
                            break;
                        case 2:
                            System.out.println();
                            System.out.println("****** Login Distributor Page ******");
                            System.out.print("Enter distributor name: ");
                            String distLoginName = scanner.nextLine();
                            System.out.print("Enter password: ");
                            String distLoginPassword = scanner.nextLine();
                            Distributor loggedInDistributor = customerManager.loginDistributor(distLoginName, distLoginPassword);
                            if (loggedInDistributor != null) {
                                while (true) {
                                    System.out.println();
                                    System.out.println("****** Distributor Home Page ******");
                                    System.out.println("1. Display all customer details");
                                    System.out.println("2. Edit customer details");
                                    System.out.println("3. Delete customer");
                                    System.out.println("4. Order for customer");
                                    System.out.println("5. Display All Product");
                                    System.out.println("6. Logout");
                                    System.out.print("Choose an option: ");
                                    int distributorOption = scanner.nextInt();
                                    scanner.nextLine(); // Consume newline

                                    switch (distributorOption) {
                                        case 1:
                                            System.out.println();
                                            System.out.println("****** All Customer Details ******");
                                            customerManager.printAllCustomers();
                                            break;
                                        case 2:
                                            System.out.println();
                                            System.out.println("****** Edit Customer Details ******");
                                            System.out.print("Enter customer ID to edit: ");
                                            String editCustomerId = scanner.nextLine();
                                            customerManager.editCustomerDetails(editCustomerId);
                                            break;
                                        case 3:
                                            System.out.println();
                                            System.out.println("****** Delete Customer Details ******");
                                            System.out.print("Enter customer ID to delete: ");
                                            String deleteCustomerId = scanner.nextLine();
                                            customerManager.deleteCustomer(deleteCustomerId);
                                            break;
                                        case 4:
                                            System.out.println();
                                            System.out.println("****** Order For Customer ******");
                                            System.out.print("Enter customer ID to order for: ");
                                            String customerId = scanner.nextLine();
                                            customerManager.placeOrderForCustomer(customerId);
                                            break;
                                        case 5:
                                            customerManager.displayAvailableProducts();
                                            break;
                                        case 6:
                                            System.out.println();
                                            System.out.println("Logged out.");
                                            break;
                                        default:
                                            System.out.println();
                                            System.out.println("Invalid option");
                                    }

                                    if (distributorOption == 6) {
                                        break;
                                    }
                                }
                            }
                            break;
                        default:
                            System.out.println();
                            System.out.println("Invalid option");
                    }
                    break;
                case 3:
                    System.out.println("Exit...");
                    System.exit(0);
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid option");
            }
        }
    }
}
