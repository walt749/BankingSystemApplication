//import javax.swing.JOptionPane;



public class Loan {

	double[] cflow;
	double interest = 0.05;
	private double dloan,loan, givenLoan;
	private static double debt;
	boolean hasLoan = false;
	
	
	
	public Loan(double[] cflow) {
		// TODO Auto-generated constructor stub
		this.cflow = cflow;
		
		
		loan = CalculateLoan();
		
		
	}
	public double CalCulateDebt() {
		return loan * (1*interest);
	}
	
	public double CalculateLoan() {
		 double ave = (cflow[0]+cflow[1]+cflow[2]+cflow[3])/4;
		 
		 return ave;
	}
	public void setDesiredLoan(double d) {
		dloan = d;
	}
	
	public double giveLoan() {
		double lo = 0;
		
		if(dloan <= loan ) {
			lo = dloan;
		}
		else if(dloan > loan) {
			
				
			
			    lo = loan;
			
		}
		givenLoan = givenLoan + lo;
		
		return lo;
	}
	
	public void setDebt() {
		
		System.out.println("fdebt"+debt);
		 debt = debt + givenLoan*(1+interest);
		 hasLoan = true;
		
		 System.out.println(debt +" ," +givenLoan);
	}
	 
	
	
	public double getDebt() {		
		
		return debt;

		
	}
	public void pay(double a) {
		
		debt = debt - a;
		
	}
	public double getInterest() {
		return interest;
	}
	
	public double getLoan() {
		return loan;
	}
	
	public void setLoan(double loan) {
		this.loan = loan;
		
	}
	
	public double getDesiredloan() {
		return dloan;
	}
	
	public void cancel() {
		
		debt = debt - givenLoan*(1+interest);
		hasLoan = false;
	}
	
	public boolean hasLoan() {
		return hasLoan;
	}
	
	
	

}
