import java.util.*;

public class DrehstrommotorMain {
    public static void main(String[] args) {
        /*
        Drehstrommotor sewMotor = new Drehstrommotor(1405, 5, 230, 1.26, 0.66, 3.37);
        System.out.println(sewMotor.getDrehzahlBeiLast(3.5));
        System.out.println(sewMotor.getStromstaerkeBeiLast(3.5));
        */

        Scanner sc = new Scanner(System.in);
        Drehstrommotor dm = new Drehstrommotor();

        System.out.print("Bitte Drehzahl eingeben: ");
        dm.setDrehzahl(sc.nextInt());
        System.out.print("Bitte Drehmoment in Nm eingeben: ");
        dm.setDrehmoment(sc.nextDouble());
        System.out.print("Bitte Spannung in V eingeben: ");
        dm.setSpannung(sc.nextDouble());
        System.out.print("Bitte Stromstärke in A eingeben: ");
        dm.setStromstaerke(sc.nextDouble());
        System.out.print("Bitte Leistungsfaktor eingeben: ");
        dm.setLeistungsfaktor(sc.nextDouble());
        System.out.print("Bitte Getriebeübersetzung eingeben: ");
        dm.setGetriebeUebersetzung(sc.nextDouble());
        System.out.print("Bitte Last in Nm eingeben: ");
        dm.setLast(sc.nextDouble());
    }
}