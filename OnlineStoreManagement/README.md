## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Database Management

just copy and paste the code wrriten below in your MySQL workbench


Create Database store;
use store;
Create table products(
 ProductID int auto_increment primary key,
 ProductName Varchar(50),
 Price int Not null,
 Stock int Not null
);
create table customers(
 CustomerID int auto_increment primary key,
 CustomerName varchar(50),
 Email varchar(50)
);
create table orders(
 OrderID int auto_increment primary key,
 CustomerID int,
 ProductID int,
 Quantity Int,
 foreign key(CustomerID) references customers(CustomerID),
 foreign key(ProductID) references Products(ProductID)
);


## Replace some commponents in java code
replace password in each DAO class with your work bench password and username and port as well 
