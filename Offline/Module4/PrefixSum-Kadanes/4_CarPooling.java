class Solution {

    // public class Trip implements Comparable<Trip>{
    //     int numPassanger;
    //     int st;
    //     int en;
    //     public Trip(int numPass, int st, int en){
    //         this.numPassanger = numPass;
    //         this.st = st;
    //         this.en = en;
    //     }

    //     public int compareTo(Trip obj){
    //         return obj.st - this.st;
    //     }
    // }
    public boolean carPooling(int[][] trips, int capacity) {
        // a, b 
        //Arrays.sort(trips, (a, b) -> a[1] -b[1]);
        // Trip [] tripsArr = new int[trips.length];
        // for(int i = 0; i < trips.length; i++){
        //     Trip obj = new Trip(trips[i][0], trips[i][1], trips[i][2]);
        //     tripsArr[i] = obj;
        // }
        // Arrays.sort(tripArr);

        Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int currCapacity = 0; // 

        for(int i = 0; i < trips.length; i++){
            int [] trip = trips[i];
            int currSt = trip[1];
            while(pq.size() > 0 &&  currSt >= pq.peek()[2]){
                int [] rem = pq.remove();
                currCapacity -= rem[0];
            }
            if(currCapacity + trip[0] <= capacity){
                currCapacity += trip[0];
                pq.add(trip);
            }else{
                return false;
            }
        }
        return true;

    }
}
