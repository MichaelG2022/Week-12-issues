import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return (a + b);
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	} // end addPositive
	
	int randomNumberSquared() {
		int squaredNumber = getRandomInt();
		return (squaredNumber * squaredNumber);
	} // end randomNumberSquared

	// Method to get a random integer between 1 and 10
	// Package scope for testing - marked as such for future reference
	@VisibleForTesting
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	} // end getRandomInt
	
	

} // end CLASS
