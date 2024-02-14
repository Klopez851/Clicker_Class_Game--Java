/* File: Game.java
 * Author: Dr. Huelsman
 * Created On: 03 Apr 2023
 * Purpose:
 * Notes:
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<ClickerObject> pieces;
    private boolean valid;

    public Game(String game_file){
        valid = true;
        pieces = new ArrayList<>();
        File in_file = new File(game_file);
        if(!in_file.exists()){
            valid = false;
            return;
        }
        try{
            Scanner fin = new Scanner(in_file);
            fin.nextLine();
            while(fin.hasNextLine()){
                String line = fin.nextLine();
                line = line.trim();
                if(line.isEmpty())continue;
                String[] elements = line.split(",");
                String name = elements[0].trim();
                int cost = Integer.parseInt(elements[1].trim());
                int production = Integer.parseInt(elements[2].trim());
                int timing = Integer.parseInt(elements[3].trim());
                ClickerObject current = new ClickerObject(name, cost, production, timing);
                pieces.add(current);
            }
            fin.close();
        } catch(IOException exp){
            valid = false;
        }
    }

    public boolean isValid(){
        return valid;
    }

    public ClickerObject get(int index){
        return pieces.get(index);
    }

    public int size(){
        return pieces.size();
    }
}
