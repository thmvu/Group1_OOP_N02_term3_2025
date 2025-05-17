public class User {
    private String name;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
public User(String name, String gender, String phoneNumber, String email, String address){
    this.name = name;
    this.gender = gender;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
}
public void showInfo(){
    System.out.println("== Thong Tin Ca Nhan ==");
    System.out.println("Ho va Ten     : "+name);
    System.out.println("Gioi Tinh     : "+gender);
    System.out.println("SDT           : "+phoneNumber);
    System.out.println("Email         : "+email);
    System.out.println("Dia Chi       : "+address);
}

}
