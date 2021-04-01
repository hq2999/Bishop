mkdir ./ts_list/out/$1/

for file in ./ts_list/$1/*
do
    #file1=${file:10}
	file1=${file##*/}
	key=`cat ./ts_list/$1.key.txt`
	openssl aes-128-cbc -d -in ./ts_list/$1/${file1} -out ./ts_list/out/$1/${file1} -nosalt -iv 0 -K ${key}
	echo ${file1}
done
