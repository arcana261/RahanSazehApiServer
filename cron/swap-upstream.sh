#!/bin/bash

/bin/cat /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf | /bin/sed -e "s/^\(\s*\)server\(\s\+\)\(\S\+\)\(\s*\);\(\s*\)$/\1server\2\3 backup_temp\4;\5/g" > /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf

/bin/cat /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf | /bin/sed -e "s/^\(\s*\)server\(\s\+\)\(\S\+\)\(\s\+\)backup\(\s*\);\(\s*\)$/\1server\2\3\5;\6/g" > /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf

/bin/cat /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf | /bin/sed -e "s/^\(\s*\)server\(\s\+\)\(\S\+\)\(\s\+\)backup_temp\(\s*\);\(\s*\)$/\1server\2\3\4backup\5;\6/g" > /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf

/sbin/nginx -t && /bin/systemctl restart nginx.service
