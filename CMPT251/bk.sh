firefox &
export i=$(ps | grep firefox)
echo $i
[[ $i =~ ([1234567890]{4}).* ]]
echo ${BASH_REMATCH}
echo ${BASH_REMATCH[1]}
kill ${BASH_REMATCH[1]}
