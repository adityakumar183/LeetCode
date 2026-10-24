class Solution {
    public int convert(String date, int[] days) {
        int month = (date.charAt(0) - '0') * 10 + (date.charAt(1) - '0');

        int day = (date.charAt(3) - '0') * 10 + (date.charAt(4) - '0');

        for (int i = 0; i < month - 1; i++) {
            day += days[i];
        }
        return day;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int a1 = convert(arriveAlice, days);
        int a2 = convert(leaveAlice, days);
        int b1 = convert(arriveBob, days);
        int b2 = convert(leaveBob, days);

        int start = 0;
        int end = 0;

        if(a1>b1) start = a1;
        else start = b1;
        
        if(a2<b2) end = a2;
        else end = b2;

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }
}