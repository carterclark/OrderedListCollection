/**
 * This class represents one job in the technology sector
 * 
 * @author Carter Clark
 */

import java.text.DecimalFormat;

public class TechJob implements Comparable<TechJob>{
	
	//instance variables
	private String job;
	private int percentGrowth;
	private double avgSalary;
	
	//static object for formatting output
	private static DecimalFormat dfDoller = new DecimalFormat("$###,###.##");
	
	//getters and setters
	public int getPercentGrowth() {
		return percentGrowth;
	}
	
	public void setPercentGrowth(int percentGrowth) {
		this.percentGrowth = percentGrowth;
	}
	
	public double getAvgSalary() {
		return avgSalary;
	}
	
	public void setAvgSalary(int avgSalary) {
		this.avgSalary = avgSalary;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	/**
	 * Constructor
	 * @param job - name of job
	 * @param percentGrowth - projected job growth in percent
	 * @param avgSalary - average salary of job
	 */
	TechJob(String job, int percentGrowth, double avgSalary){
		
		this.job = job;
		this.percentGrowth = percentGrowth;
		this.avgSalary = avgSalary;
	}
	
	/**
	 * Constructor
	 * @param job - name of job
	 */
	TechJob(String job){
		this.job = job;
		this.percentGrowth = 0;
		this.avgSalary = 0;
	}
	
	TechJob(){
		this.job = "";
		this.percentGrowth = 0;
		this.avgSalary = 0;
	}
	
	/**
	 * returns the properties of TechJob into a formatted string
	 * 
	 * @return Formated string
	 */
	@Override
	public String toString() {
		
		return this.makeSpaces(job)
				+ percentGrowth + "%\t\t\t"
				+ dfDoller.format(avgSalary)
				+ "\n";
		
		//return str;
	}
	
	/**
	 * determines the equality of two TechJobs by there names
	 * 
	 * @param other - Object of type TechJob
	 * 
	 * @return 	TRUE if the TechJobs have the same name
	 * 			FALSE if the TechJobs do not have the same name
	 */
	@Override
	public boolean equals(Object other) {
		
		if(other instanceof TechJob) {
			return this.job.equalsIgnoreCase(((TechJob) other).job);
		}
		
		else {
			return false;
		}
		
	}
	
	/**
	 * compares one TechJob to a different TechJob
	 * 
	 * @param other - the other TechJob to compare
	 * 
	 * @return 	an number less than 0		if the other TechJob has a higher precedence
	 * 			0 							if the TechJobs have equal precedence
	 * 			an number greater than 0	if the other TechJob has lower precedence
	 */
	@Override
	public int compareTo(TechJob other) {
		
		return this.getJob().compareToIgnoreCase(other.getJob());
	}
	
	/**
	 * creates a certain number of spaces after a string for formatting the toString method
	 * 
	 * @param str - a string to be formatted
	 * 
	 * @return a string with the correct number of spaces after it
	 */

	public String makeSpaces(String str) {
		
		int len = 30 - str.length();
		
		for(int i=0; i<len; i++) {
			str += " ";
		}
		
		return str + "\t";
	}
	
}
