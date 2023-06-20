public class DrehstrommotorMain {
    public static void main(String[] args) {
        Drehstrommotor sewMotor = new Drehstrommotor(1405, 5, 230, 1.26, 0.66, 3.37);
        System.out.println(sewMotor.getDrehzahlBeiLast(3.5));
        System.out.println(sewMotor.getStromstaerkeBeiLast(3.5));
    }
}