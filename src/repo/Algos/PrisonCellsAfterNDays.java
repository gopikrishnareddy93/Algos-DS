package repo.Algos;

public class PrisonCellsAfterNDays {

    public static class Exercise{

        static int[] cells = new int[]{0,1,0,1,1,0,0,1};
        static int days = 7;

        public static void Run(){
            Analyze();
        }

        static void Analyze(){

            int[] newCells = new int[cells.length];

            while (days > 0){
                for (int i = 1 ; i < cells.length - 1; i++){
                    newCells[i] = cells[i+1] == cells[i-1] ? 1 : 0;
                }
                newCells[0] = 0;
                newCells[cells.length - 1] = 0;

                days--;
                cells = newCells.clone();
            }

            for (int cell: cells) {
                System.out.print(cell + "\t");
            }


        }

    }

}
