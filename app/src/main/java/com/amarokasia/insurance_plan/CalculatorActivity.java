package com.amarokasia.insurance_plan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2);

        myDb = new DatabaseHelper(this);
    }

    public void calculate(View view){

        EditText txtIncome = findViewById(R.id.txtIncome);
        EditText txtBill = findViewById(R.id.txtBills);
        EditText txtRental = findViewById(R.id.txtRental);
        EditText txtMedical = findViewById(R.id.txtMedical);
        EditText txtLoan = findViewById(R.id.txtLoan);
        TextView txtMonthlyInstallment = findViewById(R.id.txtMonthlyInstallment);
        TextView txtBestPlan = findViewById((R.id.txtBestPlan));


        try {
            double income = Double.parseDouble(txtIncome.getText().toString());
            double bills = Double.parseDouble(txtBill.getText().toString());
            double rental = Double.parseDouble(txtRental.getText().toString());
            double medical = Double.parseDouble(txtMedical.getText().toString());
            double loan = Double.parseDouble(txtLoan.getText().toString());


            /*Calculation
            * Profit =Income - (Total Bills + Rent + Medical + Loan)
            * Monthly installment = Profit/4
            * Best plan = Monthly installment * 12
            * */


            double monthlyInstallments = calcMonthlyinstallment(income, bills, rental, medical, loan);
            double bestPlan = calcBestPlan(monthlyInstallments);

            txtMonthlyInstallment.setText("Monthly Installment : Rs."+Double.toString(monthlyInstallments));
            txtBestPlan.setText("Best Suitable Plan : Rs."+Double.toString(bestPlan));

            saveData(income,bills,rental,medical,loan, monthlyInstallments, bestPlan);

//            Toast.makeText(this, "Clicked"+(Double.toString(income+bills)), Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
//            Toast.makeText(this, "Clicked"+e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    public double calcMonthlyinstallment(double income, double bills, double rental, double medical, double loan){
        double monthlyInstallment = 0.0;
        double profit = income - (bills+rental+medical+loan);
        monthlyInstallment = profit/4;

        return  monthlyInstallment;
    }


    public double calcBestPlan(double monthlyInstallment){
        double bestPlan = monthlyInstallment*12;
        return bestPlan;
    }

    public  void saveData(double income, double bills, double rental, double medical, double loan, double installments, double plan){
        boolean isInserted = myDb.insertData(income, bills, rental, medical, loan, installments, plan);
        if (isInserted){
            Toast.makeText(this, "Inserted To Database", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Failed To Database", Toast.LENGTH_SHORT).show();
        }
    }
}
