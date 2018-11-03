#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
	struct Node * nextNode;
	int data;
} Node;

void add(Node* head, int i);
Node* removeNode(Node* head);

int main() {
	int i = 0;
	Node* head;
	head = malloc(sizeof(Node));
	head->nextNode = 0;
	head->data = 0;
	int length = 0;

	while (scanf("%d", &i) == 1) {
		add(head, i);
		length++;
	}

	for (int j = 0; j < length; j++) {
		head = removeNode(head);
	}
}

void add(Node* head, int i) {

	if (!head->data) {
		head->data = i;
	} else {
		Node* newNode;
		newNode = malloc(sizeof(Node));
		newNode->data = i;
		newNode->nextNode = 0;

		//traverse to the end and add
		Node* current = head;

		while (current->nextNode != 0) {
			current = current->nextNode;
		}

		current->nextNode = newNode;
	}
	return;
}

Node* removeNode(Node* head) {
	printf("%d\n", head->data);
	head = head->nextNode;
	return head;
}