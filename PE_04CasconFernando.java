import java.util.InputMismatchException;
import java.util.Scanner;
public class PE_04CasconFernando {
    Scanner sc = new Scanner(System.in);
    int lightsMenu = 0;
    int lightChoice = 0;
    String livingRoom = "off";
    String restRoom = "off";
    String kitchen = "off";
    String room1 = "off";
    String room2 = "off";
    String room3 = "off";
    String allLights = "off";
    public static void main(String[] args) {
        PE_04CasconFernando p = new PE_04CasconFernando();
        p.principal();
    }

    public void principal(){
        boolean validation = true;              //bucles variable
        int houseOptions = 0;                   //menu variables
        int temperatureOptions = 0;             //
        int roomChoice = 0;                     //
        String temperatureStatus = "off";       //variables for temperature
        int currentTemperature = 20;            //        
        int tempLivingRoom = 20;                //
        int tempRestroom = 20;                  //
        int tempKitchen = 20;                   //
        int tempRoom1 = 20;                     //
        int tempRoom2 = 20;                     //
        int tempRoom3 = 20;                     //
        String blindsMenu = "";                 //variables for blinds
        String blindState = "";                 //


        System.out.println("Welcome!");
        //when the option is 4 you exit of the main menu
        do {
            while (validation) {
                System.out.println("Please, choose your desired option:");
                System.out.println("1. Temperature \n2. Blinds \n3. Lights \n4. Exit");

                try {
                    houseOptions = sc.nextInt();
                    sc.nextLine();  

                    if (houseOptions < 1 || houseOptions > 4) {
                            System.out.println("Error, insert a valid option");
                    } else {
                        validation = false;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Error, insert a valid format");
                    sc.nextLine();
                }
            }
            //reset of validation for the next time 
            validation = true;
            switch (houseOptions) {
                case 1:
                //temperature control
                    do {
                        while (validation) {
                            System.out.println("Temperature menu:");
                            System.out.println("1. Turn on/off");
                            System.out.println("2. Adjust all the house");
                            System.out.println("3. Adjust a room");
                            System.out.println("4. View current temperatures");
                            System.out.println("5. Program an hour");
                            System.out.println("6. Return to main menu");

                            try {
                                temperatureOptions = sc.nextInt();
                                sc.nextLine();

                                if (temperatureOptions < 1 || temperatureOptions > 6) {
                                    System.out.println("Error, insert a valid option.");
                                } else {
                                    validation = false;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Error, insert a valid format.");
                                sc.nextLine();
                            }
                        }
                        validation = true;
                    
                        switch (temperatureOptions) {
                            case 1:
                            //turn on/off temperature
                                temperatureStatus = toggleState();
                                System.out.println("Temperature system turned " + temperatureStatus);
                            break;

                            case 2:
                            //control all the house
                                if (temperatureStatus.equalsIgnoreCase("off")) {
                                    System.out.println("System is off, turn it on first");

                                } else {
                                    //variable for the new temperature
                                    currentTemperature = updateTemperature(currentTemperature);

                                    //if temperature is higher than 9, that means that the user putted the temperature itself,
                                    //so we change the temperature of all the rooms to the same
                                    if (currentTemperature > 9) {
                                        tempLivingRoom = tempRestroom = tempKitchen = tempRoom1 =  tempRoom2 = tempRoom3 = currentTemperature;

                                    } else {
                                        //if not, we adjust the temperature by +1,+2,-1,-2
                                        tempLivingRoom += currentTemperature;
                                        tempRestroom += currentTemperature;
                                        tempKitchen += currentTemperature;
                                        tempRoom1 += currentTemperature;
                                        tempRoom2 += currentTemperature;
                                        tempRoom3 += currentTemperature;
                                    }   

                                }
                            break;

                            case 3:
                            //adjust single room
                                if (temperatureStatus.equalsIgnoreCase("off")) {
                                    System.out.println("System is off, turn it on first");

                                } else {
                                    roomChoice = roomChoice();
                                    currentTemperature = updateTemperature(currentTemperature);

                                    //adjust manually the change of every room
                                    switch (roomChoice) {
                                        case 1:
                                            //same logic as before
                                            if (currentTemperature > 9) {
                                                tempLivingRoom = currentTemperature;

                                            } else {
                                                tempLivingRoom += currentTemperature;
                                            }

                                        break;

                                        case 2:
                                            if (currentTemperature > 9) {
                                                tempRestroom = currentTemperature;

                                            } else {
                                                tempRestroom += currentTemperature;
                                            }
                                            
                                        break;

                                        case 3:
                                            if (currentTemperature > 9) {
                                                tempKitchen = currentTemperature;

                                            } else {
                                                tempKitchen += currentTemperature;
                                            }
                                            
                                        break;

                                        case 4:
                                            if (currentTemperature > 9) {
                                                tempRoom1 = currentTemperature;

                                            } else {
                                                tempRoom1 += currentTemperature;
                                            }
                                            
                                        break;

                                        case 5:
                                            if (currentTemperature > 9) {
                                                tempRoom2 = currentTemperature;

                                            } else {
                                                tempRoom2 += currentTemperature;
                                            }
                                            
                                        break;

                                        case 6:
                                            if (currentTemperature > 9) {
                                                tempRoom3 = currentTemperature;

                                            } else {
                                                tempRoom3 += currentTemperature;
                                            }
                                            
                                        break;
                                    }
                                }

                            break;

                            case 4:
                            //Show the temperature of every room
                                System.out.println("Living Room: " + tempLivingRoom + "ºC");
                                System.out.println("Rest Room: " + tempRestroom + "ºC");
                                System.out.println("Kitchen: " + tempKitchen + "ºC");
                                System.out.println("Room 1: " + tempRoom1 + "ºC");
                                System.out.println("Room 2: " + tempRoom2 + "ºC");
                                System.out.println("Room 3: " + tempRoom3 + "ºC");
                            break;

                            case 5:
                            break;
                        }  
                    } while (temperatureOptions != 6);
                break;

                case 2:
                do {
                    //menu de las persianas
                    System.out.println("Blinds control:");
                    System.out.println("a. Open all blinds");
                    System.out.println("b. Close all blinds");
                    System.out.println("c. Return to main menu");

                    blindsMenu = sc.nextLine();

                    switch (blindsMenu.toLowerCase()) {
                        case "a":
                            blindState = "open";
                            System.out.println("All blinds opened.");
                        break;

                        case "b":
                            blindState = "closed";
                            System.out.println("All blinds closed.");
                        break;
                        }

                    System.out.println("Current blinds state: " + blindState);

                    } while (!blindsMenu.equalsIgnoreCase("c"));
                break;

                case 3:
                    do {
                        System.out.println("Lights control:");
                        System.out.println("1. Control a room. ");
                        System.out.println("2. Control all the rooms. ");
                        System.out.println("3. Show the real state of the lights. ");
                        System.out.println("4. Exit. ");

                        while (validation) {
                            try {
                                lightsMenu = sc.nextInt();
                                sc.nextLine();

                                if (lightsMenu < 1 || lightsMenu > 4) {
                                    System.out.println("Error, insert a valid option.");

                                } else {
                                    validation = false;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Error, insert a valid format.");
                                sc.nextLine();
                            }
                        }
                        validation = true;

                        switch (lightsMenu) {
                            case 1:
                                lightChoice = roomChoice();
                                lightsState(lightChoice);
                            break;

                            case 2:
                                allRooms();
                            break;

                            case 3:
                                realState();
                            break;
                        }

                    } while (lightsMenu != 4);

                break;
            }
            

        } while (houseOptions != 4);

        sc.close();
    }

    public int roomChoice() {
        //method for room selection
        int room = 0;
        do {
            System.out.println("Choose a room: ");
            System.out.println("1. Living Room.\n2. Restroom.\n3. Kitchen.\n4. Room 1.\n5. Room 2.\n6. Room 3");

            try {
                room = sc.nextInt();
                sc.nextLine();

                if (room < 1 ||room > 6) {
                    System.out.println("Error, insert a valid option.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error, insert a valid format.");
                sc.nextLine();
            }

        } while (room < 1 || room > 6);
        return room;
    }

    //Turn on/off function
    public String toggleState() {
        String state;
        do {
            System.out.print("Please, choose your option (on/off): ");
            state = sc.nextLine();
        } while (state.equals("on") &&  state.equals("off"));

        return state;
    }

    /***********************
    TEMPERATURE FUNCTIONS
    ***********************/

    //increase or decrease temperature
    public int temperatureMenu() {
        int option = 0;
        boolean validation = true;

        while (validation) {
            System.out.println("Please, choose an option:");
            System.out.println("1. Increase by 1.");
            System.out.println("2. Increase by 2");
            System.out.println("3. Decrease by 1");
            System.out.println("4. Decrease by 2.");
            System.out.println("5. Insert temperature");

            try {
                option = sc.nextInt();
                sc.nextLine();

                if (option < 1 || option > 5) {
                    System.out.println("Error, insert a valid option.");

                } else {
                    validation = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error, insert a valid format.");
                sc.nextLine();
            }
        }
        validation = true;
        return option;
    }

    //update the temperature
    public int updateTemperature(int currentTemperature) {
        int option = 0;
        option = temperatureMenu();

        switch (option) {
            case 1: 
                currentTemperature = 1;
            break;
            case 2: 
                currentTemperature = 2;
            break;
            case 3: 
                currentTemperature = -1;
            break;
            case 4: 
                currentTemperature = -2;
            break;
            case 5:
                currentTemperature = insertTemperature();
            break;
        }
        return currentTemperature;
    }

    //method for the case where user insert the temperature manually
    public int insertTemperature() {
        int currentTemperature = 0;

        do {
            try {
                System.out.println("Insert a temperature:");
                currentTemperature = sc.nextInt();
                sc.nextLine();

                if (currentTemperature < 10 || currentTemperature > 35) {
                    System.out.println("Error, the range must be between 10 and 35.");
                } 

            } catch (InputMismatchException e) {
                System.out.println("Error, insert a valid format.");
                sc.nextLine();
            }

        } while (currentTemperature < 10 || currentTemperature > 35);
        
        if (currentTemperature < 10) {
            currentTemperature = 10;
        } 

        if (currentTemperature > 35) {
            currentTemperature = 35;
        } 

        return currentTemperature;
    }

    /***********************
    BLINDS FUNCTIONS
    ***********************/


    /***********************
    LIGHTS FUNCTIONS
    ***********************/
    public String lightState() {
        String state = "";
        System.out.println("");
        return state;
    }

    public void lightsState(int roomChoice) {
        String state = toggleState();
        String room = "";
        boolean comprovation = false;

        switch (roomChoice) {
            case 1: 
                if (livingRoom == state) {
                    comprovation = true;
                }
                livingRoom = state;
                room = "Living Room";
            break;

            case 2: 
                if (restRoom == state) {
                    comprovation = true;
                }
                restRoom = state;
                room = "Rest Room";
            break;

            case 3: 
                if (kitchen == state) {
                    comprovation = true;
                }
                kitchen = state;
                room = "Kitchen";
            break;

            case 4:
                if (room1 == state) {
                    comprovation = true;
                }
                room1= state;
                room = "Room 1";
            break;

            case 5: 
                if (room2 == state) {
                    comprovation = true;
                }
                room2 = state;
                room = "Room 2";
            break;

            case 6:
                if (room3 == state) {
                    comprovation = true;
                }
                room3 = state;
                room = "Room 3";
            break;

            default:
                if (comprovation) {
                    System.out.println(room + " has already the lights " + state);
                } else {    
                    System.out.println(room + " turned " + state + " correctly.");
                }
            break;
        }
    }

    public void allRooms() {
        System.out.println("Manual - turn on or turn off (on/off): ");
        allLights = sc.nextLine();
        System.out.println("All rooms turned " + allLights + " correctly.");

        livingRoom = allLights;
        restRoom = allLights;
        kitchen = allLights;
        room1 = allLights;
        room2 = allLights;
        room3 = allLights;  
    }

    public void realState() {
        System.out.println("Living room: " + livingRoom);
        System.out.println("Kitchen: " + kitchen);
        System.out.println("Restroom: " + restRoom);
        System.out.println("Room 1: " + room1);
        System.out.println("Room 2: " + room2);
        System.out.println("Room 3: " + room3);
    }
}
