function returnSubDirectories() {
for i in $(ls); do
	if [ -d $i ]; then
		cd $i
		returnSubDirectories
		pwd
		cd ..
	fi
done
}

returnSubDirectories