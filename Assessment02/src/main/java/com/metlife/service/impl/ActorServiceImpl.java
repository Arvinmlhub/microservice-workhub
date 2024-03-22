package com.metlife.service.impl;

import com.metlife.model.ActorModel;
import com.metlife.model.MoviesAndActor;
import com.metlife.repository.ActorRepository;
import com.metlife.service.ActorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ActorServiceImpl implements ActorService {

    private ActorRepository bookingRepository=new ActorRepository();;
    private Integer actorId;

    private String firstName;
    private String lastName;
    @Override
    public void addBooking(Scanner scanner) {
        List<ActorModel> actorModels=new ArrayList<>();
         try {
             boolean cond = false;
             do {
                 cond=false;
                 System.out.print("Enter first name ::");
                 firstName=scanner.nextLine();
                 System.out.print("Enter last name ::");
                 lastName=scanner.nextLine();

                 ActorModel actorModel=new ActorModel(firstName,lastName);
                 actorModels.add(actorModel);
                 System.out.print("Do you want to create more ticket [YES/NO] :: ");
                 Optional<String> con= Optional.of(scanner.nextLine());
                 if (con.get().equalsIgnoreCase("yes"))
                     cond=true;
             }while (cond);


             bookingRepository.addBooking(actorModels);

         }catch (Exception e){
             System.out.println(e.getMessage());
         }
    }

    @Override
    public void displayActorAndMoviesDetails() {
        try {
            bookingRepository.displayActorAndMoviesDetails();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void searchByTpeById(int typeId, String type) {
        try {
            List<MoviesAndActor> moviesAndActorList= bookingRepository.searchBaseOnType(typeId,type);
            if (!moviesAndActorList.isEmpty())
                moviesAndActorList.forEach(moviesAndActor -> System.out.println(moviesAndActor.getMoviesName() +" "+moviesAndActor.getActorName() +" "+moviesAndActor.getAvaliableLanguage()+" "+moviesAndActor.getMoviesCategory()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateActorDetails(Scanner scanner) {
        try {
            System.out.print("Press 1 to know all Actor and movies details ::");
            int con=scanner.nextInt(); scanner.nextLine();
            if (con==1)
                displayActorAndMoviesDetails();
            else {
                System.out.print("Enter actor id :: ");
                actorId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter first name ::");
                Optional<String> firstUserName = Optional.of(scanner.nextLine());
                System.out.print("Enter last name ::");
                lastName = scanner.nextLine();
                ActorModel actorModel = new ActorModel(actorId, firstUserName.get(), lastName);
                bookingRepository.updateBooking(actorModel);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteActorAccount(Scanner scanner) {

        try {
            System.out.print("Enter actor id :: ");
            actorId=scanner.nextInt();scanner.nextLine();
            bookingRepository.deleteActorAccount(actorId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }



}
