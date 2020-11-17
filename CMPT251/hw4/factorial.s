	.global factorial
	.arm
	.balign 2
	.text
factorial:
	MOV 	R1, R0
	MOV 	R0, #1
	B	Loop

END_STATEMENT:
	bx	lr

Loop:
	CMP 	R1, #1
	BLE	END_STATEMENT
	MUL	R0, R1, R0	
	SUB 	R1, R1, #1
	B 	Loop


		
