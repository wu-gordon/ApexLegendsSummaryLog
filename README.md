# Apex Legends Ranked Points (RP) Summary Log Calculator

## *Evaluate your ranked session progress in an organized fashion*

## PHASE 1:

**What will the application do?**

Inspired by the free-to-play battle royale-hero shooter game Apex Legends developed by Respawn
Entertainment, this application allows players to visualize a game by game point breakdown of their
ranked sessions. 

At the beginning of each session, players will be asked to select their appropriate ranked division (Bronze, 
Silver, Gold, Platinum, Diamond, Masters/Predator). This will introduce a new window with a text line
requesting for an RP value which will be provided to the player at the end of each game. Once the RP value
has been inserted, a built-in RP calculator will then determine the player's placement among 60 teams of 3,
and a combined total of Kills/Assists or kill participation (KP) for that game.
 
Next, there will be an option to "Submit" which will complete the session and print out a total RP
gained/lost summary with an ordered breakdown of placement and KP alongside the selected division it was in.
Players also have the option to "Re-enter" to continue entering RP entries after each game until their
session is over.

Additionally, there will be a "Menu" option at the bottom after receiving the details per RP entry, allowing
players to head back to the main menu and select a different ranked division, in the case where players 
rank up during their session.

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

This application was designed to break down the competitive ranked points (RP) system in the game for players 
who grind out long sessions with friends and want to track an organized log of their RP gain/loss for 
their ranked session(s).
 
**Why is this project of interest to you?**

This project interests me because Apex Legends is currently my favourite video game. I have been playing 
this game for the past 8 months and I am still in love with it. For this reason, I knew I had to create 
an application that I can benefit from and players who share a similar competitive mindset.

# User Stories

**Summary Log**
- As a user, I want to be able to select a ranked division
- As a user, I want to be able to insert an RP value
- As a user, I want to be able to go back to the main menu if selected incorrect ranked division
- As a user, I want to be able to view the KP and placement breakdown after inserting an RP value
- As a user, I want to be able to re-enter RP values to visualize the gain/loss from each game played
- As a user, I want to be able to go back to the main menu if there is a rank up during the session
- As a user, I want to be able to submit the stored RP statistics to a summary log that will display all gains
  and losses in each division within the ranked session
  
**RP Calculator**
- As a user, I want to be able to receive a total KP value based on the RP value in conjunction with the 
  KP multiplier (Max KP = 6) at each placement in the game
- As a user, I want to be able to receive a placement value based on the RP value which will determine the 
  weight of the KP multiplier
- As a user, I want to be able to have entry cost deducted corresponding to the selected ranked division
  before producing the KP and placement results for that game
- As a user, I want to be able to have results based on RP gain and RP loss
- As a user, I want to be able to not demote out of the current division due to the demotion rules where 
  players can only demote within tiers of the same division and not divisions themselves

