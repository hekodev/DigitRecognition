import java.util.Scanner;

class Weight {
    private int[][] zero   = {
            {1,1,1},
            {1,-1,1},
            {1,-1,1},
            {1,-1,1},
            {1,1,1}};
    private int[][] one   = {
            {-1,1,-1},
            {-1,1,-1},
            {-1,1,-1},
            {-1,1,-1},
            {-1,1,-1}};
    private int[][] two   = {
            {1,1,1},
            {-1,-1,1},
            {1,1,1},
            {1,-1,-1},
            {1,1,1}};
    private int[][] three   = {
            {1,1,1},
            {-1,-1,1},
            {1,1,1},
            {-1,-1,1},
            {1,1,1}};
    private int[][] four   = {
            {1,-1,1},
            {1,-1,1},
            {1,1,1},
            {-1,-1,1},
            {-1,-1,1}};
    private int[][] five   = {
            {1,1,1},
            {1,-1,-1},
            {1,1,1},
            {-1,-1,1},
            {1,1,1}};
    private int[][] six   = {
            {1,1,1},
            {1,-1,-1},
            {1,1,1},
            {1,-1,1},
            {1,1,1}};
    private int[][] seven   = {
            {1,1,1},
            {-1,-1,1},
            {-1,-1,1},
            {-1,-1,1},
            {-1,-1,1}};
    private int[][] eight   = {
            {1,1,1},
            {1,-1,1},
            {1,1,1},
            {1,-1,1},
            {1,1,1}};
    private int[][] nine   = {
            {1,1,1},
            {1,-1,1},
            {1,1,1},
            {-1,-1,1},
            {1,1,1}};

    public int[][] getZero() {
        return zero;
    }

    public int[][] getOne() {
        return one;
    }

    public int[][] getTwo() {
        return two;
    }

    public int[][] getThree() {
        return three;
    }

    public int[][] getFour() {
        return four;
    }

    public int[][] getFive() {
        return five;
    }

    public int[][] getSix() {
        return six;
    }

    public int[][] getSeven() {
        return seven;
    }

    public int[][] getEight() {
        return eight;
    }

    public int[][] getNine() {
        return nine;
    }
}

class Machine {
    private Weight weight = new Weight();
    private int[][] input;
    private int[] possibilities = new int[10];

    Machine(int[][] input){
        this.input = input;
    }

    public int interpret(){

        possibilities[0] = getOutput(input, weight.getZero(),7);
        possibilities[1] = getOutput(input, weight.getOne(),1);
        possibilities[2] = getOutput(input, weight.getTwo(),3);
        possibilities[3] = getOutput(input, weight.getThree(),2);
        possibilities[4] = getOutput(input, weight.getFour(),2);
        possibilities[5] = getOutput(input, weight.getFive(),2);
        possibilities[6] = getOutput(input, weight.getSix(),7);
        possibilities[7] = getOutput(input, weight.getSeven(),5);
        possibilities[8] = getOutput(input, weight.getEight(),6);
        possibilities[9] = getOutput(input, weight.getNine(),7);

        int output = 0;
        int check = possibilities[0];

        for(int i = 0; i < 10; i++){
            if(check < possibilities[i]){
                check = possibilities[i];
                output = i;
            }
        }

        return output;
    }

    public int getOutput(int[][] input, int[][] weights, int biasCode){
        int output = 0;

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                output += input[i][j] * weights[i][j];
            }
        }
        switch (biasCode){
            case 1:
                output += 6;
                break;
            case 2:
                output += 0;
                break;
            case 3:
                output += 1;
                break;
            case 5:
                output += 3;
                break;
            case 6:
                output += -2;
                break;
            case 7:
                output += -1;
                break;
        }
        return output;
    }

}
public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[][] inputS = new String[5][3];
        String[] out = new String[5];
        int[][] input = new int[5][3];
        String[] row;

        for (int i = 0; i < 5; i++) {
            String in = scanner.nextLine();
            out[i] = in;
            row = in.split("");
            inputS[i] = row;
        }

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j++){
                if (inputS[i][j].equals("_")){
                    input[i][j] = -1;
                } else if (inputS[i][j].toUpperCase().equals("X")){
                    input[i][j] = 1;
                }
            }
        }

        System.out.println("Input grid:");
        for(int i = 0; i < 5; i++){
            System.out.println(out[i]);
        }
        System.out.println("This number is "+new Machine(input).interpret());
    }
}
