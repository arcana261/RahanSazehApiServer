#!/bin/bash

export MONGO_PWD="xxx"
export TS=`date "+%Y-%m-%d-%H-%M"`
export APP_NAME="rahansazeh"
export BACKUP="${APP_NAME}-${TS}"

mkdir -p /root/backups/mongo/${APP_NAME}
cd /root/backups/mongo/${APP_NAME}

/bin/mongodump --host ds159676.mlab.com --port 59676 -d rahansazeh -u arcana261_rahansazeh -p $MONGO_PWD -o ${BACKUP}
tar cvJf ${BACKUP}.tar.xz ${BACKUP}
rm -rfv ${BACKUP}

