FROM mysql:5.7

RUN apt-get update

COPY etc/mysql/mysql.conf.d/mysqld.cnf /etc/mysql/mysql.conf.d/
COPY etc/mysql/conf.d/mysql.cnf /etc/mysql/conf.d/
COPY prepare.sh /usr/local/bin/
COPY init-data.sh /usr/local/bin/
COPY sql /sql
RUN chmod +x /usr/local/bin/*.sh

CMD ["mysqld"]
