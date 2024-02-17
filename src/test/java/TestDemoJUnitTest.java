import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	} // end assertThatTwoPositiveNumbersAreAddedCorrectly
	
	static Stream<Arguments> argumentsForAddPositive() {
		// @Formatter:off
		
		return Stream.of
		(
				arguments(1, 5, 6, false),
				arguments(-1, 5, 4, true),
				arguments(1, -5, -4, true),
				arguments(-2, -3, -5, true),
				arguments(0, 0, 0, true),
				arguments(42, 0, 42, true),
				arguments(0, 16, 16, true),
				arguments(-7, 0, -7, true),
				arguments(0, -24, -24, true)				
		);
		// @Formatter:on
		
	} // end argumentsForAddPositive
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(1, 5)).isEqualTo(6);
		assertThat(testDemo.addPositive(10, 10)).isEqualTo(20);
		assertThat(testDemo.addPositive(42, 1)).isEqualTo(43);
		assertThat(testDemo.addPositive(1, 15)).isEqualTo(16);	
	} // end assertThatPairsOfPositiveNumbersAreAddedCorrectly
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);

		doReturn(5).when(mockDemo).getRandomInt();

		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);

	} // end assertThatNumberSquaredIsCorrect
	
	

} // end CLASS
