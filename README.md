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