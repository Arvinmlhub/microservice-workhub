package com.metlife.service;

import java.util.Scanner;

public interface ActorService {
    void addBooking(Scanner scanner);

    void displayActorAndMoviesDetails();

    void searchByTpeById(int typeId, String type);

    void updateActorDetails(Scanner scanner);

    void deleteActorAccount(Scanner scanner);

}
