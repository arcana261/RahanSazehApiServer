#!/bin/bash

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

source "${DIR}/credentials.source"

export TS=`date "+%Y-%m-%d-%H-%M"`
export APP_NAME="rahansazeh"
export BACKUP="${APP_NAME}-${TS}"
export MONGO_HOST="ds159676.mlab.com"
export MONGO_PORT="59676"
export FTP_HOST="b103545.parspack.org"

mkdir -p /root/backups/${APP_NAME}/mongo
cd /root/backups/${APP_NAME}/mongo

/bin/mongodump --host $MONGO_HOST --port $MONGO_PORT -d rahansazeh -u $MONGO_USER -p $MONGO_PWD -o ${BACKUP}
rc=$?; if [[ $rc != 0 ]]; then exit $rc; fi

tar cvJf ${BACKUP}.tar.xz ${BACKUP}
rc=$?; if [[ $rc != 0 ]]; then exit $rc; fi

rm -rfv ${BACKUP}
rc=$?; if [[ $rc != 0 ]]; then exit $rc; fi

echo "
 verbose
 open ${FTP_HOST}
 user ${FTP_USER} ${FTP_PWD}
 mkdir backups
 cd backups
 mkdir ${APP_NAME}
 cd ${APP_NAME}
 mkdir mongo
 cd mongo
 bin
 put ${BACKUP}.tar.xz
 bye
" | ftp -n

