export i=y
while [ $i == y ]; do
	nano jh.c
	gcc jh.c 
	./a.out
	read -p "continue? y/n:> " i
done
