package repo.Algos;

import java.util.ArrayList;
import java.util.List;

public class FindNumberOfMeetingRoomsRequired {
    public static class Exercise{

        static List<int[]> meetings;

        static void Initialize(){
            meetings = new ArrayList<>();

            meetings.add(new int[]{0,30});
            meetings.add(new int[]{5,10});
            meetings.add(new int[]{15,20});
            meetings.add(new int[]{21,25});
        }

        public static void Run(){

            Initialize();
            FindNumberOfMeetingRooms();
        }

        static void FindNumberOfMeetingRooms(){
            int result = 1;

            for (int i =0; i < meetings.size(); i++){
                for (int j =i+1; j<meetings.size(); j++){

                    if (CheckIfMeetingsOverlap(meetings.get(i), meetings.get(j))){
                        result++;
                    }else {
                        result--;
                    }

                }
            }

            System.out.println("Number of Meeting rooms required : " + result);
        }

        static boolean CheckIfMeetingsOverlap(int[] meeting1, int[] meeting2){
            return (meeting1[0] <= meeting2[0] && meeting1[1] >= meeting2[0]) ;
        }

    }

}
