#include <stdio.h>

int main(int n, char** args) {
	int i;
	FILE* input = fopen(args[1], "r");
	FILE* output = fopen(args[2], "w");
	while (fscanf(input, "%d", &i) == 1) {
		fprintf(output, "%d\n", i);
	}
	return 0;
} 