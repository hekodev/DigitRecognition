import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Interpret {
    String[][] grid = new String[3][3];
    ArrayList<Neuron> neurons = new ArrayList<>();

    Interpret(String input){
        initialize(input);
        interpret();
    }

    public void initialize(String input){
        int j = 0;
        int k = 0;
        for(int i = 0; i < input.length() || j!= 3; i++){
            if(String.valueOf(input.charAt(i)).equals("_")){
                grid[j][k]="_";
                neurons.add(new Neuron(0));
                k++;
                if(k == 3) {
                    k = 0;
                    j++;
                }
            } else if(String.valueOf(input.charAt(i)).equals("X")){
                grid[j][k]="X";
                neurons.add(new Neuron(1));
                k++;
                if(k == 3) {
                    k = 0;
                    j++;
                }
            }
        }
    }

    public void interpret(){
        int[] w = {2,1,2,4,-4,4,2,-1,2};
        int b = -5;
        int result = 0;

        for(int i  = 0; i < neurons.size(); i++){
            result += neurons.get(i).getValue()*w[i];
        }

        System.out.println("Input grid:");
        for(String[] s:grid){
            System.out.println(Arrays.toString(s));
        }
        if ((result+b) >= 0){
            System.out.println("This number is 0");
        } else
            System.out.println("This number is 1");

    }


}

class Neuron{
    private static int id;
    private int value;

    Neuron(int value){
        this.value = value;
        this.id = id++;
    }

    public String getId() {
        return "a"+id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = "";

        for(int i = 0; i < 3; i++){
            input += scanner.nextLine();
        }

        new Interpret(input);
    }
}
