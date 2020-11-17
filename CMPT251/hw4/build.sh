gcc -S fac.c
as -o fac.o fac.s
as -o factorial.o factorial.s
gcc fac.o factorial.o -o exec
