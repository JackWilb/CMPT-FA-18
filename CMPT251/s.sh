for i in $(ls); do
	if [ -d $i ]; then
		cd $i
		pwd
		cd ..
	fi
done
