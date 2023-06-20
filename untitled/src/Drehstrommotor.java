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
        setDrehzahl(drehzahl);
        setDrehmoment(drehmoment);
        setSpannung(spannung);
        setStromstaerke(stromstaerke);
        setLeistungsfaktor(leistungsfaktor);
        setGetriebeUebersetzung(getriebeUebersetzung);
        this.m = m;
        this.b = b;
    }

    public Drehstrommotor(int drehzahl, double drehmoment, double spannung, double stromstaerke, double leistungsfaktor, double getriebeUebersetzung) {
        setDrehzahl(drehzahl);
        setDrehmoment(drehmoment);
        setSpannung(spannung);
        setStromstaerke(stromstaerke);
        setLeistungsfaktor(leistungsfaktor);
        setGetriebeUebersetzung(getriebeUebersetzung);
    }

    public Drehstrommotor() {

    }

    public int getDrehzahl() {
        return drehzahl;
    }

    public void setDrehzahl(int drehzahl) {
        if(drehzahl < 0){
            throw new IllegalArgumentException("Drehzahl darf nicht negativ sein.");
        }else{
            this.drehzahl = drehzahl;
        }
    }

    public double getDrehmoment() {
        return drehmoment;
    }

    public void setDrehmoment(double drehmoment) {
        if(drehmoment < 0){
            throw new IllegalArgumentException("Drehmoment darf nicht negativ sein.");
        }else{
            this.drehmoment = drehmoment;
        }
    }

    public double getSpannung() {
        return spannung;
    }

    public void setSpannung(double spannung) {
        if(drehmoment < 0){
            throw new IllegalArgumentException("Spannung darf nicht negativ sein.");
        }else{
            this.spannung = spannung;
        }
    }

    public double getStromstaerke() {
        return stromstaerke;
    }

    public void setStromstaerke(double stromstaerke) {
        if(drehmoment < 0){
            throw new IllegalArgumentException("Spannung darf nicht negativ sein.");
        }else{
            this.stromstaerke = stromstaerke;
        }
    }

    public double getLeistungsfaktor() {
        return leistungsfaktor;
    }

    public void setLeistungsfaktor(double leistungsfaktor) {
        if(drehmoment < 0){
            throw new IllegalArgumentException("Leistungsfaktor darf nicht negativ sein.");
        }else{
            this.leistungsfaktor = leistungsfaktor;
        }
    }

    public double getGetriebeUebersetzung() {
        return getriebeUebersetzung;
    }

    public void setGetriebeUebersetzung(double getriebeUebersetzung) {
        if(drehzahl < 0){
            throw new IllegalArgumentException("Getriebeübersetzung darf nicht negativ sein.");
        }else{
            this.getriebeUebersetzung = getriebeUebersetzung;
        }
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

    public double getDrehzahlBeiLast(double last) {
        return (last-this.b) / this.m;
    }

    public double getStromstaerkeBeiLast(double last) {
        double p = (last*getDrehzahlBeiLast(last))/(this.getriebeUebersetzung*9550);
        return p/this.spannung;
    }
}
