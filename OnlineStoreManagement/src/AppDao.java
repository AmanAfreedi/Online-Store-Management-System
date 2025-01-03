

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;

public class AppDao {
    public static void showpass(String Name,String Email){
        try {
            String Query = "Select * from customers where customerName= ? and email =?";
            String url = "jdbc:mysql://localhost:3306/";
            String DB = "store";
            String user = "root";
            String password = "qazxsw12";
            Connection con =DriverManager.getConnection(url+DB, user, password);
            PreparedStatement ps=con.prepareStatement(Query);
            ps.setString(1, Name);
            ps.setString(2, Email);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String pass =rs.getString("password");
                System.out.println("Your Password is : "+pass);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addStock(int id, int Qant) {
        try {
            String Query = "Select * from products where productID= ?";
            String url = "jdbc:mysql://localhost:3306/";
            String DB = "store";
            String user = "root";
            String password = "qazxsw12";
            Connection con =DriverManager.getConnection(url+DB, user, password);
            PreparedStatement ps =con.prepareStatement(Query);
            ps.setInt(1, id);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                int stock =rs.getInt("stock");
                int newStock =stock+Qant;
                String Qu = "UPDATE Products SET stock = ? WHERE productID= ?";
                PreparedStatement s=con.prepareStatement(Qu);
                s.setInt(1, newStock);
                s.setInt(2, id);
                s.executeUpdate();
                System.out.println("Updated Succesfully");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void order(int id, int quantity) {
        try {
            String Query = "Select * from products where productID= ?";
            String url = "jdbc:mysql://localhost:3306/";
            String DB = "store";
            String user = "root";
            String password = "qazxsw12";
            Connection con = DriverManager.getConnection(url + DB, user, password);
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int price = rs.getInt("Price");
                int quan = rs.getInt("Stock");
                if (quantity > quan) {
                    System.out.println("Insufficient Stock Avialable ");
                } else {
                    int left = quan - quantity;
                    System.out.println(
                            "Thanks for shopping with us............. \nYour total bill is $ " + quantity * price);
                    String Qu = "UPDATE Products SET stock = ? WHERE productID= ?";
                    PreparedStatement p = con.prepareStatement(Qu);
                    p.setInt(1, left);
                    p.setInt(2, id);
                    p.execute();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            ;
        }

    }

    public static void login(int userid, String pass) {
        try {
            String Query = "Select * from customers where customerID= ? AND password =?";
            String url = "jdbc:mysql://localhost:3306/";
            String DB = "store";
            String user = "root";
            String password = "qazxsw12";
            Connection con = DriverManager.getConnection(url + DB, user, password);
            PreparedStatement ps = con.prepareStatement(Query);

            ps.setInt(1, userid);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String n = rs.getString("customerName");

                System.out.println("Login Success");
                System.out.println("Welcome To our Online Store,Dear " + n);
                System.out.println("Explore Our Inventory by pressing 1");
                Scanner sc = new Scanner(System.in);
                if (sc.nextInt() == 1) {
                    viewProducts();
                }
                System.out.println("Would You like to order Something ?\n1.For Yes\n2.For NO");
                if (sc.nextInt() == 1) {
                    System.out.println("Enter the Product Id of the product you want to order ");
                    int id = sc.nextInt();
                    System.out.println("How much Quantity you want sir");
                    int q = sc.nextInt();
                    order(id, q);

                }
            } else if (!rs.next()) {
                System.out.println("Incorrect ID or Password");
                System.out.println("1.Forgot Password?");
                Scanner sc = new Scanner(System.in);
                if(sc.nextInt()==1){
                    System.out.println("Enter Your Name : ");
                    String Name=sc.next();
                    System.out.println("Enter your email : ");
                    String Email=sc.next();
                    showpass(Name, Email);
                }
                

            } else {
                System.out.println("Incorrect ID or Password");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void viewProducts() {
        try {
            String Query = "Select * from Products";
            String url = "jdbc:mysql://localhost:3306/";
            String DB = "store";
            String user = "root";
            String password = "qazxsw12";
            Connection con = DriverManager.getConnection(url + DB, user, password);
            Statement ss = con.createStatement();
            ResultSet rs = ss.executeQuery(Query);
            while (rs.next()) {
                System.out.print("ProductID : " + rs.getInt("ProductID"));
                System.out.println("  -->     ProductName : " + rs.getString("ProductName"));
                System.out.print("ProductValue $ : " + rs.getString("Price"));
                System.out.println("  -->   ProductStock: " + rs.getInt("Stock"));
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addCustomer(NewUser u) {
        String url = "jdbc:mysql://localhost:3306/";
        String DB = "Store";
        String user = "root";
        String password = "qazxsw12";
        try {

            Connection con = DriverManager.getConnection(url + DB, user, password);
            String Query = "Insert into customers(CustomerID,CustomerName,Email,password) Values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, u.getID());
            ps.setString(2, u.getName());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());

            ps.executeUpdate();
            System.out.println("ADDED");

        } catch (Exception e) {
            System.out.println("Registration Failed\nThis id is already taken,Try using diffrent and Unique ID");
            // e.printStackTrace();
        }
    }

    public static void removeCustomer() {
        String url = "jdbc:mysql://localhost:3306/";
        String DB = "Store";
        String user = "root";
        String password = "qazxsw12";
        try {

            Connection con = DriverManager.getConnection(url + DB, user, password);
            String Query = "Delete From customers Where CustomerID = 1";
            PreparedStatement ps = con.prepareStatement(Query);
            // ps.setInt(1, u.getID());

            System.out.println("Removed");
            ps.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void addproduct(int ProductID, String productName, int price, int stock) {
        String url = "jdbc:mysql://localhost:3306/";
        String DB = "Store";
        String user = "root";
        String password = "qazxsw12";
        try {
            Connection con = DriverManager.getConnection(url + DB, user, password);
            String Query = "Insert into products(ProductID,ProductName,price,stock) Values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, ProductID);
            ps.setString(2, productName);
            ps.setInt(3, price);
            ps.setInt(4, stock);
            System.out.println("ADDED");
            ps.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
