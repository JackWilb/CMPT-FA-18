gcc hw3.c
echo "inputfile:"
cat inputfile.txt
./a.out < inputfile.txt > outputfile.txt;
echo "outputfile:"
cat outputfile.txt;