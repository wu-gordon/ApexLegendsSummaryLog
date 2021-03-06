# Apex Legends Ranked Points (RP) Match History Log

## *Evaluate your ranked session progress in an organized fashion*

## PHASE 1:

**What will the application do?**

Inspired by the free-to-play battle royale-hero shooter game Apex Legends, developed by Respawn
Entertainment, this application allows players to visualize a game by game breakdown of their
ranked sessions.

At the beginning of each session, players will be asked to select their appropriate ranked division (Bronze,
Silver, Gold, Platinum, Diamond, Masters/Predator). At the end of each game, players will be able to record three
unique values: the overall placement among sixty teams of three, a kill participation (KP) value which consists a
combined total of kills and assists, and a positive/negative RP value based on the quality of their game.

After entering these values, players will be prompted to add data for a new match. If selected "yes", the same values
will be requested from the player again, until "no" is selected to indicate completion of their ranked session. In the
event that a player promotes from their current division, they may select the next appropriate rank division when
re-entering their data for the following game(s).

Next, a match history log of all the games that have been recorded will be printed out in chronological order. Players
will be able to visualize their progress from all the matches that were played, in addition to which divisions they were
played in.

**Kills/Assists (KP) Multiplier (Max KP = 6)** </P>
*1 KP = 1 Kill or Assist(s)*
>
> **14th+ - 11th** = KP * 10 RP </P>
> **10th - 6th** = KP * 12 RP </P>
> **5th - 4th** = KP * 15 RP </P>
> **3th - 2nd** = KP * 20 RP </P>
> **1st** = KP * 25 RP </P>

**Placement RP Breakdown**
>
> **14th+** = 0 RP </P>
> **13th - 11th** = +5 RP </P>
> **10th - 9th** = +10 RP </P>
> **8th - 7th** = +20 RP </P>
> **6th - 5th** = +30 RP </P>
> **4th - 3rd** = +40 RP </P>
> **2nd** = +60 RP </P>
> **1st** = +100 RP

**Per game Entry Cost (EC) based on Division**
>
> **Bronze:** EC = 0 RP </P>
> **Silver:** EC = -12 RP </P>
> **Gold:** EC = -24 RP </P>
> **Platinum:** EC = -36 RP </P>
> **Diamond:** EC = -48 RP </P>
> **Master/Predator:** EC = -60 RP

**Ranked Points (RP) ranges between Divisions**
>
> **Bronze:** (0 - 900 RP) *300 RP per tier*
>> **Bronze IV** = 0 RP </P>
>> **Bronze III** = 300 RP </P>
>> **Bronze II** = 600 RP </P>
>> **Bronze I** = 900 RP
>
> **Silver:** (1200 - 2400 RP) *400 RP per tier*
>> **Silver IV** = 1200 RP </P>
>> **Silver III** = 1600 RP </P>
>> **Silver II** = 2000 RP </P>
>> **Silver I** = 2400 RP
>
> **Gold:** (2800 - 4300 RP) *500 RP per tier*
>> **Gold IV** = 2800 RP </P>
>> **Gold III** = 3300 RP </P>
>> **Gold II** = 3800 RP </P>
>> **Gold I** = 4300 RP
>
> **Platinum** (4800 - 6600 RP) *600 RP per tier*
>> **Platinum IV** = 4800 RP </P>
>> **Platinum III** = 5400 RP </P>
>> **Platinum II** = 6000 RP </P>
>> **Platinum I** = 6600 RP
>
> **Diamond** (7200 - 9300 RP) *700 RP per tier*
>> **Diamond IV** = 7200 RP </P>
>> **Diamond III** = 7900 RP </P>
>> **Diamond II** = 8600 RP </P>
>> **Diamond I** = 9300 RP
>
> **Masters/Predator** (10,000+ RP)
>> *No tiers, just raw RP gains from here on out*

**Who will use it?**

Since the game only allows players to view the data from their most recently played game, the functionality of this
application is designed for competitive Apex Legends players who enjoy grinding out long sessions with
friends and want to have a record of their ranked progression.

**Why is this project of interest to you?**

