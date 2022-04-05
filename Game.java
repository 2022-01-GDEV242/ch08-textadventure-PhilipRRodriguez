/**
 *  This class is the main class of the "Haunted House" application. 
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 * 
 * @author  Philip Rodriguez
 * @version 2022.04.04
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room prevRoom;
    
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
        Item entranceItem[] = { new Item ("A Match: \n To light the torch", 1),
                                new Item ("Polaroid:\n Looks like a happy family", 1)};
                                
        Item dinningItem[] = { new Item ("A Car battery:\n A little scratched up but appears to be in good condition", 300)};
        
        
        Item kitchenItem[] = { new Item ("A bloody kitchen knife:\n Maybe it's ketchup on the knife? Could be used a weapon", 10),
                               new Item ("A rusty spoon:\n I wonder how old these are", 5)};
          
                               
        Item kitchenBathroomItem[] = {new Item("Black Key:\n A random key, I wonder what it can open..", 3)};
        
        
        Item livingRoomItem[] = {new Item ("The Dark meadows Daily Newspaper:\n It's dated March 21st 1967", 5)};
                                
        Item firstFloorClosetItem[] = {new Item ("A Match: \n To light the torch", 1)};
        
        
        
        // initialise second floor items
        Item hallwayItem[] = {new Item ("A Portrait Painting:\n Looks like it's a painting of an old man \n why does it feel like his eyes are follwing me?", 10),
                               new Item("An old wallet:\n looks empty and torn up", 3)};
                               
                               
        Item libraryItem[] = {new Item ("Rituals of the Undead Book:\n the book is open with pages torn off", 15)};                  
        
        Item masterBedroomItem[] = {new Item ("Car Keys:\n Looks like keys for an old truck", 3)};
        
        Item masterBathroomItem[] = {new Item ("Red Key:\n A random key, I wonder what it can open..", 3)};
        
        Item officeItem[] = {new Item ("Old Rusty Gun:\n Looks old but working and loaded", 5)};
        
        Item secondFloorClosetItem [] = {new Item ("Bloody shovel:\n Is that blood or rust?", 25)};
        
        
        
        // initialise 0 floor items
        Item basementItem[] = {new Item ("Beer Bottle:\n A dusty old bottle with something inside", 5)};
        
        Item laundryItem[] = {new Item ("Bar of Soap:\n The only thing clean here", 2)};
        
        Item utilityClosetItem[] = {new Item ("A broken Pocket Watch:\n I guess telling time does not matter right now", 2)};
        
        Item dungeonItem[] = {new Item ("A Pile of Bones:\n I hope those aren't human bones...", 20)};
        
        
        
        //first floor rooms
        entrance = new Room("the main entrance of the haunted house. \nThe entrance is covered in combwebs and bugs\n and what I hope to be just ketchup stains.");
        diningRoom = new Room("the dining room\n There is rotting food on the table and flies flying around the room");
        kitchen = new Room("the kitchen room\n the room is filled with the smell of rotten food and rusty utensils");
        kitchenBathroom = new Room("the kitchen's bathroom\n Not the cleaniest bathroom, lets not stay here too long");
        livingRoom = new Room("the living room\n Can't believe people use to live here\n The TV is broken and filled with bones");
        firstFloorCloset = new Room(" a closet\n it's dark in here, is anyone here?");
        
        //Second floor rooms
        hallway = new Room("the second floor hallway\n I can hear things moving but don't see anything");
        library = new Room("a library\n A nice room filled with combwebs\n oh and some books too..");
        masterBedroom = new Room("the master bedroom\n A fancy bedframe is sitting in middle of the room\n everything else seems to be missing");
        masterBathroom = new Room("the master bathroom\n this bathroom has seen better days \n I am trying to forget the smell");
        office = new Room(" the office room \n There is a lot of papers all around the desk and broken glass");
        secondFloorCloset = new Room("a closet\n Yep this is a closet, very interesting..");
        
        //0 floor rooms
        basement = new Room("the basement\n It's a very damp, dark and moist place\n What's crawling in the cornor?");
        laundry = new Room("the laundry room \n For a place where things get cleaned, its not such a clean place");
        utilityCloset = new Room(" a utility closet\n Lots of loose cables and wiring. Does not look so safe");
        dungeon = new Room ("a dungeon \n lots of bones, combwebs and claw marks");
        
        //add items to rooms
        
entrance = addItems(entrance,entranceItem);
diningRoom = addItems(diningRoom,dinningItem);
kitchen = addItems(kitchen,kitchenItem);
kitchenBathroom = addItems(kitchenBathroom,kitchenBathroomItem);
livingRoom = addItems(livingRoom,livingRoomItem);
firstFloorCloset = addItems(firstFloorCloset,firstFloorClosetItem);
        
hallway = addItems(hallway,hallwayItem);
library = addItems(library,libraryItem);
masterBedroom = addItems(masterBedroom, masterBedroomItem);
masterBathroom = addItems(masterBathroom,masterBedroomItem);
office = addItems(office,officeItem);
secondFloorCloset = addItems(secondFloorCloset,secondFloorClosetItem);


basement = addItems(basement,basementItem);
laundry = addItems(laundry,laundryItem);
utilityCloset = addItems(utilityCloset,utilityClosetItem);
dungeon = addItems(dungeon,dungeonItem);


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
        prevRoom = null;
    }

    private Room addItems(Room room, Item items[]){
        for (int i = 0; i < items.length; i++){
            room.addItem(items[i]);
        }
        return room;
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
        System.out.println("Welcome to the Haunted House on Hill Lane");
        System.out.println("Haunted House on Hill Lane is an adventure game");
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
                
            case BACK:
                back();
                break;
                
        }
        return wantToQuit;
    }

    // implementations of user commands:

    private void look()
    {
        System.out.println("You look around but find nothing");
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
            prevRoom = currentRoom;
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private void back(){
        currentRoom = prevRoom;
        System.out.println("You went back to the previous room!\n\n" +currentRoom.getLongDescription());
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
