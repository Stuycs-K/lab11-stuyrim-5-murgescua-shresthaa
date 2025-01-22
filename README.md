[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.

---

:white_check_mark: Attack, special, support, quit commands

:white_check_mark: Special boss

:white_check_mark: Different adventurer types

:white_check_mark: Text inside text box

:white_check_mark: Randomly chosen players/enemies

:question: Special attacks on enemies by players sometimes increases special

:ballot_box_with_check: Red text for enemies

:ballot_box_with_check: Checking for valid input command

:ballot_box_with_check: Pre-assigned/default character names

:ballot_box_with_check: Allows attacks/special attacks to specific enemies

:beetle: Enemies/players with HP below 0 continue to act


## Adventurer Subclasses

### 1. Spice Enthusiast  
**Name:** Seifer  
**HP:** 21/21 [^1]  
**Sprays:** 20  
**Role:** Long-range attacker/buffer  

- **Attack:** Throws spices into opponent's eyes and makes them tear up (deals 3-5 damage, restores 2 sprays)  
- **Special Attack:** (AoE) Sprays the gigantic pepper spray on opponents (deals 5-7 damage per opponent, reduces sprays by 6)  
- **Support (self):** Drinks spicy soup and reinvigorates (restores 4 sprays, restores 1 HP)  
- **Support (comrades):** Gives comrades spicy sticks to eat (restores 6 special)  

---

### 2. Hungry Vampire  
**Name:** Morpheus  
**HP:** 30/30 [^1]  
**Lifeblood:** 15  
**Role:** Healer/debuffer

- **Attack:** Turns into a bat and unleashes martial arts moves (deals 2-4 damage, restores 2 lifeblood)  
- **Special Attack:** Sucks opponent's blood (deals 8 damage, reduces lifeblood by 5, restores 2 HP)  
- **Support (self):** Grabs a nearby wolf and sucks its blood (restores 6 lifeblood)  
- **Support (comrades):** Gives comrades one drop of condensed lifeblood (restores comrade 3 HP, reduces self 2 HP)

---

### 3. Code Warrior  
**Name:** Carmack  
**HP:** 24/24 [^1]  
**Caffeine:** 12  
**Role:** Main attacker  

- **Attack:** Attacks opponent and take a sip of coffee (deals 2-7 damage, restores 2 caffeine)  
- **Special Attack:** Hacks the matrix (deals 3-12 damage, reduces caffeine by 8)  
- **Support (self):** Drinks coffee (restores 6 special, restores 1 HP)  
- **Support (comrades):** Gives comrades a coffee (restores 5 special)

---

### 4. Boss  
**Name:** Albert  
**HP:** 44/44 [^1]  
**Calories:** 22  
**Role:** Strong attacker

- **Attack:** Launches cheeseburgers at opponents (deals 5-10 damage, restores 3 calories)
- **Special Attack:** Forces opponent to eat their veggies (deals 6-15 damage, reduces calories by 7) 
- **Support (self):** Eats a pizza to restore 6 calories and 3 HP
  
[^1]: This defines starting HP and HP limit if HP not specified (specified HP must be under the limit).
