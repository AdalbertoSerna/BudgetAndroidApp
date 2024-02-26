package edu.utsa.cs3443.budget_tracker.Model;

public class Budgeter {
    double needs, wants, savings;
    PaycheckCalc pay = new PaycheckCalc();
    float needsPerc = 55, wantsPerc = 30, savingsPerc = 15;

    private static Budgeter budgeter = null;
    private Budgeter(float needs, float wants, float savings) {
        this.needsPerc = needs;
        this.wantsPerc = wants;
        this.savingsPerc = savings;
    }
    public static Budgeter getInstance(float needs, float wants, float savings) {
        if(budgeter == null){
            budgeter = new Budgeter(needs, wants, savings);
        }
        return budgeter;
    }
    public static Budgeter getInstance() {
        return budgeter;
    }

    public void calcBudget(double payAmount){
     needs = payAmount * needsPerc / 100;
     wants = payAmount * wantsPerc / 100;
     savings = payAmount * savingsPerc / 100;

    }

    public double getNeeds() {
        return needs;
    }

    public double getWants() {
        return wants;
    }

    public double getSavings() {
        return savings;
    }
}
