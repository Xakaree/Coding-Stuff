import java.util.*;
import java.io.*;

public class Base {

    //Class Variables for all methods

    //General User Info
    static String name;
    static String charClass;
    static boolean alive = true;
    static int progress = 0;
    static int karma = 0;
    static double stamina = 50;
    //NPC interaction
    static int masen = 0;
    static int lara = 0;

    //User Stats
    static int money = 15;
    static int lvl = 1;
    static int xp = 0;
    static int nxtLvl = lvl * 85;
    static double maxHP;
    static double HP;
    static double def;
    static double dmg;
    static double crit;

    //Enemy Stats
    static double enmyCount;
    static double enmyHP;
    static double enmyDef;
    static double enmyDmg;
    static double enmyCrit;

    //Combat Variables
    static double defChange;
    static double dmgChange;
    static double critChange;

    static double enmyDefChange;
    static double enmyDmgChange;
    static double enmyCritChange;

    public static void main(String[] args) throws IOException {
        //Variable Deceleration
        int c, x;
        boolean a = true, b = true, load = false;
        String y;
        String fileName = "charSheet";
        //Check for Save
        File file = new File(fileName);
        Scanner keyboard = new Scanner(System.in);
        if (file.exists()) {
            System.out.println("Would you like to Load:" + fileName + " a previous Save?");
            System.out.println("1:Yes\n" + "2:No");
            x = keyboard.nextInt();
            while (a) {
                switch (x) {
                    case 1:
                        loadChar();
                        load = true;
                        a = false;
                        break;
                    case 2:
                        load = false;
                        a = false;
                        break;
                    default:
                        System.out.println("Load save?");
                        System.out.println("1:Yes\n" + "2:No");
                        x = keyboard.nextInt();
                }
            }
        }
        //Starting out New
        if (!load) {
            Scanner keys = new Scanner(System.in);
            System.out.println("Hello Adventurer, welcome to the Realm of Rochester!");
            System.out.println("You seem to be new here, may I ask what your name is?: ");
            y = keys.nextLine();
            name = y;
            System.out.println("Welcome, " + name + ",");
            System.out.println("What is your profession?\n" + "1:Knight\n" + "2:Wizard\n" + "3:Rogue");//Ask for Class
            c = keyboard.nextInt();
            a = true;
            while (a) {
                switch (c) {//Update class based on decision(loop if invalid input)
                    case 1:
                        charClass = "Knight";
                        charaUpdate(charClass);
                        a = false;
                        break;
                    case 2:
                        charClass = "Wizard";
                        charaUpdate(charClass);
                        a = false;
                        break;
                    case 3:
                        charClass = "Rogue";
                        charaUpdate(charClass);
                        a = false;
                        break;
                    default:
                        System.out.println("My apologies " + name + "What did you say?\n");
                        System.out.println("1: Knight\n" + "2:Wizard\n" + "3:Rogue");
                        c = keyboard.nextInt();
                }
            }
            System.out.println("Ah, a young " + charClass + ", well Rochester has much to offer Adventurers like you,");
            System.out.println("They either go on an epic quest to achieve either fame, money, maybe even infamy,");
            System.out.println("Or they venture to the Colosseum to test their strength!... or die trying.\n");
            System.out.println("Would you like to venture on a Quest or go to the Colosseum?");
            System.out.println("1:Quest(Story Mode)\n" + "2:Colosseum(Player Vs AI fighting)\n"
                    + "3:Leave Rochester(Exit)");
            x = keyboard.nextInt();//Another Input to ask what to do
            while (b) {
                switch (x) {//Sent to appropriate Mode or End the Program
                    case 1:
                        System.out.println("So begins the story of " + name + " we shall see what tales unfold.");
                        storyMode();
                        b = false;
                        break;
                    case 2:
                        System.out.println("Well " + name + " we shall see how strong you are young Adventurer!");
                        colosseumMode();
                        b = false;
                        break;
                    case 3:
                        System.out.println("Leaving before your story even began " + name + "!\n");
                        System.exit(0);
                    default:
                        System.out.println("My apologies " + name + "What did you want to do?\n");
                        System.out.println("1:Quest(Story Mode)\n" + "2:Colosseum(Player Vs AI fighting)\n"
                                + "3:Leave Rochester(Exit)");
                        x = keyboard.nextInt();
                }
            }
        }
    }

    public static void charaUpdate(String y) throws IOException {//Updates character
        switch (y) {//Receives based on decision in the Main
            case "Knight":
                charClass = "Knight";
                maxHP = 110;
                HP = maxHP;
                def = 10;
                dmg = 7;
                crit = 3;
                break;
            case "Wizard":
                charClass = "Wizard";
                maxHP = 100;
                HP = maxHP;
                def = 4;
                dmg = 14;
                crit = 7;
                break;
            case "Rogue":
                charClass = "Rogue";
                maxHP = 100;
                HP = maxHP;
                def = 7;
                dmg = 11;
                crit = 12;
                break;
        }
    }

