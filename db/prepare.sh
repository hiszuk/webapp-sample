#!/bin/bash -e

# $MYSQL_DATABASE用のユーザーと権限の作成
mysql -u root -p$MYSQL_ROOT_PASSWORD -e "CREATE USER '$MYSQL_APP_USER'@'%' IDENTIFIED BY '$MYSQL_APP_PASSWORD';"
mysql -u root -p$MYSQL_ROOT_PASSWORD -e "GRANT ALL ON $MYSQL_DATABASE.* TO '$MYSQL_APP_USER'@'%';"

