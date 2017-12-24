#!/bin/bash

export TS=`date "+%Y-%m-%d-%H-%M"`
mkdir -p /root/backups/rahansazeh/nginx

cp -f /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf /root/backups/rahansazeh/nginx/$TS-heroku.api.conf


/bin/cat /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf | /bin/sed -e "s/^\(\s*\)server\(\s\+\)\(\S\+\)\(\s*\);\(\s*\)$/\1server\2\3 backup_temp\4;\5/g" > /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf.new

/bin/cat /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf.new | /bin/sed -e "s/^\(\s*\)server\(\s\+\)\(\S\+\)\(\s\+\)backup\(\s*\);\(\s*\)$/\1server\2\3\5;\6/g" > /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf.new2

/bin/cat /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf.new2 | /bin/sed -e "s/^\(\s*\)server\(\s\+\)\(\S\+\)\(\s\+\)backup_temp\(\s*\);\(\s*\)$/\1server\2\3\4backup\5;\6/g" > /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf.new3

rm -f /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf
rm -f /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf.new
rm -f /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf.new2
mv /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf.new3 /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf

/sbin/nginx -t && /bin/systemctl restart nginx.service
