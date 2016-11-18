public class Date {
	private int day;
	private int month;
	private int year;

	public Date(int year, int month, int day){
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Date(){
		this.day = 1;
		this.month = 1;
		this.year = 1000;
	}

	public void setDate(int year, int month, int day){
		if(year % 4 != 0){
			this.year = year;
			if(month == 2 && day <= 28){
				this.month = month;
				this.day = day;
			}
			else{
				throw new IllegalArgumentException("Day is invalid!");
			}
		}
		else{
			this.year = year;
			this.month = month;
			this.day = day;
		} 
	}

	public String toString(){
		return String.format("%02d/%02d/%d", day, month, year);
	}
	public int getDay(){
		return day;
	}

	public void setDay(int day){
		if(day >= 1 && day <= 31){
			if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day <= 31)){
				this.month = month;
				this.day = day;
			}
			else if((month == 4 || month == 6 || month == 9 || month == 11) && (day <= 30)){
				this.month = month;
				this.day = day;
			}
			else if((month == 2) && (day <= 29)){
				this.month = month;
				this.day = day;
			}

			else{
				throw new IllegalArgumentException("Day is invalid!");
			}
		}
		else{
			throw new IllegalArgumentException("Day is invalid!");
		}


	}

	public int getMonth(){
		return month;
	}

	public void setMonth(int month){
		if(month >= 1 && month <= 12){
			this.month = month;
		}
		else{
			throw new IllegalArgumentException("Month is invalid!");
		}
	}

	public int getYear(){
		return year;
	}

	public void setYear(int year){
		if(year >= 1000 && year <= 9999){
			this.year = year;
		}
		else{
			throw new IllegalArgumentException("Year is invalid!");
		}
	}
}