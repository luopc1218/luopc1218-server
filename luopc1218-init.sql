create table luopc1218_develop.article
(
    id          int auto_increment
        primary key,
    title       varchar(40)                         not null,
    description varchar(100)                        not null,
    content     longtext                            not null,
    authorId    int                                 not null,
    viewCount   int       default 0                 not null,
    createTime  timestamp default CURRENT_TIMESTAMP not null,
    updateTime  timestamp                           null,
    deleteTime  timestamp                           null,
    constraint article_id_uindex
        unique (id),
    constraint article_title_uindex
        unique (title)
);

create table luopc1218_develop.article_comment
(
    id           int auto_increment
        primary key,
    articleId    int                                 not null,
    authorId     int                                 not null,
    content      longtext                            not null,
    commentId    int                                 null,
    subCommentId int                                 null,
    createTime   timestamp default CURRENT_TIMESTAMP not null,
    constraint article_comment_id_uindex
        unique (id)
);

create table luopc1218_develop.article_evaluate
(
    id        int auto_increment
        primary key,
    articleId int     not null,
    evaluate  tinyint not null,
    userId    int     not null,
    constraint article_evaluate_id_uindex
        unique (id)
);

create table luopc1218_develop.article_favorite
(
    id        int auto_increment
        primary key,
    articleId int not null,
    userId    int not null,
    constraint article_favorite_link_id_uindex
        unique (id)
);

create table luopc1218_develop.article_tag
(
    id         int auto_increment
        primary key,
    name       varchar(50)                         not null,
    createTime timestamp default CURRENT_TIMESTAMP null,
    constraint article_tag_id_uindex
        unique (id)
);

create table luopc1218_develop.article_tag_link
(
    id        int auto_increment
        primary key,
    articleId int not null,
    tagId     int not null,
    constraint article_tag_link_id_uindex
        unique (id)
);

create table luopc1218_develop.country_tel_code
(
    id     int auto_increment
        primary key,
    short  varchar(20) not null,
    name   varchar(50) not null,
    en     varchar(50) not null,
    tel    varchar(10) not null,
    pinyin varchar(20) not null,
    constraint country_tel_code_id_uindex
        unique (id)
);

create table luopc1218_develop.leave_message
(
    id         int auto_increment
        primary key,
    content    longtext                            not null,
    authorId   int                                 null,
    createTime timestamp default CURRENT_TIMESTAMP null,
    constraint leave_message_id_uindex
        unique (id)
);

create table luopc1218_develop.notice
(
    id         int auto_increment
        primary key,
    content    longtext                            not null,
    authorId   int                                 not null,
    createTime timestamp default CURRENT_TIMESTAMP not null,
    constraint notice_id_uindex
        unique (id)
);

create table luopc1218_develop.user
(
    id         int auto_increment
        primary key,
    name       varchar(20)                         not null,
    avatarUrl  longtext                            null,
    createTime timestamp default CURRENT_TIMESTAMP not null,
    constraint user_id_uindex
        unique (id),
    constraint user_name_uindex
        unique (name)
);

create table luopc1218_develop.user_email
(
    id      int auto_increment
        primary key,
    userId  int          not null,
    address varchar(225) not null,
    constraint user_email_id_uindex
        unique (id)
);

create table luopc1218_develop.user_password
(
    id       int auto_increment
        primary key,
    userId   int         not null,
    password varchar(32) not null,
    constraint user_password_id_uindex
        unique (id)
);

create table luopc1218_develop.user_phone
(
    id        int auto_increment
        primary key,
    userId    int         not null,
    telCodeId int         not null,
    number    varchar(20) not null,
    constraint user_phone_id_uindex
        unique (id)
);

