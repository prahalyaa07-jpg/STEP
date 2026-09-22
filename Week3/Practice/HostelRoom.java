class HostelRoomData {
    String roomNo;
    int occupied;
}

public class HostelRoom {

    public static void main(String[] args) {

        HostelRoomData roomA = new HostelRoomData();
        HostelRoomData roomB = new HostelRoomData();

        roomA.roomNo = "C-101";
        roomB.roomNo = "C-102";

        roomA.occupied++;
        roomA.occupied++;
        roomA.occupied++;

        System.out.println(roomA.roomNo
                + " occupied: " + roomA.occupied);

        System.out.println(roomB.roomNo
                + " occupied: " + roomB.occupied);
    }
}
