	.section	__TEXT,__text,regular,pure_instructions
	.build_version macos, 10, 14
	.globl	_factorial_inefficient  ## -- Begin function factorial_inefficient
	.p2align	4, 0x90
_factorial_inefficient:                 ## @factorial_inefficient
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movl	%edi, -4(%rbp)
	movl	-4(%rbp), %edi
	movl	%edi, -8(%rbp)
	movl	$1, -12(%rbp)
LBB0_1:                                 ## =>This Inner Loop Header: Depth=1
	cmpl	$1, -8(%rbp)
	jle	LBB0_3
## %bb.2:                               ##   in Loop: Header=BB0_1 Depth=1
	movl	-12(%rbp), %eax
	imull	-8(%rbp), %eax
	movl	%eax, -12(%rbp)
	movl	-8(%rbp), %eax
	addl	$-1, %eax
	movl	%eax, -8(%rbp)
	jmp	LBB0_1
LBB0_3:
	movl	-12(%rbp), %eax
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.globl	_main                   ## -- Begin function main
	.p2align	4, 0x90
_main:                                  ## @main
	.cfi_startproc
## %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	$5, %edi
	movl	$0, -4(%rbp)
	callq	_factorial_inefficient
	movl	$5, %edi
	movl	%eax, -8(%rbp)
	callq	_factorial
	leaq	L_.str(%rip), %rdi
	movl	%eax, -12(%rbp)
	movl	-8(%rbp), %esi
	movl	-12(%rbp), %edx
	movb	$0, %al
	callq	_printf
	xorl	%edx, %edx
	movl	%eax, -16(%rbp)         ## 4-byte Spill
	movl	%edx, %eax
	addq	$16, %rsp
	popq	%rbp
	retq
	.cfi_endproc
                                        ## -- End function
	.section	__TEXT,__cstring,cstring_literals
L_.str:                                 ## @.str
	.asciz	"inefficient: %d, efficient: %d\n"


.subsections_via_symbols
