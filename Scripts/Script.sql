select user(), database ();

create database exam;

use exam;

grant all
on exam.*
to 'user_title'@'localhost' identified by 'rootroot';