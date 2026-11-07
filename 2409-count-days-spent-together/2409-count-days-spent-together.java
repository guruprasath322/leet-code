class Solution {
    public int countDaysTogether(
            String arriveAlice,
            String leaveAlice,
            String arriveBob,
            String leaveBob) {

        String[] alliceArriveInfo = arriveAlice.split("-");
        String[] bobArriveInfo = arriveBob.split("-");

        String[] alliceLeaveInfo = leaveAlice.split("-");
        String[] bobLeaveInfo = leaveBob.split("-");

        if (!isOverlap(alliceArriveInfo[0], alliceLeaveInfo[0], bobArriveInfo[0], bobLeaveInfo[0])) {
            return 0;
        }

        String start = "";

        if (alliceArriveInfo[0].equals(bobArriveInfo[0])) {
            start = alliceArriveInfo[0] +
                    "-" +
                    Math.max(
                            Integer.parseInt(alliceArriveInfo[1]),
                            Integer.parseInt(bobArriveInfo[1]));
        } else {
            if (Integer.parseInt(alliceArriveInfo[0]) > Integer.parseInt(bobArriveInfo[0])) {
                start = arriveAlice;
            } else {
                start = arriveBob;
            }
        }

        String end = "";

        if (alliceLeaveInfo[0].equals(bobLeaveInfo[0])) {
            end = alliceLeaveInfo[0] +
                    "-" +
                    Math.min(
                            Integer.parseInt(bobLeaveInfo[1]),
                            Integer.parseInt(alliceLeaveInfo[1]));
        } else {
            if (Integer.parseInt(alliceLeaveInfo[0]) > Integer.parseInt(bobLeaveInfo[0])) {
                end = leaveBob;
            } else {
                end = leaveAlice;
            }
        }

        String[] startInfo = start.split("-");
        String[] endInfo = end.split("-");
        int day = getDay(startInfo, endInfo);
        return day > 0 ? day : 0;
    }

    public static int getDay(String[] startInfo, String[] endInfo) {
        int startMonth = Integer.parseInt(startInfo[0]);
        int startMonthDay = getMonthOfDay(startMonth - 1);
        int endMonth = Integer.parseInt(endInfo[0]);
        int endMonthDay = getMonthOfDay(endMonth - 1);

        int startDay = Integer.parseInt(startInfo[1]);
        int endDay = Integer.parseInt(endInfo[1]);

        if (startMonth - endMonth == 0) {
            return endDay - startDay + 1;
        }

        //month in between
        int between = 0;

        for(int i = startMonth + 1; i < endMonth; i++) {
            between += getMonthOfDay(i -1);
        }

        return (startMonthDay - startDay) + between + endDay + 1 ;
    }
    //12-26
    //12-17

    public static boolean isOverlap(String alliceArriveMonth, String alliveLeaveMonth, String bobArriveMonth,
            String bobLeaveMonth) {
        boolean checkAllice = (convertInt(alliceArriveMonth) >= convertInt(bobArriveMonth) &&
                convertInt(bobLeaveMonth) >= convertInt(alliceArriveMonth))
                || (convertInt(alliveLeaveMonth) >= convertInt(bobArriveMonth) &&
                        convertInt(bobLeaveMonth) >= convertInt(alliveLeaveMonth));

        boolean checkBob = (convertInt(bobArriveMonth) >= convertInt(alliceArriveMonth) &&
                convertInt(alliveLeaveMonth) >= convertInt(bobArriveMonth))
                || (convertInt(bobLeaveMonth) >= convertInt(alliceArriveMonth) &&
                        convertInt(alliveLeaveMonth) >= convertInt(bobLeaveMonth));

        return checkAllice || checkBob;
    }

    public static int convertInt(String s) {
        return Integer.parseInt(s);
    }

    public static int getMonthOfDay(int month) {
        int[] dayOfMonth = new int[] {
                31,
                28,
                31,
                30,
                31,
                30,
                31,
                31,
                30,
                31,
                30,
                31,
        };
        return dayOfMonth[month];
    }
}