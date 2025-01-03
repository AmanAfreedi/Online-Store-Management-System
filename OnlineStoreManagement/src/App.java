

import java.sql.*;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        AppDao ad = new AppDao();
        Scanner sc = new Scanner(System.in);
        System.out.print("1.New User");
        System.out.print("  2.Existing User");
        System.out.println("  3 Admin");
        System.out.print("Enter The Number : ");
        int a = sc.nextInt();
        if(a==0){
            ad.removeCustomer();
        }
        
        if (a == 1) {
            try {
                NewUser newuser = new NewUser();
                System.out.println("Enter userID : ");
                newuser.setID(sc.nextInt());
                System.out.println("Enter Your Name");

                newuser.setName(sc.next());

                System.out.println("Enter Your Email");

                newuser.setEmail(sc.next());
                System.out.println("Set a new password : ");
                newuser.setPassword(sc.next());

                ad.addCustomer(newuser);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (a == 2) {
            System.out.print ("Enter UserID : ");
            int uname=sc.nextInt();
            System.out.print ("Enter Your PassWord: ");
            String upass=sc.next();
            ad.login(uname, upass);
        }
        if(a==3){
            
            System.out.println("Enter Your PassWord : ");
            int pass=sc.nextInt();
            int ps=12345;
            if(pass==ps){
            System.out.print ("1.Add Products ");
            System.out.print("2.View Products ");
            System.out.print("3.Add Stock ");
            int k=sc.nextInt();
            if(k==1){
            System.out.print("Enter ProductID : ");
            int id =sc.nextInt();
            System.out.print("Enter Name : ");
            String N=sc.next();
            System.out.print("Enter Price : ");
            int p=sc.nextInt();
            System.out.print("Enter Stock : ");
            int r=sc.nextInt();
            ad.addproduct(id, N, p, r);
            System.out.println("Product Added Succesfully");
            }
            if(k==2){
                ad.viewProducts();
            }
            if(k==3){
                System.out.println("Enter the ProductId of the product you want to add : ");
                int id=sc.nextInt();
                System.out.println("Enter the qantity you wants to add : ");
                int qant =sc.nextInt();
                ad.addStock(id,qant);
            }
        }else{
            System.out.println("Incorrect password please try again");
        }
        }

    }
}
