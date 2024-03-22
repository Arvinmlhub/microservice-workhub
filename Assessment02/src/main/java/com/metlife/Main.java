package com.metlife;

import com.metlife.util.MainMenuUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        try(Scanner scanner=new Scanner(System.in);) {
            MainMenuUtil.displayMainMenu(scanner);

        } catch (Exception e){
            System.err.println("Error occurred try with resource block.. ");
        }







    }
}