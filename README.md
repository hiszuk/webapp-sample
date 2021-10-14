# WEB アプリ サンプル 構築方法

- [WEB アプリ サンプル 構築方法](#web-アプリ-サンプル-構築方法)
  - [ビルド](#ビルド)
  - [環境変数ファイル編集](#環境変数ファイル編集)
  - [起動](#起動)
  - [MySQLが完全に起動するまで待つ](#mysqlが完全に起動するまで待つ)
  - [DB初期登録](#db初期登録)
    - [1. dbコンテナに入る](#1-dbコンテナに入る)
    - [2. sampleユーザーを作成](#2-sampleユーザーを作成)
    - [3. データ登録](#3-データ登録)
    - [4. 登録データ確認](#4-登録データ確認)

## ビルド

```
docker-compose build
```

## 環境変数ファイル編集

1. `.env.sample` 内の`REST_SRV`IPアドレスをコンテナ起動マシンのIPアドレスに変更する
2. `.env.sample` を `.env` にリネームする

## 起動

```
docker-compose up -d
```

## MySQLが完全に起動するまで待つ

```
docker-compose logs -f
```

下記ログが表示されるまで待つ
```
db_1   | Version: '5.7.35'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server (GPL)
```

## DB初期登録

### 1. dbコンテナに入る

```
docker exec -it WORKDIR_db_1 bash
```

### 2. sampleユーザーを作成

```sh
prepare.sh

↓

mysql: [Warning] Using a password on the command line interface can be insecure.
mysql: [Warning] Using a password on the command line interface can be insecure.
```

### 3. データ登録

```sh
init-data.sh
```

### 4. 登録データ確認

**mysqlに入る**

```
mysql -usample -psample sampledb
```

**データ確認**

```
mysql> select * from items;
+----+-----------------------------------------------------------+---------------------------------------------------------------------------------------------------------------+----------+---------------------+---------------------+
| id | title                                                     | content                                                                                                       | status   | created
  | updated             |
+----+-----------------------------------------------------------+---------------------------------------------------------------------------------------------------------------+----------+---------------------+---------------------+
|  1 | WEB Application作成                                       | NUXT.js+ElementUIでフロントエンドのWEBアプリを作成する                                                        | DONE     | 2021-10-14 01:29:06 | 2021-10-14 01:29:06 |
|  2 | RESTful API作成                                           | Spring Bootを用いてRESTful APIを構築する                                                                      | DONE     | 2021-10-14 01:29:06 | 2021-10-14 01:29:06 |
|  3 | フロントエンドとバックエンドを結合                        | NUXTのアプリからaxios経由でREST APIをコールしフロントとバックエンドを繋げる                                   | PROGRESS | 2021-10-14 01:29:06 | 2021-10-14 01:29:06 |
|  4 | MySQLのDockerイメージを作成する                           | DockerでRESTful APIでアクセスするMySQLのイメージを作成する                                                    | PROGRESS | 2021-10-14 01:29:06 | 2021-10-14 01:29:06 |
|  5 | バックエンドのDockerイメージを作成する                    | Javaのイメージにバックエンドのjarをレイヤー化したイメージを作成する                                           | TODO     | 2021-10-14 01:29:06 | 2021-10-14 01:29:06 |
|  6 | フロントエンドのDockerイメージを作成する                  | Node.jsからNUXTをインストールしWEBアプリをコピー後にbuildするイメージを作成する                               | TODO     | 2021-10-14 01:29:06 | 2021-10-14 01:29:06 |
|  7 | Docker-composeでパッケージ化する                          | フロントエンド・バックエンド・DBの3層をひとつのパッケージにまとめる                                           | TODO     | 2021-10-14 01:29:06 | 2021-10-14 01:29:06 |
+----+-----------------------------------------------------------+---------------------------------------------------------------------------------------------------------------+----------+---------------------+---------------------+
7 rows in set (0.00 sec)

mysql> quit
```
