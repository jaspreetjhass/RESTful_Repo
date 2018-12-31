
show tables;

--   profile table --
create table profile(id long,profileName varchar(20),firstName varchar(10), lastName varchar(10),created Date);
--   message table --
create table message(id long,message varchar(200),dateCreated Date,author varchar(20));
--   comment table --
create table comment(id long, comment varchar(200),dateCreated Date,author varchar(20),messageId long);

-- get data from profile  --
select * from profile;
--  get data from message --
select * from message;
-- get data from comment  --
select * from comment;

select * from message inner join profile on message.author = profile.profileName;

select message.message,comment.comment from comment left outer join message on message.id  = comment.messageId;