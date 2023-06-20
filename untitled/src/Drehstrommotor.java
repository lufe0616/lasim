public class Drehstrommotor {

    private int drehzahl;
    private double drehmoment;
    private double spannung;
    private double stromstaerke;
    private double leistungsfaktor;
    private double getriebeUebersetzung;

    private double m = -0.0455;
    private double b = 68.9275;

    public Drehstrommotor(int drehzahl, double drehmoment, double spannung, double stromstaerke, double leistungsfaktor, double getriebeUebersetzung, double m, double b) {
        this.drehzahl = drehzahl;
        this.drehmoment = drehmoment;
        this.spannung = spannung;
        this.stromstaerke = stromstaerke;
        this.leistungsfaktor = leistungsfaktor;
        this.getriebeUebersetzung = getriebeUebersetzung;
        this.m = m;
        this.b = b;
    }

    public Drehstrommotor(int drehzahl, double drehmoment, double spannung, double stromstaerke, double leistungsfaktor, double getriebeUebersetzung) {
        this.drehzahl = drehzahl;
        this.drehmoment = drehmoment;
        this.spannung = spannung;
        this.stromstaerke = stromstaerke;
        this.leistungsfaktor = leistungsfaktor;
        this.getriebeUebersetzung = getriebeUebersetzung;
    }

    public Drehstrommotor() {

    }

    public int getDrehzahl() {
        return drehzahl;
    }

    public void setDrehzahl(int drehzahl) {
        this.drehzahl = drehzahl;
    }

    public double getDrehmoment() {
        return drehmoment;
    }

    public void setDrehmoment(double drehmoment) {
        this.drehmoment = drehmoment;
    }

    public double getSpannung() {
        return spannung;
    }

    public void setSpannung(double spannung) {
        this.spannung = spannung;
    }

    public double getStromstaerke() {
        return stromstaerke;
    }

    public void setStromstaerke(double stromstaerke) {
        this.stromstaerke = stromstaerke;
    }

    public double getLeistungsfaktor() {
        return leistungsfaktor;
    }

    public void setLeistungsfaktor(double leistungsfaktor) {
        this.leistungsfaktor = leistungsfaktor;
    }

    public double getGetriebeUebersetzung() {
        return getriebeUebersetzung;
    }

    public void setGetriebeUebersetzung(double getriebeUebersetzung) {
        this.getriebeUebersetzung = getriebeUebersetzung;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}
