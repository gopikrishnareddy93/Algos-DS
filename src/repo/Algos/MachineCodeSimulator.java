package repo.Algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MachineCodeSimulator {
    public static class Exercise{
        static List<Integer> input;
        static int[] registers = new int[10];
        static int number_instructions_executed = 0;

        static void Initialize(){
            input = new ArrayList<>();
        }

        public static void Run(){
            try {
                Simulate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        static void Simulate() throws Exception {
            int i =0;

            while(true){

                int instruction = input.get(i);
                number_instructions_executed++;
                if (instruction == 101){
                    break;
                }

                if (instruction >= 0 && instruction < 99 ){
                    throw new Exception("Invalid instruction");
                }

                if (instruction > 101 && instruction <200 ){
                    throw new Exception("Invalid instruction");
                }

                int[] operands = IntToOperandConverter(instruction);

                if (operands[0] == 2){
                    registers[operands[2]] = operands[1];
                }
                else if (operands[0] == 3){
                    registers[operands[2]] = CleanData(registers[operands[2]] + operands[1]);
                }
                else if (operands[0] == 4){
                    registers[operands[2]] = CleanData(registers[operands[2]] - operands[1]);
                }
                else if (operands[0] == 5){
                    registers[operands[2]] = CleanData(registers[operands[2]] * operands[1]);
                }
                else if (operands[0] == 6){
                    registers[operands[2]] = CleanData(registers[operands[2]] + registers[operands[1]]);
                }
                else if (operands[0] == 7){
                    registers[operands[2]] = CleanData(registers[operands[2]] - registers[operands[1]]);
                }
                else if (operands[0] == 8){
                    registers[operands[2]] = CleanData(registers[operands[2]] * registers[operands[1]]);
                }
                else if (operands[0] == 8){
                    i = registers[operands[1]];
                }
            }
        }

        static int[] IntToOperandConverter(int instruction){
            int[] operands = new int[3];

            operands[2] = instruction%10;
            instruction = instruction/10;
            operands[1] = instruction%10;
            instruction = instruction/10;
            operands[0] = instruction;

            return operands;
        }

        //each register can hold a maximum of 000-999
        static int CleanData(int input){
            return input%1000;
        }

    }
}
