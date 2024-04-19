create table working_time(
user_id varchar(3),
date date,
begin_time time,
end_time time,
working_time float
);

create table user_basic(
user_id varchar(3),
name varchar(64),
grade tinyint,
home char(1)
);

create table user_role(
user_id varchar(3),
manage bool,
document bool,
circuit bool,
design bool,
processing bool,
drill bool,
bandsaw bool,
bandsaw_auto bool,
shearing bool,
lathe bool,
milling bool,
raser bool
);
