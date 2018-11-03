#include <stdio.h>
#include <stdlib.h>

int main(int n, char** args) {
	int j = 2;
	int k = 0;
	int* i = malloc(j * sizeof( int ));

	FILE* input = fopen(args[1], "r");
	FILE* output = fopen(args[2], "w");

	while (1) {
		
		if (k == j) {
		j = j * 2;
		printf("j = %d\n", j);
		int* temp = malloc(j * sizeof( int ));

		for (int a = 0; a < k; a++) {
			temp[a] = i[a];
		};

		i = temp;
		} 

		if (fscanf(input, "%d", (i + k)) == 1) {
			printf("k = %d\n", k);
			printf("success\n");
			k = k + 1;
		} else {
			break;
		}
	};

	for (int a = 0; a < k; a++) {
		fprintf(output, "%d\n", *(i + a));
	};

	return 0;
}