--this is how you comment in SQL
/*
 * multi-line comment 
 */

/*
 * SQL = structured query language = the standard language for relational database systems
 * 
 * RDMS = a system of tables that make up a database and whose records are related to one another through unique indentifers (aka primary keys and foreign keys)
 * 
 * 
 * SQL can further organized its database through its sublanguages of commands:
 * 
 * 1. DDL = data definition language = allows us to create our database schema
 * 
 * schema = layout of your database columns with datatypes and other table creation commands
 * 
 * CREATE
 * ALTER
 * DROP
 * TRUNCATE
 * */
--commonly, it's good to have a series of DROP statements for your tables as you are developing
drop table if exists departments;

create table departments(
	--here we will set up our columns for this table with placing some constraints:
	id serial constraint department_pk primary key,
	name varchar(25) unique not null,
	monthly_budget numeric(8, 2) --numeric(#, #) <- 1st = precision (aka # of digits allowed), 2nd = scale (aka # of decimal points)
);

/*
 * Insert allows you to add new records 
 */
insert into departments (name, monthly_budget) 
values('Accounting', 200000);

--select statement will allow you to query against your database and view some data
select * from departments;