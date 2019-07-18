docker pull delron/fastdfs

docker run -d --network=host --name tracker -v /var/fdfs/tracker:/var/fdfs delron/fastdfs tracker

docker run -d --network=host --name storage -e TRACKER_SERVER=49.234.188.53:22122 -v /var/fdfs/storage:/var/fdfs -e GROUP_NAME=group1 delron/fastdfs storage


wKgBcFvTv86AOwckAAFbd_uukFc519.png
将文件放到 /var/fdfs/storage/data/00/00下
访问
http://49.234.188.53:8888/group1/M00/00/00/wKgBcFvTv86AOwckAAFbd_uukFc519.png
ojbk 折磨了我好久，