    public static void storyMode() throws IOException {//Main Story, decision based, no actual Combat
        //Ideally would use IO to save progress, Karma, and Character Interactions
        //Each Night would ask if you want to Save.
        byte decision;
        boolean a = true, b = false, c = false, d = true;

        Scanner keyboard = new Scanner(System.in);
        if (progress == 0) {
            System.out.println("Thus the tale of " + name + " the " + charClass + " begins.\n \n");

            System.out.println("You arrive in the town of Bern riding on the back of a merchant's cart,");
            System.out.println("after such a long journey on the back of the cart you get out and stretch.");
            System.out.println("The merchant looks to you curiously,");
            System.out.println("\"I hope you enjoyed the trip, but if you don't mind would you spare me some fare?\"");
            System.out.println("You check your pockets and see that you have " + money + " Silver coins, a meager amount for yourself.");

            System.out.println("What would you like to do?:");
            System.out.println("1:Give him 10 Silver and Thank him for the ride.\n"
                    + "2:Offer him 5 Silver and apologize that you could not offer more.\n"
                    + "3:Lie to him and say you have no money.\n");
            decision = keyboard.nextByte();

            while (a) {
                switch (decision) {
                    case 1:
                        System.out.println("You smile at the Merchant then say,");
                        System.out.println("\"Thank you for the ride, it sure saved me from a long trek\"");
                        money -= 10;
                        karma += 1;
                        a = false;
                        break;
                    case 2:
                        System.out.println("You look at the Merchant uneasily and say,");
                        System.out.println("\"My apologies, but I've not much Silver, but I can offer you a small amount.");
                        money -= 5;
                        a = false;
                        break;
                    case 3:
                        System.out.println("You scratch your head then say to the merchant,");
                        System.out.println("\"Sorry good Merchant, but I've come to make money for I currently have none!\"");
                        karma -= 1;
                        a = false;
                        break;
                    default:
                        System.out.println("(I must decide soon...)");
                        decision = keyboard.nextByte();
                }
            }
            a = true;
            if (money < 15) {
                System.out.println("The Merchant smiles,");
                System.out.println("\"Thank you dear " + charClass + ", your generosity is appreciated.");
                System.out.println("If I may offer a bit of advice, the Inn offers cheaper food than Tavern,");
                System.out.println("that may be exactly what you need after the long trip.\"");
                if (karma == 1) {
                    System.out.println("(You realize the Merchant has traveled longer than you have,");
                    System.out.println("would you like to invite him to the Inn as well?)");
                    System.out.println("1:Yes\n" + "2:No");
                    decision = keyboard.nextByte();
                    while (a) {
                        switch (decision) {
                            case 1:
                                b = true;
                                a = false;
                                break;
                            case 2:
                                b = false;
                                a = false;
                                break;
                            default:
                                System.out.println("You think to yourself carefully");
                        }
                    }
                    if (b) {
                        System.out.println("\"The advice is much appreciated, but your trip was longer than my own,");
                        System.out.println("would you care to join me at the Inn, Merchant?\"");
                        System.out.println("The Merchant laughs heartily.");
                        System.out.println("\"Such a thoughtful " + charClass + " you are, I will take you up on that offer!\"");
                        System.out.println("Together you park his cart near the Marketplace and walk to the Inn.\n");
                        masen += 1;
                        c = true;
                    } else {
                        System.out.println("You kindly thank the Merchant for his advice and walk to into town.");
                    }
                } else {
                    System.out.println("You kindly thank the Merchant for his advice and walk to into town.\n");
                }
            } else {
                System.out.println("The Merchant scoffs at you,");
                System.out.println("\"I suppose not all Adventurers are considerate.\"");
                System.out.println("He leaves you on the edge of town alone, you decide to head into Bern.\n");
            }
            a = true;
            b = false;
            if (!c) {
                System.out.println("Upon entering the town you begin to feel the long trip taking its toll,");
                System.out.println("you decide it's probably best to find a place to get some food for an evening meal.");
                System.out.println("After asking a passerby which direction you should go you head towards the:");
                System.out.println("1:Tavern\n" + "2:Inn\n");
                decision = keyboard.nextByte();
                while (a) {
                    switch (decision) {
                        case 1:
                            System.out.println("You head to the Tavern in hopes of a decent brew.");
                            c = false;
                            a = false;
                            break;
                        case 2:
                            System.out.println("You head to the Inn in hopes of a cook savvy Innkeeper");
                            c = true;
                            a = false;
                            break;
                        default:
                            System.out.println("You think to yourself carefully");
                    }
                }
            }
            a = true;
            if (!c) {
                System.out.println("You arrive at the Tavern and notice it's bustling with activity.");
                System.out.println("Making your way through the crowd you find a table to sit at,");
                System.out.println("and after a decent amount of time you finally get your meal.");
                System.out.println("After getting gouged for 11 Silvers you sit around for awhile,");
                money -= 11;
                stamina = 100;
                System.out.println("listening to the bustle of the people in the Tavern.");
                if (karma == -1) {
                    System.out.println("You notice one particularly quiet man, slowly walking through the Tavern,");
                    System.out.println("while watching him you realize he's pickpocketing some of the drunkards.");
                    System.out.println("(You realize you should probably do something about this:)");
                    System.out.println("1:Confront the Pickpocket\n" + "2:Pull the Pickpocket aside\n"
                            + "3:Point out the Pickpocket");
                    decision = keyboard.nextByte();
                    while (a) {
                        switch (decision) {
                            case 1:
                                System.out.println("You move to the bar where the Pickpocket is scouting his next target,");
                                System.out.println("\"You shouldn't be stealing like that, I'm poor myself but there are");
                                System.out.println("other ways of obtaining money.\"");
                                System.out.println("The Pickpocket looks at you surprised that you noticed, then sneers.");
                                System.out.println("\"You must not be from around here, most people know this is");
                                System.out.println("our territory, stay out of it.\"");
                                System.out.println("After counting some of his pickings he leaves the Tavern.");
                                System.out.println("You smile to yourself then begin to feel your fatigue setting in,");
                                System.out.println("you get up and head towards the Inn for a nights rest.");
                                b = true;
                                a = false;
                                break;
                            case 2:
                                karma += -1;
                                System.out.println("You casually walk over to the Pickpocket and bump into him,");
                                System.out.println("he clumsily drops one of the pouches he snagged of a drunkard.");
                                System.out.println("You pick it up and make eye contact then walk outside.");
                                System.out.println("He follows you out then when in ear shot you remark,");
                                System.out.println("\"If you're going to steal you should at least be good at it,");
                                System.out.println("I can teach you a thing or two if you share your pickings.\"");
                                System.out.println("The Pickpocket chuckles,");
                                System.out.println("\"You must not understand the situation but you've got guts");
                                System.out.println("if you're really interested in making some good money come out");
                                System.out.println("to a small camp at the edge of the forest.\"");
                                System.out.println("He looks to the pouch you're still holding.");
                                System.out.println("\"Consider that a gift now.\"");
                                System.out.println("You nod and the Pickpocket turns and walks away down a dark alley.");
                                System.out.println("After mulling over the idea you decide that you need rest before you");
                                System.out.println("decide, so you turn and head towards the Inn.");
                                a = false;
                                break;
                            case 3:
                                System.out.println("You stand up quickly knocking your chair down and point at the Pickpocket");
                                System.out.println("\"Thief! You should keep your hands to yourself!\"");
                                System.out.println("The Drunkards become enraged at the Pickpocket in their midst,");
                                System.out.println("as he's caught red-handed a bar fight ensues as he slams a goblet");
                                System.out.println("into the head of the woman who's pouch he was snagging.");
                                System.out.println("People get up and begin flipping tables and chaos ensues");
                                System.out.println("You lose sight of the Pickpocket then suddenly feel a sharp pain.");
                                stamina = 0;
                                System.out.println("You look to your side and see a woman sliding a bloodied dagger into");
                                System.out.println("her robes, she smiles eerily then remarks");
                                System.out.println("\"You shouldn't mess with the Bandit Regime that runs this town.\"");
                                System.out.println("As she walks away you collapse on the table slowly losing consciousness.");
                                a = false;
                                break;
                            default:
                                System.out.println("(I must decide soon...)");
                                decision = keyboard.nextByte();
                        }
                    }
                    deathCheck(stamina);
                }
                else {
                    System.out.println("You overhear a particularly loud bunch as they carry their discussion");
                    System.out.println("\"Damned Bandit Regime has been pillaging this town as they please again!\"");
                    System.out.println("Another at the table sharply remarks the loud Drunkard");
                    System.out.println("\"Keep your voice down Gus, they're everywhere.");
                    System.out.println("While you may not care about them I'd like to stay alive\"");
                    System.out.println("Gus chugs his mug of mead then grunts.");
                    System.out.println("\"Don't be such a coward, we aught to march straight to their camp at the");
                    System.out.println("edge of the forest and slaughter the lot of them\"");
                    System.out.println("A woman at the table remarks,");
                    System.out.println("\"They'd slaughter you alive with your sloppy skills, but my axe will behead");
                    System.out.println("half the camp by the time they kill you!\"");
                    System.out.println("They laugh heartily as they continue to drink and converse loudly.");
                    System.out.println("You begin to feel fatigue setting in and decide to head to the Inn for a nights rest.");
                }
            }
            else if(c && masen == 0) {
                System.out.println("You arrive at the Inn and notice it is actually bustling with other adventurers.");
                System.out.println("After walking around for a bit you finally find a table and take a seat.");
                System.out.println("A few minutes later a stunning woman approaches your table and says,");
                System.out.println("\"Hello " + charClass + " I am Lara, the Innkeeper here,");
                System.out.println("may I be of service?\"");
                System.out.println("1:Comment on her beauty\n" + "2:Comment that a Merchant recommended her\n"
                        + "3:Ask for a meal.");
                a = true;
                decision = keyboard.nextByte();
                while (a) {
                    switch (decision) {
                        case 1:
                            System.out.println("\"Well I haven't seen a fine Innkeeper like you before,");
                            System.out.println("if I could trouble you for a meal as fine as you are.\"");
                            System.out.println("Lara smiles at you seemingly unsurprised by your comments.");
                            System.out.println("\"Sure, if you don't mind waiting a bit I'll get to it\"");
                            a = false;
                            break;
                        case 2:
                            lara += 1;
                            System.out.println("\"A kind Merchant recommended I get a meal here after our long trip.\"");
                            System.out.println("Lara grins brightly and she comments,");
                            System.out.println("\"It must have been Mason, that man loves my cooking,");
                            System.out.println("I guess that means I have expectations to live up to!\"");
                            System.out.println("She happily walks away to get your meal started.");
                            a = false;
                            break;
                        case 3:
                            System.out.println("\"A good meal would be great, and after most likely a room for rest.\"");
                            System.out.println("Lara nods and walks away to get your meal started.");
                            a = false;
                            break;
                        default:
                            System.out.println("(I must decide soon...)");
                            decision = keyboard.nextByte();
                    }
                }
                System.out.println("While waiting for you meal you notice a poster on the wall labeled BOUNTY");
                System.out.println("You get up and read the poster, it describes a band of thieves named");
                System.out.println("The Bandit Regime and warns that they set up camp on the edge of the forest.");
                System.out.println("You sit back down and your meal arrives.");
                money -= 3;
                if (lara == 1) {
                    System.out.println("\"Wow, that is quite the amount of food for one, if you'd like you can join me.\"");
                    System.out.println("Lara smiles again and takes a seat, chatting with you about your journey thus far.");
                    System.out.println("As the two of you talk the place begins to quiet down.");
                    System.out.println("\"Well as an Innkeeper I should tend to my other duties,\"");
                    System.out.println("can I interest you in a room for 5 Silver?\"");
                }
                else{
                    System.out.println("You eat your meal in peace as the Inn slowly starts to quiet down.");
                    System.out.println("Lara begins to start cleaning the empty tables and looks towards you,");
                    System.out.println("\"If you'd like a room its 5 Silver a night");
                    System.out.println("If not you'd best be on your way.\"");
                    System.out.println("You have "+ money + " silver, stay the night?");
                    System.out.println("1:Yes\n" +"2:No");
                    decision = keyboard.nextByte();
                    a = true;
                    while(a){
                        switch(decision){
                            case 1:
                                d = true;
                                a = false;
                                break;
                            case 2:
                                System.out.println("You sigh and get up from your table, leaving the Inn.");
                                d = false;
                                a = false;
                                break;
                            default:
                                System.out.println("It's getting late I should decide soon.");
                                System.out.println("1:Yes\n" +"2:No");
                                decision = keyboard.nextByte();
                        }
                    }
                }
            }
            else {
                if (karma == 1 && masen == 1) {
                    System.out.println("You arrive at the Inn laughing heartily with the Merchant.");
                    System.out.println("\"Allow me to get us some Rum and a nice meal!");
                    System.out.println("The Innkeeper here is an exquisite cook and I know her well.\"");
                    System.out.println("You take a seat with the Merchant at a table and realize how busy the Inn is,");
                    System.out.println("the Innkeeper comes to your table and you realize she is quite stunning.");
                    System.out.println("\"Lara, it's been some time since I've been here in Bern,");
                    System.out.println("get " + name + " and I some of your finest Rum and cook us a fine meal!\"");
                    System.out.println("Lara laughs and smiles brightly then says,");
                    System.out.println("\"Oh Masen it is good to see you, and it seems you've made another friend,");
                    System.out.println("its a pleasure to meet you!\"");
                    System.out.println("(You think for a small moment before speaking.)");
                    System.out.println("1:Comment to Masen\n" + "2:Comment to Lara\n");
                    a = true;
                    decision = keyboard.nextByte();
                    while (a) {
                        switch (decision) {
                            case 1:
                                masen += 1;
                                System.out.println("\"Wow Masen, awfully chummy with Lara I see, but its great to finally");
                                System.out.println("know your name.\"");
                                System.out.println("Masen looks at you slightly embarrassed as Lara laughs");
                                System.out.println("\"Oh Masen it seems you've upset" + name + "you really do get carried");
                                System.out.println("away when you have a good chat.\"");
                                System.out.println("Masen chuckles nervously,");
                                System.out.println("\"My apologies " + name + "I guess I did get quite carried away!\"");
                                a = false;
                                break;
                            case 2:
                                lara += 1;
                                System.out.println("\"And a pleasure to meet you Lara, Masen has me excited for your");
                                System.out.println("food, if its as amazing as you look I won't be disappointed.\"");
                                System.out.println("Masen laughs heartily at you as Lara smiles,");
                                System.out.println("\"Quite the spectacular " + charClass + " " + name + "is!\"");
                                System.out.println("Lara nods and laughs lightly,");
                                System.out.println("\"Well I better hop to it then, best not to disappoint.\"");
                                a = false;
                                break;
                            default:
                                System.out.println("(I must decide soon...)");
                                decision = keyboard.nextByte();
                        }
                    }
                    System.out.println("While waiting for you meal you notice a group of armored men walk in and survey the crowd.");
                    System.out.println("Masen looks over and comments,");
                    System.out.println("\"Thats the Royal Guard, they're probably here on official business.\"");
                    System.out.println("One of the Guards approach your table and ask,");
                    System.out.println("\"Have either of you seen any thieves lately? We're here to begin the end of the");
                    System.out.println("Bandit Regime's reign, they've terrorized Bern for too long near the edge of the Forest.\"");
                    System.out.println("Masen shakes his head and comments,");
                    System.out.println("\"No, but its about time the Royal Guard did something about the Bandits,");
                    System.out.println("they've stolen from my cart too many times.\"");
                    System.out.println("The Guard ignores Masen's comment and continues inquiring to others.");
                    System.out.println("After questioning the crowd the Royal Guards leave.");
                    if (lara == 1) {
                        System.out.println("\"Well I hope you two are Hungry, I've made enough to feed you both for the day!\"");
                        System.out.println("You marvel at the amount of food as does Masen,");
                        System.out.println("\"" + name + " and I cannot possibly eat all this ourselves, join us Lara!\"");
                        System.out.println("You laugh at Masen as he beacons to Lara");
                        System.out.println("\"Yes join us Lara, Masen and I would enjoy your company!\"");
                        System.out.println("Lara blushes then grabs herself some food and a drink.");
                        System.out.println("You happily converse with the two until the Inn begins to quiet down.");
                        System.out.println("Lara stands up from her seat,");
                        System.out.println("\"It's getting quite late I must tend to my other duties,");
                        System.out.println("will the two of you be staying the night?\"");
                        System.out.println("You both nod and Masen slides 5 Silver across the table,");
                    }

                }
            }
            if (money >= 5 && d) {
                money -= 5;
                System.out.println("You pay the Innkeeper 5 Silver for a room.");
                System.out.println("after you sit down on your bed you feel your exhaustion settling in.");
            }
            else {
                if(d) {
                    System.out.println("After arriving at the Inn you find that a room costs 5 Silver");
                }
                System.out.println("You decide to walk to the edge of town and sleep in the slums in an abandoned shack.");
                if (b) {
                    System.out.println("In your sleep you feel a pain in your chest, it jolts you awake.");
                    System.out.println("You immediately see a shadow standing over you with a knife in your chest,");
                    System.out.println("in your last moments you realize its the Pickpocket from earlier.");
                    stamina = 0;
                }
            }
            deathCheck(stamina);
            System.out.println("You rest peacefully.");
            System.out.println("Day 1 end.");
            progress += 1;
            saveChar();
        }
        if(progress == 1)
        {
            System.out.println("Day 2 will be added soon.");
            System.out.print("Be patent ");
            if(karma > 0)
                System.out.println("young hero, you adventure will continue.");
            else if(karma < 0)
                System.out.println("villainous adventurer, you shall continue your antics soon enough.");
            else{
                System.out.println(charClass + " your tale will continue.");
            }
        }
        System.exit(0);
    }
    public static void colosseumMode()throws IOException{
        //Start for Colosseum Mode

        if(!alive){
            lvl = 1;
            xp = 0;
            enmyCount = 0;
            alive = true;
        }
        //Spawning enemy
        enmyCount += 1;

        System.out.println("Round " + enmyCount +"\nACTION!\n");
        HP = Math.floor(HP);
        System.out.println(name + "\nLevel: " + lvl +"\nExp: " + xp + "\nHealth: " + HP +"/" + maxHP
                + "\nDamage: " + dmg + "\nDefense: " + def + "\nCritical: " + crit);

        //Randomize enemy
        Random rand = new Random();
        enmyHP = rand.nextInt(lvl*12) + 10 + enmyCount;
        enmyDmg = rand.nextInt(lvl*5) + 5 + enmyCount;
        enmyDef = rand.nextInt(lvl*3) + 4 + enmyCount;
        enmyCrit = rand.nextInt(lvl*2) + 2 + enmyCount;

        System.out.println("\nEnemy\n" + "Health: " + enmyHP + "\nDamage: " + enmyDmg + "\nDefense: "
                + enmyDef + "\nCritical: " + enmyCrit);
        abilSelection();
    }
    public static void abilSelection()throws IOException{
        byte x;
        boolean a = true;

        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("\nWhat will you do?: ");
        switch(charClass){//Ability Selection based on Character Class
            case "Knight":
                System.out.println("1:Slash(Dmg+)\n" + "2:Parry(EnemyDef-)\n" + "3:Shield Bash(Def+)");
                x = keyboard.nextByte();
                while(a){
                    switch(x){
                        case 1:
                            dmgChange = lvl*1.5;
                            System.out.println("You used Slash!");
                            combatCalc();
                            a = false;
                            break;
                        case 2:
                            enmyDefChange = -lvl*2;
                            System.out.println("You used Parry!");
                            combatCalc();
                            a = false;
                            break;
                        case 3:
                            defChange = def*.15;
                            System.out.println("You used Shield Bash!");
                            combatCalc();
                            a = false;
                            break;
                        default:
                            System.out.println("Fight seriously Adventurer!");
                            System.out.println("1:Slash(Dmg+)\n" + "2:Parry(EnemyDef-)\n" + "3:Shield Bash(Def+)");
                            x = keyboard.nextByte();
                    }
                }
                break;
            case "Wizard":
                System.out.println("1:Fireball(Dmg+)\n" + "2:Polymorph(Random EnemyHP)\n" + "3:Reflect(Return Dmg)");
                x = keyboard.nextByte();
                while(a){
                    switch(x){
                        case 1:
                            dmgChange = dmg*.3;
                            System.out.println("You used Fireball!");
                            combatCalc();
                            a = false;
                            break;
                        case 2:
                            enmyHP = rand.nextInt(lvl*10) + (lvl*5);
                            System.out.println("You used Polymorph!");
                            combatCalc();
                            a = false;
                            break;
                        case 3:
                            System.out.println("You used Reflect!");
                            int reflectChance;
                            reflectChance = rand.nextInt(100)+1;
                            if(reflectChance <=40) {
                                dmgChange = (enmyDmg * 1.2);
                                System.out.println("Reflect Successful!");
                            }
                            else{
                                System.out.println("Reflect Failed!");
                            }
                            combatCalc();
                            a = false;
                            break;
                        default:
                            System.out.println("Fight seriously Adventurer!");
                            System.out.println("1:Fireball(Dmg+)\n" + "2:Polymorph(Random EnemyHP)\n" + "3:Reflect(Return Dmg)");
                            x = keyboard.nextByte();
                    }
                }
                break;
            case "Rogue":
                System.out.println("1:Flourish(Dmg+)\n" + "2:Shadow Step(Def+)\n" + "3:Backstab(Crit+)");
                x = keyboard.nextByte();
                while(a){
                    switch(x){
                        case 1:
                            dmgChange = rand.nextInt(lvl*7);
                            System.out.println("You used Flourish!");
                            combatCalc();
                            a = false;
                            break;
                        case 2:
                            defChange = rand.nextInt(lvl*4);
                            System.out.println("You used Shadow Step!");
                            combatCalc();
                            a = false;
                            break;
                        case 3:
                            critChange = rand.nextInt(10);
                            System.out.println("You used Backstab!");
                            combatCalc();
                            a = false;
                            break;
                        default:
                            System.out.println("Fight seriously Adventurer!");
                            System.out.println("1:Flourish(Dmg+)\n" + "2:Shadow Step(Def+)\n" + "3:Backstab(Crit+)");
                            x = keyboard.nextByte();
                    }
                }
                break;
        }
    }
    public static void combatCalc()throws IOException{

        //Variables for reference
        Random rand = new Random();
        int critCheck = rand.nextInt(100);
        int enmyCritCheck = rand.nextInt(100);
        double dmgDone;
        double dmgTaken;

        enmyDef += enmyDefChange;

        //Damage Calculator
        if(crit + critChange >= critCheck) {
            dmgDone = (((dmg + dmgChange)*2)-((enmyDef)/1.5));
            enmyHP -= dmgDone;
            dmgDone = Math.floor(dmgDone);
            System.out.println("\nYou Critically hit the Enemy for " + dmgDone + " damage!");
        }
        else{
            dmgDone = ((dmg + dmgChange)-((enmyDef)/1.5));
            enmyHP -= dmgDone;
            dmgDone = Math.floor(dmgDone);
            System.out.println("\nYou did: " + dmgDone + " damage.");
        }
        if(enmyCrit + enmyCritChange >= enmyCritCheck) {
            dmgTaken = (((enmyDmg + enmyDmgChange)*2)-((def + defChange)/1.5));
            if (dmgTaken>=0){
                HP -= dmgTaken;
                dmgTaken = Math.floor(dmgTaken);
                System.out.println("The Enemy Critically hit you for " + dmgTaken + " damage!");
            }
            else{ System.out.println("The enemy did 0 Damage.");}
        }
        else{
            dmgTaken = (((enmyDmg + enmyDmgChange))-((def + defChange)/1.5));
            if (dmgTaken >= 0){
                HP -= dmgTaken;
                dmgTaken = Math.floor(dmgTaken);
                System.out.println("The Enemy did: " + dmgTaken +" damage.");
            }
            else{ System.out.println("The enemy did 0 Damage."); }
        }

        System.out.println(" ");

        //Post Damage check
        if(enmyDef <= 0){ enmyDef = 0;} //reset so not negative the entire fight
        deathCheck(HP);
        if(enmyHP >=1){
            HP = Math.floor(HP);
            enmyHP = Math.floor(enmyHP);
            System.out.println(name + "\nLevel: " + lvl +"\nExp: " + xp + "\nHealth: " + HP +"/" + maxHP
                    + "\nDamage: " + dmg + "\nDefense: " + def + "\nCritical: " + crit);
            System.out.println("Enemy\n" + "Health: " + enmyHP + "\nDamage: " + enmyDmg + "\nDefense: "
                    + enmyDef + "\nCritical: " + enmyCrit);
            abilSelection();
        }
        else{
            int moneyGain = rand.nextInt(75)+35;
            double xpGain = rand.nextInt(50)+(25+(lvl*5)+(enmyCount+5));
            money += moneyGain;
            xp += xpGain;
            System.out.println("You are victorious!");
            if(xp >= nxtLvl){
                lvl += 1;
                xp = 0;
                nxtLvl = lvl*85;
                switch(charClass){
                    case "Knight":
                        maxHP += 12;
                        dmg += 1;
                        def += 2;
                        crit += 1;
                        System.out.println("You Leveled Up!\n" + "Stat Increase:+12 Health, +2 Dmg, +2 Def, +1 Crit");
                        break;
                    case "Wizard":
                        maxHP += 8;
                        dmg += 2;
                        def += 1;
                        System.out.println("You Leveled Up!\n" + "Stat Increase:+8 Health, +1 Dmg, +1 Def");
                        break;
                    case "Rogue":
                        maxHP += 10;
                        dmg += 1;
                        def += 1;
                        crit += 2;
                        System.out.println("You Leveled Up!\n" + "Stat Increase:+10 Health, +1 Dmg, +1 Def, +2 Crit");
                        break;
                }
                HP = maxHP;
            }
            System.out.println("You gained " + xpGain + "xp");
            System.out.println("You gained " + moneyGain + "credits.\n");
            shop();
        }
    }
    public static void shop()throws IOException{

        Scanner keyboard = new Scanner(System.in);
        byte shopPick;

        HP = Math.floor(HP);
        System.out.println(name + "\nLevel: " + lvl +"\nExp: " + xp + "\nHealth: " + HP +"/" + maxHP
                + "\nDamage: " + dmg + "\nDefense: " + def + "\nCritical: " + crit);
        System.out.println("\nYou have " + money + " credits,\n" + "Would you like to buy something?");
        System.out.println("1: Heal 20 HP (30 Credits)\n" + "2: +25 XP (50 Credits)\n" +"3: +15 MaxHP (125 Credits)\n"
                + "4: +3 Dmg (75 Credits)\n" + "5: +2 Def (75 Credits)\n" + "6: +1 Crit (69 Credits)\n"
                + "7: Back to Battle\n" + "8: Leave Rochester(Exit game)");
        shopPick = keyboard.nextByte();

        switch(shopPick) {
            case 1:
                if (money >= 30) {
                    money -= 30;
                    HP += 20;
                    if (HP >= maxHP) {
                        HP = maxHP;
                    }
                    shop();
                } else {
                    System.out.println("Not enough Credits.");
                    shop();
                }
                break;
            case 2:
                if (money >= 50) {
                    money -= 50;
                    xp += 25;
                    if (xp >= nxtLvl) {
                        lvl += 1;
                        xp = 0;
                        nxtLvl = lvl * 85;
                        switch (charClass) {
                            case "Knight":
                                maxHP += 12;
                                dmg += 1;
                                def += 2;
                                crit += 1;
                                System.out.println("You Leveled Up!\n" + "Stat Increase:+12 Health, +2 Dmg, +2 Def, +1 Crit");
                                break;
                            case "Wizard":
                                maxHP += 8;
                                dmg += 2;
                                def += 1;
                                System.out.println("You Leveled Up!\n" + "Stat Increase:+8 Health, +1 Dmg, +1 Def");
                                break;
                            case "Rogue":
                                maxHP += 10;
                                dmg += 1;
                                def += 1;
                                crit += 2;
                                System.out.println("You Leveled Up!\n" + "Stat Increase:+10 Health, +1 Dmg, +1 Def, +2 Crit");
                                break;
                        }
                        HP = maxHP;
                    }
                    shop();
                } else {
                    System.out.println("Not enough Credits.");
                    shop();
                }
            case 3:
                if (money >= 125){
                    money -= 125;
                    maxHP += 15;
                    HP += 15;
                    if (HP >= maxHP){ HP = maxHP; }
                    shop();
                }
                else{
                    System.out.println("Not enough Credits.");
                    shop();
                }
            case 4:
                if (money >= 75){
                    money -= 75;
                    dmg += 3;
                    shop(); }
                else{
                    System.out.println("Not enough Credits.");
                    shop();
                }
            case 5:
                if (money >= 75){
                    money -= 75;
                    def += 2;
                    shop();
                }
                else{
                    System.out.println("Not enough Credits.");
                    shop();
                }
            case 6:
                if (money >= 69){
                    money -= 69;
                    crit += 1;
                    shop(); }
                else{
                    System.out.println("Not enough Credits.");
                    shop();
                }
            case 7:
                colosseumMode();
            case 8:
                System.out.println("It's a shame to see you go, but fair well Adventurer!\n");
                saveChar();
            default:
                shop();
        }

    }
    public static void deathCheck(double life) throws IOException{
        if(life <= 0) {
            System.out.print("You have Died!\n" + "The legend of " + name + " has come to an end.\n\n");
            alive = false;
            main(null);
        }
    }
    public static void saveChar() throws IOException{
        int x;
        boolean a = true, save = false;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to Save your character?");
        System.out.println("1:Yes\n" + "2:No");
        x = keyboard.nextInt();
        while(a){
            switch(x){
                case 1:
                    save = true;
                    a= false;
                    break;
                case 2:
                    save = false;
                    a = false;
                    break;
                default:
                    System.out.println("Save character?");
                    System.out.println("1:Yes\n" + "2:No");
                    x = keyboard.nextInt();
            }
        }
        if(save){
            String fileName = "charSheet";
            PrintWriter outputFile = new PrintWriter(fileName);
            //Character Stats
            outputFile.println(name);
            outputFile.println(charClass);
            outputFile.println(alive);
            outputFile.println(progress);
            outputFile.println(karma);
            outputFile.println(stamina);
            outputFile.println(money);
            outputFile.println(lvl);
            outputFile.println(xp);
            outputFile.println(nxtLvl);
            outputFile.println(maxHP);
            outputFile.println(HP);
            outputFile.println(def);
            outputFile.println(dmg);
            outputFile.println(crit);
            //NPC interactions
            outputFile.println(masen);
            outputFile.println(lara);
            outputFile.close();
            System.out.println("Save Successful!");
        }
        a = true;
        System.out.println("What would you like to do?");
        System.out.println("1:Continue the Story\n" + "2:Back to the Colosseum\n" + "3:Close Game");
        x = keyboard.nextInt();
        while(a){
            switch(x){
                case 1:
                    storyMode();
                    a= false;
                    break;
                case 2:
                    colosseumMode();
                    a = false;
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("What would you like to do?");
                    System.out.println("1:Continue the Story\n" + "2:Back to the Colosseum\n" + "3:Close Game");
                    x = keyboard.nextInt();
            }
        }
    }
    public static void loadChar() throws IOException{
        int x;
        boolean a = true;
        String fileName = "charSheet";
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);
        Scanner keyboard = new Scanner(System.in);
        while(inputFile.hasNext()) {
            //Character Stats
            name = inputFile.nextLine();
            charClass = inputFile.nextLine();
            alive = inputFile.nextBoolean();
            progress = inputFile.nextInt();
            karma = inputFile.nextInt();
            stamina = inputFile.nextDouble();
            money = inputFile.nextInt();
            lvl = inputFile.nextInt();
            xp = inputFile.nextInt();
            nxtLvl = inputFile.nextInt();
            maxHP = inputFile.nextDouble();
            HP = inputFile.nextDouble();
            def = inputFile.nextDouble();
            dmg = inputFile.nextDouble();
            crit = inputFile.nextDouble();
            //NPC Interactions
            masen = inputFile.nextInt();
            lara = inputFile.nextInt();
        }
        inputFile.close();
        System.out.println("Load Successful!");
        System.out.println("Welcome back to Rochester " + name + " what adventures will unfold for you today?");
        System.out.println("1:Quest(Story Mode)\n" + "2:Colosseum(Player Vs AI fighting)\n"
                + "3:Leave Rochester(Exit)");
        x = keyboard.nextInt();
        while (a) {
            switch (x) {
                case 1:
                    if(progress == 0) {
                        System.out.println("So begins the story of " + name + " we shall see what tales unfold.");
                    }
                    else{
                        System.out.println("The tales of " + name + "continue!");
                    }
                    storyMode();
                    a = false;
                    break;
                case 2:
                    if(lvl > 1) {
                        System.out.println("The Legendary Gladiator " + name + " Returns!");
                    }
                    else{
                        System.out.println("Finally trying your hand at the Stadium " + name + "?");
                    }
                    colosseumMode();
                    a = false;
                    break;
                case 3:
                    System.out.println("Well " + name + " you're always welcome to return!\n");
                    System.exit(0);
                default:
                    System.out.println("My apologies " + name + "What did you want to do?\n");
                    System.out.println("1:Quest(Story Mode)\n" + "2:Colosseum(Player Vs AI fighting)\n"
                            + "3:Leave Rochester(Exit)");
                    x = keyboard.nextInt();
            }
        }
    }
}
