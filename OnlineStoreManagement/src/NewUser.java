
public class NewUser {
    private int ID ;
    private String Name ;
    private String Email;
    private String password;
    
    
    public String getName(){
        return this.Name;
    }
    public String getEmail(){
        return this.Email;
    }
    public String setEmail(String e){
        return this.Email=e;
    }
    public String setName(String e){
        return this.Name=e;
    }
    public void setID(int ID){
        this.ID=ID;
    }
    public int getID(){
        return this.ID;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
       return this.password;
    }
}
