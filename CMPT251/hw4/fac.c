#include <stdio.h>
extern int factorial(int n);
int factorial_inefficient(int n) {
	int counter = n;
	int result = 1;
	while( counter > 1) {
		result = result * counter;
		counter--;
	}
	return result;
}



int main() {
	int inef = factorial_inefficient(5);
	int ef = factorial(5);
	printf("inefficient: %d, efficient: %d\n", inef, ef);
	return 0;
}

