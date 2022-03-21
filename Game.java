/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    
    public static void main(String[]args){
        Game game = new Game();
        game.play();
    }
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        //first floor rooms
        Room entrance, diningRoom, kitchen, kitchenBathroom, livingRoom, firstFloorCloset,
        //second floor rooms
        hallway,library,masterBedroom,masterBathroom,office,secondFloorCloset,
        //third floor rooms
        basement, laundry, utilityCloset, dungeon ;
      
        //first floor items
        Item entranceMatch, dinningBattery, kitchenKnife, kitchenbathroomKey, livingroomNewspaper, firstfloorclosetMatch,
        //second floor items
        hallwayPainting, libraryBook, masterbedroomCarKeys, masterbathroomKey, officeGun, secondfloorclosetShovel,
        //0 floor items
        basementBottle, laundrySoap, utilityclosetWatch, dungeonBones;
        
        // initialise first floor items
        entranceMatch = new Item ("A Match: \n To light the torch", 1);
        dinningBattery = new Item ("A Car battery:\n A little scratched up but appears to be in good condition", 300);
        kitchenKnife = new Item ("A bloody kitchen knife:\n Maybe it's ketchup on the knife? Could be used a weapon", 10);
        kitchenbathroomKey = new Item("Black Key:\n A random key, I wonder what it can open..", 3);
        livingroomNewspaper = new Item ("The Dark meadows Daily Newspaper:\n It's dated March 21st 1967", 5);
        firstfloorclosetMatch = new Item ("A Match: \n To light the torch", 1);
        
        // initialise second floor items
        hallwayPainting = new Item ("A Portrait Painting:\n Looks like it's a painting of an old man \n why does it feel like his eyes are follwing me?", 10);
        libraryBook = new Item ("Rituals of the Undead Book:\n the book is open with pages torn off", 15);
        masterbedroomCarKeys = new Item ("Car Keys:\n Looks like keys for an old truck", 3);
        masterbathroomKey = new Item ("Red Key:\n A random key, I wonder what it can open..", 3);
        officeGun = new Item ("Old Rusty Gun:\n Looks old but working and loaded", 5);
        secondfloorclosetShovel = new Item ("Bloody shovel:\n Is that blood or rust?", 25);
        
        // initialise 0 floor items
        basementBottle = new Item ("Beer Bottle:\n A dusty old bottle with something inside", 5);
        laundrySoap = new Item ("Bar of Soap:\n The only thing clean here", 2);
        utilityclosetWatch = new Item ("A broken Pocket Watch:\n I guess telling time does not matter right now", 2);
        dungeonBones = new Item ("A Pile of Bones:\n I hope those aren't human bones...", 20);
        
        
        
        
        //first floor rooms
        entrance = new Room("main entrance of the house", entranceMatch);
        diningRoom = new Room("dining room", dinningBattery);
        kitchen = new Room("kitchen room",kitchenKnife);
        kitchenBathroom = new Room("kitchen's bathroom", kitchenbathroomKey);
        livingRoom = new Room("living room",livingroomNewspaper);
        firstFloorCloset = new Room("a closet",firstfloorclosetMatch);
        
        //Second floor rooms
        hallway = new Room("second floor hallway", hallwayPainting);
        library = new Room("a library", libraryBook);
        masterBedroom = new Room("the master bedroom", masterbedroomCarKeys);
        masterBathroom = new Room("the master bathroom", masterbathroomKey);
        office = new Room("office room", officeGun);
        secondFloorCloset = new Room("a closet", secondfloorclosetShovel);
        
        //0 floor rooms
        basement = new Room("the basement", basementBottle);
        laundry = new Room("the laundry room", laundrySoap);
        utilityCloset = new Room(" a utility closet", utilityclosetWatch);
        dungeon = new Room ("a dungeon", dungeonBones);
        
        
        // initialise room exits
        entrance.setExit("up", hallway);
        entrance.setExit("down", basement);
        entrance.setExit("west", diningRoom);
        entrance.setExit("east", livingRoom);
        
        diningRoom.setExit("east", entrance);
        diningRoom.setExit("north", kitchen);
        
        
        kitchen.setExit("south", diningRoom);
        kitchen.setExit("east", kitchenBathroom);
        
        kitchenBathroom.setExit("south", livingRoom);
        kitchenBathroom.setExit("west", kitchen);
        
        livingRoom.setExit("north", kitchenBathroom);
        livingRoom.setExit("east", entrance);
        livingRoom.setExit("west", firstFloorCloset);
        
        
        hallway.setExit("down", entrance);
        hallway.setExit("north", library);
        hallway.setExit("west", office);
        hallway.setExit("east", masterBedroom);
        
        office.setExit("north", secondFloorCloset);
        office.setExit("east", hallway);
        
        secondFloorCloset.setExit("south", office);
        
        library.setExit("south", hallway);
        
        masterBedroom.setExit("north", masterBathroom);
        masterBedroom.setExit("west", hallway);
        
        
        masterBathroom.setExit("south", masterBedroom);
        
        
        basement.setExit("up", entrance);
        basement.setExit("east", laundry);
        basement.setExit("south", utilityCloset);
        
        laundry.setExit("west", basement);
        
        utilityCloset.setExit("north", basement);
        
        dungeon.setExit("up", basement);
        
        
        
        
        
        
        

        currentRoom = entrance;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case LOOK:
                look();
                break;
                
            case EAT:
                eat();
                break;
                
        }
        return wantToQuit;
    }

    // implementations of user commands:

    private void look()
    {
        System.out.println("To be added!");
    }
    private void eat()
    {
        System.out.println("You have eaten now and you are no hungry any more");
    }
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
