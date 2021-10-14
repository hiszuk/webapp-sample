#!/bin/bash -e

for SQL in `ls /sql/*.sql`
do
  mysql -u $MYSQL_APP_USER -p$MYSQL_APP_PASSWORD $MYSQL_DATABASE < $SQL > /dev/null 2>&1
done
