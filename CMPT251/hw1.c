#include <stdio.h>
#include <stdlib.h>

int main () {
	while (1) {
		printf("Type 1 for triangle, 2 for square, and 3 to quit.\n");
		int input;
		int how_many_items = scanf("%d", &input);

		if (how_many_items == 0){
			char junk = 'a';
			do {
				scanf("%c", &junk);
			} while(junk != '\n');
		}

		switch (input) {
			case 1 :
				printf(".\n");
				printf("..\n");
				printf("...\n");
				printf("....\n");
				printf(".....\n");
				break;
			case 2 :
				printf(".....\n");
				printf(".   .\n");
				printf(".   .\n");
				printf(".....\n");
				break;
			case 3 :
				exit(0);
				break;
			default :
				printf("Please enter 1, 2, or 3.\n");
				break;
			}
	}
}
