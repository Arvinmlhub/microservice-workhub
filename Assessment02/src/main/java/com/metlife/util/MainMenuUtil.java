package com.metlife.util;

import com.metlife.service.ActorService;
import com.metlife.service.impl.ActorServiceImpl;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;
import java.util.Scanner;
@NoArgsConstructor
public class MainMenuUtil implements Serializable {

    public static void displayMainMenu(Scanner scanner){

        ActorService bookingService=new ActorServiceImpl();

        System.out.println(

                " 1.View the details regarding movies and actor . " +
                        " 2 Movies Search. " +
                "3 Save actor details." +
                " 4 Update Actor details. " +
                " 5.Delete actor details ");
        System.out.print("Enter above menu select operation :: ");
        try {
            int type = scanner.nextInt();scanner.nextLine();
            switch (type){
                case 0: {
                    break;
                }
                case 1: {
                    System.out.println("View the details regarding movies and actor  :: ");
                    bookingService.displayActorAndMoviesDetails();
                    break;
                }
                case 2: {
                    System.out.println("[1. Actor Name . 2 Available Language 3. Category] :: ");
                    System.out.print("Enter Search type id :: ");
                    int typeId=scanner.nextInt();scanner.nextLine();
                    System.out.print("Enter Data ");
                    String typeOfSearchData=scanner.nextLine();
                    bookingService.searchByTpeById(typeId,typeOfSearchData);
                    break;
                }case 3: {
                    System.out.println("Add actor by selecting below option  ");
                    bookingService.addBooking(scanner);
                    break;
                }
                case 4: {
                    System.out.println("Update Actor Details :: ");
                    bookingService.updateActorDetails(scanner);
                    break;
                }
                case 5: {
                    System.out.println("Delete actor account :: ");
                    bookingService.deleteActorAccount(scanner);
                    break;
                }
                default: {
                    System.err.println("Invalid Enter data::");
                    break;
                }
            }

        }catch (Exception e){
            System.err.println("Invalid Input data...");
        }
        System.out.print("Do you want to perform more operation [Yes/No] :: ");
        String condition= scanner.nextLine();
        Optional<String> discussion= Optional.of(condition);
        if(discussion.get().toLowerCase().equalsIgnoreCase("Yes"))
            displayMainMenu(scanner);

    }
}
