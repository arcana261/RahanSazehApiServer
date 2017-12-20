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
* mongo shell: mongo ds159676.mlab.com:59676/rahansazeh -u <dbuser> -p <dbpassword>
* driver: mongodb://<dbuser>:<dbpassword>@ds159676.mlab.com:59676/rahansazeh

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

**heroku reverse proxy**

* serving srv1.heroku.api.rahansazeh.ucoder.ir
* serving srv2.heroku.api.rahansazeh.ucoder.ir
* serving heroku.api.rahansazeh.ucoder.ir

```bash
cp nginx/heroku.api.rahansazeh.ucoder.ir /etc/nginx/conf.d/heroku.api.rahansazeh.ucoder.ir.conf
```

Cron Tabs
=========

** Swapping heroku upstreams to keep free account alive **

```bash
0 0 * * 0  /root/RahanSazehApiServer/cron/swap-upstream.sh
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