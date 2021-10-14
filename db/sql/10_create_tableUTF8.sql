CREATE TABLE items (
  `id`      INT(10) UNSIGNED AUTO_INCREMENT NOT NULL COMMENT 'ID',
  `title`   VARCHAR(188) NOT NULL                    COMMENT 'タイトル',
  `content` TEXT                                     COMMENT '内容',
  `status`  ENUM('TODO', 'PROGRESS', 'DONE')         COMMENT 'ステータス',
  `created` DATETIME NOT NULL                        COMMENT '作成時間',
  `updated` DATETIME NOT NULL                        COMMENT '更新時間',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO items(`title`, `content`, `status`, `created`, `updated`) VALUES
('WEB Application作成','NUXT.js+ElementUIでフロントエンドのWEBアプリを作成する', 'DONE', NOW(), NOW()),
('RESTful API作成','Spring Bootを用いてRESTful APIを構築する', 'DONE', NOW(), NOW()),
('フロントエンドとバックエンドを結合','NUXTのアプリからaxios経由でREST APIをコールしフロントとバックエンドを繋げる', 'PROGRESS', NOW(), NOW()),
('MySQLのDockerイメージを作成する','DockerでRESTful APIでアクセスするMySQLのイメージを作成する', 'PROGRESS', NOW(), NOW()),
('バックエンドのDockerイメージを作成する','Javaのイメージにバックエンドのjarをレイヤー化したイメージを作成する', 'TODO', NOW(), NOW()),
('フロントエンドのDockerイメージを作成する','Node.jsからNUXTをインストールしWEBアプリをコピー後にbuildするイメージを作成する', 'TODO', NOW(), NOW()),
('Docker-composeでパッケージ化する','フロントエンド・バックエンド・DBの3層をひとつのパッケージにまとめる', 'TODO', NOW(), NOW());
