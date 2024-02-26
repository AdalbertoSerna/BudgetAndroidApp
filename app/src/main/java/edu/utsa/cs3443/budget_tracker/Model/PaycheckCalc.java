package edu.utsa.cs3443.budget_tracker.Model;

public class PaycheckCalc {

    float payrate = 15;
    float pretaxPay = 0;
    float grossPay = 0;
    float totalhours = 0;


    public void setTotalhours(float week1hours, float week2hours){
        totalhours = week1hours + week2hours;
    }
    public void grossPayCalc(){
        pretaxPay = payrate * totalhours;
        grossPay = (float) (pretaxPay - (pretaxPay * .15));
    }
    public double getGrossPay(){
        return grossPay;
    }
}
