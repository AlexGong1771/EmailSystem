import java.util.Random;
import java.util.Scanner;

public class Email {
    private String password , department,alternate;
    private  int  capMailBox;
    private User user;


    public Email(User user) {
       this.user = user;
        System.out.println("Welcome new  user  "  + this.user.getFirstName()+ " " +  this.user.getLastName() );
        department = "";
        setAlternativeEmail();
    }

    public  String randomPassword(int length) {
        String rand = "ABCDEFGHIJKLOPQRSTUVWXYZ1234567890!@#$%";
        char[] passwordChar = new char[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(rand.length());
            passwordChar[i] = rand.charAt(randomIndex);
        }

        String password = new String(passwordChar);
         return password;
    }

    public boolean isBoxFull(){
        return capMailBox > 1000;
    }
    public void chooseDepartment(String department) {
        this.department = department;
    }

    public String generateEmail() {
        return this.user.getFirstName().toLowerCase() +
                this.user.getLastName().toLowerCase() + "@" +
                department.toLowerCase() + ".com";
    }

    public void setCapMailBox(int capMailBox) {
        this.capMailBox = capMailBox;
        System.out.println("Capacity of box is " + this.capMailBox);
    }
    public String setAlternativeEmail(){
            String stringBuilder = this.user.getFirstName().toLowerCase() +
                    this.user.getLastName().toLowerCase() + "@" +
                    "alternative.com";
        return "Your new email: "  + stringBuilder.toString();
    }
    public String changePassword(int length){
        String password = randomPassword(length);
        String generated = null;
        if (!password.isEmpty()){
             generated= randomPassword(length);
        }
        return generated;
    }

}
