/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.HashMap;

/**
 *
 * @author ryanf
 */
public class user {
    public static HashMap<String, String> users = new HashMap<>();
    
    public static void addUser(String username, String password){
        users.put(username, password);
    }
}
