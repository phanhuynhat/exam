package com.example.ecommerce.util;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPass {
  public static String encrupt(String password){
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    return encoder.encode(password);
  }
  public static void main(String[] args) {
    String password="123456789";
    String pass=encrupt(password);
    System.out.println("Password: "+pass);
  }
}
