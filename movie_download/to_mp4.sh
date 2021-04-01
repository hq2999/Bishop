file_array=(38.ts)

for file in ${file_array[@]}
do
	ffmpeg -i "${file}" -threads 4 "${file}.mp4"
done