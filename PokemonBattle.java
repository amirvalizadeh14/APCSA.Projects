import java.util.Random;
import java.util.Scanner;

public class MyProgram
{
    public static void main(String[] args)
    {
        /**
         * asks user for values of two Pokemon
         * 
         * displays the two pokemons' pokemon cards,
         * displays them on screen before battle
         * 
         * simulates a battle between the two pokemon based on
         * user inputs
         * 
         * displays result of battle simulation
         * */
         
        Scanner s = new Scanner(System.in);
        
        System.out.println("Defining Pokemon 1");
        System.out.println("Enter the name of the Pokemon: ");
        String pokemon1name = s.nextLine();
        System.out.println("Enter the level of the Pokemon: ");
        int pokemon1level = s.nextInt();
        System.out.println("Enter the base HP of the Pokemon: ");
        int pokemon1baseHP = s.nextInt();
        System.out.println("Enter the base attack of the Pokemon: ");
        int pokemon1baseAttack = s.nextInt();
        System.out.println("Enter the defense of the Pokemon: ");
        int pokemon1defense = s.nextInt();
        
        s.nextLine();
        
        System.out.println("Defining Pokemon 2");
        System.out.println("Enter the name of the Pokemon: ");
        String pokemon2name = s.nextLine();
        System.out.println("Enter the level of the Pokemon: ");
        int pokemon2level = s.nextInt();
        System.out.println("Enter the base HP of the Pokemon: ");
        int pokemon2baseHP = s.nextInt();
        System.out.println("Enter the base attack of the Pokemon: ");
        int pokemon2baseAttack = s.nextInt();
        System.out.println("Enter the defense of the Pokemon: ");
        int pokemon2defense = s.nextInt();
        
        s.nextLine();
        
        int pokemon1ActualHP = pokemon1postHP(pokemon1baseHP, pokemon1level);
        int pokemon2ActualHP = pokemon2postHP(pokemon2baseHP, pokemon2level);
        int pokemon1ActualAttack = pokemon1postAttack(pokemon1baseAttack, pokemon1level);
        int pokemon2ActualAttack = pokemon2postAttack(pokemon2baseAttack, pokemon2level);

        
         
        System.out.println();
        
        System.out.println("|_________________|");
        System.out.println("POKEMON: " + pokemon1name);
        System.out.println("| Level: " + pokemon1level);
        System.out.println("| HP: " + pokemon1ActualHP);
        System.out.println("| Attack: " + pokemon1ActualAttack);

        System.out.println("|_________________|");
        System.out.println("POKEMON: " + pokemon2name);
        System.out.println("| Level: " + pokemon2level);
        System.out.println("| HP: " + pokemon2ActualHP);
        System.out.println("| Attack: " + pokemon2ActualAttack);
        System.out.println("|_________________|");
        System.out.println();
        System.out.println();
        System.out.println();
        
        while (pokemon1ActualHP > 0 && pokemon2ActualHP > 0){
            double damagetoPokemon2 = calculatePokemon1AttackDamage(pokemon1level,
            pokemon1ActualAttack, pokemon2defense);
            pokemon2ActualHP -= (int) damagetoPokemon2;
            
            if (pokemon2ActualHP <= 0){
                System.out.println(pokemon2name + " has fainted. "
                + pokemon1name + " wins!");
                break;
            }
            
            double damagetoPokemon1 = calculatePokemon2AttackDamage(pokemon2level,
            pokemon2ActualAttack, pokemon1defense);
            pokemon1ActualHP -= (int) damagetoPokemon1;
            
            if (pokemon1ActualHP <= 0){
                System.out.println(pokemon1name + " has fainted. "
                + pokemon2name + " wins!");
                break;
            }
        }

        System.out.println("Results from Battle: ");
        System.out.println(pokemon1name + "'s Remaining HP: " + pokemon1ActualHP);
        System.out.println(pokemon2name + "'s Remaining HP: " + pokemon2ActualHP);
        
        
        
    }
    
