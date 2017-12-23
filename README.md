DNS
===

* Provider: cloudns.net
* Email: m_kh


MLAB
====

**Our MongoDB Database**

* Link: [mlab](https://mlab.com)
* account name: "arcana261_rahansazeh"
* email: "project-rahansazeh@ucoder.ir"
* username: "arcana261_rahansazeh"
* password: usual
* dbname: rahansazeh
* db username: arcana261_rahansazeh
* db password: usual
* mongo shell: mongo ds159676.mlab.com:59676/rahansazeh -u arcana261_rahansazeh -p <dbpassword>
* driver: mongodb://arcana261_rahansazeh:<dbpassword>@ds159676.mlab.com:59676/rahansazeh

Heroku Account 1
================

* First Name: Rahan
* Last Name: Sazeh
* Email: project-rahansazeh@ucoder.ir
* Company: RahanSazeh
* Country: Germany
* Language: Java
* Password: usual
* App Name: rahansazeh-1
* Region: Europe

heroku login
heroku container:login
heroku container:push -a rahansazeh-1 web
heroku config:set -a rahansazeh-1 JAVA_TOOL_OPTIONS="-Xmx300m"
heroku config:set -a rahansazeh-1 DB_PASSWORD=<PASSWORD>
heroku ps:scale -a rahansazeh-1 web=1
heroku logs -a rahansazeh-1 -n 100 -t

Access Application via https://rahansazeh-1.herokuapp.com/

Heroku Account 2
================

* First Name: Sazeh
* Last Name: Rahan
* Email: sazeh-rahan@ucoder.ir
* Company: SazzehRah
* Country: Germany
* Language: Java
* Password: usual
* App Name: rahansazeh-2
* Region: Europe

heroku login
heroku container:login
heroku container:push -a rahansazeh-2 web
heroku config:set -a rahansazeh-2 JAVA_TOOL_OPTIONS="-Xmx300m"
heroku config:set -a rahansazeh-2 DB_PASSWORD=<PASSWORD>
heroku ps:scale -a rahansazeh-2 web=1
heroku logs -a rahansazeh-2 -n 100 -t

Access Application via https://rahansazeh-2.herokuapp.com/

Nginx
=====

** Extract SSL certificates **
** have used "sslforfree" to generate them **

```bash
7za e ssl.7z
tar xvJf ssl.tar.xz
mkdir -p /etc/nginx/ssl/heroku.api.rahansazeh.ucoder.ir
cp -rfv ssl/heroku.api/* /etc/nginx/ssl/heroku.api.rahansazeh.ucoder.ir/
openssl dhparam -out /etc/nginx/ssl/heroku.api.rahansazeh.ucoder.ir/dhparam.pem 4096
mkdir -p /etc/nginx/ssl/api.rahansazeh.ucoder.ir
cp -rfv ssl/api/* /etc/nginx/ssl/api.rahansazeh.ucoder.ir/
openssl dhparam -out /etc/nginx/ssl/api.rahansazeh.ucoder.ir/dhparam.pem 4096
```

**heroku reverse proxy**

* serving srv1.heroku.api.rahansazeh.ucoder.ir
* serving srv2.heroku.api.rahansazeh.ucoder.ir
* serving heroku.api.rahansazeh.ucoder.ir
* serving api.rahansazeh.ucoder.ir

```bash
cp nginx/heroku.api.rahansazeh.ucoder.ir /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf
cp nginx/api.rahansazeh.ucoder.ir /etc/nginx/conf.d/api.rahansazeh.ucoder.ir.conf
```

**secure nginx**

```
http {
    server_tokens       off;
```

Cron Tabs
=========

** Swapping heroku upstreams to keep free account alive **

```bash
0 0 * * 0  /root/RahanSazehApiServer/cron/swap-upstream.sh
```

** Heartbeat to keep server running in free heroku server **

```bash
*/15 * * * * /root/RahanSazehApiServer/cron/heartbeat.sh
```

** Backup (dump) mongodb periodically **

**Set Credentials First!**

**edit cron/crendentials.source file!**

```bash
0    0 * * 0  /root/RahanSazehApiServer/cron/backup-mongodb.sh
```

Lets Encrypt
============

**Step 1**
Install Lets Encrypt Cert Bot

```bash
yum -y install yum-utils
yum-config-manager --enable rhui-REGION-rhel-server-extras rhui-REGION-rhel-server-optional
sudo yum install certbot-nginx
```

**Step 2**
Enable CertBot on our Nginx Configuration

```bash
sudo certbot --nginx
```

**Step 3**
Test if renewal procedure succeeds

```bash
sudo certbot renew --dry-run
```

**Step 4**
Enable CronTab job to renew our certificates automatically

```bash
0 0,12 * * * python -c 'import random; import time; time.sleep(random.random() * 3600)' && certbot renew 
```

Tyk API Gateway
===============

* First Name: Rahan
* Last Name: Sazeh
* Email: project-rahansazeh@ucoder.ir
* Company: RahanSazeh
* Password: usual
* Url: https://rahansazeh.cloud.tyk.io/rahasazeh

Fail2ban DDOS Protection
========================

```bash
[nginx-limit-req-api-rahansazeh]

filter = nginx-limit-req
port    = http,https
logpath = /var/log/nginx/error_api_rahansazeh.log
enabled = true
```

Swagger
=======

Open [http://localhost:3000/v2/api-docs](http://localhost:3000/v2/api-docs)
in browser

GUIDE: [Spring Swagger Guide](https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/)


Notes
=====

-Dspring.profiles.active=dev

docker build -t rahansazeh-api .

application-dev.properties