This project interests me because Apex Legends is currently my favourite video game. I have been playing
this game for the past 8 months and I am still in love with it. For this reason, I knew I had to create
an application that I can benefit from as well as players who share a similar competitive mindset. </P>
***Interesting fact**: The highest rank I've reached is Diamond IV 7524 RP. I also stream Apex Legends at Twitch.tv/
maangchiii*

# User Stories

- As a user, I want to be able to select a ranked division
- As a user, I want to be able to insert a placement value after each game
- As a user, I want to be able to insert a kill participation (KP) value after each game
- As a user, I want to be able to receive a ranked points (RP) total after inputting ranked division, placement, 
  and KP values
- As a user, I want to be able to re-enter game data for different games
- As a user, I want to be able to input game data for a different ranked division in the event of a division promotion
- As a user, I want to be able to have a match history log that will display the list of recorded games played in
  chronological order including the stored game data

## PHASE 2: Additional User Stories

- As a user, I want to be able to choose from a list of options displayed to me after opening the application
- As a user, I want to be able to add ranked game data from the list of options
- As a user, I want to be able to save all Apex matches to a JSON file from the list of options
- As a user, I want to be able to load all Apex match history data from the JSON file, from the list of options
- As a user, I want to be able to print the Apex match history data after loading the JSON file, from the list of 
  options
- As a user, I want to be able to quit the application once the ranked session is over, from the list of options

## PHASE 3: Optimized User Stories - GUI

**PANEL 1: HOME PAGE**

- As a user, I want to be able to hear the Apex Legends Season 7 Ascension Main theme after running the application
- As a user, I want to be able to choose between Add, Save, Print, and Load from the drop down menu
- As a user, I want to be able to use the enter button to confirm a drop down menu option
- As a user, I want to be able to quit the application using the quit button
  
**PANEL 2: RANKED DIVISIONS**

- As a user, I want to be able to select and click the appropriate ranked division button

**PANEL 3: GAME DATA INPUT**

- As a user, I want to be able to have the selected ranked division displayed next to "Division: "
- As a user, I want to be able to input kill participation data into the "Kills/Assists (KP): " text field
- As a user, I want to be able to input placement data into the "Placement: " text field
- As a user, I want to be able to use the enter button to confirm the game data inputted 

**PANEL 4: RANKED POINTS (RP) CALCULATION**

- As a user, I want to be able to see the selected ranked division, kill participation, and placement values confirmed
- As a user, I want to be able to the total ranked points (RP) gained/lost based on the inputted game data values
- As a user, I want to be able to use the add button to go back to the home page

**PANEL 5: MATCH HISTORY LOG**

- As a user, I want to be able to see all matches added, printed on this page to display a record of the session

## PHASE 4a: TASK 2 - Throwing a checked exception (PlacementNotWithinRange)

For the occasion that a player inputs a placement value that is not within the specified placement range which is
between 0-20, a PlacementNotWithinRange exception will be thrown from the storePlacement() method in ApexMatch.java.
The insertPlacement() method in ApexSummaryLogConsole.java has the call to storePlacement() wrapped in a try/catch 
and notifies the player that the "Placement value is not within range. Try again". 

To test this exception, I modified the testStorePlacement() test method in ApexMatchTest.java by splitting them into
testStorePlacementNotWithinRange (expects the exception), and testStorePlacementWithinRange (doesn't expect the
exception). For the remaining tests that call upon storePlacement() and have within-boundary placement values, 
those test methods threw the PlacementNotWithinRange exception. 

## PHASE 4b: UML Class Design Diagram Reflection

**If you had more time to work on the project, is there any refactoring that you would do to improve your design?**

If I had more time to work on this project, I would refactor my ApexSummaryLogGUI.java class due to methods 
such as menuSelect1, menuSelect2, and menuSelect3 having bad coupling. The content within those classes has code 
copied and pasted from my JsonReader.java and JsonWriter.Java classes. In terms of cohesion, I attempted to create
good cohesion within my classes and placed the ActionListeners for different buttons into the ApexSummaryLogGUI.java
class which served as my "main hub". However, I think that I could create even better cohesion inside
ApexSummaryLogGUI.java if I had separated those ActionListeners into their own corresponding classes, making the code 
less cluttered and easier to read for others.