    public static int pokemon1postHP(int pokemon1baseHP, int pokemon1level){
        /**
         * calculates pokemon1's new HP (pokemon1ActualHP)
         * after being given its base HP and level values
         * 
         * @param pokemon1baseHP baseHP of pokemon1
         * @param pokemon1level level of pokemon1
         * @return pokemon1's actual HP being used in battle 
         */
         
        if(pokemon1level == 1){
            return 11;
        }else{
            double pokemon1leveledHP = (10 + pokemon1level + (0.02 * pokemon1baseHP * (pokemon1level - 1)));
            int pokemon1roundedLeveledHP = (int) Math.floor(pokemon1leveledHP);
            return pokemon1roundedLeveledHP;
            
    }
    }
    
    public static int pokemon2postHP(int pokemon2baseHP, int pokemon2level){
        /**
         * calculates pokemon2's new HP (pokemon2ActualHP)
         * after being given its base HP and level values
         * 
         * @param pokemon2baseHP baseHP of pokemon1
         * @param pokemon2level level of pokemon1
         * @return pokemon2's actual HP being used in battle 
         */
         
        if(pokemon2level == 1){
            return 11;
        }else{
            double pokemon2leveledHP = (10 + pokemon2level + (0.02 * pokemon2baseHP * (pokemon2level - 1)));
            int pokemon2roundedLeveledHP = (int) Math.floor(pokemon2leveledHP);
            return pokemon2roundedLeveledHP;
            
    }
    }
    
    public static int pokemon1postAttack(int pokemon1baseAttack, int pokemon1level){
        /**
         * calculates pokemon1's new attack (pokemon1ActualAttack)
         * after being given its base attack and level values
         * 
         * @param pokemon1baseAttack base attack of pokemon1
         * @param pokemon1level level of pokemon1
         * @return pokemon1's actual Attack stat being used in battle
         */
         
        if(pokemon1level == 1){
            return 5;
        }else{
            double pokemon1leveledAttack = (5 + (0.02 * pokemon1baseAttack * (pokemon1level - 1)));
            int pokemon1roundedLeveledAttack = (int) Math.floor(pokemon1leveledAttack);
            return pokemon1roundedLeveledAttack;
            
        }
        
    }
    
    public static int pokemon2postAttack(int pokemon2baseAttack, int pokemon2level){
        /**
         * calculates pokemon2's new attack (pokemon2ActualAttack)
         * after being given its base attack and level values
         * 
         * @param pokemon2baseAttack base attack of pokemon2
         * @param pokemon2level level of pokemon2
         * @return pokemon2's actual Attack stat being used in battle
         */
         
        if(pokemon2level == 1){
            return 5;
        }else{
            double pokemon2leveledAttack = (5 + (0.02 * pokemon2baseAttack * (pokemon2level - 1)));
            int pokemon2roundedLeveledAttack = (int) Math.floor(pokemon2leveledAttack);
            return pokemon2roundedLeveledAttack;
            
        }
        
    }
    
    public static double calculatePokemon1AttackDamage(int pokemon1level, 
    int pokemon1leveledAttack, int pokemon2defense){
        /**
         * calculates the damage caused by pokemon1's attack
         * to pokemon2
         * 
         * @param pokemon1level level of pokemon1
         * @param pokemon1leveledAttack ActualAttack of pokemon1
         * @param pokemon2defense defense stat of pokemon2
         * @return damage caused by pokemon1's attack to pokemon2
         */
         
        Random rand = new Random();
        double modifier = rand.nextDouble()*0.15 + 0.85;
        double pokemon1Damage = modifier * ((2 * pokemon1level + 10)/250.0
        + ((double) pokemon1leveledAttack / pokemon2defense) + 2);
        return pokemon1Damage;
    }
    
    public static double calculatePokemon2AttackDamage(int pokemon2level, 
    int pokemon2leveledAttack, int pokemon1defense){
        /**
         * calculates the damage caused by pokemon2's attack
         * to pokemon1
         * 
         * @param pokemon2level level of pokemon2
         * @param pokemon2leveledAttack ActualAttack of pokemon2
         * @param pokemon1defense defense stat of pokemon1
         * @return damage caused by pokemon2's attack to pokemon1
         */
         
        Random rand = new Random();
        double modifier = rand.nextDouble()*0.15 + 0.85;
        double pokemon2Damage = modifier * ((2 * pokemon2level + 10)/250.0
        + ((double) pokemon2leveledAttack / pokemon1defense) + 2);
        return pokemon2Damage;
    }
}